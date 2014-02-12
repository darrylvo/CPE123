import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S6 extends Cutscene5
{

    /**
     * Constructor for objects of class S6.
     * 
     */
    public S6()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            S7 s7 = new S7();
            Greenfoot.setWorld(s7);
        }
    }
}
