import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBreath here.
 * 
 * @Hayden
 * Pretty simple but interesting attack. Instead of just shooting out one firebreath that calculates its own size and 
 * position, made it so that the loop in the dragon's code for breathing fire passes the iteration count for the act
 * in order to have the firebreath be created in a different size. Makes it so it creates firebreath thats larger than previous
 * up until the max size where it holds that size while you have mana and then it shrinks back. 
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
        hitEnemy1();
        hitEnemy2();
        hitThrower1();
        hitBoss2();
        
  
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
    public void hitBoss2()
    {
        SWorld world = (SWorld) getWorld();
        Boss2 b2 = (Boss2) getOneIntersectingObject(Boss2.class);
        if(b2 != null)
        {
            b2.loseHealth(0.1);
        }
    }
    public void hitKnight()
    {
        SWorld world = (SWorld) getWorld();
        Knight k = (Knight) getOneIntersectingObject(Knight.class);
        if(k != null)
        {
            k.loseHealth(0.1);
        }
    }
    public void Boss3()
    {
        SWorld world = (SWorld) getWorld();
        Boss3 b3 = (Boss3) getOneIntersectingObject(Boss2.class);
        if(b3 != null)
        {
            b3.loseHealth(0.1);
        }
    }
}
