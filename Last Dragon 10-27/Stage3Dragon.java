import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Dragon here.
 * 
 * @author Jessica w/ Hayden's reference to first dragon code. 
 * @version (a version number or a date)
 */
public class Stage3Dragon extends GifActor
{
    private GreenfootSound sound;
    private String moveDir = "r";
    private boolean movingLeft = false; 
    private boolean movingRight = false;

    private int count;
    private int breathingCounter = 0;
    private int breathEndingCounter = 0;
    private int breathingCooldown = 0;
    private boolean fireBreathing = false;

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
    /**)
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World world)
    {
        setImage("Stage3Dragonright.gif");
    }
    public void act() 
    {
        super.act();

        MouseInfo mi = Greenfoot.getMouseInfo();
        SWorld world = (SWorld) getWorld();
        ManaBar mb = world.getManaBar();
        List<Object> objList = new ArrayList<Object>();
        Object obj = new Object();
        nextLevel();
        move();
        dieAnimate();
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
            shootFire();
            world.subtractMana(10);
            count = 0;
        }
        if(count>30 && !fireBreathing) 
        {
            if(moveDir.equals("r"))
            {
                //setImage("Stage3Dragonright.gif");
            }
            if(moveDir.equals("l"))
            {
               //setImage("Stage3Dragonleft.gif");
            }
        }
        if(Greenfoot.isKeyDown("shift") && breathingCooldown == 0 && mb.getOldHealth() > 20)
        {
            if(breathEndingCounter == 0)
            {
                fireBreathing = true;
                breathingCounter++;
                breathFire();
            }
        }
        else if(breathingCooldown > 0)
        {
            if(breathingCooldown > 10)
            {
                breathingCooldown = 0;
            }
            else
            {
                breathingCooldown++;
            }
        }
        else
        {
            if(breathEndingCounter > 0)
            {
                if(breathEndingCounter > 10)
                {
                    breathEndingCounter = 0;
                    breathingCooldown++;
                }
                else
                {
                    breathEndingCounter++;
                    breathFire();
                }
            }
            else if(fireBreathing == true)
            {
                if(breathingCounter < 20)
                {
                    breathingCounter++;
                    breathFire();
                    
                }
                else
                {
                    breathingCounter = 0;
                    fireBreathing = false;
                    breathEndingCounter++;
                }
            }
        }

        count++;

        grounded();
        passThroughGround();
        if(Greenfoot.isKeyDown("space") && !isJumping && !isFalling && jumpCooldown == 0)
        {
            sound = new GreenfootSound("sounds/Woosh-Mark_DiAngelo-4778593.mp3");
           sound.play();
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
        fallDeath();

    }   

    public Stage3Dragon()
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
            if(m.getX() < getX() && !movingRight)
            {
                moveDir = "l";
                sound = new GreenfootSound("sounds/Depth Charge Shorter-SoundBible.com-1978501900.mp3");
                            sound.play();
                setImage("s3openleft.png");
                SWorld sWorld = (SWorld) getWorld();
                sWorld.addObject(f,getX()-39 , getY() -15,false);
                //System.out.println("clicked left of it");
            }
            else if(m.getX() > getX())
            {
                SWorld sWorld = (SWorld) getWorld();
                sWorld.addObject(f, getX()+43 ,getY() - 15,false);
                sound = new GreenfootSound("sounds/Depth Charge Shorter-SoundBible.com-1978501900.mp3");
                            sound.play();
                setImage("s3openright.png");
            }
        }
        else
        {
            if(m.getX() > getX() && !movingLeft)
            {
                moveDir = "r";
                setImage("s3openright.png");
                sound = new GreenfootSound("sounds/Depth Charge Shorter-SoundBible.com-1978501900.mp3");
                            sound.play();
                SWorld sWorld = (SWorld) getWorld();
                sWorld.addObject(f, getX()+43 , getY() - 15,false);

            }
            else if(m.getX() < getX())
            {
                SWorld sWorld = (SWorld) getWorld();
                sound = new GreenfootSound("sounds/Depth Charge Shorter-SoundBible.com-1978501900.mp3");
                            sound.play();
                sWorld.addObject(f, getX()-39, getY() - 15,false);
                setImage("s3openleft.png");
            }
        }
    }

    public void breathFire()
    {
        FireBreath fb;
        SWorld world = (SWorld) getWorld();
        int bc; 
        if(breathEndingCounter > 0)
        {
            fb = new FireBreath(10 - breathEndingCounter);
            bc = 10 - breathEndingCounter;
        }
        else if(breathingCounter < 10)
        {
            fb = new FireBreath(breathingCounter);
            bc = breathingCounter;
        }
        else
        {
            fb = new FireBreath(10);
            bc = 10;
        }

        if(moveDir == "r")
        {
            world.addObject(fb, getX() + 58 + (bc * 2), getY() - 9 + (bc * 3), false);
            sound = new GreenfootSound("sounds/Depth Charge Shorter-SoundBible.com-1978501900.mp3");
                        sound.play();
            setImage("s3openright.png");
        }
        else
        {
            fb.flip();
            world.addObject(fb, getX() - (54 + (bc * 2)), getY() - 9 + (bc * 3), false);
            sound = new GreenfootSound("sounds/Depth Charge Shorter-SoundBible.com-1978501900.mp3");
            sound.play();
            setImage("s3openleft.png");
        }
        
        world.subtractMana(1);
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
                setImage("stage3dragonleft.gif");
                moveDir = "l";
            }
            move(-6);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            movingLeft = false;
            movingRight = true;
            if(moveDir != "r")
            {
                setImage("stage3dragonright.gif");
                moveDir = "r";
            }
            move(6);
        }
        else 
        {
            movingLeft = false;
            movingRight = false;
        }

    }

    public void grounded()
    {
        Ground g = (Ground) getOneIntersectingObject(Ground.class);
        UnsolidGround ug = (UnsolidGround) getOneIntersectingObject(UnsolidGround.class);
        Block b = (Block) getOneIntersectingObject(Block.class);
        Stage2Ground s2g = (Stage2Ground) getOneIntersectingObject(Stage2Ground.class);
        Stage2Platform s2p = (Stage2Platform) getOneIntersectingObject(Stage2Platform.class);
        Stage3Ground s3g = (Stage3Ground) getOneIntersectingObject(Stage3Ground.class);
        Stage3Platform s3p = (Stage3Platform) getOneIntersectingObject(Stage3Platform.class);
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
        else if(s2p != null)
        {

            if((getY()) < s2p.getY())
            {
                setLocation (getX(),s2p.getY()-90);
                airCounter = 0;
                isFalling = false;
                s2p = null;
                //System.out.println("On ground");
            }
            else
            {
                airCounter = 2;
                isFalling = true;
                isJumping = false;
            }
        }
         else if(s3p != null)
        {
            if(getY() < s3p.getY() && !passingThroughGround && !isJumping)
            {
                setLocation(getX(), s3p.getY() - 130);
                airCounter = 0;
                isFalling = false;
                isJumping = false;
                s3p = null;
                onUnsolidGround = true; 
            }
            else
            {
                passingThroughGround = false;
            
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

                setLocation (getX(),s2g.getY()-100);
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
         else if(s3g !=null)
        {
            if((getY()) < s3g.getY())
            {

                setLocation (getX(),s3g.getY()-130);
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
        Stage3Ground z = (Stage3Ground)getOneObjectAtOffset(getImage().getHeight()-40,0, Stage3Ground.class);
        Stage3Ground x = (Stage3Ground)getOneObjectAtOffset(-getImage().getHeight()+40,0, Stage3Ground.class);
        if ( z!=null )
        {
            //System.out.println("side");
            isFalling=false;
            setLocation(getX()-8,getY());           

        }

        if (x!=null)
        {

            setLocation(getX()+8,getY()+speedListFalling[airCounter]);         
        }    
        Stage3Platform o = (Stage3Platform)getOneObjectAtOffset(getImage().getHeight()-40,0, Stage3Platform.class);
        Stage3Platform p = (Stage3Platform)getOneObjectAtOffset(-getImage().getHeight()+40,0, Stage3Platform.class);
        if ( o!=null )
        {
            //System.out.println("side");
            isFalling=false;
            setLocation(getX()-8,getY());           

        }

        if (p!=null)
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
    
    public void fallDeath()
    {
        SWorld world = (SWorld) getWorld();
        if(getY() >= world.getHeight() -10)
        {
            sound = new GreenfootSound("sounds/Monster Growl-SoundBible.com-344645592.mp3");
            sound.play();
            world.kill();
        }
    }
    public void dieAnimate()
    {
        
    }
    public int locationX()
    {
        return getX();
        
    }
    public int locationY()
    {
        return getY();
    }
}
