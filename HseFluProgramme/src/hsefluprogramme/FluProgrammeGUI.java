package hsefluprogramme;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sereen
 */
public class FluProgrammeGUI extends javax.swing.JFrame {

    /**
     * Creates new form FluProgrammeGUI
     */
  
    private MyPriorityQueue myPQueue;
    
    public FluProgrammeGUI() {
        myPQueue = new MyPriorityQueue();
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameJlabel = new javax.swing.JLabel();
        ageJlabel = new javax.swing.JLabel();
        mcJlabel = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        nameTF = new javax.swing.JTextField();
        ageTF = new javax.swing.JTextField();
        mcTF = new javax.swing.JTextField();
        titleJlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        listBtn = new javax.swing.JButton();
        numOfPBtn = new javax.swing.JButton();
        prioBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameJlabel.setText("Patient Name:");

        ageJlabel.setText("Patient Age:");

        mcJlabel.setText("Medical Condition: ");

        addBtn.setText("Add patient to Vaccination list");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        ageTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTFActionPerformed(evt);
            }
        });

        titleJlabel.setText("Flu Vaccination Programme");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        listBtn.setText("List patients");
        listBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBtnActionPerformed(evt);
            }
        });

        numOfPBtn.setText("Number of Patients");
        numOfPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numOfPBtnActionPerformed(evt);
            }
        });

        prioBtn.setText("Allocate Priority");
        prioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prioBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next Scheduled Group");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mcJlabel)
                                            .addComponent(ageJlabel)
                                            .addComponent(nameJlabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nameTF)
                                            .addComponent(ageTF)
                                            .addComponent(mcTF, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(listBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(numOfPBtn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(prioBtn)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(titleJlabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJlabel))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageJlabel)
                    .addComponent(ageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mcTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mcJlabel))
                .addGap(18, 18, 18)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listBtn)
                    .addComponent(numOfPBtn)
                    .addComponent(prioBtn))
                .addGap(40, 40, 40)
                .addComponent(nextBtn)
                .addGap(18, 18, 18)
                .addComponent(exitBtn)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String nName = nameTF.getText();        
        String med_cond = mcTF.getText();
        int age;

    try {
        age = Integer.parseInt(ageTF.getText());
        Patient newPatient = new Patient(nName, age, med_cond);
        myPQueue.enqueue(newPatient);

        // Use a shared connection
        try (Connection conn = DataB.getConnection()) {
            DataB.insertPatient(conn, nName, age, med_cond);
            jTextArea1.append(nName + " has been successfully added to the Vaccine List\n");
        } catch (Exception e) {
            jTextArea1.append("Error adding patient: " + e.getMessage() + "\n");
        }
    } catch (NumberFormatException numberFormatException) {
        jTextArea1.append("Please enter a valid age\n");
    }

    // Clear the text fields
    nameTF.setText("");
    mcTF.setText("");
    ageTF.setText("");    
    }                                      

    private void listBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBtnActionPerformed
        // print Priority everything in pg
        jTextArea1.append("\n");
        jTextArea1.append("The patients on the Vaccine List are...\n");
        jTextArea1.append(myPQueue.printPQueue()+ "\n");
    }//GEN-LAST:event_listBtnActionPerformed

    private void ageTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTFActionPerformed

    private void numOfPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numOfPBtnActionPerformed
        // TODO add your handling code here:
        jTextArea1.append("There are " + myPQueue.size() + " patients on the vaccine list\n");
    }//GEN-LAST:event_numOfPBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void prioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prioBtnActionPerformed
        //when prio button is clicked - priority will be allocated
        if(!myPQueue.isEmpty()){
            myPQueue.reallocatePriority();//call the reallocatePriority() method to reallocate priorities to the patients in the queue
            jTextArea1.append("** The priorities have been allocated to patients! **\n");
        }
        else
            jTextArea1.append("There are no patients waiting!\n");
        jTextArea1.append("***  The Top Priority is " + myPQueue.currentPriority() + ". ***"+"\n");
        
    }//GEN-LAST:event_prioBtnActionPerformed

    @SuppressWarnings("unchecked")
    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        if(myPQueue.isEmpty()){
            jTextArea1.append("There are no patients waiting!\n");
            return;
        }
        int curr_prio = myPQueue.currentPriority();
        Object nextGroup = myPQueue.dequeue(); 
        ArrayList<PriorityQueueElement> nextGroupPatients;
        nextGroupPatients = (ArrayList<PriorityQueueElement>)nextGroup;         
        jTextArea1.append("---------- The Next Group of People(Priority = " + curr_prio + ", Patient, count:"+ nextGroupPatients.size() + ") --------\n");
        for(int i=0; i<nextGroupPatients.size(); i++){
            jTextArea1.append(nextGroupPatients.get(i).printPatient());
            jTextArea1.append("\n");
        }
        jTextArea1.append("***  The Next Group Priority is " + myPQueue.currentPriority() + ". ***\n");
    }//GEN-LAST:event_nextBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FluProgrammeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FluProgrammeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FluProgrammeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FluProgrammeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FluProgrammeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel ageJlabel;
    private javax.swing.JTextField ageTF;
    private javax.swing.JButton exitBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton listBtn;
    private javax.swing.JLabel mcJlabel;
    private javax.swing.JTextField mcTF;
    private javax.swing.JLabel nameJlabel;
    private javax.swing.JTextField nameTF;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton numOfPBtn;
    private javax.swing.JButton prioBtn;
    private javax.swing.JLabel titleJlabel;
    // End of variables declaration//GEN-END:variables
}
