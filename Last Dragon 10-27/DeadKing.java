import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeadKing here.
 * 
 * @author Jessica 
 * @version (a version number or a date)
 */
public class DeadKing extends World
{
    private static GreenfootSound sound;

    /**
     * Constructor for objects of class DeadKing.
     * 
     */
    public DeadKing()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        sound = new GreenfootSound("sounds/On the Shore.mp3");
          //sound by Kevin Macleod of incompetech.com
        sound.playLoop();
    }
    public static void stopBackgroundMusic()
    {
        sound.stop();
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            LastScene ls = new LastScene();
            Greenfoot.setWorld(ls);
        }
    }
}
