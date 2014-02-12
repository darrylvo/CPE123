import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trap extends Actor
{
    private int counter;
    /**
     * Act - do whatever the Trap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Trap()
    {
        GreenfootImage image = getImage();
        image.scale( 20, 20);
        setImage(image);
    }

    public void act() 
    {
        counter++;
        if (counter >= 100 && counter <= 210)
        {
            kill();
            setImage("button-red.png");
            GreenfootImage image = getImage();
            image.scale( 20, 20);
            setImage(image);
        }
        else if (counter > 210)
        {
            counter=0;
        }
        else
        {
            setImage("button-blue.png");
            GreenfootImage image = getImage();
            image.scale( 20, 20);
            setImage(image);
        }
    }    

    public void kill()
    {
        Actor Dragon;
        Dragon = getOneObjectAtOffset(0, 0, Dragon.class);
        if (Dragon != null)
        {
            World world;
            world = getWorld();
            world.removeObject(Dragon);
        }
    }
}
