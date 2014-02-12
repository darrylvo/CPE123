import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cutscene1 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Cutscene1 extends Cutscenes
{
    private static GreenfootSound bkgMusic = new GreenfootSound("sounds/Hitman.mp3");

    /**
     * Constructor for objects of class Cutscene1.
     * 
     */
    public Cutscene1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
 
        bkgMusic = new GreenfootSound("sounds/Hitman.mp3");
        bkgMusic. playLoop();
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
        Cutscene2 cs2 = new Cutscene2();
        Greenfoot.setWorld(cs2);
        }
    }
    public static void stopBackgroundMusic()
    {
        bkgMusic.stop();
    }
}

