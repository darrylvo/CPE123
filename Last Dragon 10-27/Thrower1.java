import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thrower here.
 * 
 * @author Lenoy 
 * @version (a version number or a date)
 */
public class Thrower1 extends Actor
{
    private double mainCharX; //Position of the Dragon
    private GreenfootSound sound; //Sound made when projectile fired
    private double mainCharY; //Position of the Dragon
    private int scrolledX; //How far the screen has been scrolled in x direction
    private int scrolledY; //How far the screen has been scrolled in y direction
    private int throwCount; //Count to make sure Thrower1 doesn't throw projectiles too quickly
    private double health; //health of Thrower1
    private int type; //Parameter passed in from constructor. Decides what type of throwing motion is used
    private boolean left = false; //Whether Thrower1 is facing left or not
   
    /**
     * Act - do whatever the Thrower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Thrower1(int t) 
    {
        type = t;
        health = (int) (Math.random() * 2+2);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (int)(8*(health-1)),img.getHeight()+(int)(8 * (health-1))); //scaling image so it shrinks when it loses health
        setImage(img);
        throwCount = 0;
    }
    public void act() 
    {
       facing();
       throwCount++;
       if(Math.abs((scrolledY+getY())-mainCharY)<=192) // make sure doesn't throw if character is a certain distance away in the y direction
       {
           pickingThrow();
       }
    } 
    
    public void pickingThrow() { //decides which type of throwing motion to use
        if(fire()) { //checks to see if Thrower1 within certain x distance
           if((throwCount%100)==0 ) { //checks to see if proper time has passed before launching projectile
               if(((scrolledX+getX())-mainCharX)<=0) { //Checks to see if Dragon is to left or right of enemy
                   if(type==2) {    
                       if(Math.random()*100<50) //randomly chooses between straight and parabolic throw
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
                   else if(type==1){ //randomly chooses between straight and parabolic throw
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
    
    public void throwing(String type, String sign) { //creates the projectile to be launched
        SWorld s = (SWorld) getWorld(); 
        s.addObject(new Rock1(mainCharX,mainCharY,scrolledX+getX(),scrolledY+getY(),type,sign), scrolledX + getX(),scrolledY+getY());
    }
    
    public void facing() { //checks to see which way the Thrower1 is currently facing and switches its direction facing if necessary
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
    public boolean fire() { //returns true if Thrower1 within certain x distance
        if(Math.abs((scrolledX+getX())-mainCharX)<1000) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void setMainPos(int x , int y, int x2, int y2) { //gets position of dragon and distance scrolled from the SWorld class
        mainCharX = x;
        mainCharY = y;
        scrolledX = x2;
        scrolledY = y2;
    }
    
    public void loseHealth(double h) { //causes Thrower1 to lose health if hit
    
        health -= h;
        //system.out.printIn("lost health");
        GreenfootImage img = getImage();
        try
        {
            if((health * 10) % 10 == 0)
                img.scale(img.getWidth() - 8 , img.getHeight() -8);
        }
        catch(IllegalArgumentException iaeEx)
        {
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            world.showVisual("+5",getX(),getY());
            getWorld().removeObject(this);
            scoreboard.addScore(10);
        }
    }
    
    public boolean getDir() { //returns true the boolean left
        return left;
    }
    
    public void die() //causes the Thrower1 to be removed from the world
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
    
}
