import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class IntroScreen here.
 * 
 * @author Jessica Chao & Darryl Vo did leaderboard
 * @version (a version number or a date)
 */
public class IntroScreen extends World
{
    
    private GreenfootSound bkgMusic;
    Fill fill = new Fill(50, 50, 0);
    
    Fill fill3 = new Fill(100, 100, 150);
    /**
     * 
     * 
     */
    public IntroScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 

        bkgMusic = new GreenfootSound("sounds/The Descent.mp3");
        /* The Descent found on incompetech.com by Kevin Macleod*/
        bkgMusic.playLoop();

        prepare();
    }

    /* Darryl made the fill */
    public void act()
    {   
              
        MouseInfo ms = Greenfoot.getMouseInfo(); 
        try {
            if((ms.getX()<460 || ms.getX()>560) || (ms.getY()<300 || ms.getY()>340)){
                darken(fill,459,295); //if user outside area darken the rectangular box
            }
        }
        catch(NullPointerException e) {
            
        }
        try {
            if((ms.getX()<790 || ms.getX()>890) || (ms.getY()<45 || ms.getY()>145)){
                darken(fill3,787,41); //if user outside area darken the rectangular box
            }
            
        }
        catch(NullPointerException e) {
            
        }
        try {
            if((ms.getX()>460 && ms.getX()<560) && (ms.getY()>300 && ms.getY()<340)) {
                lightUp(fill,459,295); //if user inside area lighten up
            }
            
        }
        catch(NullPointerException e) {
            
        }
        try {
            if((ms.getX()>790 && ms.getX()<890) && (ms.getY()>45 && ms.getY()<145)) {
                lightUp(fill3,787,41); //if user inside area lighten up
            }
        }
        catch(NullPointerException e) {
            
        }
        if (Greenfoot.mouseClicked(fill))
            { 
                Cutscene1 cs1 = new Cutscene1();
                Greenfoot.setWorld(cs1);
                bkgMusic.stop();
            }
        if (Greenfoot.mouseClicked(fill3))
        {
            Highscores h = new Highscores();
            Greenfoot.setWorld(h);
            bkgMusic.stop();
        }
    }
    
    /* Lenoy made lightUp and darken */
    public void lightUp(Fill f,int x, int y) { //Creates a rectangular box that lights
        GreenfootImage img = getBackground();
        img.setColor(java.awt.Color.WHITE);
        img.setTransparency(1); 
        img.drawRect(x,y,f.getImage().getWidth()+1,f.getImage().getHeight()+1);
        setBackground(img);    
    }
    
    public void darken(Fill f,int x, int y) { //Creates a rectangular box that gets darker
        GreenfootImage img = getBackground();
        img.setColor(Color.BLACK);
        img.setTransparency(5); 
        img.drawRect(x,y,f.getImage().getWidth()+1,f.getImage().getHeight()+1);
        setBackground(img);    
    }
    

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {

        addObject(fill, 502, 301);
        fill.setLocation(488, 320);
        fill.set(100, 49);
        fill.setLocation(509, 319);
        fill.setLocation(512, 315);
        fill.setLocation(511, 320);
        Fill fill = new Fill(50, 50, 1);
        addObject(fill, 808, 126);
        fill.setLocation(795, 149);

        addObject(fill3, 817, 220);
        fill3.setLocation(838, 92);

        HallofFame halloffame = new HallofFame();
        addObject(halloffame, 846, 96);
        halloffame.setLocation(840, 90);
        removeObject(halloffame);
        removeObject(fill3);
    }
}
