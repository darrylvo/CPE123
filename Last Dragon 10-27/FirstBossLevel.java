import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FirstBossLevel here.
 * 
 * @author (Jessica) 
 * @version (a version number or a date)
 */
public class FirstBossLevel extends PrototypeWorld
{
    HealthBar healthbar;
    Boss1HealthOverlay healthbaroverlay;
    public ManaBar manabar;
    /**
     * Constructor for objects of class FirstBossLevel.
     * 
     */
    public FirstBossLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground(1000);
        addObject(ground, 493, 343);
        ground.setLocation(499, 363);
        Dragon dragon = new Dragon();
        addObject(dragon, 74, 289);

        Boss boss = new Boss(1);
        addObject(boss, 852, 283);

        healthbar = new HealthBar(625, 625);
        addObject(healthbar, getWidth()/2, 369);
        UnsolidGround unsolidground = new UnsolidGround(200);
        addObject(unsolidground, 501, 193);
        unsolidground.setLocation(525, 194);
        
        healthbaroverlay = new Boss1HealthOverlay();
        addObject(healthbaroverlay, getWidth()/2, 372);
        
        manabar = getManaBar();
        addObject(manabar, 90, 75);
        
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75);
    }
    public void act()
    {
        super.act();
        
    }
    public void loseHealth()
    {
        healthbar.add(-25);
    }
}
