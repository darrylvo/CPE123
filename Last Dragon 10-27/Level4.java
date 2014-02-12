import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class Level4 extends PrototypeWorld
{
    private GreenfootSound sound;
    public Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    
    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
        prepare();
    }
    

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground(500);
        addObject(ground, 507, 265);
        Ground ground2 = new Ground(1000);
        addObject(ground2, 511, 343);
        ground2.setLocation(513, 357);
        ground.setLocation(509, 285);
        ground.setLocation(505, 279);
        ground2.setLocation(501, 353);
        ground2.setLocation(501, 369);
        ground.setLocation(507, 291);
        ground.setLocation(507, 287);
        dragon = new Dragon();
        addObject(dragon, 50, 68);
        portal = new Portal(200);
        addObject(portal, 928, 207);
        ground.setLocation(755, 287);
        ground2.setLocation(255, 355);
        ground2.setLocation(509, 323);
        ground.setLocation(245, 151);
        ground2.setLocation(499, 335);
        dragon.setLocation(54, 86);
        
        manabar = getManaBar();
        addObject(manabar, 90, 75);
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75);
    }


    public void act()
    {
        super.act();
        boolean win = false;
        if(Math.random() * 1000 < 20)
        {
            if((int)(Math.random()*2) == 0)
            {
                Enemy e = new Enemy(1);
                addObject(e, 30, 250);
            }

        }
        try {
            win = dragon.nextLevel();
        }
        catch(Exception e) {

        } 
        if(win && Greenfoot.isKeyDown("w"))
        {
            Timer timer = getTimer();
            timer.all();

            
            Level5 level5 = new Level5();
            Greenfoot.setWorld(level5);
        }        
    }

    
}
