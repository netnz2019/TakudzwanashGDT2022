/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author tgumb
 */
public class MainGame extends javax.swing.JFrame {
    
    private String playername;
    private String playername2;
    private String playername3;
    private String playername4;
    private String playername5;
    private String playername6;
    private String playername7;
    private String playername8;
    private String movestillwin;
    private String duration;
    private String Winner_1;
    private String newname;
    private String sourceFolder="";
    private String theFile="";
    private String choosertitle;
    
    
    public static List <Players> players = new ArrayList<Players>();

    /**
     * Creates new form MainGame
     */
    public MainGame() {
        initComponents();
     theHandler handler = new theHandler();
     start.addActionListener(handler);
     next.addActionListener(handler);
     save.addActionListener(handler);
     NEXT.addActionListener(handler);
     pastmatches.addActionListener(handler);
     PLAYER_1.addActionListener(handler);
     PLAYER_2.addActionListener(handler);
     PLAYER__1.addActionListener(handler);
     PLAYER__2.addActionListener(handler);
     PLAYER_3.addActionListener(handler);
     PLAYER_4.addActionListener(handler);
     PLAYER_5.addActionListener(handler);
     PLAYER_6.addActionListener(handler);
     PLAYER_7.addActionListener(handler);
     PLAYER_8.addActionListener(handler);
     PLAYER_9.addActionListener(handler);
     PLAYER_10.addActionListener(handler);
     PLAYER_11.addActionListener(handler);
     PLAYER_12.addActionListener(handler);
    }

    
    private class theHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        playername = name1.getText();
        playername2 = name2.getText();
        playername3 = name3.getText();
        playername4 = name4.getText();
        playername5 = name5.getText();
        playername6 = name6.getText();
        playername7 = name7.getText();
        playername8 = name8.getText();
        
        if (event.getSource() == start) {
        playername = name1.getText();
        playername2 = name2.getText();
        playername3 = name3.getText();
        playername4 = name4.getText();
        playername5 = name5.getText();
        playername6 = name6.getText();
        playername7 = name7.getText();
        playername8 = name8.getText();
        
        Players play = new Players(playername,playername2,playername3,playername4,playername5,playername6,playername7,playername8,movestillwin,duration);
        
        players.add(play); // <-- adds the Player to the list.  
        name1.setText(playername);
        name2.setText(playername2);
        name3.setText(playername3);
        name4.setText(playername4);
        name5.setText(playername5);
        name6.setText(playername6);
        name7.setText(playername7);
        name8.setText(playername8);
        
        for(int i = 0; i < players.size(); i++) {
        System.out.println(players.get(i).getPlayername());
        }
        
        {
        try {
         FileOutputStream fileOut = new FileOutputStream("players.ser");//This saves the data to a file called players.ser in the save folder as the Main.java file.
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(players);//This save the data in the players arraylist
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in players.ser");
        }catch(IOException i) {
         i.printStackTrace();
        }
        {       
            
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Game");
} 
    }
       PLAYER__1.setText(name1.getText());
       PLAYER__2.setText(name2.getText());
       PLAYER_3.setText(name3.getText());
       PLAYER_4.setText(name4.getText());
       PLAYER_5.setText(name5.getText());
       PLAYER_6.setText(name6.getText());
       PLAYER_7.setText(name7.getText());
       PLAYER_8.setText(name8.getText());
     }
        //MAIN GAME CODE
        
        if (event.getSource() == PLAYER__1) {
            PLAYER_10.setText(name1.getText());  
        }
        
        if (event.getSource() == PLAYER__2) {
            PLAYER_10.setText(name2.getText());   
        }
        
        if (event.getSource() == PLAYER_3) {
            PLAYER_9.setText(name3.getText());   
        }
        
        if (event.getSource() == PLAYER_4) {
            PLAYER_9.setText(name4.getText());   
        }
        
        if (event.getSource() == PLAYER_5) {
            PLAYER_11.setText(name5.getText());   
        }
        
