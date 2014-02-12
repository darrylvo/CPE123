import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bscene5 here.
 * 
  * @author Jessica
 * @version (a version number or a date)
 */
public class FinalBossScene5 extends World
{

    /**
     * Constructor for objects of class bscene5.
     * 
     */
    public FinalBossScene5()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
    }
     public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            FinalBossLevel fbl = new FinalBossLevel();
            Greenfoot.setWorld(fbl);
        }
    }
}
