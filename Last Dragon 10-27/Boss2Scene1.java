import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss2Scene1 here.
 * 
 *  * @author Jessica
 * @version (a version number or a date)
 */
public class Boss2Scene1 extends World
{
    private static GreenfootSound bkgMusic = new GreenfootSound("sounds/Nerves.mp3");
    private GreenfootSound sound;
    private Stage2Dragon dragon;
    /**
     * Constructor for objects of class Boss2Scene1.
     * 
     */
    public Boss2Scene1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1);
        bkgMusic = new GreenfootSound("sounds/Nerves.mp3");
          //sound by Kevin Macleod of incompetech.com
        bkgMusic.playLoop();
    }
    public void act()
    {
         if(Greenfoot.mouseClicked(this))
         {         
            
            Boss2Scene2 b2s2 = new Boss2Scene2();
            Greenfoot.setWorld(b2s2);
         } 
    }
     public static void stopBackgroundMusic()
    {
        bkgMusic.stop();
    }

}
