import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossScene2 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class BossScene2 extends PrototypeWorld
{

    /**
     * Constructor for objects of class BossScene2.
     * 
     */
    public BossScene2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
        BossScene3 bs3 = new BossScene3();
        Greenfoot.setWorld(bs3);
        }
    }
}
