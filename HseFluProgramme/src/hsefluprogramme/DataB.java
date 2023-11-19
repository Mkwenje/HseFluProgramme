package hsefluprogramme;

//these are for keys
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.spec.SecretKeySpec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
//this is for cipher algorithm
import javax.crypto.*;
//these are for the provider
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;
import java.sql.ResultSet;


public class DataB {
    
    //add secuirty provider
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    
    // Ensure generateKey is called at the start
    static {
        try {
            SecretKey key = generateKey();
            saveKey(key);
            System.out.println("Key generation and storage process completed.");
        } catch (Exception e) {
        }
    }
    //init database connection
    private static final String URL = "jdbc:mysql://localhost:3306/fluprog";
    private static final String USER = "root"; 
    private static final String PASSWORD = "";

    
    // Method to generate a new AES key using Bouncy Castle
    static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", new BouncyCastleProvider());
        //keys must be saved 128,192,or 256. i choose biggest since im unsure how large the files can be -jamel
        
        keyGenerator.init(256);
        SecretKey key = keyGenerator.generateKey();
        saveKey(key);
        return key;
    }
 //save the key made to the resouce folder
    private static void saveKey(SecretKey key) throws IOException {
    byte[] keyBytes = key.getEncoded();
    try (FileOutputStream fos = new FileOutputStream("src/resources/secretKey.key")) {
        fos.write(keyBytes);
        //this is just for problem solving im having key size issue- jamel
        System.out.println("Key Length: " + keyBytes.length + " bytes");
        System.out.println("Key written to resource successfully");
    }
}

    
// Method to read the encryption key from a resource inside the JAR
private static SecretKey getKey() throws IOException {
    try (InputStream is = DataB.class.getClassLoader().getResourceAsStream("resources/secretKey.key")) {
        if (is == null) {
            throw new FileNotFoundException("Cannot find secretKey.key resource");
        }
        //close stream after its read
        byte[] keyBytes = is.readAllBytes();
        return new SecretKeySpec(keyBytes, "AES");
    } catch (IOException e) {
        e.printStackTrace();
        // Rethrow the exception to handle it in the calling method
        throw e; 
    }
}

    // Method to encrypt data using AES and Bouncy Castle
    private static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt data using AES and BC
    private static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }
    
    
 
    //insert and encrypt data to the database
    public static void insertPatient(Connection conn, String name, int age, String hasMedicalCondition) throws Exception {
        SecretKey key = getKey();
        try {
           

            // Encrypt the fields
            String encryptedName = encrypt(name, key);
            String encryptedAge = encrypt(String.valueOf(age), key);
            String encryptedCondition = encrypt(hasMedicalCondition, key);

            String sql = "INSERT INTO patients (name, age, has_medical_condition) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, encryptedName);
                pstmt.setString(2, encryptedAge);
                pstmt.setString(3, encryptedCondition);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            throw e;
        }
    }

    // New method to get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    //retrieve and decrypt data from the database
    public static Patient getPatient(int patientId) {
        Patient patient = null; 
        try {
            SecretKey key = getKey(); 
            String sql = "SELECT name, age, hasMedicalCondition FROM patient WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, patientId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    String name = decrypt(rs.getString("name"), key);
                    int age = Integer.parseInt(decrypt(rs.getString("age"), key));
                    String medicalCondition = decrypt(rs.getString("hasMedicalCondition"), key);

                    patient = new Patient(name, age, medicalCondition); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }
}