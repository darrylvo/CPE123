import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S3 extends Cutscene5
{

    /**
     * Constructor for objects of class S3.
     * 
     */
    public S3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            S4 s4 = new S4();
            Greenfoot.setWorld(s4);
            
        }
    }
}
