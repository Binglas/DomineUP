/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ComunicacaoCliente.ComCliente;
import LogicaNegocioCliente.musica_fundo;
import Share.GameRoom;
import Share.Hand;
import Share.Piece;
import Share.User;
import UserInterface.RotatedIcon.Rotate;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 * Interface da sala de jogo e toda a sua usabilidade
 * 
 * @author Luciano
 */
public class UIGameRoom extends javax.swing.JFrame {

    public static musica_fundo musica;
    
    ComCliente com;
    int lastY;
    int lastX;
    int DeckPieces=28;
    public User PlayerTime; //saber de quem é a vez
    private Hashtable<JLabel, Piece> piecesPosition = new Hashtable<JLabel, Piece>();
    GameRoom gameRoom;
    int x = 75;
    int y = 35;
    public int leftSide=0;
    public int rightSide=0;
    public int newleftSide=0;
    public int newrightSide=0;
    JPanel[] handsPanel = new JPanel[3];
    /**
     * Creates new form UIGameRoom
     */
    public UIGameRoom() {
        initComponents();
        lastY = tabuleiro.getHeight() / 2;
        lastX = tabuleiro.getWidth() / 2;
        textAreaChatWindow.setLineWrap(true);
        textAreaChatWindow.setWrapStyleWord(true);
        this.pack();
    }
    /**
     * Creates new form UIGameRoom
     */
    public UIGameRoom(Hand hand,GameRoom gr) throws IOException {
        initComponents();
         //add pub
        if (0!=UIWelcomeScreen.puburl.getSizeMensagem()){
            BufferedImage img = ImageIO.read(new URL(UIWelcomeScreen.puburl.getArguments().get(0).toString()));
            ImageIcon icone = new ImageIcon(img);  
            pub.setIcon(icone);
        }
        lastY = tabuleiro.getHeight() / 2;
        lastX = tabuleiro.getWidth() / 2;
        textAreaChatWindow.setLineWrap(true);
        textAreaChatWindow.setWrapStyleWord(true);
        
        int roomIndex= 0;
        int i =0;
        
       Player1.setText(UIWelcomeScreen.player.getUsername());
       this.avatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/min_"+UIWelcomeScreen.player.getAvatar())));
       gameRoom = gr;
       
       ArrayList<User> players = (ArrayList<User>) gr.getPlayers();
       ArrayList<Hand> hands = null;
       
       
       JLabel[] playersLbl = new JLabel[3];
       JLabel[] avatarsLbl = new JLabel[3];
      
       
       playersLbl[0] = Player2;
       playersLbl[1] = Player3;
       playersLbl[2] = Player4;
       
       avatarsLbl[0] = avatar2;
       avatarsLbl[1] = avatar3;
       avatarsLbl[2] = avatar4;
       
       hand1.setName(Player1.getText());
       hand2.setName(Player2.getText());
       hand3.setName(Player3.getText());
       hand4.setName(Player4.getText());
       
       handsPanel[0] = hand2;
       handsPanel[1] = hand3;
       handsPanel[2] = hand4;
       
       i = 0;
       
       for(User u: gr.getPlayers()){
           if(u.getUsername().equals(UIWelcomeScreen.player.getUsername()))
               continue;
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
           DeckPieces=DeckPieces-7;
           
       }
     
       PlayerTime=gameRoom.getPlayerbyUsername(gameRoom.getCreator());
       DeckPiecesNumberLabel.setText(Integer.toString(DeckPieces));
       populateHand(hand1, hand, Rotate.NORMAL);
       Estado.setText("Vez do jogador "+PlayerTime.getUsername());
    }
    
