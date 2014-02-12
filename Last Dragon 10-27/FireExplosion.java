import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireExplosion here.
 * 
 * @Hayden
 * Didn't feel like animating the fireballs and just made it so when fireballs are blocked
 * or hit ground, they create this object to make it look like its exploding.
 */
public class FireExplosion extends Actor
{
    /**
     * Act - do whatever the FireExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;
    public void act() 
    {
        if(counter == 5)
        {
            getWorld().removeObject(this);
        }
        counter++;
    }    
    public FireExplosion(int r)
    {
        setImage("fireballexplode.png");
        setRotation(r);
    }
}
