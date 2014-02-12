import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends PrototypeWorld
{
     private static GreenfootSound bkgMusic = new GreenfootSound("sounds/Hitman.mp3");
     
    private GreenfootSound sound;
    public Dragon dragon;
    public ManaBar manabar;
    public Portal portal;
    
    public Level1()
    {   
        prepare();
        
        bkgMusic = new GreenfootSound("sounds/Our Story Begins.mp3");
        bkgMusic.playLoop();
        //manabar = new ManaBar(300, 300);
    }

    
    private void prepare()
    {
       
        Ground ground = new Ground(1000);
        addObject(ground, 510, 250);
        ground.setLocation(514, 238);
        ground.setLocation(439, 246);
        ground.setLocation(501, 356);

        GreenfootImage img = ground.getImage();
        //img.scale(300,76);
        //ground.setImage(img);
        dragon = new Dragon();
        addObject(dragon, 61, 284);
        portal = new Portal(200);
        addObject(portal, 897, 237);
        portal.setLocation(918, 239);
        manabar = getManaBar();
        addObject(manabar, 90, 75);
        manabarOverlay = new ManabarOverlay();
        addObject(manabarOverlay, 88, 75);
    }
    
     public void act()    
    {
        super.act();
        
         if(dragon.nextLevel() && Greenfoot.isKeyDown("w"))
         {
            Timer timer = getTimer();
            timer.all();
            
   
            
             Level2 level2 = new Level2();
            Greenfoot.setWorld(level2);
         } 
    }
     public static void stopBackgroundMusic()
    {
        bkgMusic.stop();
    }
}
