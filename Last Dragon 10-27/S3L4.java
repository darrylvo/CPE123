import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S3L4 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class S3L4 extends SWorld
{
    private Stage3Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    /**
     * Constructor for objects of class S3L4.
     * 
     */
    public S3L4()
    {    
        super(1500 , 600, 1, 8000, 600); 
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
        dragon = new Stage3Dragon();
        addMainActor(dragon, 100, 200, 50, 300);
        GreenfootImage bg = new GreenfootImage("castle3bg.png");
        setScrollingBackground(bg);

        prepare();
    }
    public void act()
    {
        super.act();
        boolean win = false;
       try {
          win = dragon.nextLevel();
          
       }
       catch(Exception e) {
            
       } 
       
        if(win && Greenfoot.isKeyDown("w"))
        {   
            S3L1.stopBackgroundMusic();
            FinalBossScene1 s1 = new FinalBossScene1();
            Greenfoot.setWorld(s1);
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

        Stage3Ground stage3ground = new Stage3Ground();
        addObject(stage3ground, 508, 567);
        Stage3Ground stage3ground2 = new Stage3Ground();
        addObject(stage3ground2, 1514, 575);
        stage3ground2.setLocation(1508, 568);
        Stage3Ground stage3ground3 = new Stage3Ground();
        addObject(stage3ground3, 2514, 575);
        Stage3Ground stage3ground4 = new Stage3Ground();
        addObject(stage3ground4, 3519, 582);
        stage3ground3.setLocation(2507, 530);
        stage3ground4.setLocation(3507, 508);
        Stage3Ground stage3ground5 = new Stage3Ground();
        addObject(stage3ground5, 4513, 485);
        stage3ground5.setLocation(4509, 485);
        Stage3Ground stage3ground6 = new Stage3Ground();
        addObject(stage3ground6, 5515, 466);
        stage3ground6.setLocation(5505, 469);
        Stage3Ground stage3ground7 = new Stage3Ground();
        addObject(stage3ground7, 6511, 447);
        stage3ground7.setLocation(6503, 447);
        Stage3Ground stage3ground8 = new Stage3Ground();
        addObject(stage3ground8, 7509, 434);
        stage3ground8.setLocation(7500, 435);
        Knight knight = new Knight(100);
        addObject(knight, 2505, 413);
        removeObject(knight);
        Knight knight2 = new Knight(100);
        addObject(knight2, 2467, 371);
        Knight knight3 = new Knight(100);
        addObject(knight3, 3516, 369);
        removeObject(knight3);
        Knight knight4 = new Knight(100);
        addObject(knight4, 3524, 343);
        Knight knight5 = new Knight(100);
        addObject(knight5, 4512, 314);
        removeObject(knight5);
        Knight knight6 = new Knight(100);
        addObject(knight6, 4515, 316);
        knight6.setLocation(4515, 328);
        Knight knight7 = new Knight(100);
        addObject(knight7, 5491, 347);
        knight7.setLocation(5481, 312);
        Knight knight8 = new Knight(100);
        addObject(knight8, 6562, 309);
        knight8.setLocation(6554, 290);
        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 2015, 404);
        Fill fill2 = new Fill(1, 1, 1);
        addObject(fill2, 2987, 392);
        Fill fill3 = new Fill(1, 1, 1);
        addObject(fill3, 3065, 371);
        Fill fill4 = new Fill(1, 1, 1);
        addObject(fill4, 3963, 382);
        Fill fill5 = new Fill(1, 1, 1);
        addObject(fill5, 4082, 348);
        Fill fill6 = new Fill(1, 1, 1);
        addObject(fill6, 4962, 334);
        Fill fill7 = new Fill(1, 1, 1);
        addObject(fill7, 5057, 329);
        Fill fill8 = new Fill(1, 1, 1);
        addObject(fill8, 5939, 341);
        Fill fill9 = new Fill(1, 1, 1);
        addObject(fill9, 6054, 317);
        Fill fill10 = new Fill(1, 1, 1);
        addObject(fill10, 6938, 317);

        //add traps on traps on traps
        Trap trap1 = new Trap();
        addObject(trap1, 508, 487);
        Trap trap2 = new Trap();
        addObject(trap2, 1508, 487);
        Trap trap3 = new Trap();
        addObject(trap3, 2508, 450);
        Trap trap4 = new Trap();
        addObject(trap4, 3508, 428);
        Trap trap5 = new Trap();
        addObject(trap5, 4508, 405);
        Trap trap6 = new Trap();
        addObject(trap6, 5508, 389);
        Trap trap7 = new Trap();
        addObject(trap7, 6508, 367);
        Trap trap8 = new Trap();
        addObject(trap8, 7508, 355);
        PortalScroll portalscroll = new PortalScroll();
        addObject(portalscroll, 7799, 327);
        removeObject(portalscroll);
        Portal portal = new Portal(100);
        addObject(portal, 7816, 325);
    }
}
