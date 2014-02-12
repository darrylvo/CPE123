import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S3L3 here.
 * 
 * @author Jessica 
 * @version (a version number or a date)
 */
public class S3L3 extends SWorld
{
    private Stage3Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    Wizard wizard = new Wizard(false);
    Wizard wizard1 = new Wizard(false);
    Wizard wizard2 = new Wizard(false);
    Wizard wizard3 = new Wizard(false);
    Wizard wizard4 = new Wizard(false);
    Wizard wizard5 = new Wizard(false);
    /**
     * Constructor for objects of class S3L3.
     * 
     */
    public S3L3()
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
           wizard.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
           wizard1.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
           wizard2.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
           wizard3.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
           wizard4.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
           wizard5.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(), getScrolledX(),getScrolledY());
       }
       catch(Exception e) {
            
       } 
       
        if(win && Greenfoot.isKeyDown("w"))
        {   
            S3L4 l2 = new S3L4();
            Greenfoot.setWorld(l2);
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

        Stage3Platform stage3platform = new Stage3Platform(200);
        addObject(stage3platform, 148, 549);
        Stage3Platform stage3platform2 = new Stage3Platform(200);
        addObject(stage3platform2, 492, 419);
        Stage3Platform stage3platform3 = new Stage3Platform(200);
        addObject(stage3platform3, 864, 549);
        Stage3Platform stage3platform4 = new Stage3Platform(200);
        addObject(stage3platform4, 1215, 428);
        Stage3Platform stage3platform5 = new Stage3Platform(200);
        addObject(stage3platform5, 1557, 544);
        Stage3Platform stage3platform6 = new Stage3Platform(200);
        addObject(stage3platform6, 1871, 430);
        Stage3Platform stage3platform7 = new Stage3Platform(300);
        addObject(stage3platform7, 2183, 553);
        removeObject(stage3platform7);
        Stage3Platform stage3platform8 = new Stage3Platform(200);
        addObject(stage3platform8, 2213, 547);
        Stage3Platform stage3platform9 = new Stage3Platform(200);
        addObject(stage3platform9, 2517, 439);
        Stage3Platform stage3platform10 = new Stage3Platform(200);
        addObject(stage3platform10, 2840, 549);
        Stage3Platform stage3platform11 = new Stage3Platform(200);
        addObject(stage3platform11, 3150, 447);
        Stage3Platform stage3platform12 = new Stage3Platform(200);
        addObject(stage3platform12, 3458, 546);
        Stage3Platform stage3platform13 = new Stage3Platform(200);
        addObject(stage3platform13, 3758, 440);
        Stage3Platform stage3platform14 = new Stage3Platform(200);
        addObject(stage3platform14, 4084, 548);
        Stage3Platform stage3platform15 = new Stage3Platform(200);
        addObject(stage3platform15, 4376, 444);
        Stage3Ground stage3ground = new Stage3Ground();
        addObject(stage3ground, 5060, 564);
        addObject(wizard, 500,500);
        addObject(wizard1, 600,500);
        addObject(wizard2, 1000,500);
        addObject(wizard3, 2000,500);
        addObject(wizard4, 4000,500);
        addObject(wizard5, 6000,500);

        wizard2.setLocation(1534, 104);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(1000, 500);
        wizard3.setLocation(2462, 106);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(2000, 500);
        wizard4.setLocation(3388, 104);
        wizard5.setLocation(4284, 104);
        wizard5.setLocation(6576, 98);
        removeObject(wizard2);
        removeObject(wizard2);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(756, 400);
        wizard2.setLocation(1264, 108);
        wizard2.setLocation(624, 112);
        wizard.setLocation(1526, 112);
        wizard2.setLocation(654, 106);
        Portal portal3 = new Portal(100);
        addObject(portal3, 5311, 432);
    }
}
