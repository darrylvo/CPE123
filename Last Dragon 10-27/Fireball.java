import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int xDir;
    int yDir;
    //these are the x & y coordinates of the pixel that it is being fired at when it is created
    
    int fdbCounter = 0;
    //had to make this because greenfoot was being stubborn.
    private int distance = 0;
    
    
    public void act() 
    {   

        while(fdbCounter < 3)
        {
            turnTowards(xDir, yDir);
            fdbCounter++;
        }
        move(10);
        try
        {
            if(distance > 25 || getX() < 10)
            {
             shrink();
            }
            hitEnemy();
            hitBoss();
            
            distance++;
            hitsGround();
        }
        catch(IllegalStateException ilstex)
        {
        }
        
        
    }  
  
    /*
     * Initializes the fireball, accepts the coordinates where the mouse clicked. Is called in Dragon's
     * shootFire() method.
     */
    public Fireball(int x, int y)
    {
        //System.out.println("rotation: " + getRotation());
        xDir = x;
        yDir = y;
        //System.out.println("x:" + x + " " + "y:" + y);
        //System.out.println("rotation: " + getRotation());
    }
    
    public Fireball()
    {
    }
    
    public void hitEnemy()
    {
        PrototypeWorld world = (PrototypeWorld) getWorld();
        Enemy e = (Enemy) getOneIntersectingObject(Enemy.class);
        if(e != null)
        {
           try
           {
               world.removeObject(this);
               e.loseHealth();
           }
           catch(NullPointerException npex)
           {
           }
        }
    }
    public void hitBoss()
    {
        PrototypeWorld world = (PrototypeWorld) getWorld();
        if(this != null)
        {
            Boss b = (Boss) getOneIntersectingObject(Boss.class);
            if(b !=null)
            {
                try
                {
                    world.removeObject(this);
                    b.loseHealth();
                }
                catch(NullPointerException npex)
                {
                }
           }
        }
    }
    
    public void shrink()
    {
        GreenfootImage img = getImage();
        try
        {
            img.scale((int)(img.getWidth() * .75), (int)(img.getHeight() * .75));
        }
        catch(IllegalArgumentException ex)
        {
            try
            {
                getWorld().removeObject(this);
            }
            catch(NullPointerException npex2)
            {
            }
        }
    
    }
    
    public void hitsGround()
    {
        Actor g = getOneObjectAtOffset(0, 0, Ground.class);
        Actor b = getOneObjectAtOffset(0, 0, Block.class);
        Actor usg = getOneObjectAtOffset(0, 0, UnsolidGround.class);
        
        if(g != null || b !=null || usg != null)
        {
            getWorld().addObject(new FireExplosion(getRotation()), getX(), getY());
            getWorld().removeObject(this);
        }
    }
    
    
    
}
