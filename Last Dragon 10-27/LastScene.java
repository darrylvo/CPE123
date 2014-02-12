import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LastScene here.
 * 
 *  * @author Jessica
 * @version (a version number or a date)
 */
public class LastScene extends World
{

    /**
     * Constructor for objects of class LastScene.
     * 
     */
    public LastScene()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 

    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
           DeadKing.stopBackgroundMusic();
            IntroScreen is = new IntroScreen();
            Greenfoot.setWorld(is);
        }
    }
  

}
