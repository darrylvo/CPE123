import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cutscene4 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Cutscene4 extends Cutscenes
{

    /**
     * Constructor for objects of class Cutscene4.
     * 
     */
    public Cutscene4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
          if (Greenfoot.mouseClicked(this))
        {
            S1 s1 = new S1();
            Greenfoot.setWorld(s1);

        }
    }
}
