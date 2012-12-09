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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(estadoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(PubNameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PubNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(PubLinkLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PubLinkTextField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addPubButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removePubButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PubLinkLabel)
                    .addComponent(PubLinkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PubNameLabel)
                    .addComponent(PubNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(estadoLabel)
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPubButton)
                    .addComponent(removePubButton))
                .addContainerGap())
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
        System.out.println(GetDate.now()+": Server Started.");
       
        
    }//GEN-LAST:event_StartButtonActionPerformed

    private void addPubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPubButtonActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_addPubButtonActionPerformed

    private void PubLinkTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PubLinkTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PubLinkTextFieldActionPerformed

    private void removePubButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePubButtonActionPerformed
        // TODO add your handling code here:
        DataWrite DBwrite = new DataWrite();
        
        String pubLink = PubLinkTextField.toString();
        String pubName = PubNameTextField.toString();
        
        //inserir utilizador na DB (tratar das estatisticas e etc... apenas insere na tabela user)

            try {
                DBwrite.DeletePub(pubName);
                estadoLabel.setText("Publicidade Removida");
            } catch (SQLException ex) {
                System.out.println("Exception: DBwrite.InsertUser() " + ex);
                estadoLabel.setText("Publicidade Nao Removida");
            }
    }//GEN-LAST:event_removePubButtonActionPerformed
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
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel PubLinkLabel;
    private javax.swing.JTextField PubLinkTextField;
    private javax.swing.JLabel PubNameLabel;
    private javax.swing.JTextField PubNameTextField;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton addPubButton;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton removePubButton;
    // End of variables declaration//GEN-END:variables
}
