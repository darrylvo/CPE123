import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trap extends Actor
{
    private GreenfootSound sound;
    private int counter;
    //erin greenlee!!

    /**
     * Act - do whatever the Trap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Trap()
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
            setImage(image);
        }
    }    

    public void kill()
    {
        Actor Dragon;
        Dragon = getOneObjectAtOffset(0, 0, Dragon.class);
        if (Dragon != null)
        {
        //    sound = new GreenfootSound("sounds/Stab-SoundBible.com-766875573.mp3");
        //    sound.play();
            PrototypeWorld world = (PrototypeWorld) getWorld();
            world.damagetrap();
        }
        Actor dragon = getOneObjectAtOffset(0,0,Stage2Dragon.class);
        if (dragon!= null)
        {
         //   sound = new GreenfootSound("sounds/Stab-SoundBible.com-766875573.mp3");
         //   sound.play();
            SWorld world = (SWorld)getWorld();
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
