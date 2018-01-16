/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.updateForms;

import database.ConnectionProvider;
import errorChecking.InputCheck;
import inventorydatabase.Address;
import inventorydatabase.Customer;
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
public class UpdateCustomerForm extends javax.swing.JFrame {

    private List<Address> addresses;
    private int addressID;
    private List<Customer> customers;
    private int customerID;
    private Address rightAddress;
    private Customer rightCustomer;
    private JFrame rootFrame;
    /**
     * Creates new form UpdateCustomerForm
     */
    public UpdateCustomerForm(JFrame rootFrame) {
        initComponents();
        this.rootFrame = rootFrame;
        rootFrame.setVisible(false);
        fillCustomers();
        fillAddresses();
        cmbCustomers.setPreferredSize(new Dimension(150,25));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Updating Shipper");
        setResizable(false);
        setVisible(true);
    }
    
    private void fillCustomers(){
        customers = new ConnectionProvider().getCustomers();
        if(customers != null && customers.size() > 0){
            for(Customer customer : customers){
                String item = customer.getName();
                cmbCustomers.addItem(item);
            }
        }
    }
    
    private void fillAddresses(){
        addresses = new ConnectionProvider().getAddresses();
    }
    
    private void fillTxtFields(int customerID){
        Customer customer = new ConnectionProvider().getCustomerByID(customerID);
        rightCustomer = customer;
        txtShipperName.setText(customer.getName());
        txtShipperPhone.setText(customer.getPhoneNum());
        txtShipperEmail.setText(customer.getEmail());

        txtShipperCountry.setText(rightAddress.getCountry());
        txtShipperState.setText(rightAddress.getCountryState());
        txtShipperCity.setText(rightAddress.getCity());
        txtShipperStreet.setText(rightAddress.getStreet());
        txtShipperStreetNum.setText(rightAddress.getStreetNum() + "");
        txtShipperZipCode.setText(rightAddress.getPostalCode());
    }
    
