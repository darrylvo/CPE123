import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage3Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage3Ground extends Actor
{
    /**
     * Act - do whatever the Stage3Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(int a) 
    {
        GreenfootImage img = getImage();
       img.scale(a,88);
       setImage(img);
    }    
}
