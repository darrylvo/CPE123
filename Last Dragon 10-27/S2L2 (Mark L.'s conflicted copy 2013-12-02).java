import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class S2L2 extends SWorld
{

    Stage2Dragon dragon = new Stage2Dragon();
    public ManaBar manabar;
    GreenfootImage img;
    Thrower1 thrower1;
    public S2L2()
    {            
        super(4000, 400, 1, 4000,400); 
        addMainActor(dragon, 50, 220, 50, 300);
        img = new GreenfootImage("plainsbg.png");
        setScrollingBackground(img);
        thrower1 = new Thrower1(1);
        prepare();
    }
    public void act()
   {
       super.act();
        boolean win = false;
        try {
            win = dragon.nextLevel();
            thrower1.setMainPos(getScrolledX() + dragon.getX(), dragon.getY(),getScrolledX());
        }
        catch(Exception e) {
            
        }
        if(win && Greenfoot.isKeyDown("w"))
         {         
            
 
            S2L3 l3 = new S2L3();
            Greenfoot.setWorld(l3);
         } 
    }
   
    private void prepare()
    {
        manabar = getManaBar();
        addObject(manabar, 90, 75, false);
        
        Stage2Platform stage2platform = new Stage2Platform(250);
        addObject(stage2platform, 146, 317);
        Stage2Platform stage2platform9 = new Stage2Platform(200);
        addObject(stage2platform9, 433, 246, false);
        stage2platform9.setLocation(399, 243);
        Stage2Platform stage2platform10 = new Stage2Platform(250);
        addObject(stage2platform10, 647, 323);
        stage2platform10.setLocation(647, 320);
        stage2platform10.setLocation(648, 341);
        stage2platform9.setLocation(395, 244);
        Fill fill = new Fill(1, 1, 1);
        addObject(fill, 307, 192);
        Fill fill2 = new Fill(1, 1, 1);
        addObject(fill2, 488, 189);
        Enemy2 enemy2 = new Enemy2(2);
        addObject(enemy2, 390, 202);
        enemy2.setLocation(375, 193);
        Stage2Platform stage2platform4 = new Stage2Platform(3);
        addObject(stage2platform4, 922, 256);
        removeObject(stage2platform4);
        Stage2Platform stage2platform5 = new Stage2Platform(200);
        addObject(stage2platform5, 917, 260);
        stage2platform5.setLocation(914, 251);
        Fill fill3 = new Fill(1, 1, 1);
        addObject(fill3, 822, 199);
        Fill fill4 = new Fill(1, 1, 1);
        addObject(fill4, 1010, 207);
        Fill fill5 = new Fill(1, 1, 1);
        addObject(fill5, 766, 295);
        Fill fill6 = new Fill(1, 1, 1);
        addObject(fill6, 534, 290);
        Enemy1 enemy1 = new Enemy1(5);
        addObject(enemy1, 656, 290);
        Enemy2 enemy22 = new Enemy2(5);
        addObject(enemy22, 914, 207);
        Stage2Ground stage2ground = new Stage2Ground(800);
        addObject(stage2ground, 1542, 344);
        stage2ground.setLocation(1446, 340);
        Stage2Platform stage2platform6 = new Stage2Platform(100);
        addObject(stage2platform6, 1406, 47);
        stage2platform6.setLocation(1272, 52);
        removeObject(stage2platform6);
        Stage2Platform stage2platform7 = new Stage2Platform(100);
        addObject(stage2platform7, 1752, 96);
        stage2platform7.setLocation(1800, 191);
        addObject(thrower1, 1814, 160);
        Stage2Platform stage2platform8 = new Stage2Platform(300);
        addObject(stage2platform8, 2032, 269);
        Fill fill7 = new Fill(1, 1, 1);
        addObject(fill7, 2172, 216);
        Fill fill8 = new Fill(1, 1, 1);
        addObject(fill8, 1896, 213);
        Enemy2 enemy23 = new Enemy2(10);
        addObject(enemy23, 2028, 225);
        enemy23.setLocation(2017, 220);
        Stage2Ground stage2ground2 = new Stage2Ground(1000);
        addObject(stage2ground2, 2804, 348);
        stage2ground2.setLocation(2813, 337);
        Fill fill9 = new Fill(1, 1, 1);
        addObject(fill9, 2338, 295);
        Fill fill10 = new Fill(1, 1, 1);
        addObject(fill10, 2552, 291);
        Enemy1 enemy12 = new Enemy1(10);
        addObject(enemy12, 2426, 293);
        enemy12.setLocation(2427, 285);
        Fill fill11 = new Fill(1, 1, 1);
        addObject(fill11, 2730, 297);
        Fill fill12 = new Fill(1, 1, 1);
        addObject(fill12, 2980, 287);
        Enemy2 enemy24 = new Enemy2(10);
        addObject(enemy24, 2896, 300);
        enemy24.setLocation(2888, 284);
        Fill fill13 = new Fill(1, 1, 1);
        addObject(fill13, 3313, 281);
        Fill fill14 = new Fill(1, 1, 1);
        addObject(fill14, 3086, 292);
        Enemy1 enemy13 = new Enemy1(10);
        addObject(enemy13, 3218, 291);
        enemy13.setLocation(3216, 282);
        addObject(stage2platform9, 3505, 254);
        Stage2Ground stage2ground4 = new Stage2Ground(400);
        addObject(stage2ground4, 3702, 248);
        stage2ground4.setLocation(3556, 248);
        Portal portal2 = new Portal(200);
        addObject(portal2, 3693, 175);
        portal2.setLocation(3726, 176);
        stage2ground4.setLocation(3591, 248);
    }
}
