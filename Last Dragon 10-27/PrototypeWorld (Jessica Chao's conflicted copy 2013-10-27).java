import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PrototypeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class PrototypeWorld extends World
{
    Dragon dragon;
    Thrower thrower;
    /**
     * Constructor for objects of class PrototypeWorld.
     * 
     */
    public PrototypeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1, false); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        
     
    }
    
    public void act()
    {
        if(Math.random() * 1000 < 20)
        {
            if((int)(Math.random()*2) == 0)
            {
                Enemy e = new Enemy(0);
                addObject(e, 960, 360);
            }
            else
            {
                Enemy e = new Enemy(1);
                addObject(e, 30, 360);
            }
        }
        try {
            thrower.setMainPos(dragon.getX() , dragon.getY());
        }
        catch(Exception e) {
            
        }
    }

}
