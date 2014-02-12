import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author Jessica with reference to Lenoy
 * @version (a version number or a date)
 */
public class Boss2 extends GifActor
{ 
    private int type;
    private double health;
    int f =2;
    int z=0;
     private double mainCharX;
    private double mainCharY;
    private int throwCount;
   
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public Boss2()
    {
        health = (int)(25);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (int)(4 * (health-1)), img.getHeight()+ (int)(4 * (health-1)));
        int f=2;
    }
  
  
     public void act() 
    {
        
        moveToDragon();
        die();
        
        try {
            kill();
        }
        catch(Exception e) {
            
        }
        delay();
        pickingThrow();
        throwCount++;
        
       
   }  
   
   public void pickingThrow() {
           if((throwCount%100)==0 ) {
               if((getX()-mainCharX)<=0) {   
                   if(Math.random()*100<50)
                   { 
                       throwing("straight","positive");
                   }
                   else
                   {
                       throwing("parabola","positive");
                   }
                   
               }
               else {   
                   if(Math.random()*100<50){
                       throwing("straight","negative");
                   }
                   else {
                       throwing("parabola","negative");
                   }
               }
           }
    }
    
    public void throwing(String type, String sign) {
        SWorld s = (SWorld) getWorld();                 
        s.addObject(new WizBolt(mainCharX,mainCharY,getX(),getY(),type,sign), getX(), getY());
    }
   
   public void moveToDragon()
       {
           
           setLocation(getX()+f,getY());
           BossLevel fbl = (BossLevel)getWorld();
           if (getX() >= fbl.getWidth()-50)
            {
              f=-2;
              setImage("wizleft.png");
               
               
            }
            else if (getX() <= 10)
            {
                
                f=2;
                setImage("wizright.png");
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
            Stage2Cleared s2c = new Stage2Cleared();
            Greenfoot.setWorld(s2c);
           
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
    public void shoot()
    {
        if (z<0)
        {
            
            
            z=500;
        }
    }
    public void delay()
    {
        z = z-10;
    }
     public void setMainPos(int x , int y) {
        mainCharX = x;
        mainCharY = y;
    }
}
