import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ManaDroplet here.
 * 
 * @Hayden 
 * Mana droplet that restores mana to the dragon when you pick it up.
 * It spins too! So juicy.
 */
public class ManaDroplet extends Actor
{
    private int c = 0;
    private int dir = 1; //controls the directiont that the droplet is floating
    private int value; //value of mana that this droplet will give the character
    private boolean collected = false;
    /**
     * Act - do whatever the ManaDroplet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!collected)
        {
            setLocation(getX(), getY() + dir);
            turnAround();
            setRotation(c * 5);
        }
        else
        {}
    }    
    public ManaDroplet(int s, int v)
    {
        GreenfootImage img = getImage();
        img.scale((int)(img.getWidth() * s),(int)(img.getHeight() * s));
        value = v;
    }
    private void turnAround()
    {
        if(c%25 == 0)
        {
            dir *= -1;
        }
        c++;
    }
    public int returnValue()
    {
        return value;
    }
    //might be the method to have the droplet fly to the dragon's mana bar to give mana when picked up.
    private void upUpnAway() 
    {
    }
}
