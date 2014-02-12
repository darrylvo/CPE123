import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBossScene1 here.
 * 
 * @author Jessica 
 * @version (a version number or a date)
 */
public class FinalBossScene1 extends World
{
    private static GreenfootSound sound = new GreenfootSound("sounds/Ghostpocalypse - 7 Master.mp3");
    /**
     * Constructor for objects of class FinalBossScene1.
     * 
     */
    public FinalBossScene1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
        sound = new GreenfootSound("sounds/Ghostpocalypse - 7 Master.mp3");
          //sound by Kevin Macleod of incompetech.com
        sound.playLoop();
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            FinalBossScene2 fbs2 = new FinalBossScene2();
            Greenfoot.setWorld(fbs2);
        }
    }
    public static void stopBackgroundMusic()
    {
        sound.stop();
    }
    
}
