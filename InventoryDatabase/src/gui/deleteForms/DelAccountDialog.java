/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.deleteForms;

import database.ConnectionProvider;
import inventorydatabase.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Joseph
 */
public class DelAccountDialog extends javax.swing.JDialog {

    private List<Person> people = new ArrayList();
    private int currUserID = -1;
    /**
     * Creates new form DelShipperDialog
     */
    public DelAccountDialog(java.awt.Frame parent, boolean modal, int currUserID) {
        super(parent, modal);
        initComponents();
        this.currUserID = currUserID;
        setLocationRelativeTo(null);
        setTitle("Account deletion");
        hideColumn(4);
        hideColumn(5);
        fillTable();
        setResizable(false);
        setVisible(true);
    }
    
    private void hideColumn(int columnIndex){
        TableColumn tableColumnID = tableAccounts.getColumnModel().getColumn(columnIndex);
        tableColumnID.setMinWidth(0);
        tableColumnID.setMaxWidth(0);
        tableColumnID.setWidth(0);
    }
    
    private void fillTable(){
        if(people.isEmpty()){
            fillListWithPeople();
        }else{
            people.removeAll(people);
            fillListWithPeople();
        }
        
        DefaultTableModel model = (DefaultTableModel) tableAccounts.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        for (Person tempPerson : people) {
            Object[] o = new Object[6];
            o[0] = tempPerson.getFirstName();
            o[1] = tempPerson.getLastName();
            o[2] = tempPerson.getCardId();
            o[3] = tempPerson.getEmail();
            o[4] = tempPerson.getIdAcc();
            o[5] = tempPerson.getId();
            model.addRow(o);
        }
    }
    
    /*
    *   Fills atribute 'people' with personal information of all users
    */
    private void fillListWithPeople(){
        ConnectionProvider conn = new ConnectionProvider();
        people = conn.getPeople();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAccounts = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First name", "Last name", "Card ID", "Email", "AccountID", "UserPersonalID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAccounts);

        btnDelete.setText("Delete");
        btnDelete.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnDelete.setMaximumSize(new java.awt.Dimension(70, 23));
        btnDelete.setMinimumSize(new java.awt.Dimension(70, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(70, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedPersonAccountID = Integer.parseInt(tableAccounts.getValueAt(tableAccounts.getSelectedRow(), 4).toString());
        int selectedPersonID = Integer.parseInt(tableAccounts.getValueAt(tableAccounts.getSelectedRow(), 5).toString());
        ConnectionProvider conn = new ConnectionProvider();
        try {
            if(selectedPersonID == currUserID){
                JOptionPane.showMessageDialog(null, "Cannot delete yourself!");
            }else if(conn.deleteUserData(selectedPersonID, selectedPersonAccountID)){
                JOptionPane.showMessageDialog(null, "User data deleted succesfully!");
                fillTable();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "User data NOT deleted!");
        }
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAccounts;
    // End of variables declaration//GEN-END:variables
}