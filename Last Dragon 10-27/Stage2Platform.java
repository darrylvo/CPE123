import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage2Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2Platform extends Actor
{
    /**
     * Act - do whatever the Stage2Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private GreenfootImage img;
    public  Stage2Platform(int a)
    {
        GreenfootImage image = getImage();
        image.scale(a,90);
        setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
