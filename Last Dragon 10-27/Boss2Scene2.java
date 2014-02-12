import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss2Scene2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss2Scene2 extends World
{
      private Stage2Dragon dragon;
    /**
     * Constructor for objects of class Boss2Scene2.
     * 
     */
    public Boss2Scene2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
         {         
            
           BossLevel bl = new BossLevel();
           Greenfoot.setWorld(bl);
         } 
        
    }
}