    private void populateHand(JPanel panel, Hand hand,Rotate r){
        
        for(Piece p : hand.getPieces()){
            JLabel j = new JLabel();
            
            if (panel.equals(hand1)){
                Icon i = new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/"+p.getImage()));
                j.setIcon(new RotatedIcon(i,r));
                j.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                PieceCliked(evt);
            }
                        
                    /*
                    * Função que verifica qual foi a peça clicada
                    * @param evt evento da label
                    */ 
                    private void PieceCliked(MouseEvent evt) {
                        
                         //verifica de quem é a vez para desactivar botoes
                        if (UIWelcomeScreen.player.getUsername().equals(PlayerTime.getUsername())) {
                             
                                                       
                            com = ComCliente.getInstance();
                            com.TryPlayPiece(UIWelcomeScreen.player, piecesPosition.get(((JLabel) evt.getComponent())),gameRoom);
                        } else {
                            UIError erro = new UIError();
                            erro.setTextErrorLabel("Não é a sua vez!");
                            erro.setVisible(true);
                        }

                    }
                });
            }else{
                Icon i = new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/costas.png"));
                j.setIcon(new RotatedIcon(i,r));
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
            piecesPosition.put(j,p);
            panel.add(j);
            this.pack();
             
        }
        
    }
    public void setState(String state){
        
        Estado.setText(state);
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
        pub = new javax.swing.JLabel();
        VolumeLogoOff = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        hand3 = new javax.swing.JPanel();
        hand1 = new javax.swing.JPanel();
        hand4 = new javax.swing.JPanel();
        hand2 = new javax.swing.JPanel();
        DeckLabel = new javax.swing.JLabel();
        DeckPiecesNumberLabel = new javax.swing.JLabel();
        piecesTextLabel = new javax.swing.JLabel();
        Estado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/final_logo_mini.png"))); // NOI18N

        jScrollPane1.setAutoscrolls(true);

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

        pub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        VolumeLogoOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/soundoff.png"))); // NOI18N

        jToggleButton2.setText("jToggleButton2");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        hand3.setPreferredSize(new java.awt.Dimension(75, 0));
        hand3.setLayout(new java.awt.GridLayout(0, 3));

        hand1.setPreferredSize(new java.awt.Dimension(0, 75));
        hand1.setLayout(new java.awt.GridLayout(1, 0));

        hand4.setPreferredSize(new java.awt.Dimension(75, 0));
        hand4.setLayout(new java.awt.GridLayout(0, 3));

        hand2.setPreferredSize(new java.awt.Dimension(0, 75));
        hand2.setLayout(new java.awt.GridLayout(1, 0));

        DeckLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/deck.png"))); // NOI18N

        DeckPiecesNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeckPiecesNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeckPiecesNumberLabel.setText("XX");

        piecesTextLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        piecesTextLabel.setText("Peças");

        Estado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Estado.setText("Estado:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VolumeLogoOff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VolumeControl, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VolumeLogoOn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(avatar3)
                                        .addGap(61, 61, 61))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Player3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(hand3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(avatar1)
                                                .addGap(87, 87, 87))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(Player1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addComponent(hand1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DeckLabel)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(DeckPiecesNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(piecesTextLabel)))
                                        .addGap(19, 19, 19))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(Player2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hand2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pub, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(238, 238, 238)
                                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Player4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hand4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(avatar4)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(txtChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton2))
                            .addComponent(ChatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(VolumeControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(VolumeLogoOn)
                                .addComponent(VolumeLogoOff))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pub, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hand2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avatar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hand3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabuleiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(avatar4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Player4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hand4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avatar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2))
                    .addComponent(hand1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeckPiecesNumberLabel)
                            .addComponent(piecesTextLabel))))
                .addGap(27, 27, 27))
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
        //addPeca();
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    public void updateUI(String estado,Piece pecaremovida,User playerdajogada){
        
        //DeckPieces--;
        DeckPiecesNumberLabel.setText(Integer.toString(DeckPieces));
        Estado.setText("Estado:"+estado);
        
         Set set = piecesPosition.entrySet();
         Iterator it = set.iterator();
            
        if (playerdajogada.getUsername().equals(UIWelcomeScreen.player.getUsername())){ 
            //limpar uma peca hand do jogador que fez a jogada
            
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next(); 
                if(entry.getValue().equals(pecaremovida)){
                    JLabel label =  (JLabel)entry.getKey();
                    Container parent = label.getParent();
                    parent.remove(label);
                    parent.validate();
                    parent.repaint();
                    piecesPosition.remove(entry.getKey());
                    break;
                }
                    
            }
        }else{//limpar uma peca costas do jogador que fez a jogada
            
            for (int i=1;i<handsPanel.length;i++){
                if(handsPanel[i].getName().equals(playerdajogada.getUsername())){
                   
                    handsPanel[i].remove(0);
                    handsPanel[i].validate();
                    handsPanel[i].repaint();
                }
            } 
           
        }
    }
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
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    new UIGameRoom().setVisible(true);
                
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChatLabel;
    private javax.swing.JLabel DeckLabel;
    private javax.swing.JLabel DeckPiecesNumberLabel;
    private javax.swing.JLabel Estado;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel piecesTextLabel;
    private javax.swing.JLabel pub;
    private javax.swing.JPanel tabuleiro;
    private javax.swing.JTextArea textAreaChatWindow;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables

    public void addPeca(Piece piece) {
        
        if(rightSide == 0 && leftSide==0){
        Rotate r = Rotate.UP;    
        JLabel j = new JLabel();
        Icon i = new RotatedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/"+piece.getImage()+"")), r);
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
        leftSide=newleftSide;
        rightSide=newrightSide;
        
        }else if(rightSide == newleftSide){
        Rotate r = Rotate.UP;    
        JLabel j = new JLabel();
        Icon i = new RotatedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/"+piece.getImage()+"")), r);
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
        leftSide=newleftSide;
        rightSide=newrightSide;
        
        }else if(rightSide == newrightSide){
            Rotate r = Rotate.UPSIDE_DOWN; 
            JLabel j = new JLabel();
            Icon i = new RotatedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pecas/"+piece.getImage()+"")), r);
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
                case ABOUT_CENTER:
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
            leftSide=newleftSide;
            rightSide=newrightSide;
        }
        

    }
}
