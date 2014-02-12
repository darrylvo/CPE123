import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S2 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class S2 extends Cutscene5
{

    /**
     * Constructor for objects of class S2.
     * 
     */
    public S2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            S3 s3 = new S3();
            Greenfoot.setWorld(s3);
            
        }
    }
}
