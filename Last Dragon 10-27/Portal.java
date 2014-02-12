import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Portal(int t)
    {
        GreenfootImage image = getImage();
        image.scale(150, 200);
        setImage(image);
    }
    public void act() 
    
    {
        animate();
    }   
    
   public void animate()
   {
       //Jessica did this
       Actor Dragon = getOneIntersectingObject(Dragon.class);
      if (Dragon!= null)
      {
          GreenfootImage image = getImage();
          setImage("portalopen.png");
          
        }
       Actor Stage2Dragon = getOneIntersectingObject(Stage2Dragon.class);
       if (Stage2Dragon!=null)
       {
           GreenfootImage image = getImage();
           setImage("portalopen.png");
           
        }
      Actor Stage3Dragon = getOneIntersectingObject(Stage3Dragon.class);
       if (Stage3Dragon!=null)
       {
           GreenfootImage image = getImage();
           setImage("portalopen.png");
           
        }
        //Done by Jessica
    
    }
    
    
}
