import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrapScrollHidden extends Actor
{
    private GreenfootSound sound;
    private int counter;

    /**
     * Act - do whatever the Trap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TrapScrollHidden()
    {
        GreenfootImage image = getImage();
        image.scale( 80, 80);
        setImage(image);
    }

    public void act() 
    {
        counter++;
        if (counter >= 75 && counter <= 210)
        {
            kill();
            setImage("trap1.png");
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
            image.setTransparency(0);
            setImage(image);
        }
    }    

    public void kill()
    {
        Actor Stage2Dragon;
        Stage2Dragon = getOneObjectAtOffset(0, 0, Stage2Dragon.class);
        if (Stage2Dragon != null)
        {
           // sound = new GreenfootSound("sounds/Stab-SoundBible.com-766875573.mp3");
           // sound.play();
            SWorld world = (SWorld) getWorld();
            world.damagetrap();
        }
        Actor Stage3Dragon;
        Stage3Dragon = getOneObjectAtOffset(0, 0, Stage3Dragon.class);
        if (Stage3Dragon != null)
        {
           // sound = new GreenfootSound("sounds/Stab-SoundBible.com-766875573.mp3");
         //   sound.play();
            SWorld world = (SWorld) getWorld();
            world.damagetrap();
        }
    }
}