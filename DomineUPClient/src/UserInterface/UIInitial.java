/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import ComunicacaoCliente.ComCliente;
import LogicaNegocioCliente.Language;
import LogicaNegocioCliente.ReaderThread;
import Share.MD5Pwd;

/**
 * Interface Inicial da aplicação, aonde o utilizador posse aceder às funções
 * de registo, login, recuperar a sua password bem como botão de ajuda, sair e 
 * ainda a possibilidade de entrar como convidado.
 * @author Luciano
 */
public class UIInitial extends javax.swing.JFrame {

    public static UIRegister registerScreen;
    public static UIRecoverPass recoverPassScreen;
    public String Lang = Language.getInstance().GetLanguage(); 
    /**
     * Cria a instancia da classe UIInitial
     */
    public UIInitial() {
        initComponents();
        registerScreen = new UIRegister();
        recoverPassScreen = new UIRecoverPass();
        setLocationRelativeTo(null);
        this.ReconnectButton.setVisible(false);
        ConnectThread  t = new ConnectThread();
        new Thread(t). start ( );

    }
    
    public void UISetVisible(){
        this.setVisible(true);
    }
     /**
     * Este método permite atualizar todos os campos de texto para a linguagem definida 
     * com o auxílio da classe Language.java.
     * @author João Machado
     * 
     */
    private void UpdateLanguage(){
        Lang=Language.getInstance().GetLanguage();
        registerScreen.Lang=Lang;        
        registerScreen.UpdateLanguage();
        recoverPassScreen.Lang=Lang;
        recoverPassScreen.UpdateLanguage();
        this.UsernameLabel.setText(java.util.ResourceBundle.getBundle(Lang).getString("UsernameLabel"));
        this.PasswordLabel.setText(java.util.ResourceBundle.getBundle(Lang).getString("PasswordLabel"));
        this.ExitButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("ExitGameButton"));
        this.LoginButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("LoginButton"));
        this.RegisterButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("RegisterButton"));
        this.HelpButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("HelpButton"));
        this.RecoverPassButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("RecoverPassButton"));
        this.ReconnectButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("ReconnectButton"));
        this.ServerStateLabel.setText(java.util.ResourceBundle.getBundle(Lang).getString("ServerStateLabel"));
        this.ServerStateQuery.setText(java.util.ResourceBundle.getBundle(Lang).getString("Connected"));
    }
