import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5 extends PrototypeWorld
{
    private GreenfootSound sound;
    public Dragon dragon;
    public Portal portal;
    public Thrower thrower;
    public ManaBar manabar;
    /**
     * Constructor for objects of class Level5.
     * 
     */
    public Level5()
    {    
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
       

        Ground ground = new Ground(getWidth());
        addObject(ground, 501, 356);

        dragon = new Dragon();
        addObject(dragon, 61, 284);

        portal = new Portal(200);
        addObject(portal, 918, 100);

        Trap trap2 = new Trap();
        addObject(trap2,750,160);

        Block platform = new Block();
        addObject(platform,750,225);

        Block platform2 = new Block();
        addObject(platform2,150,125);

        thrower = new Thrower();
        addObject(thrower,platform2.getImage().getWidth()+80,platform2.getImage().getHeight()-10);

        manabar = getManaBar();
        addObject(manabar, 90, 75);
        
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75);
        
        prepare();
    }

    public void act() 
    {
        super.act();
        boolean win = false;
        try {
            thrower.setMainPos(dragon.getX(),dragon.getY());
            win = dragon.nextLevel();
        }
        catch(Exception e) {

        }

        if(win && Greenfoot.isKeyDown("w")) {
        
            Level1.stopBackgroundMusic();

            BossScene1 boss = new BossScene1();
            Greenfoot.setWorld(boss);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Block block = new Block();
        addObject(block, 916, 162);
    }
}
