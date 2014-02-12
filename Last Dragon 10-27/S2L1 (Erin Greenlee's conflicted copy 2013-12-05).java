import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S2L1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S2L1 extends SWorld
{
    private Stage2Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    private Thrower1 thrower1;
    private Thrower1 thrower12;
    private Thrower1 thrower13;
    private Thrower1 thrower14;
    /**
     * Constructor for objects of class S2L1.
     * 
     */
    public S2L1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(4000, 400, 1, 4000,400); 
        dragon = new Stage2Dragon();    
        thrower1 = new Thrower1(2);
        thrower12 = new Thrower1(2);
        thrower13 = new Thrower1(2);
        thrower14 = new Thrower1(2);
        addMainActor(dragon, 100, 168, 50, 300);
        GreenfootImage bg = new GreenfootImage("plainsbg.png");
        setScrollingBackground(bg);
        d();
        prepare();  
        Death death = new Death();
            death.setStage(2);
            
    }
    public void act() {
        super.act();
        boolean win = false;
        try {
            thrower1.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
            win = dragon.nextLevel();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try {
            thrower12.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
            win = dragon.nextLevel();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try {
            thrower13.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
            win = dragon.nextLevel();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try {
            thrower14.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
            win = dragon.nextLevel();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        if(win && Greenfoot.isKeyDown("w"))
         {         
            
            
             S2L2 l2 = new S2L2();
            Greenfoot.setWorld(l2);
         } 
    }
  
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {

        Stage2Ground stage2ground = new Stage2Ground(800);
        addObject(stage2ground, 557, 330);       
        stage2ground.setLocation(400, 268);

        manabar = getManaBar();
        addObject(manabar, 90, 75, false);
        
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75);

        Stage2Ground stage2ground2 = new Stage2Ground(1000);
        addObject(stage2ground2, 1266, 326);
        stage2ground2.setLocation(1297, 352);

        Stage2Ground stage2ground4 = new Stage2Ground(1000);
        addObject(stage2ground4, 1996, 246);
        stage2ground4.setLocation(2295, 264);
        Stage2Ground stage2ground5 = new Stage2Ground(800);

        Stage2Ground stage2ground6 = new Stage2Ground(500);
        addObject(stage2ground6, 3300, 353);
        stage2ground6.setLocation(3045, 343);

        stage2ground6.setLocation(3044, 349);
        Stage2Platform stage2platform3 = new Stage2Platform(88);
        addObject(stage2platform3, 3363, 175);
        stage2platform3.setLocation(3387, 149);
        stage2platform3.setLocation(3390, 141);
        Portal portal = new Portal(200);
        addObject(portal, 3232, 233);

        addObject(thrower12, 3389, 75);
        thrower12.setLocation(3389, 61);
        addObject(thrower13, 2015, 150);
        thrower13.setLocation(1989, 150);
        //addObject(thrower14, 2015, 150);
        //thrower14.setLocation(1989, 150);
        addObject(thrower1, 2753, 168);
        HealthPowerup healthpowerup = new HealthPowerup();
        addObject(healthpowerup, 3413, 65);
        healthpowerup.setLocation(3408, 79);
        thrower12.setLocation(3359, 66);

        TrapScrollHidden trapscrollhidden = new TrapScrollHidden();
        addObject(trapscrollhidden, 699, 116);
        trapscrollhidden.setLocation(1282, 233);
        removeObject(trapscrollhidden);
        Trap trap = new Trap();
        addObject(trap, 723, 188);
        Trap trap2 = new Trap();
        addObject(trap2, 968, 269);
        Trap trap3 = new Trap();
        addObject(trap3, 1660, 271);
        Trap trap4 = new Trap();
        addObject(trap4, 2323, 184);
        Trap trap5 = new Trap();
        addObject(trap5, 3018, 268);

        thrower12.setLocation(1985, 172);
        thrower12.setLocation(2093, 128);

        removeObject(thrower1);
        Enemy2 enemy2 = new Enemy2(10);
        addObject(enemy2, 1245, 248);
        removeObject(enemy2);
        Enemy1 enemy1 = new Enemy1(10);
        addObject(enemy1, 1295, 247);
        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 1737, 268);
        Fill fill2 = new Fill(1, 1, 1);
        addObject(fill2, 841, 252);
        Enemy2 enemy22 = new Enemy2(10);
        addObject(enemy22, 1485, 256);
        removeObject(enemy22);
        Enemy2 enemy23 = new Enemy2(10);
        addObject(enemy23, 1482, 251);
        removeObject(enemy23);
        Enemy1 enemy12 = new Enemy1(10);
        addObject(enemy12, 1481, 251);
        removeObject(thrower1);
        thrower1.setLocation(2719, 160);

        thrower1.setLocation(3039, 110);
        thrower1.setLocation(3375, 66);
        removeObject(thrower12);
            Enemy2 enemy24 = new Enemy2(10);
        addObject(enemy24, 2307, 152);
        enemy24.setLocation(2307, 162);
        removeObject(enemy24);
        Enemy2 enemy25 = new Enemy2(10);
        addObject(enemy25, 2329, 182);
        removeObject(enemy25);
        Enemy2 enemy26 = new Enemy2(10);
        addObject(enemy26, 2197, 172);
        removeObject(enemy26);
        Enemy2 enemy27 = new Enemy2(10);
        addObject(enemy27, 2655, 176);
        enemy27.setLocation(2651, 164);
        Fill fill3 = new Fill(1, 1, 1);
        addObject(fill3, 2769, 168);
}
}
