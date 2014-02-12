import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S5 extends Cutscene5
{

    /**
     * Constructor for objects of class S5.
     * 
     */
    public S5()
    {    
        
    }
    public void act()
    {
    if (Greenfoot.mouseClicked(this))
        {
    
            S6 s6 = new S6();
            Greenfoot.setWorld(s6);
        }
        }
    }