        if (event.getSource() == PLAYER_6) {
            PLAYER_11.setText(name6.getText());  
            
        }
        
        if (event.getSource() == PLAYER_7) {
            PLAYER_12.setText(name7.getText());   
        }
        
        if (event.getSource() == PLAYER_8) {
            PLAYER_12.setText(name8.getText());   
        }
        
        //Checks winner of the round 2 and round 1
        
        
        //Winner of 9 and 12 go to 1 and Winner of 10 and 11 go to 2
        if (event.getSource() == PLAYER_9) {
            PLAYER_1.setText(PLAYER_9.getText());   
        }
        
        if (event.getSource() == PLAYER_12) {
            PLAYER_1.setText(PLAYER_12.getText());   
        }
        
        if (event.getSource() == PLAYER_10) {
            PLAYER_2.setText(PLAYER_10.getText());   
       }
        
        if (event.getSource() == PLAYER_11) {
            PLAYER_2.setText(PLAYER_11.getText());   
        }
        
        if (event.getSource() == PLAYER_1) {
            Winner_1 = (PLAYER_1.getText());
            System.out.println(Winner_1);
        }
        
        if (event.getSource() == PLAYER_2) {
            Winner_1 = (PLAYER_2.getText()); 
            System.out.println(Winner_1);
        }
        
