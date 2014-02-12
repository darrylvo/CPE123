import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Rock here.
 * 
 * @author Jessica w/ Lenoy's thrower code referenced
 * @version (a version number or a date)
 */
public class WizBolt extends GifActor
{
    private double charX;
    private double charY;
    private double startX;
    private double startY;
    private double speedX;
    private double speedY;
    private String throwType;
    private double add;
    public void addedToWorld(World world)
    {
        setImage("boltgif.gif");
    }
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WizBolt(double x, double y, double startX, double startY,String type,String sign) {
        charX = x;
        charY = y;
        this.startX = startX;
        this.startY = startY;
        speedX = 5;
        speedY = -10*Math.abs(startX-charX)/545;
        
        throwType = type;
        if(startX-charX<0) {    
            add = 1;
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
        super.act();
        if(throwType.equals("straight"))
            straightThrow();
        else if(throwType.equals("parabola"))
            parabolicThrow();
        else {
            highThrow();
        }
        hitStage2Dragon();
        hitStage3Dragon();
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
        if(getY()<1||getY()>world.getHeight()-5) {
                world.removeObject(this);
        }
    }
    
    public void hitStage2Dragon() 
    {
        Actor dragon2 = getOneIntersectingObject(Stage2Dragon.class);

        if(dragon2 != null) 
        {
           SWorld world = (SWorld) getWorld();
           world.damage();
        }
        
    }
    public void hitStage3Dragon()
    {
        Actor dragon3 = getOneIntersectingObject(Stage3Dragon.class);
        if (dragon3 != null)
        {
            SWorld world = (SWorld) getWorld();
            world.damage();
            world.removeObject(this);
        }
    }
}

