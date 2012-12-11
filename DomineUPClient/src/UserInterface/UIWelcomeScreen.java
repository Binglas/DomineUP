/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import ComunicacaoCliente.ComCliente;
import LogicaNegocioCliente.Language;
import LogicaNegocioCliente.musica_fundo;
import Share.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import Share.GameRoom;
import Share.Message;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Este é o interface após o utilizador ter realizado o login, contém dados do utilizador,
 * como estatísticas, username,avatar. Pode também aceder às opções, controlar o volume do som
 * e fazer logout.
 * @author Luciano
 */
public class UIWelcomeScreen extends javax.swing.JFrame {
    
    
    public static UIConfiguracoes optionScreen;
    public static UICreateRoom createRoomScreen;
    public static UIWaitingRoom waitingRoomScreen;
    public static UIGameRoom uiGameRoom;
    public static UIinvited uiinvited;
    public static Message puburl;
    public static UIRank uirank = new UIRank();
    public static ArrayList<User> usersOnlineList;
    public static ArrayList<GameRoom> roomsOnlineList;
    public static User player;
    public static UIConfiguracoes config;
    public static musica_fundo musica;
    
    public String Lang = Language.getInstance().GetLanguage();
   
    
    public  UIWelcomeScreen(){
        initComponents();
        setLocationRelativeTo(null);
        
     }
    
    /**
     * Creates instancia da classe UIWelcomeScreen
     */
    public UIWelcomeScreen(User Jogador) {
        initComponents();
       
        player=Jogador;
        this.UsernameLabel.setText(Jogador.getUsername());
        setLocationRelativeTo(null);
        this.gamesplayed.setText(this.gamesplayed.getText()+" "+Integer.toString(Jogador.getgamesplayed()));
        this.winGames.setText(this.winGames.getText()+" "+Integer.toString(Jogador.getgameswon()));
        this.lostGames.setText(this.lostGames.getText()+" "+Integer.toString(
                Jogador.getgamesplayed()-Jogador.getgameswon()));
        this.ratio.setText(this.ratio.getText()+" "+Float.toString(
                ((float)Jogador.getgameswon())/(float)Jogador.getgamesplayed()));
        
        this.avatarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/"+Jogador.getAvatar())));

        optionScreen = new UIConfiguracoes(Jogador);
    }
    
     /**
     * Este método permite atualizar todos os campos de texto para a linguagem definida 
     * na interface inicial, com o auxílio da classe Language.java.
     * @author João Machado
     * 
     */
    private void UpdateLanguage(){
        Lang=Language.getInstance().GetLanguage();
    //    registerScreen.Lang=Lang;        
    //    registerScreen.UpdateLanguage();
    //    recoverPassScreen.Lang=Lang;
    //    recoverPassScreen.UpdateLanguage();
        //this.UsernameLabel.setText(java.util.ResourceBundle.getBundle(Lang).getString("UsernameLabel"));
    //    this.PasswordLabel.setText(java.util.ResourceBundle.getBundle(Lang).getString("PasswordLabel"));
    //    this.StartGameButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("StartGameButton"));
    //    this.ExitButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("ExitGameButton"));
    //    this.LoginButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("LoginButton"));
    //    this.RegisterButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("RegisterButton"));
    //    this.HelpButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("HelpButton"));
    //    this.RecoverPassButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("RecoverPassButton"));
    //    this.ReconnectButton.setText(java.util.ResourceBundle.getBundle(Lang).getString("ReconnectButton"));
    //    this.ServerStateLabel.setText(java.util.ResourceBundle.getBundle(Lang).getString("ServerStateLabel"));
    //    this.ServerStateQuery.setText(java.util.ResourceBundle.getBundle(Lang).getString("Connected"));
    }
    
      /**
     * Set genérico
     */
    public void setOptionsButton(){
        OptionsButton.setEnabled(true);
    }
     /**
     * Set genérico
     */
    public void setDisableOptionsButton(){
        OptionsButton.setEnabled(false);
    }  
    /**
     * Set genérico
     */
    public void setCreateRoomButton(){
        CreateRoomButton.setEnabled(true);
    }
     /**
     * Set genérico
     */
    public void setDisableRoomButton(){
        CreateRoomButton.setEnabled(false);
    }
    /**
     * Set genérico
     */
    public void setRoomButton(){
         JoinRoomButton.setEnabled(true);
    }
    
    /**
     * Set genérico
     */
    public void setRankLabel(String text){
         RankLabel.setText(text);
    }        
    /**
     * Set genérico
     */
    public void JoinRoomStatusLabel(String texto){
         JoinRoomStatusLabel.setText(texto);
    }
    
