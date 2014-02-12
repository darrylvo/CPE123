import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Rock here.
 * 
 * @author Lenoy
 * @version (a version number or a date)
 */
public class Rock1 extends Actor //Look at comments for Rock. It's the same method except used for different world class.
{
    private double charX;
    private double charY;
    private double startX;
    private double startY;
    private double speedX;
    private double speedY;
    private String throwType;
    private double add;
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rock1(double x, double y, double startX, double startY,String type,String sign) {
        charX = x;
        charY = y;
        this.startX = startX;
        this.startY = startY;
        speedX = 5;
        speedY = -10*Math.abs(startX-charX)/545;
        throwType = type;
        if(sign.equals("positive")) {    
            add = 1;
            GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);
        }
        else 
            add = -1;
        if(throwType.equals("high"))
            speedY = 0;
        else if(throwType.equals("straight")) {
            if(speedX>0) 
                speedX += 5;
            else
                speedX -= 5;
        }
    }
    public void act() 
    {
        if(throwType.equals("straight"))
            straightThrow();
        else if(throwType.equals("parabola"))
            parabolicThrow();
        else {
            highThrow();
        }
        hit();
        try {
            inBounds();
        }
        catch(Exception e) {
            
        }
        
    }    
    
    public void parabolicThrow() {
        speedY+=0.2;
        setLocation(getX()+(int)(add*speedX),getY() + (int)(speedY));
    }
    
    public void straightThrow() {
        setLocation(getX()+(int)(add*speedX),getY());
    }
    
    public void highThrow() {
        speedX = add*10*Math.abs(startX-charX)/545;
        speedY+= 0.1;
        setLocation(getX()+(int)(speedX),getY() + (int)(speedY));
    }
    
    public void inBounds() {
        SWorld world = (SWorld)getWorld();
        if(getX()<1 || getX()>world.getWidth()-5) {
                world.removeObject(this);
        }
        else if(getY()>world.getHeight()-5) {
                world.removeObject(this);
        }
    }
    
    public void hit() {
        Actor dragon = getOneIntersectingObject(Stage2Dragon.class);
        if(dragon != null) {
           SWorld world = (SWorld) getWorld();
           world.damage();
           world.removeObject(this);
        }
    }
}
