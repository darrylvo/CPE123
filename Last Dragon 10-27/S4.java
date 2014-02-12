import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S4 extends Cutscene5
{

    /**
     * Constructor for objects of class S4.
     * 
     */
    public S4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        
    if (Greenfoot.mouseClicked(this))
        {
            S5 s5 = new S5();
            Greenfoot.setWorld(s5);
            
        }
    }
}
