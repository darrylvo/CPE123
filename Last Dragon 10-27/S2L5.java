import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S2L5 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class S2L5 extends SWorld
{
    
    private Stage2Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    private Thrower1 thrower1 = new Thrower1(1);
   
    private Thrower1 thrower12 = new Thrower1(1);
    private Thrower1 thrower13 = new Thrower1(1);
    /**
     * Constructor for objects of class S2L5.
     * 
     */
    public S2L5()
    {    
        super(900, 700, 1, 1000,4500); 
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
        dragon = new Stage2Dragon();
         
        addMainActor(dragon, 100, 100, 20, 20);
        GreenfootImage bg = new GreenfootImage("plains2bg.png");
        setScrollingBackground(bg);

        prepare();
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
        addObject(manabarOverlay, 88, 75);

        Stage2Ground stage2ground = new Stage2Ground(1000);
        addObject(stage2ground, 497, 4471);
        Stage2Platform stage2platform = new Stage2Platform(300);
        addObject(stage2platform, 821, 188);
        addObject(thrower1, 737, 112);
        Stage2Platform stage2platform2 = new Stage2Platform(200);
        addObject(stage2platform2, 135, 385);
        Stage2Platform stage2platform3 = new Stage2Platform(100);
        addObject(stage2platform3, 517, 541);
        TrapScrollHidden trapscrollhidden = new TrapScrollHidden();
        addObject(trapscrollhidden, 515, 425);
        removeObject(trapscrollhidden);
        TrapScrollHidden trapscrollhidden2 = new TrapScrollHidden();
        addObject(trapscrollhidden2, 519, 431);
        removeObject(trapscrollhidden2);
        TrapScrollHidden trapscrollhidden3 = new TrapScrollHidden();
        addObject(trapscrollhidden3, 517, 465);
        Stage2Platform stage2platform4 = new Stage2Platform(100);
        addObject(stage2platform4, 349, 546);
        stage2platform4.setLocation(349, 544);
        Stage2Platform stage2platform5 = new Stage2Platform(200);
        addObject(stage2platform5, 777, 720);
        Stage2Ground stage2ground2 = new Stage2Ground(1000);
        addObject(stage2ground2, 73, 919);
        stage2platform5.setLocation(809, 764);
        stage2ground2.setLocation(45, 1067);
        TrapScrollHidden trapscrollhidden4 = new TrapScrollHidden();
        addObject(trapscrollhidden4, 65, 989);
        TrapScrollHidden trapscrollhidden5 = new TrapScrollHidden();
        addObject(trapscrollhidden5, 243, 991);
        TrapScrollHidden trapscrollhidden6 = new TrapScrollHidden();
        addObject(trapscrollhidden6, 445, 991);
        Enemy2 enemy2 = new Enemy2(10);
        addObject(enemy2, 319, 967);
        enemy2.sitThere();
        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 517, 983);
        Fill fill2 = new Fill(10, 10, 1);
        addObject(fill2, 27, 977);
        enemy2.setLocation(319, 977);
        Stage2Platform stage2platform6 = new Stage2Platform(200);
        addObject(stage2platform6, 801, 1233);
        Stage2Platform stage2platform7 = new Stage2Platform(200);
        addObject(stage2platform7, 615, 1320);
        Stage2Platform stage2platform8 = new Stage2Platform(200);
        addObject(stage2platform8, 431, 1412);
        Stage2Platform stage2platform9 = new Stage2Platform(200);
        addObject(stage2platform9, 147, 1638);
        TrapScrollHidden trapscrollhidden7 = new TrapScrollHidden();
        addObject(trapscrollhidden7, 621, 1246);
        TrapScrollHidden trapscrollhidden8 = new TrapScrollHidden();
        addObject(trapscrollhidden8, 439, 1334);
        addObject(thrower12, 113, 1566);
        Stage2Platform stage2platform10 = new Stage2Platform(10);
        addObject(stage2platform10, 799, 1572);
        removeObject(stage2platform10);
        Stage2Platform stage2platform11 = new Stage2Platform(100);
        addObject(stage2platform11, 821, 1614);
        addObject(thrower13, 821, 1548);
        Stage2Platform stage2platform12 = new Stage2Platform(200);
        addObject(stage2platform12, 503, 1778);
        Stage2Ground stage2ground3 = new Stage2Ground(1000);
        addObject(stage2ground3, 853, 2066);
        Enemy2 enemy22 = new Enemy2(10);
        addObject(enemy22, 649, 1946);
        enemy22.sitThere();
        removeObject(enemy22);
        Enemy2 enemy23 = new Enemy2(10);
        addObject(enemy23, 659, 1969);
        enemy23.sitThere();
        Fill fill3 = new Fill(1, 1, 1);
        addObject(fill3, 381, 1967);
        Fill fill4 = new Fill(1, 1, 1);
        addObject(fill4, 949, 1975);
        Stage2Ground stage2ground4 = new Stage2Ground(1000);
        addObject(stage2ground4, 23, 2442);
        Stage2Platform stage2platform13 = new Stage2Platform(200);
        addObject(stage2platform13, 813, 2604);
        Stage2Platform stage2platform14 = new Stage2Platform(200);
        addObject(stage2platform14, 573, 2802);
        Stage2Ground stage2ground5 = new Stage2Ground(1000);
        addObject(stage2ground5, 107, 3116);
        Stage2Ground stage2ground6 = new Stage2Ground(1000);
        addObject(stage2ground6, 575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(575, 3754);
        stage2ground6.setLocation(755, 3734);
        PortalScroll portalscroll = new PortalScroll();
        addObject(portalscroll, 874, 4338);
        removeObject(portalscroll);
        Portal portal = new Portal(200);
        addObject(portal, 871, 4366);
        TrapScrollHidden trapscrollhidden9 = new TrapScrollHidden();
        addObject(trapscrollhidden9, 577, 2728);
        Enemy2 enemy24 = new Enemy2(10);
        
        addObject(enemy24, 167, 2328);
        enemy24.sitThere();
        removeObject(enemy24);
        Enemy2 enemy25 = new Enemy2(10);
        enemy25.sitThere();
        addObject(enemy25, 225, 2340);
        Fill fill5 = new Fill(1, 1, 1);
        addObject(fill5, 501, 2362);
        Fill fill6 = new Fill(1, 1, 1);
        addObject(fill6, 25, 2352);
       
        TrapScrollHidden trapscrollhidden10 = new TrapScrollHidden();
        addObject(trapscrollhidden10, 115, 3041);
        TrapScrollHidden trapscrollhidden11 = new TrapScrollHidden();
        addObject(trapscrollhidden11, 303, 3041);
        TrapScrollHidden trapscrollhidden12 = new TrapScrollHidden();
        addObject(trapscrollhidden12, 509, 3041);
        TrapScrollHidden trapscrollhidden13 = new TrapScrollHidden();
        addObject(trapscrollhidden13, 479, 3661);
        TrapScrollHidden trapscrollhidden14 = new TrapScrollHidden();
        addObject(trapscrollhidden14, 763, 3661);
    }


    public void act()
   {
       super.act();
        boolean win = false;
        try {
            thrower1.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
            thrower12.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
            thrower13.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
           
            win = dragon.nextLevel();
           
        }
        catch(Exception e) {
            
        }
        if(win && Greenfoot.isKeyDown("w"))
         {         
            S2L1.stopBackgroundMusic();
 
            Boss2Scene1 b2s1 = new Boss2Scene1();
            Greenfoot.setWorld(b2s1);
         } 
    }
  
}
