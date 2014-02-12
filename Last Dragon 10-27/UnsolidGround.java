import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class unsolidGround here.
 * 
 * @Hayden (your name) 
 * Made this to be used as a platform that you can jump up through and go down through. 
 * Didn't utilize as much as i hoped
 */
public class UnsolidGround extends Actor
{
    private GreenfootImage img;
    public UnsolidGround(int a) 
    {
        img=getImage();
        img.scale(a,50);
        setImage(img);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
