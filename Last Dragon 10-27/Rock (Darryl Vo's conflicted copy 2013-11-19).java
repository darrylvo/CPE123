import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
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
    public Rock(double x, double y, double startX, double startY,String type,String sign) {
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
            //img.mirrororHorizontally();
            setImage(img);
        }
        else {
            add = -1;
        }
        if(throwType.equals("high"))
            speedY = 0;
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
        inBounds();
        
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
        PrototypeWorld world = (PrototypeWorld)getWorld();
        if(getX()<1 || getX()>world.getWidth()-5) {
            world.removeObject(this);
        }
        else if(getY()<1 || getY()>world.getHeight()-5) {
            world.removeObject(this);
        }
    }
    
    public void hit() {
        Actor dragon = getOneIntersectingObject(Dragon.class);
        if(dragon != null) {
           PrototypeWorld world = (PrototypeWorld) getWorld();
           world.damage();
        }
    }
    
}
