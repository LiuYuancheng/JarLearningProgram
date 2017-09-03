package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class MazeUI extends JFrame {


    JPanel playerListPanel = new JPanel();
    MazeGround groundPanel;
    ArrayList<String> playerStatus = new ArrayList<>();


    public MazeUI(int N, String userID) {
        super("Maze Game:" + userID);
        final int cell_size = 30;
        setSize(260 + cell_size * N, 90 + cell_size * N);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //BorderLayout flo = new BorderLayout();
        //setLayout(flo);
        // Create the information panel;
        playerListPanel.setBackground(Color.BLUE);
        playerListPanel.setSize(200, 20+cell_size*N);
        add(playerListPanel, BorderLayout.CENTER);
        JScrollPane panelPane = new JScrollPane(playerListPanel);
        add(playerListPanel);

        groundPanel = new MazeGround(N);
        groundPanel.setBackground(Color.YELLOW);
        groundPanel.setSize(20+cell_size*N, 20+cell_size*N);
        //add(groundPanel, BorderLayout.CENTER);
        add(groundPanel);

        getContentPane().setLayout(null);
        playerListPanel.setLocation(0, 0 );
        groundPanel.setLocation(200, 0 );
        setVisible(true);

    }
    public void onUpdateInfo(ArrayList<String> msg){
        // Update the UI player list
        //ArrayList<String> playersInfo = msg.clone();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                playerListPanel.removeAll();
                playerListPanel.setLayout(new GridLayout(msg.size(), 1));
                System.out.println("Update the player information panel. ");
                for(String s: msg){
                    String[] info = s.split("-");
                    //String playerName = info[0];
                    //int playerScore = Integer.parseInt(info[1]);
                    PlayerInfoPanel newPlayerInfo = new PlayerInfoPanel(info[0],info[1], 1);
                    newPlayerInfo.setBackground(new Color(200, 210, 200));
                    newPlayerInfo.setSize(198, 30);
                    playerListPanel.add(newPlayerInfo);
                }
                revalidate();
            }
        });
    }

    public void onUpdateGND(int[][] treasures) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Update the MazeGND");
                groundPanel.update(treasures);
                revalidate();
            }
        });
    }

    public void onUpdateOwn(int x, int y, String[] ownName){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Update the MazeGND");
                groundPanel.updateOwn(x, y, ownName);
                revalidate();
            }
        });
    }

    // Class to display the player's information.
    class PlayerInfoPanel extends JPanel {
        JLabel playerInfoLabel = new JLabel();

        public PlayerInfoPanel(String playerName, String treasureNum, int status) {
            setResizable(false);
            String playerInfo = "Name: " + playerName + "= Score: <" + treasureNum + ">";
            playerInfoLabel.setText(playerInfo);
            add(playerInfoLabel);
        }

    }

    public static void main(String[] args) {
        int N = 10;
        int K = 15;
        //String[] testPlayerID = {"Spanky", "Jack", "Daria", "Stymie", "Tommy", "Chubby", "Jhon", "Jim", "James", "Alan"};
        String[] testPlayerID = {"AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM"};
        int[][] treasures = new int[N][N];
        for (int[] row : treasures)
            Arrays.fill(row, 0);// 0 - nothing there, 1- a treasure
        MazeUI this_frame = new MazeUI(N, "AA");
        Random rand = new Random();
        ArrayList<String> testPlayers = new ArrayList<>();
        for(int i = 0; i<testPlayerID.length; i++){
            String score = ""+rand.nextInt(20);
            String info = testPlayerID[i]+"-"+score;
            testPlayers.add(info);
        }
        this_frame.onUpdateInfo(testPlayers);

        // Put the treasures into the Maze ground
        for(int i =0; i< K; i++){
            while(true){
                int x = rand.nextInt(N);
                int y = rand.nextInt(N);
                if(treasures[x][y] == 0){
                    treasures[x][y] = 1;
                    break;
                }
            }
        }

        for(int i= 0; i<testPlayerID.length; i++){
            while(true){
                int x = rand.nextInt(N);
                int y = rand.nextInt(N);
                if(treasures[x][y] <=1 ){
                    int idx = i+2;
                    treasures[x][y] +=idx ;
                    break;
                }
            }
        }

        this_frame.onUpdateGND(treasures);

        this_frame.onUpdateOwn(N/2, N/2, testPlayerID);

    }




}
