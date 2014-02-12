import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage3Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage3Platform extends Actor
{
    /**
     * Act - do whatever the Stage3Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Stage3Platform( int t)
    {
       GreenfootImage image = getImage();
        image.scale( t, 80);
        setImage(image);
    }
    }    
