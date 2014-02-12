import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossScene1 here.
 * 
 * @author Jessica 
 * @version (a version number or a date)
 */
public class BossScene1 extends PrototypeWorld
{
    private static GreenfootSound sound = new GreenfootSound("sounds/Prelude and Action.mp3");
    /**
     * Constructor for objects of class BossScene1.
     * 
     */
    public BossScene1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels
        Level1.stopBackgroundMusic();
        sound = new GreenfootSound("sounds/Prelude and Action.mp3");
          //sound by Kevin Macleod of incompetech.com
        sound.playLoop();
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
        BossScene2 bs2 = new BossScene2();
        Greenfoot.setWorld(bs2);
        }
    }
    public static void stopBackgroundMusic()
    {
        sound.stop();
    }
}
