import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class attackSword here.
 * 
 * @Hayden 
 * Made this to be used as a more reliable way for hit detection for enemies attacking the dragon.
 * Enemys create this object which then swings/rotates in order to hit the dragon as the enemy plays its
 * attack animation
 */
public class AttackSword extends Actor
{
    private boolean invisible = false;
    private String direction; 
    private int rotation;
    private boolean hashslingingslasher = false;
    private boolean hitDragon = false;
    
   
    public void act() 
    {
        
        /*if(Greenfoot.isKeyDown("v"))
        {
            hashslingingslasher = true;
        }*/
        
        if(hashslingingslasher)
        {
            if(rotation <= 30 || (rotation <= 240 && rotation >= 160)) 
                slash();
            else
                getWorld().removeObject(this);
        }
    }    
    
    //Says whether the attack should be right of the enemy or left. Rotation angles have to be different
    public AttackSword(String dir)
    {
        direction = dir;
        if(dir == "l")
        {
            rotation = 240;
        }
        else
        {
            rotation = -60;
        }
        setRotation(rotation);
        getImage().setTransparency(0);   //uncomment this out once we have attack animations
        invisible = true;
    }
    
    public void changeRotation(int r)
    {
        setRotation(r);
    }
    
    public void slash()
    {
        if(direction == "r")
        {
            for(int i = 0; i < 5; i++)   //Did this because i want it to not have issues phasing through the dragon and have better hit detection
            {
                rotation += 5;
                setRotation(rotation);
                doDmg();
            }
        }
        else
        {
            for(int i = 0; i < 5; i++)
            {
                rotation -= 5;
                setRotation(rotation);
                doDmg();
            }
        }
    }
    
    public void doDmg()
    {
        Actor dragon = getOneIntersectingObject(Dragon.class);
        if(dragon != null)
        {
            if(!hitDragon)
            {
                PrototypeWorld w = (PrototypeWorld) getWorld();
                GreenfootSound sound = new GreenfootSound("sounds/Jab-SoundBible.com-1806727891.mp3");
                sound.play();
                w.damage();
                hitDragon = true;
            }
        }
    }
    
    public void attack()
    {
        hashslingingslasher = true;
    }
    
}
