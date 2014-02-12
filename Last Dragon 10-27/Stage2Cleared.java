import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage2Cleared here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Stage2Cleared extends World
{

    /**
     * Constructor for objects of class Stage2Cleared.
     * 
     */
    public Stage2Cleared()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            
        Evolve2 e2 = new Evolve2();
        Greenfoot.setWorld(e2);
    }
}
}