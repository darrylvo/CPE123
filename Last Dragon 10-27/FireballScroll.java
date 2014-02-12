import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fireball here.
 * 
 * @Hayden 
 * @version (a version number or a date)
 */
public class FireballScroll extends Actor
{
    /**
     * Act - do whatever the fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int xDir;
    int yDir;
    //these are the x & y coordinates of the pixel that it is being fired at when it is created

    int fdbCounter = 0;
    //had to make this because greenfoot was being stubborn.
    private int distance = 0;
    public FireballScroll()
    {

    }

    public void act() 
    {   
        hitKing();
        while(fdbCounter < 3)
        {
            turnTowards(xDir, yDir);
            fdbCounter++;
        }
        move(13);
        try
        {
            if(distance > 40 || getX() < 10)
            {
                shrink();
            }
            hitEnemy1();
            hitEnemy2();
            hitBoss();
            hitThrower1();
            hitWizard();
            hitKnight();
            distance++;
            hitsGround();
            hitArrow();
        }
        catch(IllegalStateException ilstex)
        {
        }
        if(distance%5 == 0)
        {
            getImage().mirrorVertically();
        }

    }  

    /*
     * Initializes the fireball, accepts the coordinates where the mouse clicked. Is called in Dragon's
     * shootFire() method.
     */
    public FireballScroll(int x, int y)
    {
        //System.out.println("rotation: " + getRotation());
        xDir = x;
        yDir = y;
        //System.out.println("x:" + x + " " + "y:" + y);
        //System.out.println("rotation: " + getRotation());
    }

    public void hitEnemy1()
    {
        SWorld world = (SWorld) getWorld();
        Enemy1 e = (Enemy1) getOneIntersectingObject(Enemy1.class);
        if(e != null)
        {
            try
            {
                world.removeObject(this);
                e.loseHealth(1);
            }
            catch(NullPointerException npex)
            {
            }
        }
    }

    public void hitEnemy2()
    {
        SWorld world = (SWorld) getWorld();
        Enemy2 e2 = (Enemy2) getOneIntersectingObject(Enemy2.class);
        if(e2 != null)
        {
            if((getRotation() >= 0 && getRotation() <= 90) || 
            (getRotation() >= 270 && getRotation() < 360))
            {
                if(e2.getFacing() == "right")
                {
                    try
                    {
                        world.removeObject(this);
                        e2.loseHealth(1);
                    }
                    catch(NullPointerException npex)
                    {
                    }
                }
                else
                {
                    try
                    {
                        world.addObject(new FireExplosion(getRotation()), getX(), getY(), false);
                        world.removeObject(this);
                    }
                    catch(NullPointerException npex)
                    {
                    }
                }
            }
            else
            {
                if(e2.getFacing() == "left")
                {
                    try
                    {
                        world.removeObject(this);
                        e2.loseHealth(1);
                    }
                    catch(NullPointerException npex)
                    {
                    }
                }
            }
        }
    }

    public void hitThrower1()
    {
        SWorld world = (SWorld) getWorld();
        Thrower1 thr1 = (Thrower1) getOneIntersectingObject(Thrower1.class);
        if(thr1 != null)
        {
            try
            {
                world.removeObject(this);
                thr1.loseHealth(1);
            }
            catch(NullPointerException npex)
            {
            }
        }
    }

    public void hitBoss()
    {
        SWorld world = (SWorld) getWorld();
        Boss2 f = (Boss2) getOneIntersectingObject(Boss2.class);
        if(f != null)
        {
            try
            {
                world.removeObject(this);
                f.loseHealth(1);
            }
            catch(NullPointerException npex)
            {
            }
        }

    }

    public void hitWizard()
    {
        SWorld world = (SWorld) getWorld();
        if(this != null)
        {
            Wizard w = (Wizard) getOneIntersectingObject(Wizard.class);
            if(w !=null)
            {
                try
                {
                    world.removeObject(this);
                    w.loseHealth(1);
                }
                catch(NullPointerException npex)
                {
                }
            }
        }
    }
     public void hitKnight()
    {
         SWorld world = (SWorld) getWorld();
        Knight k = (Knight) getOneIntersectingObject(Knight.class);
        if(k != null)
        {
            try
            {
                world.removeObject(this);
                k.loseHealth(1);
            }
            catch(NullPointerException npex)
            {
            }
        }
    }
    public void hitKing()
    {
        SWorld world = (SWorld) getWorld();
        if(this != null)
        {
          King k = (King) getOneIntersectingObject(King.class);
          if(k!=null)
          {
              try
                {
                    world.removeObject(this);
                    k.loseHealth();
                }
                catch(NullPointerException npex)
                {
                }
              
          }
        }
        
    }
    public void hitArrow()
    {
        SWorld world = (SWorld) getWorld();
        if(this != null)
        {
            Rock w = (Rock) getOneIntersectingObject(Rock.class);
            Rock1 r1 = (Rock1) getOneIntersectingObject(Rock1.class);
            WizBolt wb = (WizBolt) getOneIntersectingObject(WizBolt.class);
            if(w !=null || r1 != null || wb !=null)
            {
                    world.removeObject(this);  
                    world.removeObject(w);
                    world.removeObject(r1);
                    world.removeObject(wb);
            }
        }

    }
    public void shrink()
    {
        GreenfootImage img = getImage();
        try
        {
            img.scale((int)(img.getWidth() * .75), (int)(img.getHeight() * .75));
        }
        catch(IllegalArgumentException ex)
        {
            try
            {
                getWorld().removeObject(this);
            }
            catch(NullPointerException npex2)
            {
            }
        }

    }
    
    public void hitsGround()
    {
        Actor g = getOneObjectAtOffset(0, 0, Ground.class);
        Actor b = getOneObjectAtOffset(0, 0, Block.class);
        Actor usg = getOneObjectAtOffset(0, 0, UnsolidGround.class);
        Actor s3p = getOneObjectAtOffset(0, 0, Stage3Platform.class);
        Actor s2p = getOneObjectAtOffset(0, 0, Stage2Platform.class);
        Actor s3g = getOneObjectAtOffset(0, 0, Stage3Ground.class);
        Actor s2g = getOneObjectAtOffset(0, 0, Stage2Ground.class);
        
        if(g != null || b !=null || usg != null || s3p != null || s2p != null ||
            s3g != null || s2g !=null)
        {
            SWorld sw = (SWorld) getWorld();
            sw.addObject(new FireExplosion(getRotation()), getX(), getY(), false);
            getWorld().removeObject(this);
        }
    }
    
}

