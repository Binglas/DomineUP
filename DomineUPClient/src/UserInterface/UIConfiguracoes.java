/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import Share.User;
import LogicaNegocioCliente.MD5Pwd;
import ComunicacaoCliente.ComCliente;
/**
 *
 * @author andre
 */
public class UIConfiguracoes extends javax.swing.JFrame {

    User player;
    /**
     * Creates new form UIConfiguracoes
     */
    public UIConfiguracoes() {
        initComponents();
    }
    
     public UIConfiguracoes(User Jogador) {
        initComponents();
        player=Jogador;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OptionsLabel = new javax.swing.JLabel();
        ImageSettingsLabel = new javax.swing.JLabel();
        ChangePasswordLabel = new javax.swing.JLabel();
        OldPasswordLabel = new javax.swing.JLabel();
        NewPasswordLabel = new javax.swing.JLabel();
        ConfirmaPasswordLabel = new javax.swing.JLabel();
        SoundEffectsLabel = new javax.swing.JLabel();
        MainVolmeLabel = new javax.swing.JLabel();
        MusicVolumeLabel = new javax.swing.JLabel();
        SFXSoundLabel = new javax.swing.JLabel();
        MainVolumeCheck = new javax.swing.JCheckBox();
        MusicVolumeCheck = new javax.swing.JCheckBox();
        SFXSoundCheck = new javax.swing.JCheckBox();
        MainVolumeSlider = new javax.swing.JSlider();
        MusicVolumeSlider = new javax.swing.JSlider();
        SFXSoundSlider = new javax.swing.JSlider();
        AccountSettingsLabel1 = new javax.swing.JLabel();
        UploadLinkLabel = new javax.swing.JLabel();
        UploadLinkField = new javax.swing.JTextField();
        UploadButton = new javax.swing.JButton();
        LanguageLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        CancelButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        xConfirmPassword = new javax.swing.JLabel();
        xOldPassword = new javax.swing.JLabel();
        ErrorLabel = new javax.swing.JLabel();
        NewPasswordField = new javax.swing.JPasswordField();
        ConfirmPasswordField = new javax.swing.JPasswordField();
        OldPasswordField = new javax.swing.JPasswordField();
        xNewPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        OptionsLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        OptionsLabel.setText("Options");

        ImageSettingsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ImageSettingsLabel.setText("Image Settings");

        ChangePasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ChangePasswordLabel.setText("Change Password");

        OldPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OldPasswordLabel.setText("Old Password");

        NewPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NewPasswordLabel.setText("New Password");

        ConfirmaPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ConfirmaPasswordLabel.setText("Confirm Password");

        SoundEffectsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SoundEffectsLabel.setText("Sound Effects");

        MainVolmeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MainVolmeLabel.setText("Main Volume");

        MusicVolumeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MusicVolumeLabel.setText("Music Volume");

        SFXSoundLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SFXSoundLabel.setText("SFX Sound");

        SFXSoundCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SFXSoundCheckActionPerformed(evt);
            }
        });

        AccountSettingsLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AccountSettingsLabel1.setText("Account Settings");

        UploadLinkLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UploadLinkLabel.setText("Upload Link");

        UploadButton.setText("Upload");

        LanguageLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LanguageLabel.setText("Language");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CancelButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CancelButton.setText("Cancel");

        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        xConfirmPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/redcross.png"))); // NOI18N

        xOldPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/redcross.png"))); // NOI18N

        ErrorLabel.setText("ERROR TEXT FIELD HERE");

        NewPasswordField.setText("jPasswordField1");

        ConfirmPasswordField.setText("jPasswordField1");

        OldPasswordField.setText("jPasswordField1");

        xNewPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/redcross.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SoundEffectsLabel)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OptionsLabel)
                        .addGap(367, 367, 367))))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ErrorLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(ChangePasswordLabel)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UploadLinkLabel)
                                .addGap(26, 26, 26)
                                .addComponent(UploadLinkField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UploadButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(ImageSettingsLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LanguageLabel))
                        .addGap(146, 146, 146))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ConfirmaPasswordLabel)
                            .addComponent(NewPasswordLabel)
                            .addComponent(OldPasswordLabel))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(xConfirmPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(NewPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(OldPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xOldPassword)
                                    .addComponent(xNewPassword))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SFXSoundCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SFXSoundLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MainVolumeCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MainVolmeLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MusicVolumeCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MusicVolumeLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MainVolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SFXSoundSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MusicVolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(AccountSettingsLabel1)
                    .addContainerGap(509, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(OptionsLabel)
                .addGap(72, 72, 72)
                .addComponent(SoundEffectsLabel)
                .addGap(17, 17, 17)
                .addComponent(ChangePasswordLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MainVolmeLabel)
                                .addComponent(MainVolumeCheck))
                            .addComponent(MainVolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MusicVolumeLabel)
                            .addComponent(MusicVolumeCheck)
                            .addComponent(MusicVolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SFXSoundSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SFXSoundCheck)
                            .addComponent(SFXSoundLabel))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OldPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(NewPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(xOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ConfirmaPasswordLabel)
                                .addComponent(ConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)))
                .addComponent(ErrorLabel)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImageSettingsLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UploadLinkLabel)
                            .addComponent(UploadLinkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UploadButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LanguageLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(AccountSettingsLabel1)
                    .addContainerGap(481, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SFXSoundCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SFXSoundCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SFXSoundCheckActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        
        String username =  player.getUsername();
        String avatar = player.getAvatar();
        char[] Oldpassword = OldPasswordField.getPassword();
        char[] Newpassword = NewPasswordField.getPassword();
        char[] Confirmpassword = ConfirmPasswordField.getPassword();
        this.OldPasswordField.setText("");
        this.NewPasswordField.setText("");
        this.ConfirmPasswordField.setText("");
        String pass = new String(Newpassword);
        String pConfirm = new String(Confirmpassword);
        String pOld = new String(Oldpassword);
        MD5Pwd enc = new MD5Pwd();
        String passEnc; 
        
        xOldPassword.setVisible(false);
        xConfirmPassword.setVisible(false);
        
        passEnc = enc.encode(username,pass);
        
        
        if(!Newpassword.equals(Oldpassword)){
            
            if(!"".equals(Oldpassword)){
                
                if(Newpassword.equals(Confirmpassword) && !"".equals(Newpassword)){
                    
                    try{
                        ComCliente com = ComCliente.getInstance();
                        com.mudarConfig(username, passEnc, avatar);
                        this.SaveButton.setEnabled(false);
                    }catch (Exception e) {
                                System.out.println("Accept failed: 4444");
                                System.exit(-1);
                    } 
                    
                }else{
                        this.ErrorLabel.setText("Error in confirm password");
                        this.xConfirmPassword.setVisible(true);
                        this.OldPasswordField.setText("");
                        this.NewPasswordField.setText("");
                        this.ConfirmPasswordField.setText("");
                     }
            }else{
                        this.ErrorLabel.setText("Error in old password");
                        this.xOldPassword.setVisible(true);
                        this.OldPasswordField.setText("");
                        this.NewPasswordField.setText("");
                        this.ConfirmPasswordField.setText("");
                }
        }else{
                        this.ErrorLabel.setText("Error in new password");
                        this.xNewPassword.setVisible(true);
                        this.OldPasswordField.setText("");
                        this.NewPasswordField.setText("");
                        this.ConfirmPasswordField.setText("");
            }
        
    }//GEN-LAST:event_SaveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UIConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIConfiguracoes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountSettingsLabel1;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel ChangePasswordLabel;
    private javax.swing.JPasswordField ConfirmPasswordField;
    private javax.swing.JLabel ConfirmaPasswordLabel;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel ImageSettingsLabel;
    private javax.swing.JLabel LanguageLabel;
    private javax.swing.JLabel MainVolmeLabel;
    private javax.swing.JCheckBox MainVolumeCheck;
    private javax.swing.JSlider MainVolumeSlider;
    private javax.swing.JCheckBox MusicVolumeCheck;
    private javax.swing.JLabel MusicVolumeLabel;
    private javax.swing.JSlider MusicVolumeSlider;
    private javax.swing.JPasswordField NewPasswordField;
    private javax.swing.JLabel NewPasswordLabel;
    private javax.swing.JPasswordField OldPasswordField;
    private javax.swing.JLabel OldPasswordLabel;
    private javax.swing.JLabel OptionsLabel;
    private javax.swing.JCheckBox SFXSoundCheck;
    private javax.swing.JLabel SFXSoundLabel;
    private javax.swing.JSlider SFXSoundSlider;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel SoundEffectsLabel;
    private javax.swing.JButton UploadButton;
    private javax.swing.JTextField UploadLinkField;
    private javax.swing.JLabel UploadLinkLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel xConfirmPassword;
    private javax.swing.JLabel xNewPassword;
    private javax.swing.JLabel xOldPassword;
    // End of variables declaration//GEN-END:variables
}
