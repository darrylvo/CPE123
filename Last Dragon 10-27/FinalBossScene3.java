import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBossScene3 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class FinalBossScene3 extends World
{

    /**
     * Constructor for objects of class FinalBossScene3.
     * 
     */
    public FinalBossScene3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
    }
     public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            FinalBossScene4 fbs4 = new FinalBossScene4();
            Greenfoot.setWorld(fbs4);
        }
    }
}
