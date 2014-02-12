import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S2L2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class S2L3 extends SWorld
{

    /**
     * Constructor for objects of class S2L2.
     * 
     */
    public S2L3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(4000, 400, 1,4000); 
        addMainActor(new Stage2Dragon(), 100, 200, 50, 300);
        GreenfootImage bg = new GreenfootImage("scrollingbg.png");
        setScrollingBackground(bg);

        prepare();
    }


    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Stage2Ground stage2ground = new Stage2Ground(429);
        addObject(stage2ground, 507, 345);
        stage2ground.setLocation(503, 343);
        stage2ground.setLocation(499, 343);
        Stage2Platform stage2platform2 = new Stage2Platform(100);
        addObject(stage2platform2, 1343, 103);
        stage2platform2.setLocation(1347, 111);
        Stage2Platform stage2platform3 = new Stage2Platform(100);
        addObject(stage2platform3, 1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1259, 343);
        stage2platform3.setLocation(1003, 89);
        stage2platform2.setLocation(1241, 213);
        stage2platform3.setLocation(1091, 93);
        stage2platform2.setLocation(1199, 319);
        stage2platform3.setLocation(1395, 109);
    }
}
