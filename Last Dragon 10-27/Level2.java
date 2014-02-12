import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends PrototypeWorld
{
    private GreenfootSound sound;
     public Dragon dragon;
     public ManaBar manabar;
     public ManabarOverlay manabayoverlay;
    
    
    public Level2()
    {   
         GreenfootSound s = new GreenfootSound("sounds/teleport.mp3");
            s.play();
        prepare();
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
        Portal portal = new Portal(200);
        addObject(portal, 897, 237);
        portal.setLocation(918, 239);
        Block block = new Block();
        addObject(block, 334, 193);
        block.setLocation(340, 211);
        block.setLocation(320, 237);
        Block block2 = new Block();
        addObject(block2, 486, 171);
        portal.setLocation(482, 87);
        block2.setLocation(712, 165);
        block.setLocation(448, 223);
        portal.setLocation(708, 83);
        block.setLocation(470, 221);
        removeObject(block);
        removeObject(block2);
        Ground ground2 = new Ground(250);
        addObject(ground2, 704, 205);
        ground2.setLocation(412, 250);
        portal.setLocation(708, 81);
        portal.setLocation(746, 69);
        portal.setLocation(784, 65);
        Ground ground3 = new Ground(250);
        addObject(ground3, 812, 153);
        ground3.setLocation(732, 159);
        portal.setLocation(740, 63);
        portal.setLocation(732, 65);
        
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
            
          
         Level3 level3 = new Level3();
        Greenfoot.setWorld(level3);
      }
       
        
    }
}