        if (event.getSource() == next) {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "WinnersScreen");
            winner.setText((Winner_1));
        }
        
        // WINNER SCREEN CODE
        
        if (event.getSource() == save) {
           newname = (filename.getText());
           
        try {
         FileOutputStream fileOut = new FileOutputStream(newname + ".ser");//This saves the data to a file called players.ser in the save folder as the Main.java file.
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(players);//This save the data in the players arraylist
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in " + newname + ".ser");
        }catch(IOException i) {
         i.printStackTrace();
        }
        }
        
        if (event.getSource() == NEXT) {
           players.clear();
           System.out.println(players);
           CardLayout card = (CardLayout)MainPanel.getLayout();
           card.show(MainPanel, "Home");
           name1.setText("");
           name2.setText("");
           name3.setText("");
           name4.setText("");
           name5.setText("");
           name6.setText("");
           name7.setText("");
           name8.setText("");
        }
        
        if (event.getSource() == pastmatches) {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "PastGames"); 
        }
        
        
        load.addActionListener(this);
        
        System.out.println("Button Clicked");
        JFileChooser chooser = new JFileChooser();
        
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        final FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "Ser");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
    
        if (chooser.showOpenDialog(MainGame.this) == JFileChooser.APPROVE_OPTION) { 
      
         String dirr = "" + chooser.getCurrentDirectory();
         File file = chooser.getSelectedFile();
       
      if(dirr.substring(dirr.length()-1,dirr.length()).equals(".")){
           dirr = dirr.substring(0,dirr.length()-1);
           sourceFolder=""+dirr + "" + file.getName();
        }else{
            
            sourceFolder=""+dirr + "/" + file.getName();
        }

          System.out.println("Folder path: " + dirr + " | File Name: " + file.getName());
          System.out.println(sourceFolder);
        //ExamineImage.lum(sourceFolder);
    
      }else {
          System.out.println("No Selection ");
      }
        
      try
        {
        FileInputStream fileIn = new FileInputStream(chooser.getSelectedFile());//The file that data has been save to,
        ObjectInputStream in = new ObjectInputStream(fileIn);
        players = (ArrayList) in.readObject();//players is the arraylist that we want the data read to
        in.close();
        fileIn.close();
        }catch (IOException ioe) {
         ioe.printStackTrace();
         return;
        }catch (ClassNotFoundException c) {
        System.out.println( "Class not found");
         c.printStackTrace();
         return;       
        }
    }
    }
    
    
    //Past Matches Code
    
    

    
    public static void loadSaved(){
        try
        {
        FileInputStream fileIn = new FileInputStream("File");//The file that data has been save to,
        ObjectInputStream in = new ObjectInputStream(fileIn);
        players = (ArrayList) in.readObject();//players is the arraylist that we want the data read to
        in.close();
        fileIn.close();
        }catch (IOException ioe) {
         ioe.printStackTrace();
         return;
        }catch (ClassNotFoundException c) {
        System.out.println( "Class not found");
         c.printStackTrace();
         return;       
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

        MainPanel = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name1 = new javax.swing.JTextField();
        name2 = new javax.swing.JTextField();
        name3 = new javax.swing.JTextField();
        name4 = new javax.swing.JTextField();
        name5 = new javax.swing.JTextField();
        name6 = new javax.swing.JTextField();
        name7 = new javax.swing.JTextField();
        name8 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        pastmatches = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Game = new javax.swing.JPanel();
        PLAYER__1 = new javax.swing.JButton();
        PLAYER__2 = new javax.swing.JButton();
        PLAYER_5 = new javax.swing.JButton();
        PLAYER_6 = new javax.swing.JButton();
        PLAYER_11 = new javax.swing.JButton();
        PLAYER_10 = new javax.swing.JButton();
        PLAYER_1 = new javax.swing.JButton();
        PLAYER_2 = new javax.swing.JButton();
        PLAYER_12 = new javax.swing.JButton();
        PLAYER_9 = new javax.swing.JButton();
        PLAYER_3 = new javax.swing.JButton();
        PLAYER_4 = new javax.swing.JButton();
        PLAYER_7 = new javax.swing.JButton();
        PLAYER_8 = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        WinnersScreen = new javax.swing.JPanel();
        winnertext = new javax.swing.JLabel();
        gametitle = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        NEXT = new javax.swing.JButton();
        tournamentname = new javax.swing.JLabel();
        filename = new javax.swing.JTextField();
        winner = new javax.swing.JLabel();
        PastGames = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        name_1 = new javax.swing.JTextField();
        name_2 = new javax.swing.JTextField();
        name_3 = new javax.swing.JTextField();
        name_4 = new javax.swing.JTextField();
        name_5 = new javax.swing.JTextField();
        name_6 = new javax.swing.JTextField();
        name_7 = new javax.swing.JTextField();
        name_8 = new javax.swing.JTextField();
        name_9 = new javax.swing.JTextField();
        name_10 = new javax.swing.JTextField();
        name_11 = new javax.swing.JTextField();
        name_12 = new javax.swing.JTextField();
        name_13 = new javax.swing.JTextField();
        name_14 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        winner_name = new javax.swing.JLabel();
        load = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setLayout(new java.awt.CardLayout());

        Home.setMaximumSize(new java.awt.Dimension(557, 383));
        Home.setPreferredSize(new java.awt.Dimension(557, 383));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 26)); // NOI18N
        jLabel1.setText("CAS CHESS TOURNAMENT ");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("CONTESTANT NAMES:");

        pastmatches.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        pastmatches.setText("PAST MATCHES");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("TKGAMINGSTUDIOS");

        start.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        start.setText("START");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("How To Play:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("DATE:");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addComponent(name8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                                    .addComponent(pastmatches)
                                    .addGap(131, 131, 131)
                                    .addComponent(jLabel5))
                                .addGroup(HomeLayout.createSequentialGroup()
                                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(HomeLayout.createSequentialGroup()
                                            .addGap(108, 108, 108)
                                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(HomeLayout.createSequentialGroup()
                                            .addGap(129, 129, 129)
                                            .addComponent(jLabel3)))
                                    .addGap(9, 9, 9))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(59, 59, 59))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(132, 132, 132))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pastmatches, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 90, Short.MAX_VALUE))))
        );

        MainPanel.add(Home, "Home");

        Game.setMaximumSize(new java.awt.Dimension(557, 383));
        Game.setPreferredSize(new java.awt.Dimension(557, 383));

        PLAYER__1.setText("PLAYER__1");
        PLAYER__1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLAYER__1ActionPerformed(evt);
            }
        });

        PLAYER__2.setText("PLAYER__2");

        PLAYER_5.setText("PLAYER_5");

        PLAYER_6.setText("PLAYER_6");

        PLAYER_11.setText("PLAYER_11");

        PLAYER_10.setText("PLAYER_10");

        PLAYER_1.setText("PLAYER_1");

        PLAYER_2.setText("PLAYER_2");

        PLAYER_12.setText("PLAYER_12");

        PLAYER_9.setText("PLAYER_9");

        PLAYER_3.setText("PLAYER_3");

        PLAYER_4.setText("PLAYER_4");

        PLAYER_7.setText("PLAYER_7");

        PLAYER_8.setText("PLAYER_8");

        next.setText("NEXT");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel6.setText("CAS CHESS TOURNAMENT");

        javax.swing.GroupLayout GameLayout = new javax.swing.GroupLayout(Game);
        Game.setLayout(GameLayout);
        GameLayout.setHorizontalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PLAYER_4))
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GameLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PLAYER__1)
                                    .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(GameLayout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(GameLayout.createSequentialGroup()
                                                    .addComponent(PLAYER_6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                                                    .addComponent(PLAYER_5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(PLAYER_1)
                                                        .addComponent(PLAYER_2))
                                                    .addGap(154, 154, 154))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameLayout.createSequentialGroup()
                                            .addComponent(PLAYER__2)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(GameLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GameLayout.createSequentialGroup()
                                        .addComponent(PLAYER_11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                                        .addComponent(PLAYER_12))
                                    .addGroup(GameLayout.createSequentialGroup()
                                        .addComponent(PLAYER_10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PLAYER_9)))))
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GameLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(PLAYER_3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PLAYER_7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(PLAYER_8, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259))))
        );
        GameLayout.setVerticalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER__1)
                    .addComponent(PLAYER_3))
                .addGap(18, 18, 18)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER_10)
                    .addComponent(PLAYER_9))
                .addGap(15, 15, 15)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER__2)
                    .addComponent(PLAYER_4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER_5)
                    .addComponent(PLAYER_7)
                    .addComponent(PLAYER_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PLAYER_11)
                            .addComponent(PLAYER_12))
                        .addGap(15, 15, 15)
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PLAYER_6)
                            .addComponent(PLAYER_8)))
                    .addComponent(PLAYER_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        MainPanel.add(Game, "Game");

        winnertext.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        winnertext.setText("Winner:");

        gametitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        gametitle.setText("CAS CHESS TOURNAMENT");

        save.setText("Save FIle");

        NEXT.setText("Contiune");

        tournamentname.setText("Name This Tournament:");

        winner.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        winner.setText("?????");

        javax.swing.GroupLayout WinnersScreenLayout = new javax.swing.GroupLayout(WinnersScreen);
        WinnersScreen.setLayout(WinnersScreenLayout);
        WinnersScreenLayout.setHorizontalGroup(
            WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WinnersScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WinnersScreenLayout.createSequentialGroup()
                        .addGap(0, 109, Short.MAX_VALUE)
                        .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WinnersScreenLayout.createSequentialGroup()
                                .addComponent(gametitle)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WinnersScreenLayout.createSequentialGroup()
                                .addComponent(winnertext)
                                .addGap(18, 18, 18)
                                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tournamentname)
                                    .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(134, 134, 134))))
                    .addGroup(WinnersScreenLayout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(NEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        WinnersScreenLayout.setVerticalGroup(
            WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WinnersScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gametitle)
                .addGap(95, 95, 95)
                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(winnertext)
                    .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(tournamentname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        MainPanel.add(WinnersScreen, "WinnersScreen");

        title.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        title.setText("Past Tournaments");

        name_1.setEditable(false);

        name_2.setEditable(false);

        name_3.setEditable(false);

        name_4.setEditable(false);

        name_5.setEditable(false);

        name_6.setEditable(false);

        name_7.setEditable(false);

        name_8.setEditable(false);

        name_9.setEditable(false);

        name_10.setEditable(false);

        name_11.setEditable(false);

        name_12.setEditable(false);

        name_13.setEditable(false);

        name_14.setEditable(false);

        jLabel8.setText("WINNER");

        winner_name.setText("...........................");

        load.setText("LOAD");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PastGamesLayout = new javax.swing.GroupLayout(PastGames);
        PastGames.setLayout(PastGamesLayout);
        PastGamesLayout.setHorizontalGroup(
            PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PastGamesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(name_3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(name_1)
                            .addComponent(name_2))
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PastGamesLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(jLabel8))
                            .addGroup(PastGamesLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(winner_name, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PastGamesLayout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name_8, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(name_5)
                            .addComponent(name_6)
                            .addComponent(name_7)))
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addComponent(name_4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(load)
                            .addComponent(name_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PastGamesLayout.createSequentialGroup()
                                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PastGamesLayout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PastGamesLayout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PastGamesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)))))
                .addContainerGap())
            .addGroup(PastGamesLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PastGamesLayout.createSequentialGroup()
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(130, 130, 130))
        );
        PastGamesLayout.setVerticalGroup(
            PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PastGamesLayout.createSequentialGroup()
                .addComponent(title)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(winner_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(name_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(load)
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PastGamesLayout.createSequentialGroup()
                                .addComponent(name_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PastGamesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(name_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        MainPanel.add(PastGames, "PastGames");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PLAYER__1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLAYER__1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PLAYER__1ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadActionPerformed

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
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Game;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton NEXT;
    private javax.swing.JButton PLAYER_1;
    private javax.swing.JButton PLAYER_10;
    private javax.swing.JButton PLAYER_11;
    private javax.swing.JButton PLAYER_12;
    private javax.swing.JButton PLAYER_2;
    private javax.swing.JButton PLAYER_3;
    private javax.swing.JButton PLAYER_4;
    private javax.swing.JButton PLAYER_5;
    private javax.swing.JButton PLAYER_6;
    private javax.swing.JButton PLAYER_7;
    private javax.swing.JButton PLAYER_8;
    private javax.swing.JButton PLAYER_9;
    private javax.swing.JButton PLAYER__1;
    private javax.swing.JButton PLAYER__2;
    private javax.swing.JPanel PastGames;
    private javax.swing.JPanel WinnersScreen;
    private javax.swing.JTextField date;
    private javax.swing.JTextField filename;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JLabel gametitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton load;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField name2;
    private javax.swing.JTextField name3;
    private javax.swing.JTextField name4;
    private javax.swing.JTextField name5;
    private javax.swing.JTextField name6;
    private javax.swing.JTextField name7;
    private javax.swing.JTextField name8;
    private javax.swing.JTextField name_1;
    private javax.swing.JTextField name_10;
    private javax.swing.JTextField name_11;
    private javax.swing.JTextField name_12;
    private javax.swing.JTextField name_13;
    private javax.swing.JTextField name_14;
    private javax.swing.JTextField name_2;
    private javax.swing.JTextField name_3;
    private javax.swing.JTextField name_4;
    private javax.swing.JTextField name_5;
    private javax.swing.JTextField name_6;
    private javax.swing.JTextField name_7;
    private javax.swing.JTextField name_8;
    private javax.swing.JTextField name_9;
    private javax.swing.JButton next;
    private javax.swing.JButton pastmatches;
    private javax.swing.JButton save;
    private javax.swing.JButton start;
    private javax.swing.JLabel title;
    private javax.swing.JLabel tournamentname;
    private javax.swing.JLabel winner;
    private javax.swing.JLabel winner_name;
    private javax.swing.JLabel winnertext;
    // End of variables declaration//GEN-END:variables
}
