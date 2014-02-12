import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthPowerup here.
 * 
 * @darryl used for health pickup
 * @version (a version number or a date)
 */
public class HealthPowerup extends Actor
{
    public HealthPowerup()
    {
        GreenfootImage img = getImage();
      img.scale(25,25);
      setImage(img);
      
        
    }
    public void act() 
    {
      Actor a = getOneIntersectingObject(Stage2Dragon.class);
      if (a!= null)
      {
       
          SWorld sworld = (SWorld)getWorld();
        sworld.addHearts();
        sworld.removeObject(this);
          
       }
    }    
}
