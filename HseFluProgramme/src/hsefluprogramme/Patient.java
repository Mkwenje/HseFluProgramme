package hsefluprogramme;

/**
 *
 * @author sereen
 */
public class Patient {

    private String name;
    private String has_medical_condition; // Changed to String
    private int age;

    public Patient(String name, int age, String has_medical_condition) {
        this.name = name;
        this.has_medical_condition = has_medical_condition;
        this.age = age;
        
    }

     public String getnName() {
        return name;
    }

    public void setnName(String nName) {
        this.name = nName;
    }

    public String getMedCon() { // Updated to return String
        return has_medical_condition;
    }

    public void setMedCon(String med_cond) { // Updated to accept String
        this.has_medical_condition = med_cond;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int aAge) {
        this.age = aAge;
    }

  public int getPriority() {
    if (age >= 90) {
        return 10;
    } else if (age >= 80) {
        return 9;
    } else if (age >= 70) {
        return 8;
    } else if (age >= 65 && age <= 69) {
        return 7;
    } else if (age >= 18 && age <= 64 && has_medical_condition.equals("Y")) { // Updated condition
        return 6;
    } else if (age >= 55 && age <= 64) {
        return 5;
    } else if (age >= 45 && age <= 54) {
        return 4;
    } else if (age >= 30 && age <= 44) {
        return 3;
    } else if (age >= 18 && age <= 29) {
        return 2;
    } else {
        return 1;
    }
}

}
