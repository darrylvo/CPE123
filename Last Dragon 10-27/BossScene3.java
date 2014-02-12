import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossScene3 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class BossScene3 extends PrototypeWorld
{

    /**
     * Constructor for objects of class BossScene3.
     * 
     */
    public BossScene3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
        BossScene4 bs4 = new BossScene4();
        Greenfoot.setWorld(bs4);
        }
    }
}
