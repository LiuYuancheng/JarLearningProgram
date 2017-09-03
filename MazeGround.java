package com.company;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class MazeGround extends  JPanel{
    int size_N = 10;
    int [][] grid ;
    String[] ownName;
    Boolean gridTag = false;
    public MazeGround (int N){
        size_N = N;

    }

    public void paint(Graphics g)
    {
        // Draw the Maze grid
        for ( int row = 0;  row < size_N;  row++ )
        {
            for ( int col = 0;  col < size_N;  col++)
            {
                int x = col * 30;
                int y = row * 30;
                if ( (row % 2) == (col % 2) )
                    g.setColor(Color.lightGray);
                else
                    g.setColor(Color.gray);

                g.fillRect(x, y, 30, 30);
            }
        }

        int playerCount = 0;
        for(int i = 0; i <size_N; i++ )
        {
            for (int j =0; j<size_N; j ++){
                if(grid[i][j] >0){
                    Font myFont = new Font ("Courier New", 1, 27);
                    int x = i * 30+12;
                    int y = j * 30+12;
                    g.setColor(Color.red);
                    //g.fillRect(x, y, 3,3);
                    g.setFont (myFont);
                    g.drawString("*",x-5, y+15 );
                    // Draw the Own position
                    if (gridTag && grid[i][j] == 2) {
                        g.setColor(new Color(200, 240, 200));
                        g.fillOval(x-8, y-8, 20, 20);
                        g.setColor(Color.black);
                        Font myFont2 = new Font ("Courier New", 1, 12);
                        g.setFont (myFont2);
                        g.drawString(ownName[0],x-5, y+8 );
                    }

                    if (gridTag && grid[i][j] >2) {
                        g.setColor(new Color(200, 200, 240));
                        g.fillOval(x-8, y-8, 20, 20);
                        g.setColor(Color.black);
                        Font myFont2 = new Font ("Courier New", 1, 12);
                        g.setFont (myFont2);
                        g.drawString(ownName[++playerCount],x-5, y+8 );
                    }

                }
            }
        }
    }
    public void update(int[][] treasures){
        grid = treasures;

    }

    public Boolean updateOwn(int x, int y, String[] playerIDList){
        //Check whether own can move to here;
        //if(grid[x][y]<=1){
            //grid[x][y] = 2;
        ownName= playerIDList;
        gridTag = true;
        return true;
        //}
    }
}
