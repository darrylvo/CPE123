import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author Jessica 
 * @version (a version number or a date)
 */
public class Knight extends GifActor
{
    private int type;
    private int health;
    private int s=8;
    boolean left=false;
    boolean right=true;
    /**)
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World world)
    {
        setImage("knightrightgif.gif");
    }

    public void act() 
    {
        super.act();
        move();
        die();
        try {
            kill();
        }
        catch(Exception e) {
            
        }
       
    }    
    
    public Knight(int t)
    {
        type = t;
        health = (int)(8);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (8 * (health-1)), img.getHeight()+ (8 * (health-1)));
    }
    
    public void move()
    {
        setLocation(getX()+s,getY());
        Stage2Ground z = (Stage2Ground)getOneObjectAtOffset(getImage().getHeight()-40,0, Stage2Ground.class);
        Stage2Ground x = (Stage2Ground)getOneObjectAtOffset(-getImage().getHeight()+40,0, Stage2Ground.class);
        if ( z!=null )
        {
            //System.out.println("side");
            setImage("knightrightgif.gif");
            s=-8;     
            left=true;
            right=false;
            z=null;
        }
        
        if (x!=null)
        {
            setImage("knightgif.gif");
            s=8; 
            right = true;
            left=false;
            x=null;
        }    
        Actor f = getOneIntersectingObject(Fill.class);
        if (f!= null)
        {
            if(right ==true)
            {
                
                right=false;
                setImage("knightgif.gif");
                s=-8;
                f=null;
            
            }
            }
        if (f!= null)    
        {
           if(right==false)
            
            {                
                right=true;
                setImage("knightrightgif.gif");
                s=8;
            }
            
            
        
        }
    }
    
    public void die()
    {
        if(health < 1)
        {
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.addScore(5);
            world.showVisual("+5",getX(),getY());
            getWorld().removeObject(this);
           
        }
        
    }
    
    public void loseHealth(double h)
    {
        health-=h;
        //System.out.println("lost health");
        GreenfootImage img = getImage();
        if((health*10)%10 == 0)
            img.scale(img.getWidth() - 8, img.getHeight() - 8);
    }
    
    public void kill()
    {
        Actor dragon = getOneIntersectingObject(Stage3Dragon.class);
        if(dragon != null) {
            SWorld world = (SWorld) getWorld();
           world.damage();
        }
    }
    
    
}