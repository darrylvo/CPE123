import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Death here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death extends World
{
    private GreenfootSound bkgMusic;
    Fill fill = new Fill(100, 100, 1);
    EndScore endscore = new EndScore();
    Keyboard keyboard = new Keyboard();
    public static int a;
   String string;
    public Death()
    {    
  
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
              
        
        prepare();
        
    }


    public void act()
    {  
        Level1.stopBackgroundMusic();
        S3L1.stopBackgroundMusic();
        S2L1.stopBackgroundMusic();
        BossScene1.stopBackgroundMusic();
        Boss2Scene1.stopBackgroundMusic();
        FinalBossScene1.stopBackgroundMusic();
        string=keyboard.getString();
        if (Greenfoot.mouseClicked(fill)&&string.isEmpty()==false)
        {
            
            if (a==1)
            {
            keyboard.writeScore();
            
            PrototypeWorld world= new PrototypeWorld();            
            world.reset();
            
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.reset();
            
            endscore.reset();
            
           
            
            Level1 l1 = new Level1();
            Greenfoot.setWorld(l1);
            }
            if (a==2)
            {
                keyboard.writeScore();
                
                SWorld world= new SWorld(1,1,1,1);            
                world.reset();
                
                Scoreboard scoreboard = world.getScoreboard();
                scoreboard.reset();
                
            
                
                //endscore.reset();
                S2L1 s2l1 = new S2L1();
                Greenfoot.setWorld(s2l1);
            }
              if (a==3)
            {
                keyboard.writeScore();
                
                SWorld world= new SWorld(1,1,1,1);            
                world.reset();
                
                Scoreboard scoreboard = world.getScoreboard();
                scoreboard.reset();
                
            
                
                endscore.reset();
                S3L1 s3l1 = new S3L1();
                Greenfoot.setWorld(s3l1);
            }
        }
    
        int width = fill.getImage().getWidth();
        int height = fill.getImage().getHeight();
        
        try {
            MouseInfo ms = Greenfoot.getMouseInfo();
            if((ms.getX()<715 || ms.getX()>715+width) || (ms.getY()<353 || ms.getY()>353+height)) {
                darken(fill,715,348);
            }
            if((ms.getX()>715 && ms.getX()<715+width) && (ms.getY()>353 && ms.getY()<353+height)) {
                lightUp(fill,715,348);
            }
        }
        catch(NullPointerException e) {
            
        }
    }
    public void lightUp(Fill f,int x, int y) {
        GreenfootImage img = getBackground();
        img.setColor(java.awt.Color.WHITE);
        img.setTransparency(3); 
        img.drawRect(x,y,f.getImage().getWidth()+1,f.getImage().getHeight()+1);
        setBackground(img);    
    }
    
    public void darken(Fill f,int x, int y) {
        GreenfootImage img = getBackground();
        img.setColor(Color.RED);
        img.setTransparency(5); 
        img.drawRect(x,y,f.getImage().getWidth()+1,f.getImage().getHeight()+1);
        setBackground(img);    
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {

        addObject(fill, 752, 326);
        fill.setLocation(776, 341);
        fill.set(300, 50);
        fill.setLocation(844, 364);
        fill.set(280, 40);
        fill.setLocation(856, 369);

        addObject(endscore, 406, 308);
        endscore.setLocation(525, 293);

        addObject(keyboard, 497, 354);
        keyboard.setLocation(530, 346);
       
    }


    public void setStage(int b)
    {
        a=b;
        
    }
    public int getStage()
    {
        return a;
    }
    
        
}
