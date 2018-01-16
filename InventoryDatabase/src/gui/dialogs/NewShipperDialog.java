/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dialogs;

import database.ConnectionProvider;
import errorChecking.InputCheck;
import inventorydatabase.Shipper;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author client
 */
public class NewShipperDialog extends javax.swing.JDialog {

    private InputCheck inputCheck = null;
    /**
     * Creates new form NewShipperDialog
     */
    public NewShipperDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Add New Shipper");
        setResizable(false);
        clearWarningLabels();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        txtPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStreetNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtZipCode = new javax.swing.JTextField();
        lblIncorrectNameWarning = new javax.swing.JLabel();
        lblIncorrectPhoneWarning = new javax.swing.JLabel();
        lblIncorrectEmailWarning = new javax.swing.JLabel();
        lblIncorrectCountryWarning = new javax.swing.JLabel();
        lblIncorrectStateWarning = new javax.swing.JLabel();
        lblIncorrectCityWarning = new javax.swing.JLabel();
        lblIncorrectStreetWarning = new javax.swing.JLabel();
        lblIncorrectStreetNumWarning = new javax.swing.JLabel();
        lblIncorrectZipCodeWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        jLabel9.setText("Street Number");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        jLabel10.setText("ZIP Code");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountryKeyTyped(evt);
            }
        });

        jLabel5.setText("Country");

        txtState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStateKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Address");

        jLabel6.setText("Country State");

        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCityKeyTyped(evt);
            }
        });

        jLabel7.setText("City");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("New Shipper");

        jLabel2.setText("Name");

        txtStreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStreetKeyTyped(evt);
            }
        });

        jLabel3.setText("Phone Number");

        jLabel4.setText("Email");

        jLabel8.setText("Street");

        txtZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtZipCodeKeyTyped(evt);
            }
        });

        lblIncorrectNameWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectNameWarning.setText(" ");

        lblIncorrectPhoneWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectPhoneWarning.setText(" ");

        lblIncorrectEmailWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectEmailWarning.setText(" ");

        lblIncorrectCountryWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectCountryWarning.setText(" ");

        lblIncorrectStateWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectStateWarning.setText(" ");

        lblIncorrectCityWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectCityWarning.setText(" ");

        lblIncorrectStreetWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectStreetWarning.setText(" ");

        lblIncorrectStreetNumWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectStreetNumWarning.setText(" ");

        lblIncorrectZipCodeWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectZipCodeWarning.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(10, 10, 10)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblIncorrectNameWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(23, 23, 23))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblIncorrectEmailWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(24, 24, 24)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblIncorrectPhoneWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtStreetNum, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel11))
                                .addGap(39, 39, 39))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIncorrectStateWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectStreetWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectCountryWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectCityWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectZipCodeWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectStreetNumWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIncorrectNameWarning)
                    .addComponent(lblIncorrectCountryWarning))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(lblIncorrectStateWarning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(lblIncorrectCityWarning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lblIncorrectPhoneWarning)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIncorrectEmailWarning)))
                .addGap(4, 4, 4)
                .addComponent(lblIncorrectStreetWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtStreetNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblIncorrectStreetNumWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblIncorrectZipCodeWarning)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAdd))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void clearWarningLabels(){
        lblIncorrectNameWarning.setText(" ");
        lblIncorrectPhoneWarning.setText(" ");
        lblIncorrectEmailWarning.setText(" ");
        lblIncorrectCountryWarning.setText(" ");
        lblIncorrectStateWarning.setText(" ");
        lblIncorrectCityWarning.setText(" ");
        lblIncorrectStreetWarning.setText(" ");
        lblIncorrectStreetNumWarning.setText(" ");
        lblIncorrectZipCodeWarning.setText(" ");
    }
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ConnectionProvider conn = new ConnectionProvider();
        int idAddress = -1;
        int streetNum = -1;
        int[] correctInputs = new int[9];
        inputCheck = new InputCheck();
        String shipName = txtName.getText().trim();
        String shipPhone = txtPhone.getText().trim();
        String shipEmail = txtEmail.getText().trim();
        String shipCountry = txtCountry.getText().trim();
        String shipState = txtState.getText().trim();
        String shipCity = txtCity.getText().trim();
        String shipStreet = txtStreet.getText().trim();
        String shipStreetNum = txtStreetNum.getText().trim();
        String shipZipCode = txtZipCode.getText().trim();
        
        if(!inputCheck.isInputLengthCorrect(shipName, 300, 2)){
            lblIncorrectNameWarning.setText("Shipper name length incorrect!");
            correctInputs[0] = 0;
        }else if(inputCheck.isNameInUse(shipName, 'i')){
            lblIncorrectNameWarning.setText("Shipper name already in use!");
            correctInputs[0] = 0;
        }else{
            lblIncorrectNameWarning.setText(" ");
            correctInputs[0] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipPhone, 20, 8) || !inputCheck.isPhoneCorrect(shipPhone)){
            lblIncorrectPhoneWarning.setText("Phone format or length incorrect!");
            correctInputs[1] = 0;
        }else if(inputCheck.isPhoneInUse(shipPhone)){
            lblIncorrectPhoneWarning.setText("Phone already in use!");
            correctInputs[1] = 0;
        }else{
            lblIncorrectPhoneWarning.setText(" ");
            correctInputs[1] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipEmail, 100, 5) || !inputCheck.isEmailCorrect(shipEmail)){
            lblIncorrectEmailWarning.setText("Email format or length incorrect!");
            correctInputs[2] = 0;
        }else if(!inputCheck.isEmailInDatabase(shipEmail)){
            lblIncorrectEmailWarning.setText("Email already in use!");
            correctInputs[2] = 0;
        }else{
            lblIncorrectEmailWarning.setText(" ");
            correctInputs[2] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipCountry, 100, 2)){
            lblIncorrectCountryWarning.setText("Country name length incorrect!");
            correctInputs[3] = 0;
        }else{
            lblIncorrectCountryWarning.setText(" ");
            correctInputs[3] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipState, 100, 2)){
            lblIncorrectStateWarning.setText("State name length incorrect!");
            correctInputs[4] = 0;
        }else{
            lblIncorrectStateWarning.setText(" ");
            correctInputs[4] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipCity, 50, 1)){
            lblIncorrectCityWarning.setText("City name length incorrect!");
            correctInputs[5] = 0;
        }else{
            lblIncorrectCityWarning.setText(" ");
            correctInputs[5] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipStreet, 50, 1)){
            lblIncorrectStreetWarning.setText("Street name length incorrect!");
            correctInputs[6] = 0;
        }else{
            lblIncorrectStreetWarning.setText(" ");
            correctInputs[6] = 1;
        }

        if(!inputCheck.isInt(shipStreetNum) && !inputCheck.isInputLengthCorrect(shipStreetNum, 4, 1)){
            lblIncorrectStreetNumWarning.setText("Incorrect street number!");
            correctInputs[7] = 0;
        }else{
            lblIncorrectStreetNumWarning.setText(" ");
            correctInputs[7] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipZipCode, 10, 0)){
            lblIncorrectZipCodeWarning.setText("ZIP code incorrect!");
            correctInputs[8] = 0;
        }else{
            lblIncorrectZipCodeWarning.setText(" ");
            correctInputs[8] = 1;
        }

        int sum = 0;
        for(int i : correctInputs){
            sum += i;
        }
        if(sum == 9){
            String zipCode = "";
            if(shipZipCode.length() > 0){
                zipCode = shipZipCode;
            }
            streetNum = Integer.parseInt(shipStreetNum);
            idAddress = conn.addNewAddress(shipCountry, shipState, zipCode, shipCity, shipStreet, streetNum);
            conn.addNewShipper(idAddress, shipName, shipPhone, shipEmail);
            JOptionPane.showMessageDialog(null, "Shipper '" + shipName + "' added!");
            this.dispose();
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        if(txtName.getText().length() >= 300){
            evt.consume();
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        if(txtPhone.getText().length() >= 20){
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        if(txtEmail.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryKeyTyped
        if(txtCountry.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_txtCountryKeyTyped

    private void txtStateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStateKeyTyped
        if(txtState.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_txtStateKeyTyped

    private void txtCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyTyped
        if(txtCity.getText().length() >= 50){
            evt.consume();
        }
    }//GEN-LAST:event_txtCityKeyTyped

    private void txtStreetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStreetKeyTyped
        if(txtStreet.getText().length() >= 50){
            evt.consume();
        }
    }//GEN-LAST:event_txtStreetKeyTyped

    private void txtZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipCodeKeyTyped
        if(txtZipCode.getText().length() >= 10){
            evt.consume();
        }
    }//GEN-LAST:event_txtZipCodeKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblIncorrectCityWarning;
    private javax.swing.JLabel lblIncorrectCountryWarning;
    private javax.swing.JLabel lblIncorrectEmailWarning;
    private javax.swing.JLabel lblIncorrectNameWarning;
    private javax.swing.JLabel lblIncorrectPhoneWarning;
    private javax.swing.JLabel lblIncorrectStateWarning;
    private javax.swing.JLabel lblIncorrectStreetNumWarning;
    private javax.swing.JLabel lblIncorrectStreetWarning;
    private javax.swing.JLabel lblIncorrectZipCodeWarning;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtStreetNum;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}
