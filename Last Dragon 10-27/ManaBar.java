import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ManaBar here.
 * 
 * @Erin made this based off generic bar. Hayden had to implement it and fix the bugs as well.
 * @version (a version number or a date)
 */
public class ManaBar extends GenericBar
{
    //erin greenlee!!!
    /**
     * Act - do whatever the ManaBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }   
    public ManaBar(int fullHealth, int currentHealth)
    {
        super(140, 24, fullHealth, currentHealth, new Color (50, 50, 255));
        setSpeed(5);
    }
    public void updateColor()
    {
        //
    }
    public void setMana(int mana)
    {
        super.setBar(mana);
    }
}