/**
* Implementa uma Thread que permite a ligação automática ao servidor quando a 
* aplicação é iniciada, chamando a função ServerConnect().
*/    
private class ConnectThread implements Runnable 
{
    public void run ( ) 
    {
     
       ServerConnect();
    }
}
   
   /*
    * Metodo que faz um pedido de ligação ao servidor.
    */
   private void ServerConnect(){
       
        //connect server
         try{       
                    this.ServerStateQuery.setText(java.util.ResourceBundle.getBundle(Lang).getString("Connecting"));
                    ComCliente com = ComCliente.getInstance();
                    int checkConnection = com.connection();
                    System.out.println("checkConnection: " + checkConnection);
                    this.ServerStateLabel.setText(java.util.ResourceBundle.getBundle(Lang).getString("ServerStateLabel"));

                    if(checkConnection!=1){
                        UIError errorFrame = new UIError();
                        errorFrame.setErrorTitleLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorLabel"));
                        errorFrame.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorIP"));
                        errorFrame.setVisible(true);
                        this.jProgressBar.setVisible(false);
                        this.ReconnectButton.setVisible(true);
                        this.ServerStateQuery.setText(java.util.ResourceBundle.getBundle(Lang).getString("Disconnected"));

                    }else{
                        
                        this.UsernameField.setEnabled(true);
                        this.PasswordField.setEnabled(true);
                        this.RecoverPassButton.setEnabled(true);
                        this.RegisterButton.setEnabled(true);
                        this.LoginButton.setEnabled(true);
                        this.jProgressBar.setVisible(false);
                        this.ReconnectButton.setVisible(false);
                        new ReaderThread(this,registerScreen,recoverPassScreen).start();
                        this.ServerStateQuery.setText(java.util.ResourceBundle.getBundle(Lang).getString("Connected"));

                    }

                } catch (Exception e) {
                    System.out.println("Error establishing Connection");
                    System.exit(1);
                }
   }
   public void setLoginButton(){
       this.LoginButton.setEnabled(true);
   }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExitButton = new javax.swing.JButton();
        HelpButton = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        UsernameLabel = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        RecoverPassButton = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();
        PasswordLabel = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        ReconnectButton = new javax.swing.JButton();
        ServerStateLabel = new javax.swing.JLabel();
        ServerStateQuery = new javax.swing.JLabel();
        LanguageButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources/Portugues_pt_PT_EURO"); // NOI18N
        setTitle(bundle.getString("AppTitle")); // NOI18N
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        ExitButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ExitButton.setText(bundle.getString("ExitGameButton")); // NOI18N
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        HelpButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HelpButton.setText(bundle.getString("HelpButton")); // NOI18N

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/final_logo.png"))); // NOI18N

        UsernameField.setEnabled(false);
        UsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameFieldActionPerformed(evt);
            }
        });

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UsernameLabel.setText(bundle.getString("UsernameLabel")); // NOI18N

        RegisterButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RegisterButton.setText(bundle.getString("RegisterButton")); // NOI18N
        RegisterButton.setEnabled(false);
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LoginButton.setText(bundle.getString("LoginButton")); // NOI18N
        LoginButton.setEnabled(false);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        RecoverPassButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RecoverPassButton.setText(bundle.getString("RecoverPassButton")); // NOI18N
        RecoverPassButton.setEnabled(false);
        RecoverPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecoverPassButtonActionPerformed(evt);
            }
        });

        PasswordField.setEnabled(false);

        PasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PasswordLabel.setText(bundle.getString("PasswordLabel")); // NOI18N

        jProgressBar.setIndeterminate(true);

        ReconnectButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReconnectButton.setText(bundle.getString("ReconnectButton")); // NOI18N
        ReconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReconnectButtonActionPerformed(evt);
            }
        });

        ServerStateLabel.setText("Estado do servidor:");

        ServerStateQuery.setText("jLabel1");

        LanguageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pt.png"))); // NOI18N
        LanguageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(HelpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(ReconnectButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ServerStateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ServerStateQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LanguageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(302, 302, 302)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(698, 698, 698)
                            .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(574, 574, 574)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RecoverPassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(111, 111, 111))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(UsernameLabel))
                            .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LanguageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecoverPassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerStateLabel)
                    .addComponent(ServerStateQuery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HelpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameFieldActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
       
       registerScreen.setVisible(true);  
       this.setVisible(false);
                
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
      
       System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void RecoverPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecoverPassButtonActionPerformed
        
        recoverPassScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_RecoverPassButtonActionPerformed

    private void ReconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReconnectButtonActionPerformed
        
        ConnectThread  t = new ConnectThread();
        this.jProgressBar.setVisible(true);
        this.ReconnectButton.setVisible(false);
        new Thread(t). start ( );
    }//GEN-LAST:event_ReconnectButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
      
      String username = UsernameField.getText();
      char[] password = PasswordField.getPassword();
      this.UsernameField.setText("");
      this.PasswordField.setText("");

        if(username.equals("") || password.length==0){
              System.out.println("Invalid Username");
              UIError errorFrame = new UIError();
              errorFrame.setErrorTitleLabel(java.util.ResourceBundle.getBundle(Lang).getString("ErrorLabel"));
              errorFrame.setTextErrorLabel(java.util.ResourceBundle.getBundle(Lang).getString("InvalidParameter"));
              errorFrame.setVisible(true);
          } else{
              String pass = new String(password);
              MD5Pwd enc = new MD5Pwd();
              String passEnc=null;
              this.LoginButton.setEnabled(false);
              try {
                    passEnc = enc.encode(username, pass);
              } catch (Exception ex) {
                    System.err.println("Error encrypting password");
              }
              ComCliente com;
              try {
                    //sends request to server
                    com = ComCliente.getInstance();
                    com.login(username, passEnc);
                } catch (Exception ex) {
                    System.out.println("LoginUI: unable to get instance");
                }
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void LanguageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanguageButtonActionPerformed
        
        if (Lang.equals("resources/Portugues_pt_PT_EURO")){
             this.LanguageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/uk.png")));
             Language.getInstance().SetLanguageEN();
             UpdateLanguage();
        }else{
            this.LanguageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pt.png")));
            Language.getInstance().SetLanguagePT();
            UpdateLanguage();
        }
       
    }//GEN-LAST:event_LanguageButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(UIInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                new UIInitial().setVisible(true);
              
            }
             
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton HelpButton;
    private javax.swing.JToggleButton LanguageButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel Logo;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton ReconnectButton;
    private javax.swing.JButton RecoverPassButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel ServerStateLabel;
    private javax.swing.JLabel ServerStateQuery;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables
}
