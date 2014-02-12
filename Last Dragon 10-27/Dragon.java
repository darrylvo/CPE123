import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Dragon here.
 * 
 * @Hayden
 * Modified this code many times and had to use the code for the later stages of the dragon as well.
 */
public class Dragon extends GifActor
{
    private GreenfootSound sound;
    private String moveDir = "r";
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean shootingFire = false;
    private boolean changingImage = false;
    
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
    
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World world)
    {
        setImage("stage1dragonrightgif.gif");
    }
    public void act() 
    {
        super.act();
        MouseInfo mi = Greenfoot.getMouseInfo();
        PrototypeWorld world = (PrototypeWorld) getWorld();
        ManaBar mb = world.getManaBar();
        List<Object> objList = new ArrayList<Object>();
        Object obj = new Object();
        nextLevel();
        move();
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
        if(Greenfoot.mouseClicked(obj) && mb.getOldHealth() > 10)
        {
            pause();
            shootFire();
            shootingFire = true;
            world.subtractMana(10);
            count = 1;
        }
        if(count > 0 && count <= 4)
        {
            count++;
        }
        else if(count > 4) 
        {
            shootingFire = false;
            changingImage = true;

            count = 0;           
        }
        if(!shootingFire && changingImage)
        {
             if(moveDir == "r")
            {  
                setImage("stage1dragonrightgif.gif");
            }
            else
            {
                setImage("stage1dragonleftgif.gif");
            }
            changingImage = false;
        }
       
        
   
        grounded();
        passThroughGround();
       if(Greenfoot.isKeyDown("space") && !isJumping && !isFalling && jumpCooldown == 0)
       {
           sound = new GreenfootSound("sounds/Woosh-Mark_DiAngelo-4778593.mp3");
           sound.play();
           isJumping = true;
           airCounter = 0;
           onUnsolidGround = false;
           jumpCooldown++;
       }
       else if(isJumping)
       {
           jump();
           if(jumpCooldown > 0)
           {
               jumpCooldown++;
           }
       }
       else if(isFalling)
       {
           fall();
       }
       
       if(jumpCooldown == 6)
       {
           jumpCooldown = 0;
       }
       getMana();
    }    

    public Dragon()
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
        /* hayden made this code to shoot the fireball where the mouse is
         * 
         */
        MouseInfo m = Greenfoot.getMouseInfo();
        Fireball f = new Fireball(m.getX(), m.getY());
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
            if(m.getX() < getX() && !movingRight)
            {
                moveDir = "l";
                sound = new GreenfootSound("sounds/Roundhouse Kick-SoundBible.com-1663225804.mp3");
                sound.play();
                setImage("open mouth left.png");
                getWorld().addObject(f, getX() - 10, getY() +5);
            }
            else if(m.getX() > getX())
            {
                moveDir = "r";
                getWorld().addObject(f, getX() + 29, getY() - 7);
                setImage("open mouth right.png");
                 sound = new GreenfootSound("sounds/Roundhouse Kick-SoundBible.com-1663225804.mp3");
                sound.play();
            }
        }
        else
        {
            if(m.getX() > getX() && !movingLeft)
            {
                moveDir = "r";
                setImage("open mouth right.png");
                 sound = new GreenfootSound("sounds/Roundhouse Kick-SoundBible.com-1663225804.mp3");
                sound.play();
                getWorld().addObject(f, getX() + 29, getY() - 7);
            }
            else if(m.getX() < getX())
            {
                getWorld().addObject(f, getX() - 29, getY() - 7);
                setImage("open mouth left.png");
                 sound = new GreenfootSound("sounds/Roundhouse Kick-SoundBible.com-1663225804.mp3");
                sound.play();
            }
        }
    }
    
    public void move()
    {   
        Object obj = new Object();
        if(Greenfoot.isKeyDown("a"))
        {
            movingLeft = true;
            movingRight = false;
            if(moveDir != "l")
            {
                moveDir = "l";
                changingImage = true;
            }
        
            move(-4);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            movingRight = true;
            movingLeft = false;
            if(moveDir != "r")
            {
                moveDir = "r";
                changingImage = true;
            }
            
            move(4);
        }
        else
        {
            movingLeft = false;
            movingRight = false;
        }
 
    }
    public void grounded()
    {
        /* hayden made top and bottom collision code. darryl made side collision code
         * 
         */
        Ground g = (Ground) getOneIntersectingObject(Ground.class);
        UnsolidGround ug = (UnsolidGround) getOneIntersectingObject(UnsolidGround.class);
        Block b = (Block) getOneIntersectingObject(Block.class);
        Stage2Ground s2g = (Stage2Ground) getOneIntersectingObject(Stage2Ground.class);
        if(g != null)
        {
            
            if((getY()) < g.getY())
            {
                setLocation (getX(),g.getY()-70);
                if(isFalling)
                {
                    airCounter = 0;
                    isFalling = false;
                    jumpCooldown = 0;
                }
                g = null;
                //System.out.println("On ground");
            }
            else
            {
                airCounter = 2;
                jumpCooldown = 0;
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
        Ground z = (Ground)getOneObjectAtOffset(getImage().getHeight()-40,0, Ground.class);
        Ground x = (Ground)getOneObjectAtOffset(-getImage().getHeight()+40,0, Ground.class);
        if ( z!=null )
        {
            //System.out.println("side");
            isFalling=false;
            
            setLocation(getX()-6,getY());           
            
        }
        
        if (x!=null)
        {
            
            setLocation(getX()+6,getY()+speedListFalling[airCounter]);         
        }    
        
        passingThroughGround = false;
    }

    public void jump() 
    {
       if(airCounter < 11)
       {
           // sound = new GreenfootSound("sounds/Woosh-Mark_DiAngelo-4778593.mp3");
              // sound.play();   
           setLocation(getX(), getY() - speedListRising[airCounter]);
           airCounter++;
       }                  
       else
       {
           sound.stop();
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
    
    public boolean nextLevel()
    {
        Portal portal = (Portal)getOneObjectAtOffset(0, 0, Portal.class);
        if (portal != null)
        {
            return true;
        }
        else {    
            return false;
        }
    }
    
    public void getMana()
    {
        PrototypeWorld world = (PrototypeWorld) getWorld();
        ManaDroplet md = (ManaDroplet) getOneIntersectingObject(ManaDroplet.class);
        if(md != null)
        {
            sound = new GreenfootSound("sounds/shooting_star-Mike_Koenig-1132888100.mp3");
            sound.play();
            world.subtractMana(-1 * md.returnValue());
            world.removeObject(md);
        }
    }
    
}
