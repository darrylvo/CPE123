import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelCleared here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Level1Cleared extends PrototypeWorld
{

    /**
     * Constructor for objects of class LevelCleared.
     * 
     */
    public Level1Cleared()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
        Evolve1Screen e1s = new Evolve1Screen();
        Greenfoot.setWorld(e1s);
        }
    }
}
