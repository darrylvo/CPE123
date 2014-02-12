import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HallofFame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HallofFame extends Actor
{
    /**
     * Act - do whatever the HallofFame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(Greenfoot.mouseClicked(this))
        {
            Highscores h = new Highscores();
            Greenfoot.setWorld(h);
        }
    }    
    
}
