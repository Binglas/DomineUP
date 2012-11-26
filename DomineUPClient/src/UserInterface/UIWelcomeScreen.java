/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import ComunicacaoCliente.ComCliente;
import Share.User;
import java.util.ArrayList;
import LogicaNegocioCliente.Language;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import resources.musica_fundo;
import UserInterface.UIConfiguracoes;

/**
 * Este é o interface após o utilizador ter realizado o login, contém dados do utilizador,
 * como estatísticas, username,avatar. Pode também aceder às opções, controlar o volume do som
 * e fazer logout.
 * @author Luciano
 */
public class UIWelcomeScreen extends javax.swing.JFrame {
    
    
    public static UIConfiguracoes optionScreen;
    public static UICreateRoom createRoomScreen;
    public static ArrayList<User> usersOnlineList;
    private static User player;
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
     * Creates instancia da classe UIWelcomeScreen
     */
    public void setCreateRoomButton(){
        CreateRoomButton.setEnabled(true);
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
        OptionsButton = new javax.swing.JButton();
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
        StatisticsLabel1 = new javax.swing.JLabel();
        CreateRoomButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1074, 670));
        setPreferredSize(new java.awt.Dimension(1074, 670));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Tittle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Tittle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/final_logo.png"))); // NOI18N

        Leave.setText("Logout");
        Leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveActionPerformed(evt);
            }
        });

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setText("jLabel1");

        VolumeControl.setMaximum(0);
        VolumeControl.setMinimum(-80);
        VolumeControl.setValue(0);
        VolumeControl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeControlStateChanged(evt);
            }
        });

        OptionsButton.setText("Opções");
        OptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsButtonActionPerformed(evt);
            }
        });

        StatisticsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StatisticsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        StatisticsLabel.setText("Estatísticas:");

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WelcomeLabel.setText("Bem Vindo,");

        VolumeLogoOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/soundon.png"))); // NOI18N

        VolumeLogoOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/soundoff.png"))); // NOI18N

        avatarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/avatar5.png"))); // NOI18N

        winGames.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winGames.setText("Jogos Ganhos:");

        lostGames.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lostGames.setText("Jogos Perdidos:");

        RankLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RankLabel.setText("Rank:");

        ratio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ratio.setText("Rácio:");

        gamesplayed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gamesplayed.setText("Jogos Realizados:");

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

        StatisticsLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StatisticsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        StatisticsLabel1.setText("Jogadores Online:");

        CreateRoomButton.setText("Criar Sala");
        CreateRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateRoomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(OptionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(CreateRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Leave, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(WelcomeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tittle)
                                .addGap(166, 166, 166)
                                .addComponent(VolumeLogoOff)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VolumeControl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(VolumeLogoOn)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avatarLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(StatisticsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(RankLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ratio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lostGames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(winGames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gamesplayed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StatisticsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tittle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(VolumeControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VolumeLogoOn)
                            .addComponent(VolumeLogoOff))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WelcomeLabel)
                    .addComponent(UsernameLabel))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StatisticsLabel)
                            .addComponent(StatisticsLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RankLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gamesplayed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(winGames)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lostGames)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ratio))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Leave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsButtonActionPerformed
        // TODO add your handling code here:  
        //this.setVisible(false);
        optionScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_OptionsButtonActionPerformed

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
       // config.MusicVolumeSliderSetValue(volume);
    }//GEN-LAST:event_VolumeControlStateChanged

//    public int VolumeControlGetValue()
//    {
//        int valor_slider = VolumeControl.getValue();
//        return valor_slider;
//    };
//    
//    public void VolumeControlSetValue(int valor)
//    {
//        VolumeControl.setValue(valor);
//    };
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
    private javax.swing.JButton CreateRoomButton;
    private javax.swing.JButton Leave;
    private javax.swing.JButton OptionsButton;
    private javax.swing.JLabel RankLabel;
    private javax.swing.JLabel StatisticsLabel;
    private javax.swing.JLabel StatisticsLabel1;
    private javax.swing.JLabel Tittle;
    private javax.swing.JTable UserList;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JSlider VolumeControl;
    private javax.swing.JLabel VolumeLogoOff;
    private javax.swing.JLabel VolumeLogoOn;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel avatarLabel;
    private javax.swing.JLabel gamesplayed;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lostGames;
    private javax.swing.JLabel ratio;
    private javax.swing.JLabel winGames;
    // End of variables declaration//GEN-END:variables



     /**
     * Actualiza o ecra do UIWelcomeScreen
     * 
     */
    
    public void updateScreen() {
              
         int numPlayers = UIWelcomeScreen.usersOnlineList.size(); 
         int i;

      /*   
         for(int k=0; k<12;k++){
             tableGameRooms.setValueAt("",k,0);
             tableGameRooms.setValueAt("",k,1);
             tableGameRooms.setValueAt("",k,2);
             tableGameRooms.setValueAt("",k,3);
             
             UserList.setValueAt("",k,0);
             
         
        }
        */  
         //clear jtable
         for(i=0;i<numPlayers;i++){
             UserList.setValueAt("",i,0);
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
         System.out.println(player.getAvatar());
         this.avatarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/"+player.getAvatar())));
      
        
         
    }

    
}