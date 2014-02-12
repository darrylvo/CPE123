import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Rock here.
 * 
 * @author Lenoy 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    private double charX;  //dragon's position
    private double charY;  //dragon's position
    private double startX; //thrower's position, where rock starts
    private double startY; //thrower's position, where rock starts
    private double speedX; //speed of rock 
    private double speedY;  //speed of rock
    private String throwType; //type of throwing motion, can be straight, parabolic, half parabola
    private double add; //direction of rock, negative if going left and positive if going right
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
        speedY = -10*Math.abs(startX-charX)/545; //formula for determining starting speed in y direction
        throwType = type;
        if(sign.equals("positive")) {    //to tell if dragon is to right or left of enemy 
            add = 1; //set direction to positive
            GreenfootImage img = getImage();
            img.mirrorHorizontally();   //flip image so it's facing right as it is moving right
            setImage(img);
        }
        else {
            add = -1; //set direction to negative
        }
        if(throwType.equals("high")) //if throwType is set to half parabola throw
            speedY = 0;
    }
    public void act() 
    {    
        if(throwType.equals("straight")) //if throwType is set to straight throw
            straightThrow();
        else if(throwType.equals("parabola")) //if throwType is set to parabola throw
            parabolicThrow();
        else {
            highThrow();
        }
        hit();
        
        try
        {
            inBounds();
        }
        catch(IllegalStateException ils)
        {
        }
        
    }    
    
    public void parabolicThrow() {
        speedY+=0.2; //add 0.2 to speed so gradually gets slower then faster
        setLocation(getX()+(int)(add*speedX),getY() + (int)(speedY)); 
    }
    
    public void straightThrow() {
        setLocation(getX()+(int)(add*speedX),getY());
    }
    
    public void highThrow() {
        speedX = add*10*Math.abs(startX-charX)/545; //formula for speed in x direction
        speedY+= 0.1;
        setLocation(getX()+(int)(speedX),getY() + (int)(speedY));
    }
    
    public void inBounds() { //checks to make sure rock is in world, else it removes it from world
        PrototypeWorld world = (PrototypeWorld)getWorld();
        if(getX()<1 || getX()>world.getWidth()-5) {
            world.removeObject(this);
        }
        else if(getY()<1 || getY()>world.getHeight()-5) {
            world.removeObject(this);
        }
    }
    
    public void hit() { //checks to see if hits dragon, if it does it calls the damage method from PrototypeWorld
        Actor dragon = getOneIntersectingObject(Dragon.class);
        if(dragon != null) {
           PrototypeWorld world = (PrototypeWorld) getWorld();
           world.damage();
           world.removeObject(this);
        }
    }
    
}
