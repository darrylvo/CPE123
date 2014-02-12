import greenfoot.*;  
import java.io.*;
import java.util.*;
public class Leaderboard extends Actor
{
    int z = 0;
    int[] score = new int[40];
    String[] name= new String[40];
    GreenfootImage board;
    GreenfootImage sb;
    int g;
  public Leaderboard(int p) 
    { 
          g = p;
        parseFile();
          
        int boardWidth = 150; 
        int boardHeight = 30; 
        int boardTransparency = 125; 
          
        board = new GreenfootImage(boardWidth, boardHeight); 
        board.setColor(java.awt.Color.gray); 
  
        board.setTransparency(boardTransparency); 
        board.fillRect(0, 0, boardWidth, boardHeight); 
        this.setImage(board); 
          
        update(); 
          
          
    } 
  
    
    
    public void parseFile()
  {
    File f = new File("score/score.txt");
    try
    {
        Scanner s = new Scanner(f);
         while (s.hasNext())
               {               
                name[z]=s.next();
                //  System.out.println(name1[z]);
                
                score[z]=s.nextInt();
                // System.out.println(score1[z]);
                z= z+1;
               }
        
      
   }
   catch (IOException e)
   {
     e.printStackTrace();  
       
   }  
  }
  public void update()
  {
       sb = new GreenfootImage(board); 
        sb.drawImage(new GreenfootImage(name[g]+" "+score[g], 18, java.awt.Color.white, new java.awt.Color(0,0,0,0)),25,5); 
        this.setImage(sb); 
      
  }






}
