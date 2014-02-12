import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBossScene2 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class FinalBossScene2 extends World
{

    /**
     * Constructor for objects of class FinalBossScene2.
     * 
     */
    public FinalBossScene2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
    }
     public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            FinalBossScene3 fbs3 = new FinalBossScene3();
            Greenfoot.setWorld(fbs3);
        }
    }
}
