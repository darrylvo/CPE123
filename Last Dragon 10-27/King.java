import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/*
 * @darryl uses my collision code and lenoys thrower stuff
 */

public class King extends Actor
{
    boolean mode=true;
    boolean left=false;
    boolean right=true;
    int s=4;
    private int health=100;
    int a;
    int throwCount=0;
    int mainCharX;
    int mainCharY;
    int scrolledX;
    int scrolledY;
    GreenfootSound sound;
    
    public King()
    {
        GreenfootImage img = new GreenfootImage("images/king.png");
        img.scale(200,270);
        setImage(img);

    }

    public void act() 
    {
        die();
        
        kill();
        
        
        if (mode == true)
        {
            mode1();

        }
        else
        {
            mode2();   

        }
        throwCount++;
        FinalBossLevel world = (FinalBossLevel) getWorld();
        Stage3Dragon dragon = world.getDragon();
        a=dragon.locationY();

    }    

    public void mode1()
    {
        setLocation(getX()+s,getY());
        /* darryl- i created this collision code to make the actors patrol an area. when they hit teh fill class object, it will
         * turn around
         */
        Actor f = getOneIntersectingObject(Fill.class);
        if (f!= null)
        {
            if(right ==true)
            {

                right=false;
                left = true;

                s=-4;
                f=null;

            }
        }
        if (f!= null)    
        {
            if(right==false)

            {                
                right=true;
                left = false;

                s=4;
            }
        }

        if (a<=270)
        {
            mode=false;

        }
    }

    public void mode2()
    {

        pickingThrow();
        if (a>270)
        {

            mode=true;

        }

    }

    public void pickingThrow() {
        if((throwCount%100)==0 ) {
            if((getX()-mainCharX)<=0) {
                sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                throwing("parabola","positive");  
            }
            else {
                sound = new GreenfootSound("sounds/Bow_Fire_Arrow-Stephan_Schutze-2133929391.mp3");
                throwing("parabola","negative");
            }
        }
    }

    public void throwing(String type, String sign) {
        SWorld s = (SWorld) getWorld(); 
        s.addObject(new WizBolt(mainCharX,mainCharY,scrolledX+getX(),scrolledY+getY(),type,sign), scrolledX + getX(),scrolledY+getY());
    }

    public void setMainPos(int x , int y, int x2, int y2) {
        mainCharX = x;
        mainCharY = y;
        scrolledX = x2;
        scrolledY = y2;
    }

    public void kill()
    {
        try
        {
            Actor dragon = getOneIntersectingObject(Stage3Dragon.class);
            if(dragon != null) {
                SWorld world = (SWorld) getWorld();
                world.damage();
            }
        }
        catch(IllegalStateException isx)
        {
        }
    }

    public void loseHealth()
    {
        health--;
        FinalBossLevel bosslevel = (FinalBossLevel) getWorld();
        bosslevel.loseHealth();
        //System.out.println("lost health");

    }

    public void die()
    {

        if(health <1)
        {
            FinalBossScene1.stopBackgroundMusic();
            SWorld world = (SWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.addScore(500);
            DeadKing dk = new DeadKing();
            Greenfoot.setWorld(dk);
        }
    }

}
