import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
Erin made all the traps. trapmastah
 */
public class TrapScroll extends Actor
{
    private int counter;

    /**
     * Act - do whatever the Trap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TrapScroll()
    {
        GreenfootImage image = getImage();
        image.scale( 80, 80);
        setImage(image);
    }

    public void act() 
    {
        counter++;
        if (counter >= 100 && counter <= 210)
        {
            kill();
            setImage("trap 1.png");
            GreenfootImage image = getImage();
            image.scale( 80, 80);
            setImage(image);
        }
        else if (counter > 210)
        {
            counter=0;
        }
        else
        {
            setImage("trap 2.png");
            GreenfootImage image = getImage();
            image.scale( 80, 80);
            setImage(image);
        }
    }    

    public void kill()
    {
        Actor Stage2Dragon;
        Stage2Dragon = getOneObjectAtOffset(0, 0, Stage2Dragon.class);
        if (Stage2Dragon != null)
        {
            SWorld world = (SWorld) getWorld();
            world.damagetrap();
        }
        Actor Stage3Dragon =  getOneObjectAtOffset(0, 0, Stage3Dragon.class);
         if (Stage3Dragon != null)
        {
            SWorld world = (SWorld) getWorld();
            world.damagetrap();
        }
    }
}