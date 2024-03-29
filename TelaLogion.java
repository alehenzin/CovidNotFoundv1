/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covidnotfound;

import javax.swing.JOptionPane;

/**
 *
 * @author alehen
 */
public class TelaLogion extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogion
     */
    public TelaLogion() {
        super ("CovidNotFound");
        initComponents();
        setLocationRelativeTo(null);
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
        digiteSeuLoginFIeld = new javax.swing.JLabel();
        digiteSuaSenhaLabel = new javax.swing.JLabel();
        entrarButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        loginTextField = new javax.swing.JTextField();
        senhaPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        digiteSeuLoginFIeld.setFont(new java.awt.Font("Yrsa Light", 0, 24)); // NOI18N
        digiteSeuLoginFIeld.setForeground(new java.awt.Color(1, 1, 1));
        digiteSeuLoginFIeld.setText("Digite seu login: ");
        jPanel1.add(digiteSeuLoginFIeld);
        digiteSeuLoginFIeld.setBounds(100, 140, 160, 30);

        digiteSuaSenhaLabel.setFont(new java.awt.Font("Yrsa Light", 0, 24)); // NOI18N
        digiteSuaSenhaLabel.setForeground(new java.awt.Color(1, 1, 1));
        digiteSuaSenhaLabel.setText("Digite sua senha:");
        digiteSuaSenhaLabel.setToolTipText("");
        jPanel1.add(digiteSuaSenhaLabel);
        digiteSuaSenhaLabel.setBounds(100, 270, 170, 34);

        entrarButton.setBackground(new java.awt.Color(90, 219, 24));
        entrarButton.setText("Entrar");
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(entrarButton);
        entrarButton.setBounds(310, 420, 120, 70);

        sairButton.setBackground(new java.awt.Color(219, 24, 90));
        sairButton.setText("Sair");
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sairButton);
        sairButton.setBounds(100, 420, 120, 70);

        loginTextField.setFont(new java.awt.Font("Yrsa Light", 0, 21)); // NOI18N
        jPanel1.add(loginTextField);
        loginTextField.setBounds(100, 170, 330, 60);

        senhaPasswordField.setFont(new java.awt.Font("Yrsa Light", 0, 24)); // NOI18N
        senhaPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaPasswordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(senhaPasswordField);
        senhaPasswordField.setBounds(100, 300, 330, 60);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void senhaPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaPasswordFieldActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed
        String login = loginTextField.getText();
        String senha = new String(senhaPasswordField.getPassword());
        try{
            UsuarioLogin u = new UsuarioLogin (login, senha);
            DAO dao = new DAO();
            if (dao.existe(u)){
                JOptionPane.showMessageDialog(null, "Bem vindo, " + u.getLogin() + "!");
                
                if (dao.eAdm(u)){
                TelaAdm telaadm = new TelaAdm();
                this.dispose();
                telaadm.setVisible(true);
                }else{
                TelaUsuario telausuario = new TelaUsuario();
                this.dispose();
                telausuario.setVisible(true);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuário inválido");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Sistema fora do ar. Entre em contato com o suporte...");
        }
    }//GEN-LAST:event_entrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel digiteSeuLoginFIeld;
    private javax.swing.JLabel digiteSuaSenhaLabel;
    private javax.swing.JButton entrarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JButton sairButton;
    private javax.swing.JPasswordField senhaPasswordField;
    // End of variables declaration//GEN-END:variables
}
