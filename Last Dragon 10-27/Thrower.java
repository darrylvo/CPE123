import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thrower here.
 * 
 * @author Lenoy 
 * @version (a version number or a date)
 */
public class Thrower extends Actor //Same as Thrower1 except with different world that doesn't scroll
{
    private double mainCharX;
        private int scrolledX;
    private double mainCharY;
    private int throwCount;
     private int health;
    private int type;
    private boolean left = false;
    /**
     * Act - do whatever the Thrower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Thrower() {
        GreenfootImage img = getImage();
        health = (int) (Math.random() * 2+2);
        img.scale(img.getWidth()*3/2,img.getHeight()*3/2);
        setImage(img);
        throwCount = 0;
    }
    public void act() 
    {
       throwCount++;
       if((throwCount%100)==0) {
           if((getX()-mainCharX)<=0) {
               if(getY()>getWorld().getHeight()*3/4) {    
                   if(Math.random()*100<50)
                    getWorld().addObject(new Rock(mainCharX,mainCharY,getX(),getY(),"straight","positive"), getX(), getY());
                   else
                    getWorld().addObject(new Rock(mainCharX,mainCharY,getX(),getY(),"parabola","positive"), getX(), getY());
               }
               else {
                   getWorld().addObject(new Rock(mainCharX,mainCharY,getX(),getY(),"high","positive"), getX(), getY());
               }
           }
           else {
              if(getY()>getWorld().getHeight()*3/4) {    
                   if(Math.random()*100<50)
                    getWorld().addObject(new Rock(mainCharX,mainCharY,getX(),getY(),"straight","negative"), getX(), getY());
                   else
                    getWorld().addObject(new Rock(mainCharX,mainCharY,getX(),getY(),"parabola","negative"), getX(), getY());
               }
               else {
                   getWorld().addObject(new Rock(mainCharX,mainCharY,getX(),getY(),"high","negative"), getX(), getY());
               } 
           }
       }
    } 
    
    public void setMainPos(int x , int y) {
        mainCharX = x;
        mainCharY = y;
    }
}
