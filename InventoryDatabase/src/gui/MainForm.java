/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import inventorydatabase.Goods;
import inventorydatabase.Person;
import gui.dialogs.PastArrivalsDialog;
import gui.dialogs.PastExpeditionsDialog;
import gui.newBusinessPartAndUser.NewCustomerDialog;
import gui.newBusinessPartAndUser.NewShipperDialog;
import gui.newBusinessPartAndUser.NewAccount;
import gui.newBusinessPartAndUser.NewSupplierDialog;
import gui.deleteForms.DelAccountDialog;
import gui.deleteForms.DelCustomerDialog;
import gui.deleteForms.DelShipperDialog;
import gui.deleteForms.DelSupplierDialog;
import gui.updateForms.UpdateAccountForm;
import gui.updateForms.UpdateCustomerForm;
import gui.updateForms.UpdateShipperForm;
import gui.updateForms.UpdateSupplierForm;
import gui.dialogs.ArrivalOfGoodsDialog;
import gui.dialogs.ShipGoodsDialog;

/**
 *
 * @author Joseph
 */
public class MainForm extends javax.swing.JFrame {
    private int id;
    private Person person = null;
    private JFrame loginFrame;
    private List<Goods> goods = new ArrayList();
    private List<Goods> goodsNoVoid = new ArrayList();
    private static final String copyright = "©Jozef Bálint 2018";
    /**
     * Creates new form MainForm
     */
    public MainForm(int id,JFrame loginFrame) {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Stock organizer");
        this.id = id;
        this.loginFrame = loginFrame;
        showUserInfo();
        hideColumn(4);
        fillTable();
        setResizable(false);
        setLocationRelativeTo(null);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        lblWelcomeUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnArrival = new javax.swing.JButton();
        btnShip = new javax.swing.JButton();
        lblCardID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGoods = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuAddShipper = new javax.swing.JMenuItem();
        menuAddCustomer = new javax.swing.JMenuItem();
        menuAddSupplier = new javax.swing.JMenuItem();
        menuNewAccount = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuUpdateShipper = new javax.swing.JMenuItem();
        menuUpdateCustomer = new javax.swing.JMenuItem();
        menuUpdateSupplier = new javax.swing.JMenuItem();
        menuUpdateAccount = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuDelShipper = new javax.swing.JMenuItem();
        menuDelCustomer = new javax.swing.JMenuItem();
        menuDelSupplier = new javax.swing.JMenuItem();
        menuDelAccount = new javax.swing.JMenuItem();
        History = new javax.swing.JMenu();
        menuHistoryArrivals = new javax.swing.JMenuItem();
        menuHistoryExpeditions = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuMiscAbout = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblWelcomeUser.setText("Welcome sign");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Stock");

        btnArrival.setText("Arrival");
        btnArrival.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnArrival.setMaximumSize(new java.awt.Dimension(70, 23));
        btnArrival.setMinimumSize(new java.awt.Dimension(70, 23));
        btnArrival.setPreferredSize(new java.awt.Dimension(70, 23));
        btnArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrivalActionPerformed(evt);
            }
        });

        btnShip.setText("Ship");
        btnShip.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnShip.setMaximumSize(new java.awt.Dimension(70, 23));
        btnShip.setMinimumSize(new java.awt.Dimension(70, 23));
        btnShip.setPreferredSize(new java.awt.Dimension(70, 23));
        btnShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShipActionPerformed(evt);
            }
        });

        lblCardID.setText("cardID");

        tableGoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code", "Quantity", "Price per unit", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableGoods);
        if (tableGoods.getColumnModel().getColumnCount() > 0) {
            tableGoods.getColumnModel().getColumn(0).setResizable(false);
            tableGoods.getColumnModel().getColumn(1).setResizable(false);
            tableGoods.getColumnModel().getColumn(2).setResizable(false);
            tableGoods.getColumnModel().getColumn(3).setResizable(false);
            tableGoods.getColumnModel().getColumn(4).setResizable(false);
        }

        jMenu1.setText("File");

        menuLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogout);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("New");

        menuAddShipper.setText("New Shipper");
        menuAddShipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddShipperActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddShipper);

        menuAddCustomer.setText("New Customer");
        menuAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddCustomerActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddCustomer);

        menuAddSupplier.setText("New Supplier");
        menuAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddSupplierActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddSupplier);

        menuNewAccount.setText("New Account");
        menuNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewAccountActionPerformed(evt);
            }
        });
        jMenu3.add(menuNewAccount);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Update");

        menuUpdateShipper.setText("Update Shipper");
        menuUpdateShipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateShipperActionPerformed(evt);
            }
        });
        jMenu4.add(menuUpdateShipper);

        menuUpdateCustomer.setText("Update Customer");
        menuUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateCustomerActionPerformed(evt);
            }
        });
        jMenu4.add(menuUpdateCustomer);

        menuUpdateSupplier.setText("Update Supplier");
        menuUpdateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateSupplierActionPerformed(evt);
            }
        });
        jMenu4.add(menuUpdateSupplier);

        menuUpdateAccount.setText("Update Account");
        menuUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateAccountActionPerformed(evt);
            }
        });
        jMenu4.add(menuUpdateAccount);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Delete");

        menuDelShipper.setText("Delete Shipper");
        menuDelShipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDelShipperActionPerformed(evt);
            }
        });
        jMenu5.add(menuDelShipper);

        menuDelCustomer.setText("Delete Customer");
        menuDelCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDelCustomerActionPerformed(evt);
            }
        });
        jMenu5.add(menuDelCustomer);

        menuDelSupplier.setText("Delete Supplier");
        menuDelSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDelSupplierActionPerformed(evt);
            }
        });
        jMenu5.add(menuDelSupplier);

        menuDelAccount.setText("Delete Account");
        menuDelAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDelAccountActionPerformed(evt);
            }
        });
        jMenu5.add(menuDelAccount);

        jMenuBar1.add(jMenu5);

        History.setText("History");

        menuHistoryArrivals.setText("Past Arrivals");
        menuHistoryArrivals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHistoryArrivalsActionPerformed(evt);
            }
        });
        History.add(menuHistoryArrivals);

        menuHistoryExpeditions.setText("Past Expeditions");
        menuHistoryExpeditions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHistoryExpeditionsActionPerformed(evt);
            }
        });
        History.add(menuHistoryExpeditions);

        jMenuBar1.add(History);

        jMenu2.setText("Miscellaneous");

        menuMiscAbout.setText("About");
        menuMiscAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMiscAboutActionPerformed(evt);
            }
        });
        jMenu2.add(menuMiscAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnShip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnArrival, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 597, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblWelcomeUser)
                            .addComponent(lblCardID)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcomeUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCardID)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(this, 
           "Are you sure you want to exit?", "Exit confirmation",
           JOptionPane.YES_NO_OPTION,
           JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrivalActionPerformed
        ArrivalOfGoodsDialog arrivalOfGoodsDialog = new ArrivalOfGoodsDialog(this, true, id, goods);
        fillTable();
    }//GEN-LAST:event_btnArrivalActionPerformed

    private void btnShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShipActionPerformed
        ShipGoodsDialog shipGoodsDialog = new ShipGoodsDialog(this, true, id, goods);
        fillTable();
    }//GEN-LAST:event_btnShipActionPerformed

    private void menuAddShipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddShipperActionPerformed
        NewShipperDialog newShipperDialog = new NewShipperDialog(this, true);
    }//GEN-LAST:event_menuAddShipperActionPerformed

    private void menuAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddCustomerActionPerformed
        NewCustomerDialog newCustomerDialog = new NewCustomerDialog(this, true);
    }//GEN-LAST:event_menuAddCustomerActionPerformed

    private void menuAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddSupplierActionPerformed
        NewSupplierDialog newSupplierDialog = new NewSupplierDialog(this, true);
    }//GEN-LAST:event_menuAddSupplierActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        if(JOptionPane.showConfirmDialog(this, 
           "Are you sure you want logout?", "Logout confirmation",
           JOptionPane.YES_NO_OPTION,
           JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            dispose();
            loginFrame.setVisible(true);
        }
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuDelSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDelSupplierActionPerformed
        DelSupplierDialog delSupplierDialog = new DelSupplierDialog(this, true);
    }//GEN-LAST:event_menuDelSupplierActionPerformed

    private void menuUpdateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateSupplierActionPerformed
        UpdateSupplierForm updateSupplierForm = new UpdateSupplierForm(this);
    }//GEN-LAST:event_menuUpdateSupplierActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        if(JOptionPane.showConfirmDialog(this, 
           "Are you sure you want to exit?", "Exit confirmation",
           JOptionPane.YES_NO_OPTION,
           JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewAccountActionPerformed
        NewAccount newAccountDialog = new NewAccount(this, true);
    }//GEN-LAST:event_menuNewAccountActionPerformed

    private void menuHistoryExpeditionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHistoryExpeditionsActionPerformed
        PastExpeditionsDialog pastExpeditionDialog = new PastExpeditionsDialog(this, true);
    }//GEN-LAST:event_menuHistoryExpeditionsActionPerformed

    private void menuMiscAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMiscAboutActionPerformed
        JOptionPane.showMessageDialog(null, copyright);
    }//GEN-LAST:event_menuMiscAboutActionPerformed

    private void menuDelShipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDelShipperActionPerformed
        DelShipperDialog delShipperDialog = new DelShipperDialog(this, true);
    }//GEN-LAST:event_menuDelShipperActionPerformed

    private void menuDelAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDelAccountActionPerformed
        DelAccountDialog delAccountDialog = new DelAccountDialog(this, true, id);
    }//GEN-LAST:event_menuDelAccountActionPerformed

    private void menuHistoryArrivalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHistoryArrivalsActionPerformed
        PastArrivalsDialog pastArrivalsDialog = new PastArrivalsDialog(this, true);
    }//GEN-LAST:event_menuHistoryArrivalsActionPerformed

    private void menuDelCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDelCustomerActionPerformed
        DelCustomerDialog delCustomerDialog = new DelCustomerDialog(this, true);
    }//GEN-LAST:event_menuDelCustomerActionPerformed

    private void menuUpdateShipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateShipperActionPerformed
        UpdateShipperForm updateShipperForm = new UpdateShipperForm(this);
    }//GEN-LAST:event_menuUpdateShipperActionPerformed

    private void menuUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateAccountActionPerformed
        UpdateAccountForm updateAccountForm = new UpdateAccountForm(this);
    }//GEN-LAST:event_menuUpdateAccountActionPerformed

    private void menuUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateCustomerActionPerformed
        UpdateCustomerForm updateCustomerForm = new UpdateCustomerForm(this);
    }//GEN-LAST:event_menuUpdateCustomerActionPerformed
    
    public void showUserInfo(){
        getPerson();
        if(!isUserInformationPresent()){
            JOptionPane.showMessageDialog(null, "Your account seems to be empty. \nCall administrator now.", "Account error", JOptionPane.ERROR_MESSAGE);
            dispose();
            loginFrame.setVisible(true);
        }else{
            String fullName = person.getFirstName() + " " + person.getLastName();
            String cardID = person.getCardId();
            lblWelcomeUser.setText("Welcome " + fullName);
            lblCardID.setText("Card ID: " + cardID);
        }
    }
    
    private void getPerson(){
        person = null;
        ConnectionProvider conn = new ConnectionProvider();
        person = conn.getPersonByID(id);
    }
    
    private boolean isUserInformationPresent(){
        int idAcc = person.getIdAcc();
        return idAcc != -1;
    }
    private void hideColumn(int columnIndex){
        TableColumn tableColumnID = tableGoods.getColumnModel().getColumn(columnIndex);
        tableColumnID.setMinWidth(0);
        tableColumnID.setMaxWidth(0);
        tableColumnID.setWidth(0);
    }

    private void fillTable(){
        if(goods.isEmpty()){
            fillListWithGoods();
        }else{
            goods.removeAll(goods);
            fillListWithGoods();
        }
        
        DefaultTableModel model = (DefaultTableModel) tableGoods.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        for (Goods tempGoods : goods) {
            Object[] o = new Object[5];
            o[0] = tempGoods.getName();
            o[1] = tempGoods.getCode();
            o[2] = tempGoods.getQuantity();
            o[3] = tempGoods.getPricePerUnit();
            o[4] = tempGoods.getId();
            model.addRow(o);
        }
    }
  
    private void fillListWithGoods(){
        ConnectionProvider conn = new ConnectionProvider();
        goods = conn.getGoods();
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu History;
    private javax.swing.JButton btnArrival;
    private javax.swing.JButton btnShip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCardID;
    private javax.swing.JLabel lblWelcomeUser;
    private javax.swing.JMenuItem menuAddCustomer;
    private javax.swing.JMenuItem menuAddShipper;
    private javax.swing.JMenuItem menuAddSupplier;
    private javax.swing.JMenuItem menuDelAccount;
    private javax.swing.JMenuItem menuDelCustomer;
    private javax.swing.JMenuItem menuDelShipper;
    private javax.swing.JMenuItem menuDelSupplier;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuHistoryArrivals;
    private javax.swing.JMenuItem menuHistoryExpeditions;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuMiscAbout;
    private javax.swing.JMenuItem menuNewAccount;
    private javax.swing.JMenuItem menuUpdateAccount;
    private javax.swing.JMenuItem menuUpdateCustomer;
    private javax.swing.JMenuItem menuUpdateShipper;
    private javax.swing.JMenuItem menuUpdateSupplier;
    private javax.swing.JTable tableGoods;
    // End of variables declaration//GEN-END:variables
}
