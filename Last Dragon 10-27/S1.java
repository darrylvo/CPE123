import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S1 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class S1 extends Cutscene5
{

    /**
     * Constructor for objects of class S1.
     * 
     */
    public S1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            S2 s2 = new S2();
            Greenfoot.setWorld(s2);
            
        }

  
    }
  
}
