import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Visual here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Visual extends Actor
{
    private String str;
    private Scoreboard scoreboard;
    public Visual(String s,Scoreboard scoreboard) {
        str = s;
        drawImg();
        this.scoreboard = scoreboard;
    }
    
    
    /**
     * Act - do whatever the Visual wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            moveDeath();
    }    
    public void drawImg() {
        GreenfootImage img = new GreenfootImage(30,25);
        img.setColor(Color.BLACK);
        img.setTransparency(255);
        img.drawString(str,5,10);
        setImage(img);
    }
    
    public void moveDeath() {
        int scoreX = (2*scoreboard.getX() + scoreboard.getWidth())/2 - getX();
        int scoreY = getY() - (scoreboard.getY() + scoreboard.getHeight());
        setLocation(getX()+scoreX/25,getY()-scoreY/25);
        if(getY()<(2*scoreboard.getY()+scoreboard.getHeight())) {
            getWorld().removeObject(this);
        }
    }
}
