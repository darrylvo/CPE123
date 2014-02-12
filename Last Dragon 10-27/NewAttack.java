import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewAttack here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class NewAttack extends World
{

    /**
     * Constructor for objects of class NewAttack.
     * 
     */
    public NewAttack()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1);
       
    }
    public void act()
    {
          if (Greenfoot.mouseClicked(this))
        {
          S2L1 l1 = new S2L1();
          Greenfoot.setWorld(l1);
        }
    }
}
