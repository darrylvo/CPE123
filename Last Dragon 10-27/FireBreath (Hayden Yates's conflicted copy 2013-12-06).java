import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBreath here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBreath extends Actor
{
    /**
     * Act - do whatever the FireBreath wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int count = 0;
    
    public void act() 
    {
        hitEnemy2();
        if(count == 1)
        {
            getWorld().removeObject(this);
        }
        else
            count++;
            
        
    }    
    public FireBreath(int s)
    {
        GreenfootImage img = getImage();
        try
        {
            img.scale((int)(img.getWidth() * (0.1 * s)), (int)(img.getHeight() * (0.1 * s)));
        }
        catch(IllegalArgumentException ex)
        {
            img.scale((int)(img.getWidth() * 0.05), (int)(img.getHeight() * 0.05));
        }
    
            
        //setRotation(75);
    }
    public void flip()
    {
        GreenfootImage img = getImage();
        img.mirrorHorizontally();
        setImage(img);
    }
    public void hitEnemy2()
    {
        SWorld world = (SWorld) getWorld();
        Enemy2 e2 = (Enemy2) getOneIntersectingObject(Enemy2.class);
        if(e2 != null)
        {
            e2.loseHealth(0.1);
        }
    }
    public void hitEnemy1()
    {
        SWorld world = (SWorld) getWorld();
        Enemy1 e1 = (Enemy1) getOneIntersectingObject(Enemy1.class);
    
        if(e1 != null)
        {
            e1.loseHealth(0.2);
        }        
    }
    public void hitThrower1()
    {
        SWorld world = (SWorld) getWorld();
        Thrower1 t1 = (Thrower1) getOneIntersectingObject(Thrower1.class);
    
        if(t1 != null)
        {
            t1.loseHealth(0.2);
        }        
    }
}