    private void findAddressInfo(int addressID){
        if(addresses != null && addresses.size() > 0){
            for(Address address : addresses){
                if(address.getId() == addressID){
                    rightAddress = address;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStreetNumberWarning = new javax.swing.JLabel();
        txtShipperCountry = new javax.swing.JTextField();
        lblZipCodeWarning = new javax.swing.JLabel();
        txtShipperState = new javax.swing.JTextField();
        cmbCustomers = new javax.swing.JComboBox<>();
        txtShipperStreet = new javax.swing.JTextField();
        txtShipperStreetNum = new javax.swing.JTextField();
        txtShipperCity = new javax.swing.JTextField();
        txtShipperZipCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNameWarning = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPhoneWarning = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEmailWarning = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtShipperName = new javax.swing.JTextField();
        txtShipperPhone = new javax.swing.JTextField();
        lblCountryWarning = new javax.swing.JLabel();
        txtShipperEmail = new javax.swing.JTextField();
        lblStateWarning = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblCityWarning = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStreetWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblStreetNumberWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblStreetNumberWarning.setText(" ");

        lblZipCodeWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblZipCodeWarning.setText(" ");

        cmbCustomers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        cmbCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomersActionPerformed(evt);
            }
        });

        jLabel5.setText("State");

        jLabel6.setText("City");

        jLabel7.setText("Street");

        jLabel8.setText("Street number");

        jLabel9.setText("Zip code");

        lblNameWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblNameWarning.setText(" ");

        jLabel1.setText("Name");

        lblPhoneWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblPhoneWarning.setText(" ");

        jLabel2.setText("Phone");

        lblEmailWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailWarning.setText(" ");

        jLabel3.setText("Email");

        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnUpdate.setMaximumSize(new java.awt.Dimension(70, 23));
        btnUpdate.setMinimumSize(new java.awt.Dimension(70, 23));
        btnUpdate.setPreferredSize(new java.awt.Dimension(70, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblCountryWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblCountryWarning.setText(" ");

        lblStateWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblStateWarning.setText(" ");

        btnCancel.setText("Cancel");
        btnCancel.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnCancel.setMaximumSize(new java.awt.Dimension(70, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(70, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(70, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblCityWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblCityWarning.setText(" ");

        jLabel4.setText("Country");

        lblStreetWarning.setForeground(new java.awt.Color(255, 0, 0));
        lblStreetWarning.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(txtShipperEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21)
                                .addComponent(txtShipperName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtShipperPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNameWarning)
                                    .addComponent(lblPhoneWarning)
                                    .addComponent(lblEmailWarning)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cmbCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel7)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCityWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStreetWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStreetNumberWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblCountryWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(lblStateWarning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(19, 19, 19))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtShipperZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtShipperCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtShipperState, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtShipperStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtShipperStreetNum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtShipperCity, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblZipCodeWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtShipperCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cmbCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountryWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtShipperState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStateWarning)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtShipperCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtShipperStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtShipperStreetNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblCityWarning)
                                .addGap(38, 38, 38)
                                .addComponent(lblStreetWarning))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtShipperName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNameWarning)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtShipperPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPhoneWarning)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtShipperEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmailWarning)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStreetNumberWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtShipperZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblZipCodeWarning)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        rootFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void cmbCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomersActionPerformed
        int index = cmbCustomers.getSelectedIndex();
        if (index > 0) {
            Customer selectedCustomer = customers.get(index - 1);
            customerID = selectedCustomer.getId();
            addressID = selectedCustomer.getIdAddress();
            findAddressInfo(addressID);
            fillTxtFields(customerID);

        }
    }//GEN-LAST:event_cmbCustomersActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String shipName = txtShipperName.getText().trim();
        String shipPhone = txtShipperPhone.getText().trim();
        String shipEmail = txtShipperEmail.getText().trim();

        String shipCountry = txtShipperCountry.getText().trim();
        String shipState = txtShipperState.getText().trim();
        String shipCity = txtShipperCity.getText().trim();
        String shipStreet = txtShipperStreet.getText().trim();
        String shipStreetNum = txtShipperStreetNum.getText().trim();
        String shipZipCode = txtShipperZipCode.getText().trim();
        int[] correctInputs = new int[9];
        InputCheck inputCheck = new InputCheck();

        if(!inputCheck.isInputLengthCorrect(shipName, 300, 2)){
            lblNameWarning.setText("Shipper name length incorrect!");
            correctInputs[0] = 0;
        }else if(inputCheck.isNameInUse(shipName, 'i')){
            if(shipName.equals(rightCustomer.getName())){
                lblNameWarning.setText(" ");
                correctInputs[0] = 1;
            }else{
                lblNameWarning.setText("Shipper name already in use!");
                correctInputs[0] = 0;
            }
        }else{
            lblNameWarning.setText(" ");
            correctInputs[0] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipPhone, 20, 8) || !inputCheck.isPhoneCorrect(shipPhone)){
            lblPhoneWarning.setText("Phone format or length incorrect!");
            correctInputs[1] = 0;
        }else if(inputCheck.isPhoneInUse(shipPhone)){
            if(shipPhone.equals(rightCustomer.getPhoneNum())){
                lblPhoneWarning.setText(" ");
                correctInputs[1] = 1;
            }else{
                lblPhoneWarning.setText("Phone already in use!");
                correctInputs[1] = 0;
            }
        }else{
            lblPhoneWarning.setText(" ");
            correctInputs[1] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipEmail, 100, 5) || !inputCheck.isEmailCorrect(shipEmail)){
            lblEmailWarning.setText("Email format or length incorrect!");
            correctInputs[2] = 0;
        }else if(!inputCheck.isEmailInDatabase(shipEmail)){
            if(shipEmail.equals(rightCustomer.getEmail())){
                lblEmailWarning.setText(" ");
                correctInputs[2] = 1;
            }else{
                lblEmailWarning.setText("Email already in use!");
                correctInputs[2] = 0;
            }
        }else{
            lblEmailWarning.setText(" ");
            correctInputs[2] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipCountry, 100, 2)){
            lblCountryWarning.setText("Country name length incorrect!");
            correctInputs[3] = 0;
        }else{
            lblCountryWarning.setText(" ");
            correctInputs[3] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipState, 100, 2)){
            lblStateWarning.setText("State name length incorrect!");
            correctInputs[4] = 0;
        }else{
            lblStateWarning.setText(" ");
            correctInputs[4] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipCity, 50, 1)){
            lblCityWarning.setText("City name length incorrect!");
            correctInputs[5] = 0;
        }else{
            lblCityWarning.setText(" ");
            correctInputs[5] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipStreet, 50, 1)){
            lblStreetWarning.setText("Street name length incorrect!");
            correctInputs[6] = 0;
        }else{
            lblStreetWarning.setText(" ");
            correctInputs[6] = 1;
        }

        if(!inputCheck.isInt(shipStreetNum) && !inputCheck.isInputLengthCorrect(shipStreetNum, 4, 1)){
            lblStreetNumberWarning.setText("Incorrect street number!");
            correctInputs[7] = 0;
        }else{
            lblStreetNumberWarning.setText(" ");
            correctInputs[7] = 1;
        }

        if(!inputCheck.isInputLengthCorrect(shipZipCode, 10, 0)){
            lblZipCodeWarning.setText("ZIP code incorrect!");
            correctInputs[8] = 0;
        }else{
            lblZipCodeWarning.setText(" ");
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
            int streetNum = Integer.parseInt(shipStreetNum);
            ConnectionProvider conn = new ConnectionProvider();
            try {
                conn.updateBusinessPartnerWithAddress("Customers",shipName, shipPhone, shipEmail, customerID, addressID, shipCountry, shipState, zipCode, shipCity, shipStreet, streetNum);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateShipperForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Customer '" + shipName + "' altered!");
            this.dispose();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
        rootFrame.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCustomers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCityWarning;
    private javax.swing.JLabel lblCountryWarning;
    private javax.swing.JLabel lblEmailWarning;
    private javax.swing.JLabel lblNameWarning;
    private javax.swing.JLabel lblPhoneWarning;
    private javax.swing.JLabel lblStateWarning;
    private javax.swing.JLabel lblStreetNumberWarning;
    private javax.swing.JLabel lblStreetWarning;
    private javax.swing.JLabel lblZipCodeWarning;
    private javax.swing.JTextField txtShipperCity;
    private javax.swing.JTextField txtShipperCountry;
    private javax.swing.JTextField txtShipperEmail;
    private javax.swing.JTextField txtShipperName;
    private javax.swing.JTextField txtShipperPhone;
    private javax.swing.JTextField txtShipperState;
    private javax.swing.JTextField txtShipperStreet;
    private javax.swing.JTextField txtShipperStreetNum;
    private javax.swing.JTextField txtShipperZipCode;
    // End of variables declaration//GEN-END:variables
}
