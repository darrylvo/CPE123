import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends PrototypeWorld
{
    private GreenfootSound sound;
    public Dragon dragon;
    public ManaBar manabar;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
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
        Ground ground = new Ground(490);
        addObject(ground, 600, 202);
        ground.setLocation(244, 247);
        Trap trap = new Trap();
        addObject(trap, 267, 159);
        trap.setLocation(266, 169);
        dragon = new Dragon();
        addObject(dragon, 69, 171);
        Ground ground2 = new Ground(200);
        addObject(ground2, 629, 312);
        ground2.setLocation(641, 306);
        removeObject(ground2);
        Ground ground3 = new Ground(300);
        addObject(ground3, 597, 311);
        ground3.setLocation(639, 244);
        ground3.setLocation(639, 298);
        Ground ground4 = new Ground(300);
        addObject(ground4, 687, 206);
        ground4.setLocation(935, 231);
        Portal portal = new Portal(200);
        addObject(portal, 907, 128);
        Trap trap2 = new Trap();
        addObject(trap2, 579, 206);
        Trap trap3 = new Trap();
        addObject(trap3, 726, 199);
        trap2.setLocation(562, 222);
        trap3.setLocation(694, 218);
        trap2.setLocation(564, 218);
        
        manabar = getManaBar();
        addObject(manabar, 90, 75);
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75);
    }


    public void act()    
    {
        boolean win = false;
        super.act();
        try {
            win = dragon.nextLevel();
        }
        catch(Exception e) {
            
        }
        
        if(win && Greenfoot.isKeyDown("w")) 
        {
            //System.out.println("winner");
            Timer timer = getTimer();
            timer.all();
             
            Level4 level4 = new Level4();
            Greenfoot.setWorld(level4);
            
        }
    }

    
}
