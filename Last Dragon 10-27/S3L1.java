import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S3L1 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class S3L1 extends SWorld
{
    private static GreenfootSound bkgMusic = new GreenfootSound("sounds/Constance.mp3");
   
    private Stage3Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    private Wizard wizard = new Wizard(true);
    private Wizard wizard1 = new Wizard(true);
    private Wizard wizard2 = new Wizard(true);
    private Wizard wizard3 = new Wizard(true);
    private Wizard wizard4 = new Wizard(true);
    int c;
    /**
     * Constructor for objects of class S3L1.
     * 
     */
    public S3L1()
    {    
        
        super(1000, 700, 1, 4000,2000);  
        
        Boss2Scene1.stopBackgroundMusic();
        five();
        dragon = new Stage3Dragon();    
        addMainActor(dragon, 100, 300, 50, 300);
        GreenfootImage bg = new GreenfootImage("castlebg1.png");
        setScrollingBackground(bg);
        prepare();
        bkgMusic = new GreenfootSound("sounds/Constance.mp3");
        
        //Found on incompetech.com by Kevin Macleod
        bkgMusic.playLoop();
      
       Death death = new Death();
            death.setStage(3);
            Greenfoot.setWorld(death);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Stage3Ground stage3ground = new Stage3Ground();
        addObject(stage3ground, 501, 356);
        
        manabar = getManaBar();
        addObject(manabar, 90, 75, false);
        
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75, false);
        
        addObject(wizard, 618, 126);
        wizard.setLocation(894, 99);
        stage3ground.setLocation(495, 859);
        stage3ground.setLocation(516, 1343);
        stage3ground.setLocation(496, 1939);
        stage3ground.setLocation(503, 1939);
        Stage3Platform stage3platform = new Stage3Platform(100);
        addObject(stage3platform, 1177, 1740);
        removeObject(stage3platform);
        Stage3Platform stage3platform2 = new Stage3Platform(300);
        addObject(stage3platform2, 1247, 1792);
        Stage3Ground stage3ground2 = new Stage3Ground();
        addObject(stage3ground2, 1965, 1644);
        Knight knight = new Knight(100);
        addObject(knight, 2223, 1500);
        Stage3Platform stage3platform3 = new Stage3Platform(300);
        addObject(stage3platform3, 2721, 1492);
        stage3platform3.setLocation(2713, 1481);
        Stage3Ground stage3ground3 = new Stage3Ground();
        addObject(stage3ground3, 3452, 1295);
        Stage3Platform stage3platform4 = new Stage3Platform(300);
        addObject(stage3platform4, 2704, 1092);
        removeObject(knight);
        Stage3Platform stage3platform5 = new Stage3Platform(300);
        addObject(stage3platform5, 2215, 937);
        stage3platform5.setLocation(2337, 953);
        stage3platform5.setLocation(2336, 950);
        stage3platform5.setLocation(2231, 960);
        Stage3Ground stage3ground4 = new Stage3Ground();
        addObject(stage3ground4, 1514, 750);
        removeObject(wizard);
        Stage3Platform stage3platform6 = new Stage3Platform(300);
        addObject(stage3platform6, 2305, 554);
        Stage3Ground stage3ground5 = new Stage3Ground();
        addObject(stage3ground5, 3114, 361);
        Portal portal = new Portal(200);
        addObject(portal, 3541, 182);
        removeObject(portal);
        Portal portal2 = new Portal(300);
        addObject(portal2, 3540, 181);
        addObject(wizard2, 2364, 1538);
        addObject(wizard3, 3302, 788);
        addObject(wizard4, 780, 521);
        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 615, 585);
        Fill fill2 = new Fill(1, 1, 1);
        addObject(fill2, 2048, 557);
        Fill fill3 = new Fill(1, 1, 1);
        addObject(fill3, 1080, 1431);
        Fill fill4 = new Fill(1, 1, 1);
        addObject(fill4, 2062, 1423);
        Fill fill5 = new Fill(1, 1, 1);
        addObject(fill5, 2512, 1556);
        Fill fill6 = new Fill(1, 1, 1);
        addObject(fill6, 1466, 1556);
        Fill fill7 = new Fill(1, 1, 1);
        addObject(fill7, 2675, 808);
        Fill fill8 = new Fill(1, 1, 1);
        addObject(fill8, 3657, 810);
    }
     public void act()
   {
       super.act();
       
        boolean win = false;
        try {
            win = dragon.nextLevel();
            wizard.setMainPos(getScrolledX() + dragon.getX(), getScrolledY() + dragon.getY(), getScrolledX(),getScrolledY());
            wizard1.setMainPos(getScrolledX() + dragon.getX(),getScrolledY() + dragon.getY(), getScrolledX(),getScrolledY());
            wizard2.setMainPos(getScrolledX() + dragon.getX(), getScrolledY() + dragon.getY(), getScrolledX(),getScrolledY());
            wizard3.setMainPos(getScrolledX() + dragon.getX(),getScrolledY() + dragon.getY(), getScrolledX(),getScrolledY());
            wizard4.setMainPos(getScrolledX() + dragon.getX(), getScrolledY() + dragon.getY(), getScrolledX(),getScrolledY());
        }
        catch(Exception e) {
            
        }
        if(win && Greenfoot.isKeyDown("w"))
        {   
            S3L2 l2 = new S3L2();
            Greenfoot.setWorld(l2);
        } 
    }
    
    public static void stopBackgroundMusic()
    {
        bkgMusic.stop();
    }
}
