/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.updateForms;

import database.ConnectionProvider;
import errorChecking.InputCheck;
import inventorydatabase.Address;
import inventorydatabase.Supplier;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class UpdateSupplierForm extends javax.swing.JFrame {
    
    private List<Address> addresses;
    private int addressID;
    private List<Supplier> suppliers;
    private int supplierID;
    private Address initialAddress;
    private Supplier initialSupplier;
    private JFrame rootFrame;
    /**
     * Creates new form UpdateSupplierForm
     */
    public UpdateSupplierForm(JFrame rootFrame) {
        initComponents();
        this.rootFrame = rootFrame;
        rootFrame.setVisible(false);
        fillSuppliers();
        fillAddresses();
        cmbSupplier.setPreferredSize(new Dimension(150,25));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Updating Supplier");
        setResizable(false);
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

        lblIncorrectStreetNumWarning = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblIncorrectZipCodeWarning = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStreetNum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        txtStreet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblIncorrectNameWarning = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblIncorrectPhoneWarning = new javax.swing.JLabel();
        lblIncorrectCityWarning = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblIncorrectEmailWarning = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtZipCode = new javax.swing.JTextField();
        lblIncorrectCountryWarning = new javax.swing.JLabel();
        lblIncorrectStreetWarning = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblIncorrectStateWarning = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtState = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblIncorrectStreetNumWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectStreetNumWarning.setText(" ");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jLabel6.setText("Country State");

        lblIncorrectZipCodeWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectZipCodeWarning.setText(" ");

        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCityKeyTyped(evt);
            }
        });

        txtCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountryKeyTyped(evt);
            }
        });

        jLabel7.setText("City");

        jLabel2.setText("Name");

        jLabel4.setText("Email");

        cmbSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        txtStreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStreetKeyTyped(evt);
            }
        });

        jLabel3.setText("Phone Number");

        lblIncorrectNameWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectNameWarning.setText(" ");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        lblIncorrectPhoneWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectPhoneWarning.setText(" ");

        lblIncorrectCityWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectCityWarning.setText(" ");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        jLabel8.setText("Street");

        lblIncorrectEmailWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectEmailWarning.setText(" ");

        jLabel10.setText("ZIP Code");

        jLabel9.setText("Street Number");

        txtZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtZipCodeKeyTyped(evt);
            }
        });

        lblIncorrectCountryWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectCountryWarning.setText(" ");

        lblIncorrectStreetWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectStreetWarning.setText(" ");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel5.setText("Country");

        lblIncorrectStateWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblIncorrectStateWarning.setText(" ");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStateKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
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
                                            .addComponent(lblIncorrectNameWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(23, 23, 23))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblIncorrectEmailWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(24, 24, 24)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblIncorrectPhoneWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
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
                                    .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIncorrectStateWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectStreetWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectCountryWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectCityWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectZipCodeWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIncorrectStreetNumWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIncorrectCountryWarning)
                        .addGap(5, 5, 5)
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
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lblIncorrectNameWarning)
                        .addGap(5, 5, 5)
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
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillSuppliers(){
        suppliers = new ConnectionProvider().getSuppliers();
        if(suppliers != null && suppliers.size() > 0){
            for(Supplier supplier : suppliers){
                String item = supplier.getName();
                cmbSupplier.addItem(item);
            }
        }
    }
    
    private void fillAddresses(){
        addresses = new ConnectionProvider().getAddresses();
    }
    
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        rootFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        if(txtEmail.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyTyped
        if(txtCity.getText().length() >= 50){
            evt.consume();
        }
    }//GEN-LAST:event_txtCityKeyTyped

    private void txtCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryKeyTyped
        if(txtCountry.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_txtCountryKeyTyped

    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierActionPerformed
        int index = cmbSupplier.getSelectedIndex();
        if (index > 0) {
            Supplier selectedSupplier = suppliers.get(index - 1);
            supplierID = selectedSupplier.getId();
            addressID = selectedSupplier.getIdAddress();
            findAddressInfo(addressID);
            fillTxtFields(supplierID);
        }else{
            txtName.setText("");
            txtPhone.setText("");
            txtEmail.setText("");
            txtCountry.setText("");
            txtState.setText("");
            txtCity.setText("");
            txtStreet.setText("");
            txtStreetNum.setText("");
            txtZipCode.setText("");
        }
    }//GEN-LAST:event_cmbSupplierActionPerformed

    private void txtStreetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStreetKeyTyped
        if(txtStreet.getText().length() >= 50){
            evt.consume();
        }
    }//GEN-LAST:event_txtStreetKeyTyped

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        if(txtPhone.getText().length() >= 20){
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        if(txtName.getText().length() >= 300){
            evt.consume();
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipCodeKeyTyped
        if(txtZipCode.getText().length() >= 10){
            evt.consume();
        }
    }//GEN-LAST:event_txtZipCodeKeyTyped

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int idAddress = -1;
        int[] correctInputs = new int[9];
        InputCheck inputCheck = new InputCheck();
        String suppName = txtName.getText().trim();
        String suppPhone = txtPhone.getText().trim();
        String suppEmail = txtEmail.getText().trim();
        String suppCountry = txtCountry.getText().trim();
        String suppState = txtState.getText().trim();
        String suppCity = txtCity.getText().trim();
        String suppStreet = txtStreet.getText().trim();
        String suppStreetNum = txtStreetNum.getText().trim();
        String suppZipCode = txtZipCode.getText().trim();

        if(!suppName.equalsIgnoreCase(initialSupplier.getName())){
            if(!inputCheck.isInputLengthCorrect(suppName, 300, 2)){
                lblIncorrectNameWarning.setText("Supplier name length incorrect!");
                correctInputs[0] = 0;
            }else if(inputCheck.isNameInUse(suppName, 'u')){
                lblIncorrectNameWarning.setText("Supplier name already in use!");
                correctInputs[0] = 0;
            }
        }else{
            lblIncorrectNameWarning.setText(" ");
            correctInputs[0] = 1;
        }

        if(!suppPhone.equalsIgnoreCase(initialSupplier.getPhoneNum())){
            if(!inputCheck.isInputLengthCorrect(suppPhone, 20, 8) || !inputCheck.isPhoneCorrect(suppPhone)){
                lblIncorrectPhoneWarning.setText("Phone format or length incorrect!");
                correctInputs[1] = 0;
            }else if(inputCheck.isPhoneInUse(suppPhone)){
                lblIncorrectPhoneWarning.setText("Phone already in use!");
                correctInputs[1] = 0;
            }
        }else{
            lblIncorrectPhoneWarning.setText(" ");
            correctInputs[1] = 1;
        }

        if(!suppEmail.equalsIgnoreCase(initialSupplier.getEmail())){
            if(!inputCheck.isInputLengthCorrect(suppEmail, 100, 5) || !inputCheck.isEmailCorrect(suppEmail)){
                lblIncorrectEmailWarning.setText("Email format or length incorrect!");
                correctInputs[2] = 0;
            }else if(inputCheck.isEmailInDatabase(suppEmail)){
                lblIncorrectEmailWarning.setText("Email already in use!");
                correctInputs[2] = 0;
            }
        }else{
            lblIncorrectEmailWarning.setText(" ");
            correctInputs[2] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(suppCountry, 100, 2)){
            lblIncorrectCountryWarning.setText("Country name length incorrect!");
            correctInputs[3] = 0;
        }else{
            lblIncorrectCountryWarning.setText(" ");
            correctInputs[3] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(suppState, 100, 2)){
            lblIncorrectStateWarning.setText("State name length incorrect!");
            correctInputs[4] = 0;
        }else{
            lblIncorrectStateWarning.setText(" ");
            correctInputs[4] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(suppCity, 50, 1)){
            lblIncorrectCityWarning.setText("City name length incorrect!");
            correctInputs[5] = 0;
        }else{
            lblIncorrectCityWarning.setText(" ");
            correctInputs[5] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(suppStreet, 50, 1)){
            lblIncorrectStreetWarning.setText("Street name length incorrect!");
            correctInputs[6] = 0;
        }else{
            lblIncorrectStreetWarning.setText(" ");
            correctInputs[6] = 1;
        }

        if(!inputCheck.isInt(suppStreetNum) || !inputCheck.isInputLengthCorrect(suppStreetNum, 4, 1)){
            lblIncorrectStreetNumWarning.setText("Incorrect street number!");
            correctInputs[7] = 0;
        }else{
            lblIncorrectStreetNumWarning.setText(" ");
            correctInputs[7] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(suppZipCode, 10, 0)){
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
            if(suppZipCode.length() > 0){
                zipCode = suppZipCode;
            }
            int streetNum = Integer.parseInt(suppStreetNum);
            ConnectionProvider conn = new ConnectionProvider();
            try {
                conn.updateBusinessPartnerAndAddress("Suppliers",suppName, suppPhone, suppEmail, supplierID, addressID, suppCountry, suppState, zipCode, suppCity, suppStreet, streetNum);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateSupplierForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Supplier '" + suppName + "' altered!");
            this.dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtStateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStateKeyTyped
        if(txtState.getText().length() >= 100){
            evt.consume();
        }
    }//GEN-LAST:event_txtStateKeyTyped

    private void fillTxtFields(int suppID){
        for(Supplier supplier : suppliers){
            if(supplier.getId() == suppID){
                initialSupplier = supplier;
                txtName.setText(initialSupplier.getName());
                txtPhone.setText(initialSupplier.getPhoneNum());
                txtEmail.setText(initialSupplier.getEmail());
            }
        }

        txtCountry.setText(initialAddress.getCountry());
        txtState.setText(initialAddress.getCountryState());
        txtCity.setText(initialAddress.getCity());
        txtStreet.setText(initialAddress.getStreet());
        txtStreetNum.setText(initialAddress.getStreetNum() + "");
        txtZipCode.setText(initialAddress.getPostalCode());
    }
    
    private void findAddressInfo(int addressID){
        if(addresses != null || addresses.size() > 0){
            for(Address address : addresses){
                if(address.getId() == addressID){
                    initialAddress = address;
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel jLabel10;
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
