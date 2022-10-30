/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

// IMPORTS

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

///


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
    
    //First Round Postions
    private int playerpos;
    private int playerpos2;
    private int playerpos3;
    private int playerpos4;
    private int playerpos5;
    private int playerpos6;
    private int playerpos7;
    private int playerpos8;
    
    //Second Round Position
    private int playerpos9;
    private int playerpos10;


    
    
    private int Date;
    private String newname;
    private String Winner_1;
    private String seconds;
    private String sourceFolder="";
    private String theFile="";
    private String choosertitle;
    private int maxlength = 8; 
    
    //GameArray ARRAYLSIT
    public static List <GameInfo> gameinfo = new ArrayList<GameInfo>();
    
    public static List <Players> contestant = new ArrayList<Players>();
    
    public static List <Players> contestant_pastgames = new ArrayList<Players>();

    /**
     * Creates new form MainGame
     */
    
    /**
     //Adds action listener to buttons
    */
    public MainGame() {
        initComponents();
        
     dt();
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
    
    //Sets contestants name as variable
    
    public void actionPerformed(ActionEvent event) {
        playername = name1.getText();
        playername2 = name2.getText();
        playername3 = name3.getText();
        playername4 = name4.getText();
        playername5 = name5.getText();
        playername6 = name6.getText();
        playername7 = name7.getText();
        playername8 = name8.getText();
        
     //Only sets the contestants name as variable when start button is pressed

      if((event.getSource() == start) && (name1.getText().length() > 0 && name2.getText().length() > 0 && name3.getText().length() > 0  && name4.getText().length() > 0  && name5.getText().length() > 0 && name6.getText().length() > 0 && name7.getText().length() > 0 && name8.getText().length() > 0 )) {
   
        playername = name1.getText();
        playername2 = name2.getText();
        playername3 = name3.getText();
        playername4 = name4.getText();
        playername5 = name5.getText();
        playername6 = name6.getText();
        playername7 = name7.getText();
        playername8 = name8.getText();
        
        
    // adds game infomation into to Arraylist
        
        GameInfo play = new GameInfo(playername,playername2,playername3,playername4,playername5,playername6,playername7,playername8,Winner_1, Date, seconds);
        
        gameinfo.add(play); // <-- adds the Player to the list.  
        name1.setText(playername);
        name2.setText(playername2);
        name3.setText(playername3);
        name4.setText(playername4);
        name5.setText(playername5);
        name6.setText(playername6);
        name7.setText(playername7);
        name8.setText(playername8);
        
        for(int i = 0; i < gameinfo.size(); i++) {
        System.out.println(gameinfo.get(i).getPlayername());
        }
        
        //Saves player objects to arraylist
        {
        try {
         FileOutputStream fileOut = new FileOutputStream("Games.ser");//This saves the data to a file called players.ser in the save folder as the Main.java file.
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(gameinfo);//This save the data in the players arraylist
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in Games.ser");
        }catch(IOException i) {
         i.printStackTrace();
        }
               
            
        // when start is pressed it opens Game Jpanel from Mainpanel    
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Game");
      }
 
      }else if ((event.getSource() == start)){
           JOptionPane.showMessageDialog(MainPanel, "You need 8 contestants to contiune"); 
        }
      
      //changes button text to contestant name variable 
       PLAYER__1.setText(name1.getText());
       PLAYER__2.setText(name2.getText());
       PLAYER_3.setText(name3.getText());
       PLAYER_4.setText(name4.getText());
       PLAYER_5.setText(name5.getText());
       PLAYER_6.setText(name6.getText());
       PLAYER_7.setText(name7.getText());
       PLAYER_8.setText(name8.getText());
       //MAIN GAME CODE
        
       
        if (event.getSource() == PLAYER__1) {
            PLAYER_10.setText(name1.getText());
            PLAYER__1.setBackground(Color.GREEN);
            PLAYER__2.setBackground(Color.RED);
            playerpos2 = 5;
            playerpos = 3;
        }
        
        if (event.getSource() == PLAYER__2) {
            PLAYER_10.setText(name2.getText());
            PLAYER__1.setBackground(Color.RED);
            PLAYER__2.setBackground(Color.GREEN);
            playerpos = 5;
            playerpos2 = 3;
        }
        
     
     //Main Game Code ran but if statements   
        if (event.getSource() == PLAYER_3) {
            PLAYER_9.setText(name3.getText());
            PLAYER_4.setBackground(Color.RED);
            PLAYER_3.setBackground(Color.GREEN);
            playerpos4 = 6;
            playerpos3 = 4;
        }
        
        if (event.getSource() == PLAYER_4) {
            PLAYER_9.setText(name4.getText());
            PLAYER_3.setBackground(Color.RED);
            PLAYER_4.setBackground(Color.GREEN);
            playerpos3 = 6;
            playerpos4 = 4;
            
        }
        
        if (event.getSource() == PLAYER_5) {
            PLAYER_11.setText(name5.getText()); 
            PLAYER_6.setBackground(Color.RED);
            PLAYER_5.setBackground(Color.GREEN);
            playerpos6 = 7;
            playerpos5 = 30;
        }
        
        if (event.getSource() == PLAYER_6) {
            PLAYER_11.setText(name6.getText());
            PLAYER_6.setBackground(Color.GREEN);
            PLAYER_5.setBackground(Color.RED);
            playerpos5 = 7;
            playerpos6 = 30;
        }
        
        if (event.getSource() == PLAYER_7) {
            PLAYER_12.setText(name7.getText());
            PLAYER_7.setBackground(Color.GREEN);
            PLAYER_8.setBackground(Color.RED);
            playerpos8 = 8;
            playerpos7 = 40;
            
        }
        
        if (event.getSource() == PLAYER_8) {
            PLAYER_12.setText(name8.getText());
            PLAYER_8.setBackground(Color.GREEN);
            PLAYER_7.setBackground(Color.RED);
            playerpos7 = 8;
            playerpos8 = 40;
        }
        
        //Checks winner of the round 2 and round 1
        
        
        //Winner of 9 and 12 go to 1 and Winner of 10 and 11 go to 2
        if (event.getSource() == PLAYER_9) {
            PLAYER_1.setText(PLAYER_9.getText());
            PLAYER_9.setBackground(Color.GREEN);
            PLAYER_12.setBackground(Color.RED);
        }
        
        if (event.getSource() == PLAYER_12) {
            PLAYER_1.setText(PLAYER_12.getText());
            PLAYER_9.setBackground(Color.RED);
            PLAYER_12.setBackground(Color.GREEN);
        }
        
        if (event.getSource() == PLAYER_10) {
            PLAYER_2.setText(PLAYER_10.getText());
            PLAYER_10.setBackground(Color.GREEN);
            PLAYER_11.setBackground(Color.RED);
       }
        
        if (event.getSource() == PLAYER_11) {
            PLAYER_2.setText(PLAYER_11.getText());
            PLAYER_10.setBackground(Color.red);
            PLAYER_11.setBackground(Color.GREEN);
        }
        
        if (event.getSource() == PLAYER_1) {
            Winner_1 = (PLAYER_1.getText());
            System.out.println(Winner_1);
            PLAYER_1.setBackground(Color.GREEN);
            PLAYER_2.setBackground(Color.GRAY);
            selectwinner.setText(""); 
            
            seconds = (PLAYER_2.getText());
            
            playerpos9 = 1;
            playerpos10 = 2;
            
        }
        
        if (event.getSource() == PLAYER_2) {
            Winner_1 = (PLAYER_2.getText()); 
            System.out.println(Winner_1);
            PLAYER_2.setBackground(Color.GREEN);
            PLAYER_1.setBackground(Color.GRAY);
            
            seconds = (PLAYER_1.getText());
  
            selectwinner.setText(""); 
            
            playerpos9 = 2;
            playerpos10 = 1;
        }
        
        if (!PLAYER_1.getText().isEmpty() && !PLAYER_2.getText().isEmpty()){
            selectwinner.setText("Select the Winner"); 
        }
        

        if (event.getSource() == next && Winner_1 != null) {
            
            contestant.add(new Players(name1.getText(),playerpos,false));
            contestant.add(new Players(name2.getText(),playerpos2,false));
            contestant.add(new Players(name3.getText(),playerpos3,false));
            contestant.add(new Players(name4.getText(),playerpos4,false));
            contestant.add(new Players(name5.getText(),playerpos5,false));
            contestant.add(new Players(name6.getText(),playerpos6,false));
            contestant.add(new Players(name7.getText(),playerpos7,false));
            contestant.add(new Players(name8.getText(),playerpos8,false));
            
            contestant.add(new Players(Winner_1,playerpos9,true));
            contestant.add(new Players(seconds,playerpos10,false));
            
            {listAllPenDetails((ArrayList<Players>) contestant);}
            
            
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "WinnersScreen");
            winner.setText((Winner_1));
            second_pos.setText((seconds));
            
        }else if ((event.getSource() == next && Winner_1 == null)){
           JOptionPane.showMessageDialog(MainPanel, "Select a Winner"); 
        }
        
        
     
        
        
        // WINNER SCREEN CODE 
        
        
        //Saves arraylist as new file
        if (event.getSource() == save && filename.getText().length() > 2) {
           newname = (filename.getText());
           
        try {
         FileOutputStream fileOut = new FileOutputStream(newname + ".ser");//This saves the data to a file called players.ser in the save folder as the Main.java file.
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(contestant);//This save the data in the players arraylist
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in " + newname + ".ser");
        }catch(IOException i) {
         i.printStackTrace();
        }
        }else if ((event.getSource() == save)){
           JOptionPane.showMessageDialog(MainPanel, "filename can not be less then 2 character long"); 
        }
        
        //clears arraylist and sets every value back to null and returns to home
        if (event.getSource() == NEXT) {
           gameinfo.clear();
           contestant.clear();
           System.out.println(gameinfo);
           System.out.println(contestant);
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
        
        //PAST MATCHES CODE
        
        //opens pastgames panel from main panel when past matches button pressed
        if (event.getSource() == pastmatches) {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "PastGames"); 
        }
    }
    
    public static void listAllPenDetails(ArrayList<Players> listThese){
        System.out.println("LIST of details");
        for(Players contestant:listThese){
          System.out.println(contestant.getcontestant());
          System.out.println(contestant.getposition());
          System.out.println(contestant.getwinner());
        }  
    }
    
   //PAST MATCHES CODE

    
}
  
    public void dt(){

    Date d  =new Date();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    
    String dd = sdf.format(d);
    date.setText(dd);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        selectwinner = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        WinnersScreen = new javax.swing.JPanel();
        winnertext = new javax.swing.JLabel();
        gametitle = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        NEXT = new javax.swing.JButton();
        tournamentname = new javax.swing.JLabel();
        filename = new javax.swing.JTextField();
        winner = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        second_pos = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        PastGames = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        winner_name = new javax.swing.JLabel();
        load = new javax.swing.JButton();
        name_1 = new javax.swing.JButton();
        name_2 = new javax.swing.JButton();
        name_3 = new javax.swing.JButton();
        name_4 = new javax.swing.JButton();
        name_5 = new javax.swing.JButton();
        name_6 = new javax.swing.JButton();
        name_7 = new javax.swing.JButton();
        name_8 = new javax.swing.JButton();
        name_9 = new javax.swing.JButton();
        name_10 = new javax.swing.JButton();
        name_11 = new javax.swing.JButton();
        name_12 = new javax.swing.JButton();
        name_13 = new javax.swing.JButton();
        name_14 = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setLayout(new java.awt.CardLayout());

        Home.setMaximumSize(new java.awt.Dimension(557, 383));
        Home.setPreferredSize(new java.awt.Dimension(557, 383));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 26)); // NOI18N
        jLabel1.setText("CAS CHESS TOURNAMENT ");

        name1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name1KeyPressed(evt);
            }
        });

        name2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name2KeyPressed(evt);
            }
        });

        name3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name3KeyPressed(evt);
            }
        });

        name4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name4KeyPressed(evt);
            }
        });

        name5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name5KeyPressed(evt);
            }
        });

        name6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name6KeyPressed(evt);
            }
        });

        name7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name7KeyPressed(evt);
            }
        });

        name8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name8KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("CONTESTANT NAMES:");

        pastmatches.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        pastmatches.setText("PAST MATCHES");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("TKGAMINGSTUDIOS");

        start.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        start.setText("START");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("How To Play:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("DATE:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Enter 8 contestant names,\nenter date and press \nstart,press the \nbutton of the name of \nwinner on the game \nscreen. At the end \ncreate a filename and save\nthe torunament");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HomeLayout.createSequentialGroup()
                            .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(name5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(HomeLayout.createSequentialGroup()
                            .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(name6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(95, 95, 95)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(HomeLayout.createSequentialGroup()
                            .addComponent(name8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(name7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeLayout.createSequentialGroup()
                                .addComponent(pastmatches)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel5))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pastmatches, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(0, 0, Short.MAX_VALUE))))
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

        PLAYER_11.setText("WINNER");

        PLAYER_10.setText("WINNER");

        PLAYER_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLAYER_2ActionPerformed(evt);
            }
        });

        PLAYER_12.setText("WINNER");

        PLAYER_9.setText("WINNER");

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

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                                .addGap(15, 15, 15)
                                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GameLayout.createSequentialGroup()
                                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PLAYER_5)
                                            .addComponent(PLAYER__1)
                                            .addComponent(PLAYER_6))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(GameLayout.createSequentialGroup()
                                        .addComponent(PLAYER__2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectwinner, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69))))
                            .addGroup(GameLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                                        .addComponent(PLAYER_11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PLAYER_2)
                                            .addComponent(PLAYER_1))
                                        .addGap(80, 80, 80)
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
            .addGroup(GameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(101, 101, 101)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
        );
        GameLayout.setVerticalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER__1)
                    .addComponent(PLAYER_3))
                .addGap(18, 18, 18)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER_10)
                    .addComponent(PLAYER_9))
                .addGap(15, 15, 15)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PLAYER__2)
                        .addComponent(PLAYER_4))
                    .addComponent(selectwinner, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER_7)
                    .addComponent(PLAYER_6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addComponent(PLAYER_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PLAYER_2))
                    .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PLAYER_11)
                        .addComponent(PLAYER_12)))
                .addGap(15, 15, 15)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLAYER_8)
                    .addComponent(PLAYER_5))
                .addGap(5, 5, 5)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.add(Game, "Game");

        winnertext.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        winnertext.setText("Winner:");

        gametitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        gametitle.setText("CAS CHESS TOURNAMENT");

        save.setText("Save FIle");
        save.setEnabled(false);

        NEXT.setText("Contiune");
        NEXT.setEnabled(false);

        tournamentname.setText("Name This Tournament:");

        filename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filenameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filenameKeyReleased(evt);
            }
        });

        winner.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        winner.setText("?????");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Second:");

        second_pos.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        second_pos.setText("???????");

        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout WinnersScreenLayout = new javax.swing.GroupLayout(WinnersScreen);
        WinnersScreen.setLayout(WinnersScreenLayout);
        WinnersScreenLayout.setHorizontalGroup(
            WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WinnersScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WinnersScreenLayout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tournamentname)
                            .addGroup(WinnersScreenLayout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(NEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(WinnersScreenLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(WinnersScreenLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(second_pos, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                        .addGap(396, 396, 396))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WinnersScreenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(winnertext)
                        .addGap(18, 18, 18)
                        .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WinnersScreenLayout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gametitle)
                        .addGap(90, 90, 90))))
        );
        WinnersScreenLayout.setVerticalGroup(
            WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WinnersScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gametitle)
                    .addComponent(back))
                .addGap(95, 95, 95)
                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(winnertext)
                    .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WinnersScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(second_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
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

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel8.setText("WINNER:");

        winner_name.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        winner_name.setText("...........");

        load.setText("LOAD");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        name_1.setText("Positions");

        name_2.setText("Positions");

        name_3.setText("Positions");

        name_4.setText("Positions");

        name_5.setText("Positions");

        name_6.setText("Positions");

        name_7.setText("Positions");

        name_8.setText("Positions");

        name_9.setText("Positions");

        name_10.setText("Positions");

        name_11.setText("Positions");

        name_12.setText("Positions");

        name_13.setText("Positions");

        name_14.setText("Positions");

        exit.setText("back");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PastGamesLayout = new javax.swing.GroupLayout(PastGames);
        PastGames.setLayout(PastGamesLayout);
        PastGamesLayout.setHorizontalGroup(
            PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PastGamesLayout.createSequentialGroup()
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(name_12)
                                .addGroup(PastGamesLayout.createSequentialGroup()
                                    .addComponent(name_3)
                                    .addGap(27, 27, 27)
                                    .addComponent(name_11)))
                            .addComponent(name_4))
                        .addGap(139, 139, 139)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_13)
                            .addComponent(name_14))
                        .addGap(52, 52, 52)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PastGamesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name_9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PastGamesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name_10)))
                        .addGap(25, 25, 25)
                        .addComponent(name_8))
                    .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PastGamesLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(name_2)
                                .addComponent(name_1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name_6))
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(name_5)
                            .addGroup(PastGamesLayout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(title)
                                .addGap(226, 226, 226))
                            .addComponent(name_7))
                        .addGroup(PastGamesLayout.createSequentialGroup()
                            .addGap(264, 264, 264)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(winner_name, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PastGamesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(load)
                .addGap(305, 305, 305))
            .addGroup(PastGamesLayout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PastGamesLayout.setVerticalGroup(
            PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PastGamesLayout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(winner_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_1)
                    .addComponent(name_5))
                .addGap(9, 9, 9)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_9)
                    .addComponent(name_11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name_6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(load)
                .addGap(46, 46, 46)
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_3)
                    .addComponent(name_7))
                .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(name_12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(name_4)
                        .addGap(37, 37, 37))
                    .addGroup(PastGamesLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(name_10)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PastGamesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(name_13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(PastGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_14)
                            .addComponent(name_8))
                        .addGap(32, 32, 32)
                        .addComponent(exit))))
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
        contestant_pastgames = (ArrayList) in.readObject();//players is the arraylist that we want the data read to
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
      
      for (int index = 0; index < contestant_pastgames.size(); index++){
      System.out.println(index);
      
      if (contestant_pastgames.get(index).getposition() == (5)){
      System.out.println("found");
      name_2.setText(contestant_pastgames.get(index).getcontestant());
      name_2.setBackground(Color.RED);
      }
      
      if (contestant_pastgames.get(index).getposition() == (6)){
      System.out.println("found");
      name_4.setText(contestant_pastgames.get(index).getcontestant());
      name_4.setBackground(Color.RED);
      }
      
      if (contestant_pastgames.get(index).getposition() == (7)){
      System.out.println("found");
      name_6.setText(contestant_pastgames.get(index).getcontestant());
      name_6.setBackground(Color.RED);
      }
      
      if (contestant_pastgames.get(index).getposition() == (8)){
      System.out.println("found");
      name_8.setText(contestant_pastgames.get(index).getcontestant());
      name_8.setBackground(Color.RED);
      }
      
      
      
      if (contestant_pastgames.get(index).getposition() == (3)){
      System.out.println("found");
      name_1.setText(contestant_pastgames.get(index).getcontestant());
      name_1.setBackground(Color.GREEN);
      
      name_11.setText(contestant_pastgames.get(index).getcontestant());
      name_11.setBackground(Color.RED);
      
      }
      
      if (contestant_pastgames.get(index).getposition() == (4)){
      System.out.println("found");
      name_3.setText(contestant_pastgames.get(index).getcontestant());
      name_3.setBackground(Color.GREEN);
      
      name_12.setText(contestant_pastgames.get(index).getcontestant());
      name_12.setBackground(Color.GREEN);
      }
      
      if (contestant_pastgames.get(index).getposition() == (30)){
      System.out.println("found");
      name_5.setText(contestant_pastgames.get(index).getcontestant());
      name_5.setBackground(Color.GREEN);
      name_9.setText(contestant_pastgames.get(index).getcontestant());
      name_9.setBackground(Color.GREEN);
      }
      
      if (contestant_pastgames.get(index).getposition() == (40)){
      System.out.println("found");
      name_7.setText(contestant_pastgames.get(index).getcontestant());
      name_7.setBackground(Color.GREEN);
      name_10.setText(contestant_pastgames.get(index).getcontestant());
      name_10.setBackground(Color.RED);
      }
      
      if (contestant_pastgames.get(index).getposition() == (1)){
      System.out.println("found");
      name_13.setText(contestant_pastgames.get(index).getcontestant());
      name_13.setBackground(Color.GREEN);
      winner_name.setText(contestant_pastgames.get(index).getcontestant());

      }
      
      if (contestant_pastgames.get(index).getposition() == (2)){
      System.out.println("found");
      name_14.setText(contestant_pastgames.get(index).getcontestant());
      name_14.setBackground(Color.GRAY);
      }
    }
      
    }//GEN-LAST:event_loadActionPerformed

    private void name1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name1KeyPressed
        // TODO add your handling code here:
        if(name1.getText().trim().length()>= maxlength)
       {
        name1.setText(name1.getText().substring(0, maxlength));
       }else{
            System.out.println("Long Enough");
        }
    }//GEN-LAST:event_name1KeyPressed

    private void name2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name2KeyPressed
        // TODO add your handling code here:
        if(name2.getText().length()>=maxlength)
       {
        name2.setText(name2.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_name2KeyPressed

    private void name3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name3KeyPressed
        // TODO add your handling code here:
        if(name3.getText().length()>=maxlength)
       {
        name3.setText(name3.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_name3KeyPressed

    private void name6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name6KeyPressed
        // TODO add your handling code here:
        if(name6.getText().length()>= maxlength)
       {
        name6.setText(name6.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_name6KeyPressed

    private void name8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name8KeyPressed
        // TODO add your handling code here:
        if(name8.getText().length()>= maxlength)
       {
        name8.setText(name8.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_name8KeyPressed

    private void name7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name7KeyPressed
        // TODO add your handling code here:
        if(name7.getText().length()>= maxlength)
       {
        name7.setText(name7.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_name7KeyPressed

    private void name4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name4KeyPressed
        // TODO add your handling code here:
        if(name4.getText().length()>= maxlength)
       {
        name4.setText(name4.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_name4KeyPressed

    private void name5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name5KeyPressed
        // TODO add your handling code here:
        if(name5.getText().length()>= maxlength)
       {
        name5.setText(name5.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_name5KeyPressed

    private void filenameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filenameKeyPressed
        // TODO add your handling code here:
        if(filename.getText().length()>=10)
       {
        filename.setText(filename.getText().substring(0, maxlength));
       }else{
            System.out.println( "Long Enough");
        }
    }//GEN-LAST:event_filenameKeyPressed

    private void PLAYER_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLAYER_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PLAYER_2ActionPerformed

    private void filenameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filenameKeyReleased
        // TODO add your handling code here:
        if (filename.getText().length() > 0)
        {
           NEXT.setEnabled(true);
           save.setEnabled(true);
        }else{
           NEXT.setEnabled(false);
           save.setEnabled(false);
        }
    }//GEN-LAST:event_filenameKeyReleased

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
           contestant_pastgames.clear();
           System.out.println(contestant_pastgames);
           CardLayout card = (CardLayout)MainPanel.getLayout();
           card.show(MainPanel, "Home");
           name_1.setText("position");
           name_1.setBackground(Color.white);
           
           name_2.setText("position");
           name_2.setBackground(Color.white);
           
           name_3.setText("position");
           name_3.setBackground(Color.white);
           
           name_4.setText("position");
           name_4.setBackground(Color.white);
           
           name_5.setText("position");
           name_5.setBackground(Color.white);
           
           name_6.setText("position");
           name_6.setBackground(Color.white);
           
           name_7.setText("position");
           name_7.setBackground(Color.white);
           
           name_8.setText("position");
           name_8.setBackground(Color.white);
           
           name_9.setText("position");
           name_9.setBackground(Color.white);
           
           name_10.setText("position");
           name_10.setBackground(Color.white);
           
           name_11.setText("position");
           name_11.setBackground(Color.white);
           
           name_12.setText("position");
           name_12.setBackground(Color.white);
           
           name_13.setText("position");
           name_13.setBackground(Color.white);
           
           name_14.setText("position");
           name_14.setBackground(Color.white);
           
           winner_name.setText("...........");
           
    }//GEN-LAST:event_exitActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Game");
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Home");
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
    private javax.swing.JButton back;
    private javax.swing.JTextField date;
    private javax.swing.JButton exit;
    private javax.swing.JTextField filename;
    private javax.swing.JLabel gametitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton load;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField name2;
    private javax.swing.JTextField name3;
    private javax.swing.JTextField name4;
    private javax.swing.JTextField name5;
    private javax.swing.JTextField name6;
    private javax.swing.JTextField name7;
    private javax.swing.JTextField name8;
    private javax.swing.JButton name_1;
    private javax.swing.JButton name_10;
    private javax.swing.JButton name_11;
    private javax.swing.JButton name_12;
    private javax.swing.JButton name_13;
    private javax.swing.JButton name_14;
    private javax.swing.JButton name_2;
    private javax.swing.JButton name_3;
    private javax.swing.JButton name_4;
    private javax.swing.JButton name_5;
    private javax.swing.JButton name_6;
    private javax.swing.JButton name_7;
    private javax.swing.JButton name_8;
    private javax.swing.JButton name_9;
    private javax.swing.JButton next;
    private javax.swing.JButton pastmatches;
    private javax.swing.JButton save;
    private javax.swing.JLabel second_pos;
    private javax.swing.JLabel selectwinner;
    private javax.swing.JButton start;
    private javax.swing.JLabel title;
    private javax.swing.JLabel tournamentname;
    private javax.swing.JLabel winner;
    private javax.swing.JLabel winner_name;
    private javax.swing.JLabel winnertext;
    // End of variables declaration//GEN-END:variables
}
