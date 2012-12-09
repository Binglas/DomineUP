/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ComunicacaoCliente.ComCliente;
import LogicaNegocioCliente.musica_fundo;
import Share.GameRoom;
import Share.Hand;
import Share.Pieces;
import Share.User;
import UserInterface.RotatedIcon.Rotate;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 * Interface da sala de jogo
 * @author Luciano
 */
public class UIGameRoom extends javax.swing.JFrame {

    public static musica_fundo musica;
    /**
     * Creates new form UIGameRoom
     */
    int lastY;
    int lastX;
    int lastXhand3=0;
    int lastXhand4=0;
    int lastYhand3=0;
    int lastYhand4=0;
    
    GameRoom gameRoom;

    public UIGameRoom() {
        initComponents();
        lastY = tabuleiro.getHeight() / 2;
        lastX = tabuleiro.getWidth() / 2;
        textAreaChatWindow.setLineWrap(true);
        textAreaChatWindow.setWrapStyleWord(true);
      
        this.pack();


    }

    public UIGameRoom(Hand hand,GameRoom gr) {
        initComponents();
        lastY = tabuleiro.getHeight() / 2;
        lastX = tabuleiro.getWidth() / 2;
        textAreaChatWindow.setLineWrap(true);
        textAreaChatWindow.setWrapStyleWord(true);
        
        int roomIndex= 0;
        int i =0;
        
       Player1.setText(UIWelcomeScreen.player.getUsername());
       this.avatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/min_"+UIWelcomeScreen.player.getAvatar())));
       gameRoom = gr;
       
       ArrayList<User> players = gr.getPlayers();
       ArrayList<Hand> hands = null;
       players.remove(UIWelcomeScreen.player);
       
       JLabel[] playersLbl = new JLabel[3];
       JLabel[] avatarsLbl = new JLabel[3];
       JPanel[] handsPanel = new JPanel[3];
       
       playersLbl[0] = Player2;
       playersLbl[1] = Player3;
       playersLbl[2] = Player4;
       
       avatarsLbl[0] = avatar2;
       avatarsLbl[1] = avatar3;
       avatarsLbl[2] = avatar4;
       
       handsPanel[0] = hand2;
       handsPanel[1] = hand3;
       handsPanel[2] = hand4;
       
        i = 0;
       
       for(User u: gr.getPlayers()){
           playersLbl[i].setText( u.getUsername());
           avatarsLbl[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/min_"+u.getAvatar())));
           if (i==3 || i==4){
               populateHand(handsPanel[i++], hand, Rotate.UP);
           }else{
               populateHand(handsPanel[i++], hand, Rotate.NORMAL);
           }
           
       }
     
       for(;i< 3;i++){
           playersLbl[i].setVisible(false);
           avatarsLbl[i].setVisible(false);
       }
       
       populateHand(hand1, hand, Rotate.NORMAL);
           
       
    }
    
    private void populateHand(JPanel panel, Hand hand,Rotate r){
        
        for(Pieces p : hand.getPieces()){
            JLabel j = new JLabel();
            
            
            if (panel.equals(hand1)){
                Icon i = new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/"+p.getImage()));
                j.setIcon(new RotatedIcon(i,r));
            }else{
                Icon i = new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/costas.png"));
                j.setIcon(new RotatedIcon(i,r));
                
                if (panel.equals(hand3)){ 
                    
                    if ((lastXhand3 +35) >hand3.WIDTH){
                        lastYhand3+=75;
                        lastXhand3=0;
                    }else{
                        lastXhand3+=35;
                    }
                     hand3.add(j,new AbsoluteConstraints(lastXhand3, lastYhand3, -1, -1));
                }
                
                if (panel.equals(hand4)){
                    if ((lastXhand4 +35) >hand4.WIDTH){
                        lastYhand4+=75;
                        lastXhand4=0;
                    }else{
                        lastXhand4+=35;
                        
                    }
                    hand4.add(j,new AbsoluteConstraints(lastYhand4, lastYhand4, -1, -1));
                }
                this.pack();
            }
  
            switch(r){
                case NORMAL:
                     j.setPreferredSize(new Dimension(35, 75));
                    break;
                case UP:
                case DOWN:
                     j.setPreferredSize(new Dimension(75, 35));
                    break;
                default:
                    break;

            }
           
            panel.add(j);
            this.pack();
             
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
        textAreaChatWindow = new javax.swing.JTextArea();
        ChatLabel = new javax.swing.JLabel();
        txtChat = new javax.swing.JTextField();
        avatar2 = new javax.swing.JLabel();
        avatar1 = new javax.swing.JLabel();
        avatar3 = new javax.swing.JLabel();
        avatar4 = new javax.swing.JLabel();
        tabuleiro = new javax.swing.JPanel();
        Player2 = new javax.swing.JLabel();
        Player4 = new javax.swing.JLabel();
        Player3 = new javax.swing.JLabel();
        Player1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        VolumeControl = new javax.swing.JSlider();
        VolumeLogoOn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        VolumeLogoOff = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        hand3 = new javax.swing.JPanel();
        hand1 = new javax.swing.JPanel();
        hand4 = new javax.swing.JPanel();
        hand2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/final_logo_mini.png"))); // NOI18N

        textAreaChatWindow.setEditable(false);
        textAreaChatWindow.setColumns(20);
        textAreaChatWindow.setRows(5);
        textAreaChatWindow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textAreaChatWindow.setMaximumSize(new java.awt.Dimension(164, 94));
        textAreaChatWindow.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(textAreaChatWindow);

        ChatLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ChatLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChatLabel.setText("Chat:");

        txtChat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtChat.setMaximumSize(new java.awt.Dimension(164, 2));
        txtChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatActionPerformed(evt);
            }
        });
        txtChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatEnterPressed(evt);
            }
        });

        avatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/min_avatar5.png"))); // NOI18N

        avatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/min_avatar5.png"))); // NOI18N

        avatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/min_avatar5.png"))); // NOI18N

        avatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/min_avatar5.png"))); // NOI18N

        tabuleiro.setBackground(new java.awt.Color(0, 102, 0));
        tabuleiro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Player2.setText("jLabel2");

        Player4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Player4.setText("jLabel2");

        Player3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Player3.setText("jLabel2");

        Player1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Player1.setText("jLabel2");
        Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teste(evt);
            }
        });

        jToggleButton1.setText("Sair");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        VolumeControl.setMaximum(0);
        VolumeControl.setMinimum(-40);
        VolumeControl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeControlStateChanged(evt);
            }
        });

        VolumeLogoOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/soundon.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PUBLICIDADE");

        VolumeLogoOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/soundoff.png"))); // NOI18N

        jToggleButton2.setText("jToggleButton2");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        hand3.setPreferredSize(new java.awt.Dimension(75, 0));
        hand3.setLayout(new java.awt.GridLayout(1, 0));

        hand1.setPreferredSize(new java.awt.Dimension(0, 75));
        hand1.setLayout(new java.awt.GridLayout(1, 0));

        hand4.setPreferredSize(new java.awt.Dimension(75, 0));
        hand4.setLayout(new java.awt.GridLayout(0, 2));

        hand2.setPreferredSize(new java.awt.Dimension(0, 75));
        hand2.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(avatar2)
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                        .addComponent(VolumeLogoOff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VolumeControl, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VolumeLogoOn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(Player2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hand2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Player3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(avatar3)
                                    .addComponent(hand3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(avatar1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(Player1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hand1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton2))
                                    .addComponent(tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ChatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Player4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hand4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(avatar4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(txtChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avatar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(VolumeControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(VolumeLogoOn)
                                .addComponent(VolumeLogoOff)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avatar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player3)
                        .addGap(18, 18, 18)
                        .addComponent(hand3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(avatar4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Player4)
                                .addGap(18, 18, 18)
                                .addComponent(hand4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChatLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avatar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton2)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(hand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChatActionPerformed

    private void txtChatEnterPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatEnterPressed
        String message = new String();
        message = txtChat.getText();

        if (evt.getKeyCode() == 10 && (!message.equals(""))) {


            txtChat.setText("");
            System.out.println(message);

            try {
                ComCliente com = ComCliente.getInstance();
                com.GameChat(UIWelcomeScreen.player, message);

            } catch (Exception ex) {
                System.out.println("enterPressed: unable to get instance");
            }

        }
    }//GEN-LAST:event_txtChatEnterPressed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void VolumeControlStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolumeControlStateChanged
        // TODO add your handling code here:
        int volume = (int) VolumeControl.getValue();
        UIWelcomeScreen.musica.musica_control((float) volume);

    }//GEN-LAST:event_VolumeControlStateChanged

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        addPeca();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void teste(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teste
        System.out.println(((JLabel) evt.getComponent()).getText());
    }//GEN-LAST:event_teste
    /**
     * Atualiza a área de chat com as mensagens que vão sendo introduzidas pelos
     * vários jogadores da sala.
     *
     * @param message mensagem introduzida por um dos jogadores da sala.
     */
    public void updateChat(String message) {
        this.textAreaChatWindow.append(message + '\n');
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
            java.util.logging.Logger.getLogger(UIGameRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIGameRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIGameRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIGameRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIGameRoom().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChatLabel;
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JLabel Player3;
    private javax.swing.JLabel Player4;
    private javax.swing.JSlider VolumeControl;
    private javax.swing.JLabel VolumeLogoOff;
    private javax.swing.JLabel VolumeLogoOn;
    private javax.swing.JLabel avatar1;
    private javax.swing.JLabel avatar2;
    private javax.swing.JLabel avatar3;
    private javax.swing.JLabel avatar4;
    private javax.swing.JPanel hand1;
    private javax.swing.JPanel hand2;
    private javax.swing.JPanel hand3;
    private javax.swing.JPanel hand4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPanel tabuleiro;
    private javax.swing.JTextArea textAreaChatWindow;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables
    Rotate r = Rotate.UP;
    int x = 75;
    int y = 35;
    private void addPeca() {
        
        JLabel j = new JLabel();
        Icon i = new RotatedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/peca31.png")), r);
        j.setIcon(i);
        
        j.setPreferredSize(new Dimension(x, y));
        tabuleiro.add(j,new AbsoluteConstraints(lastX, lastY, -1, -1));
        switch(r){
            case UP:
                 lastX += 75;
                 break;
            case NORMAL:
                lastY += 75;
                break;
            case DOWN:
                lastX -= 75;
                break;
            default: break;
                
        }
       
        if(lastX +75 > tabuleiro.getWidth()-35 && r == Rotate.UP){
            r = Rotate.NORMAL;
           
           // lastY -= 35/4;
            x = 35;
            y= 75;
            
        }else if(lastY + 75 > tabuleiro.getHeight()-35 ){
             r = Rotate.DOWN;
           
            lastX = tabuleiro.getWidth() - 150;
            x = 75;
            y= 35;
        }
        this.pack();
        

    }
}
