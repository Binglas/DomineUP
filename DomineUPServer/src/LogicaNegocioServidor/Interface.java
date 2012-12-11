/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioServidor;

import RecolhaDados.DataFile;
import RecolhaDados.DataWrite;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

/**
 * Interface do Servidor, permite ligar e desligar o servidor.
 *
 * @author Luciano, Andre
 */
public class Interface extends javax.swing.JFrame {

    FileOutputStream log;
    DataFile saveLog;

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        estadoLabel.setText("");
        try {
            log = new FileOutputStream("log_" + GetDate.now() + ".txt", true);
        } catch (Exception ex) {
            System.out.println("Error starting log file... Exception: " + ex);
        }
        saveLog = new DataFile();

    }
    private ServerThread serverThread;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StartButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        addPubButton = new javax.swing.JButton();
        PubLinkLabel = new javax.swing.JLabel();
        PubNameLabel = new javax.swing.JLabel();
        PubLinkTextField = new javax.swing.JTextField();
        PubNameTextField = new javax.swing.JTextField();
        removePubButton = new javax.swing.JButton();
        estadoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BanusernameTextField = new javax.swing.JTextField();
        BanPlayerButton = new javax.swing.JButton();
        UnbanPlayerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        StartButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        ExitButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/final_logo_server.fw.png"))); // NOI18N

        addPubButton.setText("Adicionar PUB");
        addPubButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPubButtonActionPerformed(evt);
            }
        });

        PubLinkLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PubLinkLabel.setText("Pub Link:");

        PubNameLabel.setText("Pub Name:");

        PubLinkTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PubLinkTextFieldActionPerformed(evt);
            }
        });

        removePubButton.setText("Remover PUB");
        removePubButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePubButtonActionPerformed(evt);
            }
        });

        estadoLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoLabel.setText("jLabel1");

        jLabel1.setText("Username:");

        BanusernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanusernameTextFieldActionPerformed(evt);
            }
        });

        BanPlayerButton.setText("Ban Player");
        BanPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanPlayerButtonActionPerformed(evt);
            }
        });

        UnbanPlayerButton.setText("Unban Player");
        UnbanPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnbanPlayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PubLinkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PubLinkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(estadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(PubNameLabel)
                                            .addGap(10, 10, 10)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PubNameTextField)
                                        .addComponent(BanusernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))))
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removePubButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPubButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UnbanPlayerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BanPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PubLinkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PubLinkLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(PubNameLabel))
                    .addComponent(PubNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BanusernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estadoLabel)
                .addGap(18, 18, 18)
                .addComponent(addPubButton)
                .addGap(6, 6, 6)
                .addComponent(removePubButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UnbanPlayerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BanPlayerButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        // TODO add your handling code here:

        this.serverThread = new ServerThread(4444);
        this.serverThread.start();
        this.StartButton.setEnabled(false);
        //redirectSystemStreams();
        System.out.println(GetDate.now() + ": Server Started.");


    }//GEN-LAST:event_StartButtonActionPerformed

    private void addPubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPubButtonActionPerformed
        // TODO add your handling code here:
        if (!(PubLinkTextField.getText().equals("") && PubNameTextField.getText().equals(""))) {
            DataWrite DBwrite = new DataWrite();

            String pubLink = PubLinkTextField.getText();
            String pubName = PubNameTextField.getText();

            PubLinkTextField.setText("");
            PubNameTextField.setText("");
            estadoLabel.setText("");

            //inserir utilizador na DB (tratar das estatisticas e etc... apenas insere na tabela user)

            try {
                DBwrite.InsertPub(pubLink, pubName);
                estadoLabel.setText("Publicidade Inserida");
            } catch (SQLException ex) {
                System.out.println("Exception: DBwrite.InsertUser() " + ex);
                estadoLabel.setText("Publicidade Nao Inserida");
            }
        } else {
            estadoLabel.setText("Nao escolheu publicidade");
        }

    }//GEN-LAST:event_addPubButtonActionPerformed

    private void PubLinkTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PubLinkTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PubLinkTextFieldActionPerformed

    private void removePubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePubButtonActionPerformed
        // TODO add your handling code here:
        if (!(PubLinkTextField.getText().equals("") && PubNameTextField.getText().equals(""))) {
            DataWrite DBwrite = new DataWrite();

            String pubLink = PubLinkTextField.getText();
            String pubName = PubNameTextField.getText();

            //inserir utilizador na DB (tratar das estatisticas e etc... apenas insere na tabela user)

            try {
                DBwrite.DeletePub(pubName);
                estadoLabel.setText("Publicidade Removida");
            } catch (SQLException ex) {
                System.out.println("Exception: DBwrite.InsertUser() " + ex);
                estadoLabel.setText("Publicidade Nao Removida");
            }
        } else {
            estadoLabel.setText("Nao escolheu publicidade");
        }

    }//GEN-LAST:event_removePubButtonActionPerformed

    private void BanPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanPlayerButtonActionPerformed
        // TODO add your handling code here:
        if (!BanusernameTextField.getText().equals("")) {
            DataWrite DBwrite = new DataWrite();

            String username = BanusernameTextField.getText();

            //inserir utilizador na DB (tratar das estatisticas e etc... apenas insere na tabela user)

            try {
                DBwrite.BanPlayer(username);
                estadoLabel.setText("Utilizador Banido");
            } catch (SQLException ex) {
                System.out.println("Exception: DBwrite.InsertUser() " + ex);
                estadoLabel.setText("Utilizador Nao Banido");
            }
        } else {
            estadoLabel.setText("Nao escolhe utilizador");
        }

    }//GEN-LAST:event_BanPlayerButtonActionPerformed

    private void UnbanPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnbanPlayerButtonActionPerformed
        // TODO add your handling code here:

        if (!BanusernameTextField.getText().equals("")) {
            DataWrite DBwrite = new DataWrite();

            String username = BanusernameTextField.getText();

            //inserir utilizador na DB (tratar das estatisticas e etc... apenas insere na tabela user)

            try {
                DBwrite.UnbanPlayer(username);
                estadoLabel.setText("Utilizador Aceite");
            } catch (SQLException ex) {
                System.out.println("Exception: DBwrite.InsertUser() " + ex);
                estadoLabel.setText("Utilizador Banido");
            }
        } else {
            estadoLabel.setText("Nao escolhe utilizador");
        }


    }//GEN-LAST:event_UnbanPlayerButtonActionPerformed

    private void BanusernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanusernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BanusernameTextFieldActionPerformed
    private void updateTextArea(final String text) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                saveLog.saveLogs(text, log);
            }
        });
    }

    private void redirectSystemStreams() {

        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BanPlayerButton;
    private javax.swing.JTextField BanusernameTextField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel PubLinkLabel;
    private javax.swing.JTextField PubLinkTextField;
    private javax.swing.JLabel PubNameLabel;
    private javax.swing.JTextField PubNameTextField;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton UnbanPlayerButton;
    private javax.swing.JButton addPubButton;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton removePubButton;
    // End of variables declaration//GEN-END:variables
}
