
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
public class managecatagory extends javax.swing.JFrame {

    private int catagoryPK = 0;

    /**
     * Creates new form managecatagory
     */
    public managecatagory() {
        initComponents();

        setLocationRelativeTo(null);
    }

    private boolean validateFields() {
        if (!txtname.getText().equals("")) {
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
        tablecatagory = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setText("Manage Catagory");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 26, -1, -1));

        tablecatagory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        tablecatagory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecatagoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablecatagory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 106, 429, 464));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 192, 37, -1));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 226, 350, -1));

        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 266, -1, -1));

        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 266, -1, -1));

        btnreset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnreset.setText("Resete");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 266, -1, -1));

        btnclose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 266, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/All_page_Background.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 850, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tablecatagory.getModel();
        try {
            Connection con = connectionprovider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from catagory");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("catagory_PK"), rs.getString("name")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnupdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String name = txtname.getText();
        if (validateFields()) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                Connection con = connectionprovider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into catagory(name)values(?)");
                ps.setString(1, name);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "catagory added sucessfully");
                setVisible(false);
                new managecatagory().setVisible(true);

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
        new managecatagory().setVisible(true);
    }//GEN-LAST:event_btnresetActionPerformed

    private void tablecatagoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecatagoryMouseClicked
        // TODO add your handling code here:
        int index = tablecatagory.getSelectedRow();
        TableModel model = tablecatagory.getModel();
        String id = model.getValueAt(index, 0).toString();
        catagoryPK = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtname.setText(name);
        btnsave.setEnabled(false);
        btnupdate.setEnabled(true);
    }//GEN-LAST:event_tablecatagoryMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        String name = txtname.getText();
        if (validateFields()) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                Connection con = connectionprovider.getCon();
                PreparedStatement ps = con.prepareStatement("update catagory set name=? where catagory_PK=?");
                ps.setString(1, name);
                ps.setInt(2, catagoryPK);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "catagory updated sucessfully");
                setVisible(false);
                new managecatagory().setVisible(true);

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
            java.util.logging.Logger.getLogger(managecatagory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managecatagory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managecatagory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managecatagory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managecatagory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablecatagory;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
