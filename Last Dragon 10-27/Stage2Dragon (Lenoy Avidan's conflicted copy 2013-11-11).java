import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2Dragon extends Actor
{
    private String moveDir = "r";
    private int count;
  
    private int jumpCooldown = 0;
    private boolean passingThroughGround = false;
    private boolean onUnsolidGround = false; 
    private boolean isJumping = false;
    private boolean isFalling = false;
    private boolean touchedUnderside = false;
    private int[] speedListRising = {30, 27, 24, 21, 18, 15, 12, 9, 6, 3, 1};
    private int[] speedListFalling = {-1, -3, -6, -9, -12, -15, -18, -21, -24, -27, -30};
    private int airCounter = 0;
    private int moveSpeed = 8;
    private int scrollingX = 0;
    private int scrollingY = 0;
    SWorld sworld = (SWorld) getWorld();
    
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        S2L1 world = (S2L1) getWorld();
        List<Object> objList = new ArrayList<Object>();
        Object obj = new Object();
        nextLevel();
        try
        {
            objList = world.getObjectsAt(mi.getX(), mi.getY(), Object.class);
            try
            {
                obj = objList.get(0);
            }
            catch(IndexOutOfBoundsException ex)
            {
                obj = null;
                //System.out.println("caught IOB ex");
            }
        }
        catch(NullPointerException ex)
        {
            objList = null;
            //System.out.println("caught NullP ex");
        }               
        if(Greenfoot.mouseClicked(obj))
        {
            shootFire();
            count = 0;
        }
        if(count>30) {
            if(moveDir.equals("r"))
            {
                setImage("2dragonright.png");
            }
            if(moveDir.equals("l"))
            {
                setImage("2dragonleft.png");
            }
        }
        count++;
        move();
   
        grounded();
        passThroughGround();
       if(Greenfoot.isKeyDown("space") && !isJumping && !isFalling && jumpCooldown == 0)
       {
           isJumping = true;
           airCounter = 0;
           onUnsolidGround = false;
       }
       if(isJumping)
       {
           jump();
       }
       else if(isFalling)
       {
           fall();
       }
       jumpCooldown++;
       if(jumpCooldown == 5)
       {
           jumpCooldown = 0;
       }
       
    }    

    public Stage2Dragon()
    {
        /*GreenfootImage img = getImage();
        img.scale((int)(img.getWidth() * .50), (int)(img.getHeight() * .50));
        setImage(img);  */
        count = 0;
    }
    
    public void passThroughGround()
    {
        if(Greenfoot.isKeyDown("s") && onUnsolidGround && !passingThroughGround && !isJumping )
        {
            airCounter = 1;
            isFalling = true;
            passingThroughGround = true;
            fall();
        }
    }
    
    public void shootFire()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        FireballScroll f = new FireballScroll(m.getX(), m.getY());
        //Fireball f = new Fireball();
        //System.out.println(m.getX() + "+" + m.getY());
        //System.out.println("X:" + m.getX() + "Y: " + m.getY());
        if((m.getX() > getX() - 29) && (m.getX() < getX() + 29))
        {
            f = null;
            //do not fire
        }
        else if(moveDir == "r") 
        {
            if(m.getX() < getX())
            {
                moveDir = "l";
                setImage("2dragonleftopen.png");
                sworld.addObject(f,scrollingX , scrollingY +5,false);
            }
            else
            {
                sworld.addObject(f, scrollingX ,scrollingY - 7,false);
                setImage("2dragonrightopen.png");
            }
        }
        else
        {
            if(m.getX() > getX())
            {
                moveDir = "r";
                setImage("2dragonrightopen.png");
                SWorld fuck = (SWorld) getWorld();
                fuck.addObject(f, scrollingX , scrollingY - 7,false);
                
            }
            else
            {
                sworld.addObject(f, scrollingX , scrollingY - 7,false);
                setImage("2dragonleftopen.png");
            }
        }
    }
    
    public void updateScrollingPos(int x, int y) {
        scrollingX = x;
        scrollingY = y;
    }
    
    public void move()
    {   
        Object obj = new Object();
        if(Greenfoot.isKeyDown("a"))
        {
          
            if(moveDir != "l")
            {
                setImage("2dragonleft.png");
                moveDir = "l";
            }
            move(-6);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            if(moveDir != "r")
            {
                setImage("2dragonright.png");
                moveDir = "r";
            }
            move(6);
        }
 
    }
    public void grounded()
    {
        Ground g = (Ground) getOneIntersectingObject(Ground.class);
        UnsolidGround ug = (UnsolidGround) getOneIntersectingObject(UnsolidGround.class);
        Block b = (Block) getOneIntersectingObject(Block.class);
        Stage2Ground s2g = (Stage2Ground) getOneIntersectingObject(Stage2Ground.class);
        if(g != null)
        {
            
            if((getY()) < g.getY())
            {
                setLocation (getX(),g.getY()-70);
                airCounter = 0;
                isFalling = false;
                g = null;
                //System.out.println("On ground");
            }
            else
            {
                airCounter = 2;
                isFalling = true;
                isJumping = false;
            }
        }
        else if(ug != null)
        {
            if(getY() < ug.getY() && !passingThroughGround && !isJumping)
            {
                setLocation(getX(), ug.getY() - 35);
                airCounter = 0;
                isFalling = false;
                isJumping = false;
                ug = null;
                onUnsolidGround = true; 
            }
            else
            {
                 passingThroughGround = false;
            }
        }
        else if(s2g !=null)
        {
             if((getY()) < s2g.getY())
            {
                
                setLocation (getX(),s2g.getY()-70);
                airCounter = 0;
                isFalling = false;
                s2g=null;
                //System.out.println("On ground");
            }
            else
            {
                airCounter = 2;
                isFalling = true;
                isJumping = false;
            }
        }
        else if(b != null)
        {
            
            if((getY()) < b.getY())
            {
                //System.out.println
                setLocation (getX(),b.getY()-70);
                airCounter = 0;
                isFalling = false;
                b=null;
                //System.out.println("On ground");
            }
            else
            {
                airCounter = 2;
                isFalling = true;
                isJumping = false;
            }
        }
        else 
        {
            if(!isJumping)
            {
                isFalling = true;
                onUnsolidGround = false; 
            }
        }
        Stage2Ground z = (Stage2Ground)getOneObjectAtOffset(getImage().getHeight()-40,0, Stage2Ground.class);
        Stage2Ground x = (Stage2Ground)getOneObjectAtOffset(-getImage().getHeight()+40,0, Stage2Ground.class);
        if ( z!=null )
        {
            System.out.println("side");
            isFalling=false;
            setLocation(getX()-8,getY());           
            
        }
        
        if (x!=null)
        {
            
            setLocation(getX()+8,getY()+speedListFalling[airCounter]);         
        }    
        
        passingThroughGround = false;
    }

    public void jump() 
    {
       if(airCounter < 11)
       {
           setLocation(getX(), getY() - speedListRising[airCounter]);
           airCounter++;
       }                  
       else
       {
           isJumping = false;
           isFalling = true;
           airCounter = 0;
       }
    }

    public void fall()
    {
        if(airCounter < 10)
        {
            setLocation(getX(), getY() - speedListFalling[airCounter]);
            airCounter++;   
        }
        else
        {
            setLocation(getX(), getY() - speedListFalling[airCounter]);
        }
    }
    
    public boolean nextLevel() {
        Portal portal = (Portal)getOneObjectAtOffset(0, 0, Portal.class);
        if (portal != null)
        {
            return true;
        }
        else {    
            return false;
        }
    }
    
}
