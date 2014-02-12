import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBossLevel here.
 * 
 * @author Darryl
 * @version (a version number or a date)
 */
public class FinalBossLevel extends SWorld
{
    public Stage3Dragon dragon;
    HealthBar healthbar;
    King king;
    /**
     * Constructor for objects of class FinalBossLevel.
     * 
     */
    public FinalBossLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1, 2000, 1000); 
        dragon = new Stage3Dragon();
        addMainActor(dragon, 204, 246, 50, 300);
        GreenfootImage bg = new GreenfootImage("castle2bg.png");
        setScrollingBackground(bg);
        king = new King();
        prepare();
    }
    
    public void act() {
        super.act();
        try {
            king.setMainPos(getScrolledX() + dragon.getX(), getScrolledY() + dragon.getY(), getScrolledX(),getScrolledY());
        }
        catch(Exception e) {
            
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
        addObject(stage3ground, 504, 806);
        stage3ground.setLocation(700, 892);
        stage3ground.setLocation(502, 959);
        Stage3Ground stage3ground2 = new Stage3Ground();
        addObject(stage3ground2, 1506, 965);
        stage3ground2.setLocation(1501, 961);
        Stage3Platform stage3platform = new Stage3Platform(300);
        addObject(stage3platform, 999, 815);
        stage3platform.setLocation(945, 788);
        Stage3Platform stage3platform2 = new Stage3Platform(300);
        addObject(stage3platform2, 958, 620);
        stage3platform2.setLocation(936, 630);
        stage3platform.setLocation(935, 793);
        stage3platform2.setLocation(935, 604);
        stage3platform.setLocation(928, 799);
        Stage3Platform stage3platform3 = new Stage3Platform(200);
        addObject(stage3platform3, 1301, 500);
        stage3platform3.setLocation(1253, 520);
        removeObject(stage3platform3);
        Stage3Platform stage3platform4 = new Stage3Platform(50);
        addObject(stage3platform4, 1296, 512);
        removeObject(stage3platform4);
        Stage3Platform stage3platform5 = new Stage3Platform(100);
        addObject(stage3platform5, 1296, 541);
        stage3platform5.setLocation(1216, 513);
        Stage3Platform stage3platform6 = new Stage3Platform(200);
        addObject(stage3platform6, 1431, 438);
        stage3platform6.setLocation(1412, 437);
        stage3platform5.setLocation(1199, 540);
        Stage3Platform stage3platform7 = new Stage3Platform(100);
        addObject(stage3platform7, 624, 524);
        stage3platform7.setLocation(658, 539);
        Stage3Platform stage3platform8 = new Stage3Platform(200);
        addObject(stage3platform8, 446, 431);
        stage3platform.setLocation(935, 784);
        stage3platform2.setLocation(930, 562);
        stage3platform7.setLocation(657, 473);
        stage3platform8.setLocation(446, 370);
        stage3platform5.setLocation(1196, 493);
        stage3platform6.setLocation(1404, 374);
        stage3platform.setLocation(929, 750);
        stage3platform.setLocation(929, 761);
        stage3platform2.setLocation(920, 466);
        stage3platform.setLocation(927, 675);
        stage3platform6.setLocation(1410, 260);
        stage3platform5.setLocation(1190, 383);
        stage3platform7.setLocation(657, 431);
        stage3platform8.setLocation(444, 319);
        stage3platform7.setLocation(658, 399);
        stage3platform8.setLocation(443, 298);
        removeObject(stage3platform8);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(920, 466);
        stage3platform2.setLocation(893, 396);
        stage3platform7.setLocation(592, 398);
        stage3platform5.setLocation(1233, 396);
        stage3platform2.setLocation(916, 395);
        removeObject(stage3platform6);
        stage3platform5.setLocation(1315, 393);
        stage3platform2.setLocation(950, 399);
        stage3platform5.setLocation(1417, 378);
        stage3platform2.setLocation(1012, 387);
        stage3platform2.setLocation(1009, 387);
        stage3platform5.setLocation(1520, 393);
        TrapScroll trapscroll4 = new TrapScroll();
        trapscroll4.setLocation(1031, 619);
        removeObject(stage3platform5);
        stage3platform2.setLocation(929, 416);
        stage3platform7.setLocation(495, 403);
        stage3platform7.setLocation(1532, 416);
        stage3platform7.setLocation(1405, 516);
        stage3platform7.setLocation(1423, 514);
        TrapScroll trapscroll = new TrapScroll();
        addObject(trapscroll, 884, 603);
        trapscroll.setLocation(819, 627);
        TrapScroll trapscroll2 = new TrapScroll();
        addObject(trapscroll2, 947, 618);
        trapscroll2.setLocation(894, 628);
        TrapScroll trapscroll3 = new TrapScroll();
        addObject(trapscroll3, 1011, 624);
        trapscroll3.setLocation(965, 626);

        addObject(trapscroll4, 1024, 619);
        trapscroll4.setLocation(1034, 628);
        TrapScroll trapscroll5 = new TrapScroll();
        addObject(trapscroll5, 1054, 360);
        trapscroll5.setLocation(1037, 365);
        TrapScroll trapscroll6 = new TrapScroll();
        addObject(trapscroll6, 949, 342);
        trapscroll6.setLocation(959, 365);
        TrapScroll trapscroll7 = new TrapScroll();
        addObject(trapscroll7, 892, 359);
        trapscroll7.setLocation(882, 362);
        TrapScroll trapscroll8 = new TrapScroll();
        addObject(trapscroll8, 836, 358);
        trapscroll8.setLocation(810, 361);
        stage3platform7.setLocation(1349, 590);
        removeObject(stage3platform2);
        removeObject(trapscroll5);
        removeObject(trapscroll6);
        removeObject(trapscroll7);
        removeObject(trapscroll8);
        stage3platform7.setLocation(1365, 624);
        Stage3Platform stage3platform9 = new Stage3Platform(100);
        addObject(stage3platform9, 1214, 544);
        stage3platform9.setLocation(1184, 535);
        stage3platform7.setLocation(1451, 637);
        stage3platform9.setLocation(1224, 535);
        stage3platform7.setLocation(1456, 675);
        TrapScroll trapscroll9 = new TrapScroll();
        addObject(trapscroll9, 1269, 490);
        trapscroll9.setLocation(1221, 490);
        removeObject(stage3platform7);
        trapscroll9.setLocation(1233, 443);
        removeObject(trapscroll9);
        Fill fill = new Fill(10, 10, 1);
        addObject(fill, 313, 858);
        Fill fill2 = new Fill(10, 10, 1);
        addObject(fill2, 1839, 843);

        //adds health bar for boss
        healthbar = new HealthBar(625, 625);
        addObject(healthbar, getWidth()/2, 370,false);
        removeObject(trapscroll4);
        removeObject(trapscroll3);
        removeObject(trapscroll2);
        removeObject(trapscroll);
        TrapScroll trapscroll10 = new TrapScroll();
        addObject(trapscroll10, 847, 635);
        removeObject(trapscroll10);
        TrapScroll trapscroll11 = new TrapScroll();
        addObject(trapscroll11, 851, 635);
        trapscroll11.setLocation(805, 617);
        removeObject(trapscroll11);
        TrapScrollHidden trapscrollhidden = new TrapScrollHidden();
        addObject(trapscrollhidden, 881, 599);
        TrapScrollHidden trapscrollhidden2 = new TrapScrollHidden();
        addObject(trapscrollhidden2, 753, 599);
        trapscrollhidden2.setLocation(811, 603);
        trapscrollhidden.setLocation(881, 605);
        TrapScrollHidden trapscrollhidden3 = new TrapScrollHidden();
        addObject(trapscrollhidden3, 983, 621);
        trapscrollhidden3.setLocation(963, 603);
        TrapScrollHidden trapscrollhidden4 = new TrapScrollHidden();
        addObject(trapscrollhidden4, 1093, 603);
        trapscrollhidden4.setLocation(1039, 603);
        King king = new King();
        addObject(king, 586, 853);
        king.setLocation(589, 828);
        king.setLocation(592, 839);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(1000, 370);
        healthbar.setLocation(305, 955);
        healthbar.setLocation(295, 976);
        healthbar.setLocation(337, 168);
        healthbar.setLocation(277, 84);
        healthbar.setLocation(268, 112);
        Boss3HealthOverlay fbo= new Boss3HealthOverlay();
        addObject(fbo, 268,112,false);

        stage3platform9.setLocation(1244, 671);
        stage3platform9.setLocation(1237, 575);
    }


    public Stage3Dragon getDragon()
    {
        return dragon;
    }
    public void loseHealth()
    {
        healthbar.add(-2);
  
    }
}
