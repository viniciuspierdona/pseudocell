/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.pseudocell.gui;

/**
 *
 * @author ViníciusPierdoná
 */
public class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAboutTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelVersion = new javax.swing.JLabel();
        jLabelReleaseDate = new javax.swing.JLabel();
        jLabelLicense1 = new javax.swing.JLabel();
        jLabelLicense2 = new javax.swing.JLabel();
        jLabelText1 = new javax.swing.JLabel();
        jLabelText2 = new javax.swing.JLabel();
        jLabelText3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(56, 58, 77));

        jLabelAboutTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelAboutTitle.setForeground(new java.awt.Color(204, 204, 255));
        jLabelAboutTitle.setText("About");

        jLabelVersion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVersion.setForeground(new java.awt.Color(204, 204, 255));
        jLabelVersion.setText("PseudoCell version: 1.0.0");

        jLabelReleaseDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelReleaseDate.setForeground(new java.awt.Color(204, 204, 255));
        jLabelReleaseDate.setText("Release date: Sept 2022");

        jLabelLicense1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelLicense1.setForeground(new java.awt.Color(204, 204, 255));
        jLabelLicense1.setText("License: PseudoCell 1.0.0 is freely available under the terms of");

        jLabelLicense2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelLicense2.setForeground(new java.awt.Color(204, 204, 255));
        jLabelLicense2.setText("GPLv3 license.");

        jLabelText1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelText1.setForeground(new java.awt.Color(204, 204, 255));
        jLabelText1.setText("Developed by Vinícius Pierdona, in the Inflammation and");

        jLabelText2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelText2.setForeground(new java.awt.Color(204, 204, 255));
        jLabelText2.setText("Cellular Senescence laboratory coordinated by ");

        jLabelText3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelText3.setForeground(new java.awt.Color(204, 204, 255));
        jLabelText3.setText("Prof. Dr. Florencia María Barbé-Tuana");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVersion)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAboutTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelReleaseDate)
                            .addComponent(jLabelLicense1)
                            .addComponent(jLabelLicense2)
                            .addComponent(jLabelText1)
                            .addComponent(jLabelText3)
                            .addComponent(jLabelText2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelAboutTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelReleaseDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLicense1)
                .addGap(0, 0, 0)
                .addComponent(jLabelLicense2)
                .addGap(63, 63, 63)
                .addComponent(jLabelText1)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelText2)
                .addGap(0, 0, 0)
                .addComponent(jLabelText3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAboutTitle;
    private javax.swing.JLabel jLabelLicense1;
    private javax.swing.JLabel jLabelLicense2;
    private javax.swing.JLabel jLabelReleaseDate;
    private javax.swing.JLabel jLabelText1;
    private javax.swing.JLabel jLabelText2;
    private javax.swing.JLabel jLabelText3;
    private javax.swing.JLabel jLabelVersion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
