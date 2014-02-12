import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cutscene3 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Cutscene3 extends Cutscenes
{

    /**
     * Constructor for objects of class Cutscene3.
     * 
     */
    public Cutscene3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Cutscene4 cs4 = new Cutscene4();
            Greenfoot.setWorld(cs4);
        }
    }
}
