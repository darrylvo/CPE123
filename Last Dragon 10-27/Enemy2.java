import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends GifActor
{
    private GreenfootSound sound; 
    private int type;
    private double health;
    private int s=2;
    private boolean stationary = false;
    boolean left=true;
    boolean right=false;
    private double atkCD = 0;
    private boolean attacking = false;
    /**)
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World world)
    {
        setImage("miniboss.gif");
    }

    public void act() 
    {
        super.act();
        
        die();
        Stage2Dragon d = null;
        AttackSword as = null;
        SWorld sw = (SWorld) getWorld();
       
       if(right)
        {
            try
            {
                d = (Stage2Dragon) getOneObjectAtOffset(85, 0, Stage2Dragon.class);
                as  = new AttackSword("r");
            }
            catch(Exception e)
            {
            }
        }
        else
        {
            try
            {
                d = (Stage2Dragon) getOneObjectAtOffset(-85, 0, Stage2Dragon.class);
                as  = new AttackSword("l");
            }
            catch(Exception e)
            {
            }
        }

        if(d != null && atkCD == 0)
        {
            attacking = true;            
            if(right)
            {
                sw.addObject(as, getX() + 30, getY() - 13, true);
                setImage("enemy2attackright.gif");
            }
            else
            {
                sw.addObject(as, getX() - 30, getY() - 13, true);
                setImage("enemy2attackleft.gif");
            }

            as.attack();
            atkCD++;
        }
        else 
        {
            kill();
        }

        if(atkCD > 0 && atkCD < 10)
        {
            atkCD++;
        }
        else if(atkCD >= 10 && atkCD < 25)
        {
            atkCD++;
            attacking = false;
            if(atkCD == 15)
            {
                if(right)
                {
                    setImage("minibossright.gif");
                }
                else 
                {
                    setImage("miniboss.gif"); 
                }
            }
        }
        else if (atkCD >= 25)
        {
            atkCD = 0;
        }

        if(!attacking && !stationary)
        {
            try
            {
                move();
            }
            catch(IllegalStateException ilsx)
            {
            }
        
        }
    }    
    
    public Enemy2(int t)
    {
        type = t;
        health = 5;
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (int)(8 * (health-1)), img.getHeight()+ (int)(8 * (health-1)));
        
    }
    
    public void move()
    {
        setLocation(getX()+s,getY());
        Stage2Ground z = (Stage2Ground)getOneObjectAtOffset(getImage().getHeight()-40,0, Stage2Ground.class);
        Stage2Ground x = (Stage2Ground)getOneObjectAtOffset(-getImage().getHeight()+40,0, Stage2Ground.class);
        if ( z!=null )
        {
            //System.out.println("side");
            setImage("miniboss.gif");
            s=-5;     
            left=true;
            right=false;
            z=null;
        }
        
        if (x!=null)
        {
            setImage("minibossright.gif");
            s=5; 
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
                left=true;
                setImage("miniboss.gif");
                s=-2;
                f=null;
            
            }
            }
        if (f!= null)    
        {
           if(right==false)
            
            {                
                right=true;
                left=false;
                setImage("minibossright.gif");
                s=2;
            }
            
            
        
        }
    }
    
    public void sitThere()
    {
        stationary = true;
    }
    
    public void die()
    {
        if(health < 1)
        {
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.addScore(5);
            world.addObject(new ManaDroplet(2, 40), getX(), getY(), false);
            world.showVisual("+5",getX(),getY());
            getWorld().removeObject(this);
           
        }
        
    }
    
    public void loseHealth(double h)
    {
        health-=h;
        //System.out.println("lost health");
        GreenfootImage img = getImage();
        
        if((health*10) % 10 == 0)
            img.scale((int)(img.getWidth() - 8), (int)(img.getHeight() - 8));
    }
    
    public String getFacing()
    {
        if(right)
        {
            return "right";
        }
        else
        {
            return "left";
        }
    }
    
    public void kill()
    {
        try
        {
            Actor dragon = getOneIntersectingObject(Stage2Dragon.class);
            if(dragon != null) {
                SWorld world = (SWorld) getWorld();
               
               world.damage();
            }
        }
        catch(IllegalStateException isx)
        {
        }
    }
    
    
}
