import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 Darryl- i made the code to make them go back and forth
 */
public class Enemy1 extends GifActor
{
    private GreenfootSound sound;
    private int type;
    private int health;
    private int s=2;
    boolean left=false;
    boolean right=true;
    private double atkCD = 0;
    private boolean attacking = false;
    /**)
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World world)
    {
        setImage("enemy2.gif");
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
                setImage("enemy1attackright.gif");
            }
            else
            {
                sw.addObject(as, getX() - 30, getY() - 13, true);
                setImage("enemy1attackleft.gif");
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
            if(atkCD == 17)
            {
                if(right)
                    setImage("enemy2.gif");
                else
                    setImage("enemy.gif");
            }
        }
        else if (atkCD >= 25)
        {
            atkCD = 0;
        }

        if(!attacking)
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
    
    public Enemy1(int t)
    {
        type = t;
        health = (int)(3);
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
            setImage("enemy.gif");
            s=-4;     
            left=true;
            right=false;
            z=null;
        }
        
        if (x!=null)
        {
            setImage("enemy2.gif");
            s=4; 
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
                left = true;
                setImage("enemy.gif");
                s=-2;
                f=null;
            
            }
            }
        if (f!= null)    
        {
           if(right==false)
            
            {                
                right=true;
                left = false;
                setImage("enemy2.gif");
                s=2;
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
            world.addObject(new ManaDroplet(1, 15),getX()+world.getScrolledX(),getY()+world.getScrolledY(), false);
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
            img.scale(img.getWidth() - 8, img.getHeight() - 8);
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
