import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) 
  
/** 
 Darryl- this displays the score. taken from the class examples!
 */
public class Scoreboard extends Actor 
{ 
     private GreenfootImage board; 
    private GreenfootImage sb; 
    public static int score; 
    private String label = "Score: " ; 
    private int boardWidth;
    private int boardHeight;
    public Scoreboard() 
    { 
        
         
          
        boardWidth = 150; 
        boardHeight = 30; 
        int boardTransparency = 125; 
          
        board = new GreenfootImage(boardWidth, boardHeight); 
        board.setColor(java.awt.Color.gray); 
  
        board.setTransparency(boardTransparency); 
        board.fillRect(0, 0, boardWidth, boardHeight); 
        this.setImage(board); 
          
        update(); 
          
          
    } 
    public int getWidth() {
        return boardWidth;
    }
    public int getHeight() {
        return boardHeight;
    }
    
    public int getScore() 
    { 
        return score; 
    } 
    public void addScore (int pts) 
    { 
        score +=pts; 
        update(); 
    } 
    private void update() 
    { 
        sb = new GreenfootImage(board); 
        sb.drawImage(new GreenfootImage(label +score, 18, java.awt.Color.white, new java.awt.Color(0,0,0,0)),25,5); 
        this.setImage(sb); 
          
    } 
    public void reset() 
    { 
        score = 0; 
          
    } 
} 