import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBossScene4 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class FinalBossScene4 extends World
{

    /**
     * Constructor for objects of class FinalBossScene4.
     * 
     */
    public FinalBossScene4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
    }
     public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            FinalBossScene5 fbs5= new FinalBossScene5();
            Greenfoot.setWorld(fbs5);
        }
    }
}