    /**
     * Creates instancia da classe UIWelcomeScreen
     */
    public void UIWelcomeSetVisible(){
        this.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tittle = new javax.swing.JLabel();
        Leave = new javax.swing.JButton();
        UsernameLabel = new javax.swing.JLabel();
        VolumeControl = new javax.swing.JSlider();
        RankButton = new javax.swing.JButton();
        StatisticsLabel = new javax.swing.JLabel();
        WelcomeLabel = new javax.swing.JLabel();
        VolumeLogoOn = new javax.swing.JLabel();
        VolumeLogoOff = new javax.swing.JLabel();
        avatarLabel = new javax.swing.JLabel();
        winGames = new javax.swing.JLabel();
        lostGames = new javax.swing.JLabel();
        RankLabel = new javax.swing.JLabel();
        ratio = new javax.swing.JLabel();
        gamesplayed = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        UserList = new javax.swing.JTable();
        OnlinePlayersLabel = new javax.swing.JLabel();
        CreateRoomButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaChatWindow = new javax.swing.JTextArea();
        txtChat = new javax.swing.JTextField();
        LanguageButton = new javax.swing.JToggleButton();
        ChatLabel = new javax.swing.JLabel();
        GameRoomsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RoomList = new javax.swing.JTable();
        JoinRoomButton = new javax.swing.JButton();
        RoomPasswordLabel = new javax.swing.JLabel();
        JoinRoomStatusLabel = new javax.swing.JLabel();
        RoomPasswordField = new javax.swing.JPasswordField();
        OptionsButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pub = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tittle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Tittle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/final_logo.png"))); // NOI18N
        getContentPane().add(Tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 11, -1, -1));

