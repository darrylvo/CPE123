import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) 
  
/** 
 
 *  
 * @darryl adds up the score in the end. based off of scoreboard example code from class
 */
public class EndScore extends Actor 
{ 
     private GreenfootImage board; 
    private GreenfootImage sb; 
    public static int endscore; 
    private String label = "Endscore:" ; 
    int a;
    int b;
  
    
    
    
    public EndScore() 
    { 
        
        
        
             Timer timer = new Timer();
          a=timer.getTime();
             Scoreboard scoreboard = new Scoreboard();
          b=scoreboard.getScore();
         
        
       
         
        
          endscore = a+b;
           
        
        
         
            
        
        
       
        
      
    
        
        
    
        
      prepare();
      
        
          
    } 
    public void prepare()
    {
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
    public int getEndScore() 
    { 
        return endscore; 
    } 
    public void addScore (int pts) 
    { 
        endscore +=pts; 
        update(); 
    } 
    private void update() 
    { 
        sb = new GreenfootImage(board); 
        sb.drawImage(new GreenfootImage(label +endscore, 18, java.awt.Color.white, new java.awt.Color(0,0,0,0)),25,5); 
        this.setImage(sb); 
          
    } 
    public void reset() 
    { 
        endscore = 0; 
          
    } 
    public void act()
    {
        
       
    }
} 