import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{   public GreenfootImage img;
    public Ground(int a)
    {
        img=getImage();
        img.scale(a,76);
        setImage(img);
        
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