        Leave.setText("Logout");
        Leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveActionPerformed(evt);
            }
        });
        getContentPane().add(Leave, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 113, 56));

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setText("jLabel1");
        getContentPane().add(UsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 117, 171, -1));

        VolumeControl.setMaximum(0);
        VolumeControl.setMinimum(-40);
        VolumeControl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeControlStateChanged(evt);
            }
        });
        getContentPane().add(VolumeControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 56, 101, -1));

        RankButton.setText("Rank Servidor");
        RankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RankButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RankButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 122, 56));

        StatisticsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StatisticsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        StatisticsLabel.setText("Estatísticas:");
        getContentPane().add(StatisticsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 140, 139, -1));

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WelcomeLabel.setText("Bem Vindo,");
        getContentPane().add(WelcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 117, -1, -1));

        VolumeLogoOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/soundon.png"))); // NOI18N
        getContentPane().add(VolumeLogoOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 48, -1, -1));

        VolumeLogoOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/soundoff.png"))); // NOI18N
        getContentPane().add(VolumeLogoOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 48, -1, -1));

        avatarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/avatar5.png"))); // NOI18N
        getContentPane().add(avatarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 140, -1, 127));

        winGames.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winGames.setText("Jogos Ganhos:");
        getContentPane().add(winGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 213, 139, -1));

        lostGames.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lostGames.setText("Jogos Perdidos:");
        getContentPane().add(lostGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 233, 139, -1));

        RankLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RankLabel.setText("Rank:");
        getContentPane().add(RankLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 173, 139, -1));

        ratio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ratio.setText("Rácio:");
        getContentPane().add(ratio, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 253, 139, -1));

        gamesplayed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gamesplayed.setText("Jogos Realizados:");
        getContentPane().add(gamesplayed, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 193, 139, -1));

        UserList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        UserList.setSelectionBackground(new java.awt.Color(204, 204, 255));
        UserList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(UserList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 318, 212, 231));

        OnlinePlayersLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OnlinePlayersLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OnlinePlayersLabel.setText("Jogadores Online:");
        getContentPane().add(OnlinePlayersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 285, 262, -1));

        CreateRoomButton.setText("Criar Sala");
        CreateRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateRoomButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CreateRoomButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 338, 113, 54));

        textAreaChatWindow.setEditable(false);
        textAreaChatWindow.setColumns(20);
        textAreaChatWindow.setRows(5);
        textAreaChatWindow.setAutoscrolls(false);
        textAreaChatWindow.setBorder(null);
        textAreaChatWindow.setMaximumSize(new java.awt.Dimension(164, 94));
        textAreaChatWindow.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(textAreaChatWindow);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 500, 97));

        txtChat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        getContentPane().add(txtChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 500, -1));

        LanguageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pt.png"))); // NOI18N
        LanguageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LanguageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 25, 58, 57));

        ChatLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ChatLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChatLabel.setText("Chat:");
        getContentPane().add(ChatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 262, -1));

        GameRoomsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GameRoomsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GameRoomsLabel.setText("Salas de Jogo:");
        getContentPane().add(GameRoomsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 140, 262, -1));

        RoomList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room", "Players", "State", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RoomList.setSelectionBackground(new java.awt.Color(204, 204, 255));
        RoomList.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(RoomList);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 178, 504, 153));

        JoinRoomButton.setText("Juntar sala");
        JoinRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinRoomButtonActionPerformed(evt);
            }
        });
        getContentPane().add(JoinRoomButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 338, 113, 54));

        RoomPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RoomPasswordLabel.setText("Inserir Password Sala:");
        getContentPane().add(RoomPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 343, -1, -1));

        JoinRoomStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(JoinRoomStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 398, 262, 20));
        getContentPane().add(RoomPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 364, 242, 28));

        OptionsButton.setText("Opções");
        OptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(OptionsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 113, 56));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, -1, -1));

        pub.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(pub, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 11, 291, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RankButtonActionPerformed
        try{
            ComCliente com = ComCliente.getInstance();
            com.requestRank();
        }catch (Exception ex) {
            System.out.println("Erro no logout");
        }
        uirank.setVisible(true);
    }//GEN-LAST:event_RankButtonActionPerformed

    private void LeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveActionPerformed
        // TODO add your handling code here:
        try{
            ComCliente com = ComCliente.getInstance();
            com.logout(player);
        }catch (Exception ex) {
            System.out.println("Erro no logout");
        }
        musica.music_stop();        
    }//GEN-LAST:event_LeaveActionPerformed

    private void CreateRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateRoomButtonActionPerformed
        
        CreateRoomButton.setEnabled(false);
        JoinRoomButton.setEnabled(false);
        createRoomScreen= new UICreateRoom();
        createRoomScreen.setVisible(true);
    }//GEN-LAST:event_CreateRoomButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         try {
            musica.music();
        } catch (IOException | LineUnavailableException ex) {
            Logger.getLogger(UIInitial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void VolumeControlStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolumeControlStateChanged
        // TODO add your handling code here:
        int volume = (int) VolumeControl.getValue();
        musica.musica_control((float)volume);        
        
    }//GEN-LAST:event_VolumeControlStateChanged
    
    /**
     * Atualiza a área de chat com as mensagens que vão sendo introduzidas pelos vários jogadores da sala.
     * @param message mensagem introduzida por um dos jogadores da sala.
     */
    public void updateChat(String message){
        this.textAreaChatWindow.append(message+'\n');
    }
    
    
    
    private void txtChatEnterPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatEnterPressed
        String message = new String();
        message = txtChat.getText();
        
        if(evt.getKeyCode()==10&&(!message.equals(""))){
            

            txtChat.setText("");
            System.out.println(message);

            try{
                ComCliente com = ComCliente.getInstance();
                com.roomChat(UIWelcomeScreen.player, message);

            }catch (Exception ex){
                System.out.println("enterPressed: unable to get instance");
            }

        }
    }//GEN-LAST:event_txtChatEnterPressed

    private void txtChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChatActionPerformed

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

    private void JoinRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinRoomButtonActionPerformed
            
            String roomName;
            JoinRoomButton.setEnabled(false);
            JoinRoomStatusLabel.setText("");
            int rowS = RoomList.getSelectedRow();
            
            
            
            if(rowS!=-1 && !RoomList.getValueAt(rowS, 0).toString().equals("")){
                
                roomName = RoomList.getValueAt(rowS, 0).toString();
                
                //testar se a sala n esta cheia
                if (roomsOnlineList.get(rowS).getCurPlayers()<roomsOnlineList.get(rowS).getNumPlayers()){
                    
                    if (RoomPasswordField.getText().equals(roomsOnlineList.get(rowS).getPassword())){
                      
                        try {
                        ComCliente com = ComCliente.getInstance();
                        com.joinRoom(roomName, player);

                        } catch (Exception ex) {
                            System.out.println("welcomeScreenUI: unable to get Instance in Join");
                        }
                    }else{ //password errada
                        JoinRoomStatusLabel.setText("A password da sala que inseriu está errada.");
                         JoinRoomButton.setEnabled(true);
                    }
                    
                }else{ //sala cheia
                     JoinRoomStatusLabel.setText("A sala está cheia.");
                      JoinRoomButton.setEnabled(true);
                }
                    
            }else{ //n escolheu nenhuma sala
                JoinRoomStatusLabel.setText("Não escolheu uma sala válida.");
                 JoinRoomButton.setEnabled(true);
            }
    }//GEN-LAST:event_JoinRoomButtonActionPerformed

    private void OptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsButtonActionPerformed
        // TODO add your handling code here:
        optionScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_OptionsButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        uiGameRoom = new UIGameRoom();
        uiGameRoom.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UIWelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIWelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIWelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIWelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                new UIWelcomeScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChatLabel;
    private javax.swing.JButton CreateRoomButton;
    private javax.swing.JLabel GameRoomsLabel;
    private javax.swing.JButton JoinRoomButton;
    private javax.swing.JLabel JoinRoomStatusLabel;
    private javax.swing.JToggleButton LanguageButton;
    private javax.swing.JButton Leave;
    private javax.swing.JLabel OnlinePlayersLabel;
    private javax.swing.JButton OptionsButton;
    private javax.swing.JButton RankButton;
    private javax.swing.JLabel RankLabel;
    private javax.swing.JTable RoomList;
    private javax.swing.JPasswordField RoomPasswordField;
    private javax.swing.JLabel RoomPasswordLabel;
    private javax.swing.JLabel StatisticsLabel;
    private javax.swing.JLabel Tittle;
    private javax.swing.JTable UserList;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JSlider VolumeControl;
    private javax.swing.JLabel VolumeLogoOff;
    private javax.swing.JLabel VolumeLogoOn;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel avatarLabel;
    private javax.swing.JLabel gamesplayed;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lostGames;
    private javax.swing.JLabel pub;
    private javax.swing.JLabel ratio;
    private javax.swing.JTextArea textAreaChatWindow;
    private javax.swing.JTextField txtChat;
    private javax.swing.JLabel winGames;
    // End of variables declaration//GEN-END:variables



     /**
     * Actualiza o ecra do UIWelcomeScreen
     * @author Luciano
     */
    
    public void updateScreen() throws MalformedURLException, IOException {
        
         int i;
         //add pub
        
        if (0!=puburl.getSizeMensagem()){
            BufferedImage img = ImageIO.read(new URL(puburl.getArguments().get(0).toString()));
            ImageIcon icone = new ImageIcon(img);  
            pub.setIcon(icone);
        }
       
         //clear jtable rooms
         for(i=0;i<20;i++){
             
             for (int j=0;j<4;j++){
                 RoomList.setValueAt("",i,j);
             }
         }
         //clear jtable clientes
         for(i=0;i<20;i++){
             UserList.setValueAt("",i,0);
         }
         
         int numPlayers = UIWelcomeScreen.usersOnlineList.size(); 
         int numRooms   = UIWelcomeScreen.roomsOnlineList.size();

         String pass;
         String state;
                   
            //update RoomList
           //update Game Rooms List          
         for(i=0;i<numRooms;i++){
                                   
             RoomList.setValueAt(roomsOnlineList.get(i).getName(),i,0);
             RoomList.setValueAt(roomsOnlineList.get(i).getCurPlayers()+"/"+roomsOnlineList.get(i).getNumPlayers(),i,1);
             
             if(roomsOnlineList.get(i).getState()==0){
                 state="Waiting";
             } else{
                 state="Playing";
             }
             RoomList.setValueAt(state,i,2);
             
             if(roomsOnlineList.get(i).getPassword().equals("")){
                 pass="no";
             } else{
                 pass="yes";
             }
             
             RoomList.setValueAt(pass,i,3);      
        }
         
         
         //update UserList
         for(i=0;i<numPlayers;i++){
             UserList.setValueAt(usersOnlineList.get(i).getUsername(),i,0);
         }
         
         //update personal data
         for (i=0;i<numPlayers;i++){
             
             if (usersOnlineList.get(i).getUsername().equals(player.getUsername())){
                 player=usersOnlineList.get(i);
             }
         }
         
         //Update User personal data
         
         this.gamesplayed.setText("Jogos Realizados: "+" "+Integer.toString(player.getgamesplayed()));
         this.winGames.setText("Jogos Vencidos: "+" "+Integer.toString(player.getgameswon()));
         this.lostGames.setText("Jogos Perdidos: "+" "+Integer.toString(
                player.getgamesplayed()-player.getgameswon()));
         this.ratio.setText("Racio: "+" "+Float.toString(
                ((float)player.getgameswon())/(float)player.getgamesplayed()));
        
         this.avatarLabel.setIcon(null);
        
         this.avatarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/"+player.getAvatar())));
      
        
         
    }

   

    
}