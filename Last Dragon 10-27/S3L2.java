import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S3L2 here.
 * 
 * @author Jessica
 * @version (a version number or a date)
 */
public class S3L2 extends SWorld
{
        private GreenfootSound bkgMusic;
    private Stage3Dragon dragon;
    public Portal portal;
    public ManaBar manabar;
    Wizard wizard = new Wizard(true);
    Wizard wizard1 = new Wizard(true);
    Wizard wizard2 = new Wizard(true);
    Wizard wizard3 = new Wizard(true);
    Wizard wizard4 = new Wizard(true);
    /**
     * Constructor for objects of class S3L2.
     * 
     */
    public S3L2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500 , 900, 1, 8000, 2000); 
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
        dragon = new Stage3Dragon();
        addMainActor(dragon, 100, 600, 50, 300);
        GreenfootImage bg = new GreenfootImage("castle2bg.png");
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
       }
       catch(Exception e) {
            
       }
        if (win && Greenfoot.isKeyDown("w"))
        {
            
            S3L3 l3= new S3L3();
            Greenfoot.setWorld(l3);
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
        addObject(stage3ground, 503, 759);
        stage3ground.setLocation(511, 747);
        removeObject(stage3ground);
        Stage3Ground stage3ground2 = new Stage3Ground();
        addObject(stage3ground2, 503, 759);
        Stage3Ground stage3ground3 = new Stage3Ground();
        addObject(stage3ground3, 1510, 763);
        stage3ground3.setLocation(1502, 757);
        Stage3Ground stage3ground4 = new Stage3Ground();
        addObject(stage3ground4, 2648, 581);
        Stage3Ground stage3ground5 = new Stage3Ground();
        addObject(stage3ground5, 3653, 587);
        stage3ground5.setLocation(3647, 581);
        Stage3Ground stage3ground6 = new Stage3Ground();
        addObject(stage3ground6, 4653, 663);
        Stage3Ground stage3ground7 = new Stage3Ground();
        addObject(stage3ground7, 5658, 667);
        stage3ground7.setLocation(5652, 663);
        Stage3Ground stage3ground8 = new Stage3Ground();
        addObject(stage3ground8, 6695, 751);
        Stage3Ground stage3ground9 = new Stage3Ground();
        addObject(stage3ground9, 7697, 755);
        stage3ground9.setLocation(7689, 751);
        Stage3Ground stage3ground10 = new Stage3Ground();
        addObject(stage3ground10, 8763, 583);
        Stage3Platform stage3platform = new Stage3Platform(300);
        addObject(stage3platform, 9611, 456);
        Stage3Platform stage3platform2 = new Stage3Platform(300);
        addObject(stage3platform2, 10193, 620);
        Stage3Platform stage3platform3 = new Stage3Platform(300);
        addObject(stage3platform3, 10754, 462);
        Stage3Platform stage3platform4 = new Stage3Platform(300);
        addObject(stage3platform4, 11278, 314);
        Stage3Ground stage3ground11 = new Stage3Ground();
        addObject(stage3ground11, 11990, 610);
        Stage3Platform stage3platform5 = new Stage3Platform(300);
        addObject(stage3platform5, 12889, 708);
        Stage3Platform stage3platform6 = new Stage3Platform(300);
        addObject(stage3platform6, 13457, 708);
        Stage3Platform stage3platform7 = new Stage3Platform(300);
        addObject(stage3platform7, 14041, 700);
        Stage3Platform stage3platform8 = new Stage3Platform(300);
        addObject(stage3platform8, 14463, 568);
        Stage3Platform stage3platform9 = new Stage3Platform(3000);
        addObject(stage3platform9, 14929, 432);
        removeObject(stage3platform9);
        Stage3Platform stage3platform10 = new Stage3Platform(300);
        addObject(stage3platform10, 14873, 472);
        Stage3Platform stage3platform11 = new Stage3Platform(300);
        addObject(stage3platform11, 15404, 571);
        Stage3Ground stage3ground12 = new Stage3Ground();
        addObject(stage3ground12, 16285, 695);
        Stage3Ground stage3ground13 = new Stage3Ground();
        addObject(stage3ground13, 17582, 675);
        Stage3Ground stage3ground14 = new Stage3Ground();
        addObject(stage3ground14, 18775, 677);
        Stage3Platform stage3platform12 = new Stage3Platform(300);
        addObject(stage3platform12, 19523, 599);
        Stage3Platform stage3platform13 = new Stage3Platform(300);
        addObject(stage3platform13, 19527, 393);
        Stage3Platform stage3platform14 = new Stage3Platform(300);
        addObject(stage3platform14, 19537, 203);
        PortalScroll portalscroll = new PortalScroll();
        addObject(portalscroll, 19641, 91);
        removeObject(portalscroll);
        Portal portal = new Portal(200);
        addObject(portal, 19639, 97);

        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 19251, 597);
        Fill fill2 = new Fill(1, 1, 1);
        addObject(fill2, 18296, 581);
        Knight knight = new Knight(1);
        addObject(knight, 18968, 557);
        knight.setLocation(18960, 515);
        Stage3Platform stage3platform15 = new Stage3Platform(300);
        addObject(stage3platform15, 9614, 726);
        stage3platform15.setLocation(9726, 730);
        stage3platform15.setLocation(9848, 744);
        stage3platform2.setLocation(10333, 592);
        stage3platform6.setLocation(13379, 706);
        stage3platform7.setLocation(13797, 542);
        stage3platform8.setLocation(14189, 400);
        stage3platform10.setLocation(14741, 490);
        stage3platform11.setLocation(15256, 609);
        Stage3Platform stage3platform16 = new Stage3Platform(300);
        addObject(stage3platform16, 15650, 433);
        Knight knight2 = new Knight(1);
        addObject(knight2, 755, 585);
        Fill fill3 = new Fill(1, 1, 1);
        addObject(fill3, 303, 649);
        Fill fill4 = new Fill(1, 1, 1);
        addObject(fill4, 1965, 651);

        addObject(wizard, 2672, 193);
        addObject(wizard1, 2672, 193);
        addObject(wizard2, 2672, 193);
        addObject(wizard3, 2672, 193);
        addObject(wizard4, 2672, 193);
        Fill fill5 = new Fill(1, 1, 1);
        addObject(fill5, 3264, 229);
        Fill fill6 = new Fill(1, 1, 1);
        addObject(fill6, 2186, 215);
        Knight knight3 = new Knight(1);
        addObject(knight3, 4286, 467);
        knight3.setLocation(4352, 497);
        Knight knight4 = new Knight(1);
        addObject(knight4, 6076, 521);
        knight4.setLocation(6078, 503);
        Fill fill7 = new Fill(1, 1, 1);
        addObject(fill7, 6138, 541);
        Fill fill8 = new Fill(1, 1, 1);
        addObject(fill8, 4176, 535);
        stage3ground7.setLocation(5663, 994);
        removeObject(stage3ground7);
        Stage3Platform stage3platform17 = new Stage3Platform(300);
        addObject(stage3platform17, 5568, 848);
        removeObject(stage3ground8);
        removeObject(stage3ground9);
        removeObject(knight4);
        Stage3Platform stage3platform18 = new Stage3Platform(300);
        addObject(stage3platform18, 6042, 1021);
        Stage3Ground stage3ground15 = new Stage3Ground();
        addObject(stage3ground15, 6847, 1447);
        Stage3Platform stage3platform19 = new Stage3Platform(300);
        addObject(stage3platform19, 7581, 1244);
        HealthPowerup healthpowerup = new HealthPowerup();
        addObject(healthpowerup, 7688, 1184);
        Stage3Platform stage3platform20 = new Stage3Platform(300);
        addObject(stage3platform20, 6077, 1657);
        Stage3Ground stage3ground16 = new Stage3Ground();
        addObject(stage3ground16, 5314, 1894);
        Stage3Platform stage3platform21 = new Stage3Platform(300);
        addObject(stage3platform21, 4522, 1744);
        Stage3Platform stage3platform22 = new Stage3Platform(300);
        addObject(stage3platform22, 4073, 1627);
        Stage3Platform stage3platform23 = new Stage3Platform(300);
        addObject(stage3platform23, 3623, 1513);
        Stage3Platform stage3platform24 = new Stage3Platform(300);
        addObject(stage3platform24, 3243, 1374);
        removeObject(stage3platform24);
        removeObject(stage3platform23);
        Stage3Platform stage3platform25 = new Stage3Platform(300);
        addObject(stage3platform25, 3659, 1782);
        Stage3Platform stage3platform26 = new Stage3Platform(300);
        addObject(stage3platform26, 3242, 1662);
        Stage3Ground stage3ground17 = new Stage3Ground();
        addObject(stage3ground17, 4249, 1041);
        PortalScroll portalscroll2 = new PortalScroll();
        addObject(portalscroll2, 4269, 880);
        removeObject(portalscroll2);
        Portal portal2 = new Portal(100);
        addObject(portal2, 4281, 892);
        removeObject(portal2);
        Portal portal3 = new Portal(300);
        addObject(portal3, 4307, 890);
        removeObject(portal3);
        Portal portal4 = new Portal(400);
        addObject(portal4, 4285, 898);
        removeObject(portal4);
        Portal portal5 = new Portal(200);
        addObject(portal5, 4301, 896);
        Stage3Ground stage3ground18 = new Stage3Ground();
        addObject(stage3ground18, 2537, 1436);
        removeObject(stage3ground18);
        Stage3Ground stage3ground19 = new Stage3Ground();
        addObject(stage3ground19, 2545, 1486);
        Stage3Platform stage3platform27 = new Stage3Platform(300);
        addObject(stage3platform27, 3214, 1283);
        Stage3Platform stage3platform28 = new Stage3Platform(300);
        addObject(stage3platform28, 3560, 1146);
        Fill fill9 = new Fill(1, 1, 1);
        addObject(fill9, 7346, 1369);
        Fill fill10 = new Fill(1, 1, 1);
        addObject(fill10, 6360, 1357);
        Knight knight5 = new Knight(100);
        addObject(knight5, 6923, 1344);
        removeObject(knight5);
        Knight knight6 = new Knight(100);
        addObject(knight6, 6897, 1296);
        Fill fill11 = new Fill(1, 1, 1);
        addObject(fill11, 3008, 1385);
        Fill fill12 = new Fill(1, 1, 1);
        addObject(fill12, 2067, 1393);
        Knight knight7 = new Knight(100);
        addObject(knight7, 2823, 1342);
        Knight knight8 = new Knight(100);
        addObject(knight8, 5175, 1721);
        Knight knight9 = new Knight(300);
        addObject(knight9, 5478, 1751);
        removeObject(knight9);
        Knight knight10 = new Knight(300);
        addObject(knight10, 5489, 1721);
        Fill fill13 = new Fill(1, 1, 1);
        addObject(fill13, 5802, 1786);
        Fill fill14 = new Fill(1, 1, 1);
        addObject(fill14, 4826, 1800);
    }
   
}
