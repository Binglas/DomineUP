/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import ComunicacaoCliente.ComCliente;
import LogicaNegocioCliente.Language;
import LogicaNegocioCliente.ReaderThread;
import Share.MD5Pwd;
import java.awt.Toolkit;
import javax.swing.JFrame;

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
        this.setIconImage(Toolkit.getDefaultToolkit() 
        .getImage("/resources/ico.png"));
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        this.RecoverPassButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("RecoverPassButton"));
        this.LoginGuestButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("LoginGuest"));
        
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
                        this.LoginGuestButton.setEnabled(true);
                        new ReaderThread(this,registerScreen,recoverPassScreen).start();
                        this.ServerStateQuery.setText(java.util.ResourceBundle.getBundle(Lang).getString("Connected"));

                    }

                } catch (Exception e) {
                    System.out.println("Errorz establishing Connection");
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

        jLabel1 = new javax.swing.JLabel();
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
        LoginGuestButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/background.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources/Portugues_pt_PT_EURO"); // NOI18N
        setTitle(bundle.getString("AppTitle")); // NOI18N
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ExitButton.setText(bundle.getString("ExitGameButton")); // NOI18N
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ExitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 422, 186, 65));

        HelpButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HelpButton.setText(bundle.getString("HelpButton")); // NOI18N
        HelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpButtonActionPerformed(evt);
            }
        });
        getContentPane().add(HelpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 421, 186, 66));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/final_logo.png"))); // NOI18N
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 189, 341, 114));

        UsernameField.setEnabled(false);
        UsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameFieldActionPerformed(evt);
            }
        });
        UsernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UsernameFieldKeyPressed(evt);
            }
        });
        getContentPane().add(UsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 228, 31));

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UsernameLabel.setText(bundle.getString("UsernameLabel")); // NOI18N
        getContentPane().add(UsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 186, -1));

        RegisterButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RegisterButton.setText(bundle.getString("RegisterButton")); // NOI18N
        RegisterButton.setEnabled(false);
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 105, 32));

        LoginButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LoginButton.setText(bundle.getString("LoginButton")); // NOI18N
        LoginButton.setEnabled(false);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 118, 32));

        RecoverPassButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RecoverPassButton.setText(bundle.getString("RecoverPassButton")); // NOI18N
        RecoverPassButton.setEnabled(false);
        RecoverPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecoverPassButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RecoverPassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 229, 32));

        PasswordField.setEnabled(false);
        PasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordFieldKeyPressed(evt);
            }
        });
        getContentPane().add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 228, 28));

        PasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PasswordLabel.setText(bundle.getString("PasswordLabel")); // NOI18N
        getContentPane().add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 186, -1));

        jProgressBar.setIndeterminate(true);
        getContentPane().add(jProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 329, 341, -1));

        ReconnectButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ReconnectButton.setText(bundle.getString("ReconnectButton")); // NOI18N
        ReconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReconnectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ReconnectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 361, -1, 36));

        ServerStateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ServerStateLabel.setText("Estado do servidor:");
        getContentPane().add(ServerStateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 130, -1));

        ServerStateQuery.setText("jLabel1");
        getContentPane().add(ServerStateQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 200, -1));

        LanguageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/uk.png"))); // NOI18N
        LanguageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LanguageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 58, 57));

        LoginGuestButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LoginGuestButton.setText("Entrar como visitante");
        LoginGuestButton.setEnabled(false);
        LoginGuestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginGuestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginGuestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 230, 33));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 520));

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
         this.setVisible(false);
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
             this.LanguageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pt.png")));
             
             Language.getInstance().SetLanguageEN();
             UpdateLanguage();
        }else{
            this.LanguageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/uk.png")));
            Language.getInstance().SetLanguagePT();
            UpdateLanguage();
        }
       
    }//GEN-LAST:event_LanguageButtonActionPerformed

    private void UsernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameFieldKeyPressed
      
        if(evt.getKeyCode()==10){
          
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
        }
          
    }//GEN-LAST:event_UsernameFieldKeyPressed

    private void PasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordFieldKeyPressed
        if(evt.getKeyCode()==10){
          
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
        }
    }//GEN-LAST:event_PasswordFieldKeyPressed
   
    private void LoginGuestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginGuestButtonActionPerformed
       ComCliente com;
              try {
                    //sends request to server
                    com = ComCliente.getInstance();
                    com.loginguest();
                } catch (Exception ex) {
                    System.out.println("LoginUI: unable to get instance");
                }
        dispose();
    }//GEN-LAST:event_LoginGuestButtonActionPerformed

    private void HelpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpButtonActionPerformed
        JFrame helpFrame = new net.sourceforge.helpgui.gui.MainFrame("/resources/","java");
        helpFrame.setVisible(true);
    }//GEN-LAST:event_HelpButtonActionPerformed
    
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
    private javax.swing.JButton LoginGuestButton;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables
}
