import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S2L2 here.
 * 
 * Jessica made this stage
 * @version (a version number or a date)
 */
public class S2L3 extends SWorld
{
    public Stage2Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    private Thrower1 thrower1;
    private Thrower1 thrower12;
    private Thrower1 thrower14;
    private Thrower1 thrower15;
    /**
     * Constructor for objects of class S2L2.
     * 
     */
    public S2L3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1, 4000,400); 
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
        dragon = new Stage2Dragon();
        thrower1 = new Thrower1(1);
        thrower12 = new Thrower1(1);
        addMainActor(dragon, 100, 200, 50, 300);
        GreenfootImage bg = new GreenfootImage("scrollingbg.png");
        setScrollingBackground(bg);
        thrower14 = new Thrower1(2);
        thrower15 = new Thrower1(2);
        prepare();
    }
    public void act()
   {
       super.act();
        boolean win = false;
        try {
            win = dragon.nextLevel();
            thrower1.setMainPos(getScrolledX()+ dragon.getX(),dragon.getY(),getScrolledX(),getScrolledY());
            thrower12.setMainPos(getScrolledX()+dragon.getX(),dragon.getY(),getScrolledX(),getScrolledY());
            thrower14.setMainPos(getScrolledX()+dragon.getX(),dragon.getY(),getScrolledX(),getScrolledY());
            thrower15.setMainPos(getScrolledX()+dragon.getX(),dragon.getY(),getScrolledX(),getScrolledY());
        }
        catch(Exception e) {
            
        }
        if(win && Greenfoot.isKeyDown("w"))
         {         
            
 
            S2L4 l4 = new S2L4();
            Greenfoot.setWorld(l4);
         } 
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        manabar = getManaBar();
        addObject(manabar, 90, 75, false);
        
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75,false);
        
        Stage2Platform stage2platform = new Stage2Platform(200);
        addObject(stage2platform, 159, 319);
        Stage2Platform stage2platform2 = new Stage2Platform(200);
        addObject(stage2platform2, 586, 221);
        stage2platform2.setLocation(486, 235);
        Stage2Platform stage2platform3 = new Stage2Platform(200);
        addObject(stage2platform3, 870, 332);
        Stage2Platform stage2platform4 = new Stage2Platform(200);
        addObject(stage2platform4, 1201, 164);
        Stage2Platform stage2platform5 = new Stage2Platform(200);
        addObject(stage2platform5, 1557, 312);
        Stage2Platform stage2platform6 = new Stage2Platform(200);
        addObject(stage2platform6, 1913, 145);
        stage2platform6.setLocation(1914, 178);
        Stage2Platform stage2platform7 = new Stage2Platform(200);
        addObject(stage2platform7, 2316, 311);
        Stage2Platform stage2platform8 = new Stage2Platform(200);
        addObject(stage2platform8, 2647, 185);
        Stage2Platform stage2platform9 = new Stage2Platform(200);
        addObject(stage2platform9, 3018, 147);
        stage2platform8.setLocation(2669, 207);
        TrapScroll trapscroll = new TrapScroll();
        addObject(trapscroll, 2311, 245);
        TrapScroll trapscroll2 = new TrapScroll();
        addObject(trapscroll2, 873, 269);
        TrapScroll trapscroll3 = new TrapScroll();
        addObject(trapscroll3, 2661, 135);
        Stage2Platform stage2platform10 = new Stage2Platform(100);
        addObject(stage2platform10, 868, 92);
        Stage2Platform stage2platform11 = new Stage2Platform(100);
        addObject(stage2platform11, 2337, 80);
        Stage2Platform stage2platform12 = new Stage2Platform(100);
        addObject(stage2platform12, 3418, 100);

        stage2platform2.setLocation(534, 257);
        stage2platform4.setLocation(1203, 214);
        stage2platform6.setLocation(1904, 216);
        stage2platform6.setLocation(1958, 250);
        Enemy1 enemy1 = new Enemy1(1);
        addObject(enemy1, 1203, 157);
        enemy1.setLocation(1211, 123);
        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 1301, 159);
        Fill fill2 = new Fill(1, 1, 1);
        addObject(fill2, 1107, 159);
        Enemy1 enemy12 = new Enemy1(1);
        addObject(enemy12, 1953, 182);
        Fill fill3 = new Fill(1, 1, 1);
        addObject(fill3, 2065, 201);
        Fill fill4 = new Fill(1, 1, 1);
        addObject(fill4, 1857, 191);
        enemy12.setLocation(1945, 164);
        addObject(thrower1, 867, 54);
        addObject(thrower12, 3414, 48);
        thrower12.setLocation(2332, 34);
        Portal portal = new Portal(200);
        addObject(portal, 3032, 81);
        addObject(thrower14, 2933, 79);
        thrower14.setLocation(2929, 72);
        removeObject(stage2platform12);
        Stage2Ground stage2ground = new Stage2Ground(900);
        addObject(stage2ground, 3123, 324);
        stage2ground.setLocation(3168, 326);
        stage2ground.setLocation(3218, 335);
        stage2ground.setLocation(3194, 325);
        Stage2Platform stage2platform13 = new Stage2Platform(400);
        addObject(stage2platform13, 3582, 100);
        removeObject(stage2platform13);
        Stage2Platform stage2platform14 = new Stage2Platform(200);
        addObject(stage2platform14, 3640, 133);
        stage2platform14.setLocation(3699, 160);
        addObject(thrower15, 3669, 81);
        thrower15.setLocation(3624, 84);
      
        Fill fill5 = new Fill(1, 1, 1);
        addObject(fill5, 2834, 244);
        Fill fill6 = new Fill(1, 1, 1);
        addObject(fill6, 3575, 246);
        
        Stage2Platform stage2platform20 = new Stage2Platform(150);
        addObject(stage2platform20, 3435, 233);
        stage2platform20.setLocation(3523, 236);
        
    }
   
}

