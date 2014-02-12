import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cutscene2 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Cutscene2 extends Cutscenes
{

    /**
     * Constructor for objects of class Cutscene2.
     * 
     */
    public Cutscene2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Cutscene3 cs3 = new Cutscene3();
            Greenfoot.setWorld(cs3);
        }
    }
}
