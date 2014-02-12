import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    private int x, y;
    public Heart()
    {
      GreenfootImage img = getImage();
      x = 25;
      y = 25;
      img.scale(x,y);
      setImage(img);
      
    }
    public void act() 
    {
        // Add your action code here.
    }    
    public void shrink()
    { 
      GreenfootImage img = getImage();
      x--;
      y--;
      if(x <= 0 || y <= 0)
        getWorld().removeObject(this);
      else
      {
          img.scale(x,y);
          setImage(img);
      }
    }
}
