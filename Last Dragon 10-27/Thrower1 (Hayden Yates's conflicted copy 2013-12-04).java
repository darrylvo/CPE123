import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thrower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thrower1 extends Actor
{
    private double mainCharX;
    private GreenfootSound sound;
    private double mainCharY;
    private int scrolledX;
    private int throwCount;
    private int health;
    private int type;
    private boolean left = false;
   
    /**
     * Act - do whatever the Thrower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Thrower1(int t) 
    {
        type = t;
        health = (int) (Math.random() * 2+2);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (8*(health-1)),img.getHeight()+(8 * (health-1)));
        setImage(img);
        throwCount = 0;
    }
    public void act() 
    {
       facing();
       throwCount++;
       pickingThrow();
    } 
    
    public void pickingThrow() {
        if(fire()) {
           if((throwCount%100)==0 ) {
               if((getX()-mainCharX)>=0) {
                   if(type==2) {    
                       if(Math.random()*100<50)
                       { 
                           sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                           throwing("straight","positive");
                       }
                       else
                       {
                           sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                           throwing("parabola","positive");
                       }
                   }
                   else if(type==1){
                       sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                       throwing("high","positive");
                   }
               }
               else {
                  if(type==2) {    
                       if(Math.random()*100<50){
                        sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                        throwing("straight","negative");
                    
                    }
                    
                    else {
                        sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                        throwing("parabola","negative");
                    }
                  }
                  else if(type==1) {
                       sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                       throwing("high","negative");
                   } 
               }
           }
       }
    }
    
    public void throwing(String type, String sign) {
        SWorld s = (SWorld) getWorld();      
        System.out.println("shoot");
        s.addObject(new Rock1(mainCharX,mainCharY,scrolledX+getX(),getY(),type,sign), scrolledX + getX(), getY());
    }
    
    public void facing() {
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
    public boolean fire() {
        if(Math.abs(getX()-mainCharX)<1000) {            
            System.out.println("true");
            return true;
        }
        else {
            System.out.println("false");
            return false;
        }
    }
    
    public void setMainPos(int x , int y, int x2) {
        mainCharX = x;
        mainCharY = y;
        scrolledX = x2;
    }
    
    public void loseHealth() {
    
        health --;
        //system.out.printIn("lost health");
        GreenfootImage img = getImage();
        try
        {
            img.scale(img.getWidth() - 8 , img.getHeight() -8);
        }
        catch(IllegalArgumentException iaeEx)
        {
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            getWorld().removeObject(this);
            scoreboard.addScore(10);
        }
    }
    
    public boolean getDir() {
        return left;
    }
    
    public void die()
    {
        if(health < 1)
        {
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.addScore(5);
            getWorld().removeObject(this);
           
        }
        
    }
    
}
