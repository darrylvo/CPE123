import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Evolve2 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Evolve2 extends World
{

    /**
     * Constructor for objects of class Evolve2.
     * 
     */
    public Evolve2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
    }
    public void act()
    {
     if (Greenfoot.mouseClicked(this))
        {
        S3L1 s3 = new S3L1();
        Greenfoot.setWorld(s3);
    }
    }
}
