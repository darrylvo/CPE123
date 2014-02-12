import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends GifActor
{ 
    private int type;
    private int health;
    int f =2;
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public Boss(int t)
    {
        type = t;
        health = (int)(25);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (4 * (health-1)), img.getHeight()+ (4 * (health-1)));
    }
  
    public void addedToWorld(World world)
    {
        setImage("minibossright.gif");
    }
     public void act() 
    {
        super.act();
        moveToDragon();
        die();
        try {
            kill();
        }
        catch(Exception e) {
            
        }
       
    }    

       public void moveToDragon()
       {
           
           setLocation(getX()+f,getY());
           FirstBossLevel fbl = (FirstBossLevel)getWorld();
           if (getX() >= fbl.getWidth()-50)
            {
              f=-2;
              setImage("miniboss.gif");
               
               
            }
            if (getX() <= 10)
            {
                setImage("minibossright.gif");
                f=2;
            }
        
   
    
    }
    public void die()
    {
        if(health < 1)
        {
            PrototypeWorld world = (PrototypeWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.addScore(50);
            getWorld().removeObject(this);
           
        }
    }
    public void loseHealth()
    {
        health--;
        FirstBossLevel firstbosslevel = (FirstBossLevel) getWorld();
        firstbosslevel.loseHealth();
        //System.out.println("lost health");
        GreenfootImage img = getImage();
        img.scale(img.getWidth() - 4, img.getHeight() - 4);
    }
    
    public void kill()
    {
        Actor dragon = getOneIntersectingObject(Dragon.class);
        if(dragon != null) {
           PrototypeWorld world = (PrototypeWorld) getWorld();
           world.damage();
        }
        S2L1 s2l1 = new S2L1();
        Greenfoot.setWorld(s2l1);
    }
}
