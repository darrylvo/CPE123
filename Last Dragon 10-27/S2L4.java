import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S2L4 here.
 * 
 * Jessica made this stage
 * @version (a version number or a date)
 */
public class S2L4 extends SWorld
{
    Stage2Dragon dragon =new Stage2Dragon();
    public ManaBar manabar;
    Thrower1 thrower1;
    Thrower1 thrower12;
    Thrower1 thrower13;
    /**
     * Constructor for objects of class S2L4.
     * 
     */
    public S2L4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 400, 1 , 4000,400); 
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
        addMainActor(dragon, 100, 200, 50, 300);
        GreenfootImage bg = new GreenfootImage("scrollingbg.png");
        setScrollingBackground(bg);
        thrower1 = new Thrower1(1);
        thrower12 = new Thrower1(1);
        thrower13 = new Thrower1(2);
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
        addObject(manabarOverlay, 88, 75,false);
        
        Stage2Platform stage2platform = new Stage2Platform(200);
        addObject(stage2platform, 133, 345);
        stage2platform.setLocation(101, 351);
        Stage2Platform stage2platform2 = new Stage2Platform(200);
        addObject(stage2platform2, 335, 279);
        stage2platform2.setLocation(301, 279);
        stage2platform2.setLocation(301, 317);
        Stage2Platform stage2platform3 = new Stage2Platform(200);
        addObject(stage2platform3, 531, 289);
        stage2platform3.setLocation(501, 287);
        Stage2Platform stage2platform4 = new Stage2Platform(200);
        addObject(stage2platform4, 733, 263);
        stage2platform4.setLocation(701, 259);
        Stage2Platform stage2platform5 = new Stage2Platform(200);
        addObject(stage2platform5, 931, 237);
        stage2platform5.setLocation(901, 241);
        stage2platform5.setLocation(901, 229);
        stage2platform5.setLocation(901, 259);
        stage2platform5.setLocation(921, 261);
        stage2platform4.setLocation(711, 259);
        stage2platform4.setLocation(699, 277);
        stage2platform5.setLocation(899, 269);
        stage2platform3.setLocation(501, 295);
        stage2platform2.setLocation(301, 331);
        Stage2Platform stage2platform6 = new Stage2Platform(200);
        addObject(stage2platform6, 1130, 243);
        stage2platform6.setLocation(1098, 247);
        Stage2Platform stage2platform7 = new Stage2Platform(200);
        addObject(stage2platform7, 1332, 207);
        stage2platform7.setLocation(1298, 231);
        Stage2Platform stage2platform8 = new Stage2Platform(200);
        addObject(stage2platform8, 1532, 199);
        stage2platform8.setLocation(1498, 207);
        Stage2Platform stage2platform9 = new Stage2Platform(200);
        addObject(stage2platform9, 1730, 179);
        stage2platform9.setLocation(1698, 171);
        TrapScroll trapscroll = new TrapScroll();
        addObject(trapscroll, 502, 211);
        trapscroll.setLocation(502, 237);
        TrapScroll trapscroll2 = new TrapScroll();
        addObject(trapscroll2, 709, 193);
        trapscroll2.setLocation(709, 223);
        TrapScroll trapscroll3 = new TrapScroll();
        addObject(trapscroll3, 297, 243);
        trapscroll3.setLocation(301, 273);
        TrapScroll trapscroll4 = new TrapScroll();
        addObject(trapscroll4, 901, 177);
        trapscroll4.setLocation(901, 215);
        TrapScroll trapscroll5 = new TrapScroll();
        addObject(trapscroll5, 1105, 163);
        trapscroll5.setLocation(1101, 193);
        TrapScroll trapscroll6 = new TrapScroll();
        addObject(trapscroll6, 1297, 149);
        trapscroll6.setLocation(1297, 177);
        TrapScroll trapscroll7 = new TrapScroll();
        addObject(trapscroll7, 1498, 125);
        trapscroll7.setLocation(1502, 153);
        Stage2Ground stage2ground = new Stage2Ground(200);
        addObject(stage2ground, 2300, 171);
        removeObject(stage2ground);
        Stage2Ground stage2ground2 = new Stage2Ground(1000);
        addObject(stage2ground2, 2298, 183);
        stage2ground2.setLocation(2334, 177);
        stage2platform9.setLocation(1712, 181);
        stage2platform9.setLocation(1712, 179);
        removeObject(stage2platform9);
        stage2ground2.setLocation(2174, 187);
        Enemy2 enemy2 = new Enemy2(1);
        addObject(enemy2, 769, 217);
        enemy2.sitThere();
        enemy2.setLocation(757, 193);

        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 817, 221);
        Fill fill2 = new Fill(1, 1, 1);
        addObject(fill2, 601, 225);

        Stage2Platform stage2platform10 = new Stage2Platform(50);
        addObject(stage2platform10, 504, 107);
        removeObject(stage2platform10);
        Stage2Platform stage2platform11 = new Stage2Platform(100);
        addObject(stage2platform11, 503, 119);
        stage2platform11.setLocation(493, 123);
        Stage2Platform stage2platform12 = new Stage2Platform(100);
        addObject(stage2platform12, 1119, 68);

        addObject(thrower1, 493, 72);
        addObject(thrower12, 1123, 42);
        Enemy2 enemy3 = new Enemy2(1);
                enemy3.sitThere();
        addObject(enemy3, 1343, 178);
        enemy3.setLocation(1305, 144);

        Fill fill5 = new Fill(1, 1, 1);
        addObject(fill5, 1393, 171);
        Fill fill6 = new Fill(1, 1, 1);
        addObject(fill6, 1195, 172);

        TrapScrollHidden trapscrollhidden = new TrapScrollHidden();
        addObject(trapscrollhidden, 1816, 136);
        trapscrollhidden.setLocation(1801, 135);
        trapscrollhidden.setLocation(1866, 135);
        TrapScrollHidden trapscrollhidden2 = new TrapScrollHidden();
        addObject(trapscrollhidden2, 2073, 130);
        TrapScrollHidden trapscrollhidden3 = new TrapScrollHidden();
        addObject(trapscrollhidden3, 2301, 129);
        trapscrollhidden2.setLocation(1963, 134);
        trapscrollhidden3.setLocation(2226, 130);
        TrapScrollHidden trapscrollhidden4 = new TrapScrollHidden();
        addObject(trapscrollhidden4, 2139, 135);
        trapscrollhidden3.setLocation(2254, 130);
        trapscrollhidden4.setLocation(2161, 131);
        enemy3.setLocation(1265, 144);
        Stage2Ground stage2ground3 = new Stage2Ground(1000);
        addObject(stage2ground3, 3100, 236);
        stage2ground3.setLocation(3266, 221);
        stage2ground3.setLocation(3438, 198);
        stage2ground3.setLocation(3571, 235);
        stage2ground2.setLocation(2100, 338);
        trapscrollhidden.setLocation(1846, 288);
        trapscrollhidden2.setLocation(1938, 292);
        trapscrollhidden.setLocation(1737, 284);
        trapscrollhidden2.setLocation(1821, 287);
        trapscrollhidden4.setLocation(2149, 283);
        trapscrollhidden3.setLocation(2235, 289);
        trapscrollhidden3.setLocation(2236, 285);
        stage2ground3.setLocation(3140, 184);
        stage2ground3.setLocation(3128, 212);
        enemy3.setLocation(1280, 144);
        Stage2Platform stage2platform13 = new Stage2Platform(300);
        addObject(stage2platform13, 2036, 158);
        stage2platform13.setLocation(1980, 166);
        Fill fill7 = new Fill(1, 1, 1);
        addObject(fill7, 1629, 261);
        Fill fill8 = new Fill(1, 1, 1);
        addObject(fill8, 2532, 270);
        addObject(thrower13, 1893, 78);
        Enemy2 enemy23 = new Enemy2(6);
        addObject(enemy23, 1993, 262);
        enemy23.sitThere();
        Portal portal2 = new Portal(200);
        addObject(portal2, 3468, 128);
    }


   public void act()
   {
       super.act();
        boolean win = false;
        try {
            win = dragon.nextLevel();
            thrower1.setMainPos(getScrolledX()+ dragon.getX(),dragon.getY(),getScrolledX(),getScrolledY());
            thrower12.setMainPos(getScrolledX()+dragon.getX(),dragon.getY(),getScrolledX(),getScrolledY());
            thrower13.setMainPos(getScrolledX()+dragon.getX(),dragon.getY(),getScrolledX(),getScrolledY());
        }
        catch(Exception e) {
            
        }
        if(win && Greenfoot.isKeyDown("w"))
         {         
            
 
            S2L5 l4 = new S2L5();
            Greenfoot.setWorld(l4);
         } 
    }
}
