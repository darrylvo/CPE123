import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossScene4 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class BossScene4 extends PrototypeWorld
{

    /**
     * Constructor for objects of class BossScene4.
     * 
     */
    public BossScene4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
        FirstBossLevel bl = new FirstBossLevel();
        Greenfoot.setWorld(bl);
        }
    }
}
