import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
@darryl used for enemy colission
 */
public class Fill extends Actor
{
  public Fill(int a, int b, int c)
  {
    GreenfootImage img = new GreenfootImage(a,b);
    img.setColor(java.awt.Color.black); 
  
        img.setTransparency(c); 
        img.fillRect(0, 0, a,b); 
        this.setImage(img); 
      
   }
   public void set(int x, int y)
   {
       GreenfootImage img = getImage();
       img.scale(x,y);
       setImage(img);
       
    }
  
}
