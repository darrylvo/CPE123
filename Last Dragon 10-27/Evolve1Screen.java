import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Evolve1Screen here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Evolve1Screen extends PrototypeWorld
{

    /**
     * Constructor for objects of class Evolve1Screen.
     * 
     */
    public Evolve1Screen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
          NewAttack na = new NewAttack();
          Greenfoot.setWorld(na);
        }
    }
}
