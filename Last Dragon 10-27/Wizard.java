import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author Jessica w/ reference to Lenoy's Boss2 code
 * @version (a version number or a date)
 */
public class Wizard extends GifActor
{ 
    private int type;
    private double health;
    int f =2;
    int z=0;
    private int s=8;
    private double mainCharX;
    private double mainCharY;
    private int throwCount;
    boolean left=false;
    boolean right=true;
    private int scrolledX;
    private int scrolledY;
    private boolean move;
    
    public Wizard(boolean move)
    {
        health = (int)(7);
        this.move = move;
        int f=2;
        throwCount = 0;
    }
  
  
     public void act() 
    {
        if(move) {
            moveToDragon();
        }
        
        facing();
        
        try {
            //kill();
        }
        catch(Exception e) {
            
        }
        delay();
        if(Math.abs((scrolledY+getY())-mainCharY)<=400) 
        {
            pickingThrow();
        }
        throwCount++;
        kill();
        die();
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
    
   public void facing() {
       try {
           if(!left && ((scrolledX+getX())-mainCharX)>=0) {
               GreenfootImage img = getImage();
               img.mirrorHorizontally();
               setImage(img);
               left = true;
           }
           else if(left && ((scrolledX+getX())-mainCharX)<0) {
               GreenfootImage img = getImage();
               img.mirrorHorizontally();
               setImage(img);
               left = false;
           }
       }
       catch(Exception e) {
           
       }
    }
    
   public void throwing(String type, String sign) {
       SWorld s = (SWorld) getWorld();                 
       s.addObject(new WizBolt(mainCharX,mainCharY,scrolledX+getX(),scrolledY+getY(),type,sign), scrolledX+getX(), scrolledY+getY());
   }
   
   public void moveToDragon()
       {
        setLocation(getX()+s,getY());
        Stage3Ground z = (Stage3Ground)getOneObjectAtOffset(getImage().getHeight()-40,0, Stage2Ground.class);
        Stage3Ground x = (Stage3Ground)getOneObjectAtOffset(-getImage().getHeight()+40,0, Stage2Ground.class);
        if ( z!=null )
        {
            //System.out.println("side");
            setImage("enemy.gif");
            s=-8;     
            left=true;
            right=false;
            z=null;
        }
        
        if (x!=null)
        {
            setImage("wizright.png");
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
                setImage("wizleft.png");
                s=-8;
                f=null;
            
            }
            }
        if (f!= null)    
        {
           if(right==false)
            
            {                
                right=true;
                setImage("wizright.png");
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
            scoreboard.addScore(50);
            world.showVisual("+50",getX(),getY());
            getWorld().removeObject(this);
           
        }
    }
    public void loseHealth(double h)
    {
        health-= h;
        
        GreenfootImage img = getImage();
        try
        {
            if((health * 10)%10 == 0)
                img.scale(img.getWidth() - 8 , img.getHeight() -8);
        }
        catch(IllegalArgumentException iaeEx)
        {
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            world.showVisual("+50",getX(),getY());
            getWorld().removeObject(this);
            scoreboard.addScore(50);
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
     public void setMainPos(int x , int y, int x2, int y2) {
        mainCharX = x;
        mainCharY = y;
        scrolledX = x2;
        scrolledY = y2;
    }
        public void kill()
    {
        try 
        {
            Actor dragon = getOneIntersectingObject(Stage3Dragon.class);
            if(dragon != null) {
                SWorld world = (SWorld) getWorld();
                world.damage();
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public double getHealth() {
        return health;
    }
}