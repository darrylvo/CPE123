import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
;/**
 * Write a description of class HealthBar here.
 * 
 * @Erin made this based off of the generic bar. Hayden had to help implement this code in all of the worlds and help her with bugs.
 * @version (a version number or a date)
 */
public class HealthBar extends GenericBar
{
    //erin greenlee !!!!!
    public void act() 
    {
        super.act();
        //updateBar();
        updateColor();
    }    
    public HealthBar(int fullHealth, int currentHealth)
    {
        super(500, 25, fullHealth, currentHealth, new Color(153, 255, 102));
        setSpeed(5);
        
    }
        public HealthBar(int fullHealth)
    {
        this(fullHealth, fullHealth);
    }
    public void updateColor()
    {
        if (getOldHealth() <= getFullHealth()/4)
        { 
            setColor(Color.red);
        }
        else if (getOldHealth() < getFullHealth()/2)
        {
            setColor(Color.yellow);
        }
        else
        {
            setColor(new Color(153, 255, 102));
        }
    }
    
   /* public void updateBar()
    {
        super.updateBar();
        label = new GreenfootImage("Health", 20, Color.black, null);
        GreenfootImage image = new GreenfootImage(getImage());
        image.drawImage(label, 50, 8);
    }*/
}
