import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S7 extends Cutscene5
{
    private GreenfootSound bkgMusic;
    /**
     * Constructor for objects of class S7.
     * 
     */
    public S7()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Cutscene1.stopBackgroundMusic();
            ControlScreen cs = new ControlScreen();
            Greenfoot.setWorld(cs);

        }
      

    }
}
