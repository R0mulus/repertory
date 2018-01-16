/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.dialogs;

import database.ConnectionProvider;
import inventorydatabase.PastArrival;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joseph
 */
public class PastArrivalsDialog extends javax.swing.JDialog {

    private List<PastArrival> arrivals = null;
    /**
     * Creates new form PastArrivalsDialog
     */
    public PastArrivalsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Date currentDate = new Date();
        datePicker.setDate(currentDate);
        datePicker.getEditor().setEditable(false);
        setLocationRelativeTo(null);
        setTitle("Past arrivals");
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

        datePicker = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableArrivals = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableArrivals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Goods name", "Goods code", "Quantity", "Price per unit", "Supplier", "Shipper", "User", "Card ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableArrivals);

        jLabel1.setText("Choose date:");

        btnConfirm.setText("Confirm");
        btnConfirm.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnConfirm.setMaximumSize(new java.awt.Dimension(70, 23));
        btnConfirm.setMinimumSize(new java.awt.Dimension(70, 23));
        btnConfirm.setPreferredSize(new java.awt.Dimension(70, 23));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        Date date = datePicker.getDate();
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(cal.getTimeZone());
        cal.setTime(date);
        
        Calendar today = Calendar.getInstance();
        String dateString = sdf.format(cal.getTime());
        if(cal.compareTo(today) > 0){
            JOptionPane.showMessageDialog(rootPane, "Cannot pick future date!","Invalid date",JOptionPane.ERROR_MESSAGE);
            fillListWithArrivals(dateString);
            fillTable(dateString);
        }else{
            fillListWithArrivals(dateString);
            fillTable(dateString);
        }
    
    }//GEN-LAST:event_btnConfirmActionPerformed
 
    private void fillTable(String date){
        if(arrivals.isEmpty()){
            fillListWithArrivals(date);
        }else{
            arrivals.removeAll(arrivals);
            fillListWithArrivals(date);
        }
        DefaultTableModel model = (DefaultTableModel) tableArrivals.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (PastArrival tempArrival : arrivals) {
            Object[] o = new Object[8];
            o[0] = tempArrival.getGoodsName();
            o[1] = tempArrival.getGoodsCode();
            o[2] = tempArrival.getGoodsQuantity();
            o[3] = tempArrival.getPricePerUnit();
            o[4] = tempArrival.getSupplierName();
            o[5] = tempArrival.getShipperName();
            o[6] = tempArrival.getUserFirstName()+ " " + tempArrival.getUserLastName();
            o[7] = tempArrival.getUserCardID();
            model.addRow(o);
        }
    }

    private void fillListWithArrivals(String date){
        ConnectionProvider conn = new ConnectionProvider();
        arrivals = conn.getArrivals(date);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableArrivals;
    // End of variables declaration//GEN-END:variables
}
