import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlScreen extends World
{

    /**
     * Constructor for objects of class ControlScreen.
     * 
     */
    public ControlScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
    }
        public void act()
    {   
        if (Greenfoot.mouseClicked(this))
        {
            Level1 l1 = new Level1();
            Greenfoot.setWorld(l1);
        }
    }
}
