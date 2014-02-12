import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrapWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrapWorld extends World
{
    /**
     * Constructor for objects of class TrapWorld.
     * 
     */
    public TrapWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    public void prepare()
    {
        // checking if it resets the counter
        Dragon dragon = new Dragon();
        addObject( dragon, 150, 350);
        
        //checking if it kills the dragon
        Dragon ddragon = new Dragon();
        addObject( ddragon, 50, 350);
        
        //checking if it only kills the dragon at certain times
        Dragon dddragon = new Dragon();
        addObject( dddragon, 200, 350);
        
        Trap trap = new Trap();
        addObject( trap, 250, 350);
    }
}
