import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossLevel extends SWorld
{

    Stage2Dragon dragon = new Stage2Dragon();
    Boss2 boss2 = new Boss2();
    public ManaBar manabar;
    HealthBar bar;
    public BossLevel()
    {    

        super(1000, 400, 1, 1000);removeObject(heart4);
        
        addMainActor(dragon, 100, 200, 50, 300);
        GreenfootImage bg = new GreenfootImage("scrollingbg.png");
        setScrollingBackground(bg);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Stage2Ground stage2ground = new Stage2Ground(1000);
        addObject(stage2ground, 505, 364);

        manabar = getManaBar();
        addObject(manabar, 90, 75, false);

        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75,false);

        addObject(boss2, 877, 279);
        boss2.setLocation(878, 238);
        boss2.setLocation(865, 226);

        //adds health bar for boss
        bar = new HealthBar(625, 625);
        addObject(bar, getWidth()/2, 370);
        UnsolidGround unsolidground2 = new UnsolidGround(200);
        addObject(unsolidground2, 508, 179);
        unsolidground2.setLocation(538, 157);

    }


    public void act()
    {
        super.act();
        try {
            
            boss2.setMainPos(dragon.getX(),dragon.getY());
            
        }
        catch(Exception e) {
            
        }
        
       
    }
    public void loseHealth()
    {
        bar.add(-25);
    }
}
