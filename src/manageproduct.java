
import dao.connectionprovider;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author GudaT
 */
public class manageproduct extends javax.swing.JFrame {

    private int productionPK = 0;
    private int totalQuantity = 0;

    /**
     * Creates new form manageproduct
     */
    public manageproduct() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void getAllcatagory() {
        try {
            Connection con = connectionprovider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from catagory");
            comboBoxcatagory.removeAllItems();
            while (rs.next()) {

                comboBoxcatagory.addItem(rs.getString("catagory_pk") + "-" + rs.getString("name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private boolean validateFields(String formType) {
        if (formType.equals("edit") && !txtname.getText().equals("") && !txtprice.getText().equals("") && !txtdescription.getText().equals("")) {
            return false;
        } else if (formType.equals("new") && !txtname.getText().equals("") && !txtprice.getText().equals("") && !txtquantity.getText().equals("")) {
            return false;
        } else {
            return true;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableproduct = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        lblquantity = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdescription = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxcatagory = new javax.swing.JComboBox<>();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setText("Manage Product");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 18, -1, -1));

        tableproduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Discription", "Catagory ID", "CatagoryName"
            }
        ));
        tableproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableproductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableproduct);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 431, 488));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 125, 37, -1));

        txtname.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 159, 331, -1));

        lblquantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblquantity.setText("Quantity");
        getContentPane().add(lblquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 198, -1, -1));

        txtquantity.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        getContentPane().add(txtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 232, 331, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Price");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 271, -1, -1));

        txtprice.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 305, 331, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Discription");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 344, -1, -1));

        txtdescription.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        txtdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionActionPerformed(evt);
            }
        });
        getContentPane().add(txtdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 378, 331, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Catagory");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 417, -1, -1));

        comboBoxcatagory.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        comboBoxcatagory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxcatagory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxcatagoryActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxcatagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 451, 331, -1));

        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 490, -1, -1));

        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 490, -1, -1));

        btnreset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 490, -1, -1));

        btnclose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 490, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/All_page_Background.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        getAllcatagory();
        DefaultTableModel model = (DefaultTableModel) tableproduct.getModel();
        try {
            Connection con = connectionprovider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product inner join  catagory on product.catagory_FK =catagory.catagory_pk ");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("quantity"), rs.getString("price"), rs.getString("description"), rs.getString("catagory_FK"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnupdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescriptionActionPerformed

    private void comboBoxcatagoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxcatagoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxcatagoryActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String name = txtname.getText();
        String quantity = txtquantity.getText();
        String price = txtprice.getText();
        String description = txtdescription.getText();
        String catagory = (String) comboBoxcatagory.getSelectedItem();
        String catagoryId[] = catagory.split("-", 0);
        if (validateFields("new")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                Connection con = connectionprovider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into product (name,quantity,price,description,catagory_FK) values(?,?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, quantity);
                ps.setString(3, price);
                ps.setString(4, description);
                ps.setString(5, catagoryId[0]);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "product added successfully");
                setVisible(false);
                new manageproduct().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new manageproduct().setVisible(true);
    }//GEN-LAST:event_btnresetActionPerformed

    private void tableproductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableproductMouseClicked
        // TODO add your handling code here:
        int index = tableproduct.getSelectedRow();
        TableModel model = tableproduct.getModel();
        String id = model.getValueAt(index, 0).toString();
        int productionPK = Integer.parseInt(id);
        String name = model.getValueAt(index, 1).toString();
        txtname.setText(name);
        String quantity = model.getValueAt(index, 2).toString();
        totalQuantity = 0;
        lblquantity.setText("Add quantity");
        totalQuantity = Integer.parseInt(quantity);

        String price = model.getValueAt(index, 3).toString();
        txtprice.setText(price);
        String description = model.getValueAt(index, 4).toString();
        txtdescription.setText(description);

        comboBoxcatagory.removeAllItems();
        String catagoryId = model.getValueAt(index, 5).toString();
        String catagoryName = model.getValueAt(index, 6).toString();
        comboBoxcatagory.addItem(catagoryId + "-" + catagoryName);
        try {
            Connection con = connectionprovider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from catagory");

            while (rs.next()) {
                if (Integer.parseInt(catagoryId) != rs.getInt(1)) {
                    comboBoxcatagory.addItem(rs.getString("catagory_pk") + "-" + rs.getString("name"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnsave.setEnabled(false);
        btnupdate.setEnabled(true);
    }//GEN-LAST:event_tableproductMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        String name = txtname.getText();
        String quantity = txtquantity.getText();
        String price = txtprice.getText();
        String description = txtdescription.getText();
        String catagory = (String) comboBoxcatagory.getSelectedItem();
        String catagoryId[] = catagory.split("-", 0);
        if (validateFields("edit")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                if(!quantity.equals("")){
                 totalQuantity = totalQuantity+Integer.parseInt(quantity);
                }
                Connection con = connectionprovider.getCon();
                PreparedStatement ps = con.prepareStatement("update product set name=?,quantity=?,price=?,description=?,catagory_fk=? where product_pk=?");
                ps.setString(1, name);
                ps.setInt(2, totalQuantity);
                ps.setString(3, price);
                ps.setString(4, description);
                ps.setString(5, catagoryId[0]);
                ps.setInt(6, productionPK);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "product updated successfully");
                setVisible(false);
                new manageproduct().setVisible(true);
               
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

    }//GEN-LAST:event_btnupdateActionPerformed

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
            java.util.logging.Logger.getLogger(manageproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageproduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> comboBoxcatagory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblquantity;
    private javax.swing.JTable tableproduct;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
