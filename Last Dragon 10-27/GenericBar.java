import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class GenericBar here.
 * 
 * @author (erin, based off of zamoht's health bars) 
 * @version (a version number or a date)
 */
public class GenericBar extends Actor
{
    private GreenfootImage bar;
    GreenfootImage label;
    private GreenfootImage fullBar;
    private int fullHealth;
    private int edge;
    private int barWidth;
    private int barHeight;
    private int currentHealth;
    private int newHealth;
    private int oldHealth;
    private int changingHealth;
    private Color color;
    private double speed;
    String objectString;
    public GenericBar(int width, int height, int fullHealth, int currentHealth, Color color)
    //this way you can make as many bars as you want!
    {
        // makes a rounded rectangle shape as a base (generically, you can specify once you add it to the world)
        edge = getEdge(width, height);
        bar = new GreenfootImage(width, height);
        bar.setColor(new Color(201, 201, 201));
        bar.fillOval(0, 0, edge, height);
        bar.fillRect(edge/2, 1, width-edge, height);
        bar.fillOval(width-edge, 0, edge, height);
        barWidth = width;
        barHeight = height;
        //objectString = string;
        
        //
        fullBar = new GreenfootImage(width, height);
        setColor(color, edge, false);
        
        this.fullHealth = fullHealth;
        this.oldHealth = currentHealth;
        newHealth = oldHealth;
        speed = 5;
        updateBar();
    }
    public void act() 
    {
        //making sure the health updates each time it gets hit
        if (newHealth > oldHealth)
        {
            //make it go to the newHealth smoothly, doubles used to make it look like it's sliding
            oldHealth+=speed*((double)fullHealth/1000.0);
            if (newHealth < oldHealth)
            {
                newHealth = oldHealth;
            }
        }
        else if (newHealth < oldHealth)
        {
            //make it go to the newHealth etc etc
            oldHealth-=speed*((double)fullHealth/1000.0);
            if (newHealth > oldHealth)
            {
                newHealth = oldHealth;
            }
        }
        // making it a smooth changing son of a gun
        if (oldHealth != changingHealth)
        {
            updateBar();
        }
        
    }
    private int getEdge(int width, int height)
    {
        //just finding the width and height of the specific bar
        int edge;
        edge = height;
        return edge;
    }
    public void updateBar()
    {
        //updates the color, duh. used for the health green yellow red mostly
        updateColor();
        
        //tricky part. basically making it slide up and down depending on health
        GreenfootImage image = new GreenfootImage(bar);
        double ratio = (double)oldHealth/(double)fullHealth;
        int width = (int)Math.round(ratio*bar.getWidth());
        if (width > 0)
        {
            GreenfootImage part = new GreenfootImage(width, bar.getHeight());
            part.drawImage(fullBar, 0, 0);
            image.drawImage(part, 0, 0);
        }
        
        setImage(image);
        //label = new GreenfootImage(objectString, 20, Color.black, null);
        //image.drawImage(label, barWidth/2, barHeight/2);
    }
    public void setColor(Color color)
    {
        setColor(color, true);
    }
    private void setColor(Color color, int edge, boolean update)
    {
        if (fullBar == null || color.equals(this.color))
        {
            return;
        }
        this.color = color;
        int width = fullBar.getWidth();
        int height = fullBar.getHeight();
        fullBar.clear();
        fullBar.setColor(color);
        fullBar.fillOval(0, 0, edge, height);
        fullBar.fillRect(edge/2, 1, width-edge, height);
        fullBar.fillOval(width-edge, 0, edge, height);
        if (update)updateBar();
    }
    public void setColor(Color color, boolean update)
    {
        int width;
        int height;
        if (fullBar != null)
        {
            width = fullBar.getWidth();
            height = fullBar.getHeight();
        }
        else
        {
            return;
        }
        setColor(color, getEdge(width, height), update);
    }
    private void updateColor()
    {
        //wut
    }
    public void add(double change)
    {
        newHealth += change;
        if (newHealth > fullHealth) newHealth = fullHealth;
        if (newHealth < 0) newHealth = 0;
        updateBar();
    }
    public void setBar(int value)
    {
        newHealth = value;
        if(newHealth > fullHealth)
        {
            newHealth = fullHealth;
        }
        else if( newHealth < 0)
        {
            newHealth = 0;
        }
        updateBar();
    }
    
    //setting the different parameters
    public void setFullHealth(int fullHealth)
    {
        this.fullHealth = fullHealth;
    }
    public void setOldHealth(int oldHealth)
    {
        this.oldHealth = oldHealth;
        updateBar();
    }
    public void setNewHealth(int newHealth)
    {
        this.newHealth = newHealth;
    }
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
    
    //returning values
    public int getFullHealth()
    {
        return fullHealth;
    }
    public int getOldHealth()
    {
        return oldHealth;
    }
}