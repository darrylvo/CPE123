import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) 
  
/** 
 -darryl
 i made this class to constantly tick down from 400 using the timer class greenfoot has. at the end of the level
 the time left is added to your score, and if it hits zero the game ends
 */
public class Timer extends Actor 
{ 
     private GreenfootImage board; 
    private GreenfootImage sb; 
    public static int time; 
    private String label = "Timer: " ; 
    private SimpleTimer timer= new SimpleTimer();
    public static int all=400;
    
    
    public Timer() 
    { 
          
        super(); 
          
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
    public int getTime() 
    { 
        return time; 
    } 
    
    private void update() 
    { 
        sb = new GreenfootImage(board); 
        sb.drawImage(new GreenfootImage(label +time, 18, java.awt.Color.white, new java.awt.Color(0,0,0,0)),25,5); 
        this.setImage(sb); 
          
    } 
    public void reset() 
    { 
        time = 0; 
        all=400;
          
    } 
    public void act()
    {
        
        time=all-timer.millisElapsed()/1000;
        
        update(); 
        end();
    }
    public void all()
    {
        all=time;
        
    }
    public void end()
    {
        if (time<=0)
        {
            Death death = new Death();
            Greenfoot.setWorld(death);
            
        }
        
    }
} 