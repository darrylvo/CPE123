import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author Jessica &Darryl
 * @version (a version number or a date)
 */
public class Boss extends GifActor
{ 
    private GreenfootSound sound;
    private int type;
    private double atkCD = 0;
    private int health;
    private boolean attacking = false;
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
        
       
       /* try {
            kill();
        }
        catch(Exception e) {
            
        }*/
        
        Dragon d;
        AttackSword as;
        
        if(f==2)
        {
            d = (Dragon) getOneObjectAtOffset(85, 0, Dragon.class);
            as  = new AttackSword("r");
        }
        else
        {
            d = (Dragon) getOneObjectAtOffset(-85, 0, Dragon.class);
            as  = new AttackSword("l");
        }
        
        if(d != null && atkCD == 0)
        {
            attacking = true;            
            if(f==2)
            {
                getWorld().addObject(as, getX() + 25, getY() - 13);
                setImage("enemy2attackright.gif");
            }
            else
            {
                getWorld().addObject(as, getX() - 25, getY() - 13);
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
            if(f==2)
            {
                //setImage("enemy2attackright.gif");
            }
            else
            {
                //setImage("enemy2attackleft.gif");
            }
        }
        else if(atkCD >= 10 && atkCD < 25)
        {
            atkCD++;
            attacking = false;
            if(f==2)
            {
                setImage("minibossright.gif");
            }
            else 
            {
                setImage("miniboss.gif"); 
            }
        }
        else if (atkCD >= 25)
        {
            atkCD = 0;
        }
        
        if(!attacking)
        {
            moveToDragon();
        }
         die();
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
            world.showVisual("+50",getX(),getY());
            getWorld().removeObject(this);
            
            Timer timer = world.getTimer();
            int a = timer.getTime();
            scoreboard.addScore(a);
            world.reset();
            
            Level1Cleared l1c = new Level1Cleared();
            Greenfoot.setWorld(l1c);
           
        }
    }
    public void loseHealth()
    {
        health--;
        //used for healthbar
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
           sound = new GreenfootSound("sounds/Jab-SoundBible.com-1806727891.mp3");
           sound.play();
           world.damage();
        }
        
    } 
    
    
}
