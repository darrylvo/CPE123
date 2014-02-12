import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author Jessica 
 * @version (a version number or a date)
 */
public class Enemy extends GifActor
{
    private GreenfootSound sound;
    private int type;
    private int health;
    private double atkCD = 0;
    private boolean attacking = false;
    
    /**)
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World world)
    {
        setImage("enemy2.gif");
    }

    public void act() 
    {
        super.act();

        die();

        Dragon d = null;;
        AttackSword as = null;

        if(type != 0)
        {
            try
            {
                d = (Dragon) getOneObjectAtOffset(85, 0, Dragon.class);
                as  = new AttackSword("r");
            }
            catch(Exception e)
            {
            }
        }
        else
        {
            try
            {
                d = (Dragon) getOneObjectAtOffset(-85, 0, Dragon.class);
                as  = new AttackSword("l");
            }
            catch(Exception e)
            {
            }
        }

        if(d != null && atkCD == 0)
        {
            attacking = true;            
            if(type != 0)
                getWorld().addObject(as, getX() + 30, getY() - 13);
            else
                getWorld().addObject(as, getX() - 30, getY() - 13);

            as.attack();
            atkCD++;
        }
        else 
        {
            kill();
        }

        if(atkCD > 0 && atkCD < 10)
        {
            atkCD++;
        }
        else if(atkCD >= 10 && atkCD < 25)
        {
            atkCD++;
            attacking = false;
        }
        else if (atkCD >= 25)
        {
            atkCD = 0;
        }

        if(!attacking)
        {
            moveToDragon();
        }
    }    

    public Enemy(int t)
    {
        type = t;
        health = (int)(6);
        GreenfootImage img = getImage();
        img.scale(img.getWidth() + (8 * (health-1)), img.getHeight()+ (8 * (health-1)));
    }

    public void moveToDragon()
    {
        if(type == 0)
            move(-2);
        else 
            move(2);
    }

    public void die()
    {
        if(health < 1)
        {
            PrototypeWorld world = (PrototypeWorld) getWorld();
            Scoreboard scoreboard = world.getScoreboard();
            scoreboard.addScore(5);
            world.showVisual("+5",getX(),getY());
            //world.subtractMana(-10); //gives the player back 10 mana is option 1
            //super.visualPoints(5,getX(),getY());
            getWorld().addObject(new ManaDroplet(1, 10),getX(), getY()); //option 2 for giving mana to player
            getWorld().removeObject(this);
            
        }
        else if (getX() > 995)
        {
            getWorld().removeObject(this);
        }
    }

    public void loseHealth()
    {
        health--;
        //System.out.println("lost health");
        GreenfootImage img = getImage();
        img.scale(img.getWidth() - 8, img.getHeight() - 8);
    }

    public void kill()
    {
        try
        {    
            Actor dragon = getOneIntersectingObject(Dragon.class);
            if(dragon != null) 
            {
                PrototypeWorld world = (PrototypeWorld) getWorld();
                world.damage();

            }
        }
        catch(IllegalStateException isx)
        {
        }
    }

}
