import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss3 here.
 * 
 * @author Lenoy 
 * @version (a version number or a date)
 */
public class Boss3 extends GifActor
{
    private int type;
    private double health;
    int f = 2;
    /**
     * Act - do whatever the Boss3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Boss3() {
        health = 35;
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (int)(4 * (health-1)), img.getHeight()+ (int)(4 * (health-1)));
    }
    
    public void act() 
    {
        die();
        moveToDragon();
        try {
            kill();
        }
        catch(Exception e) {
            
        }
    }  
    
    public void die()
    {
        if(health < 1)
        {
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.addScore(50);
            world.showVisual("+50",getX(),getY());
            getWorld().removeObject(this);
           
        }
    }
    
    public void moveToDragon()
       {
           
           setLocation(getX()+f,getY());
           BossLevel fbl = (BossLevel)getWorld();
           if (getX() >= fbl.getWidth()-50)
            {
              f=-2;
              
               
               
            }
            if (getX() <= 10)
            {
                
                f=2;
            }
        
   
    
    }
    
    public void loseHealth(double h)
    {
        health-=h;
        BossLevel bosslevel = (BossLevel) getWorld();
        bosslevel.loseHealth();
        //System.out.println("lost health");
        GreenfootImage img = getImage();
        if((health*10)%10 == 0)
            img.scale(img.getWidth() - 4, img.getHeight() - 4);
    }
    
    public void kill()
    {
        Actor dragon = getOneIntersectingObject(Stage2Dragon.class);
        if(dragon != null) {
           SWorld world = (SWorld) getWorld();
           world.damage();
        }
        
    }
}
