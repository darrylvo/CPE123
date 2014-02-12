import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
Darryl/lenoy made the health code 
 */

public class PrototypeWorld extends World
{
    Dragon dragon;
    ManaBar manabar;
    ManabarOverlay manabarOverlay;
    Thrower thrower;
    public static int c=3;
    //public static int m=100;
    Heart heart2;
    Heart heart3;
    Heart heart4;
    public int h =0;
    public int regenCounter;
    public Scoreboard scoreboard=new Scoreboard();
    public SimpleTimer timer = new SimpleTimer();
    public Timer timer1 = new Timer();
    private Visual visual;
    
    public PrototypeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1, true); 
        
        prepare();
        timer.mark();
        
        //adds a mana bar
        
    }
    

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        if( c== 3)
        {
            heart2 = new Heart();
            addObject(heart2, 60, 48);
            heart2.setLocation(32, 28);
            heart3 = new Heart();
            addObject(heart3, 91, 34);
            heart3.setLocation(75, 28);
            heart4 = new Heart();
            addObject(heart4, 172, 54);
            heart4.setLocation(118, 29);
        }
        if ( c == 2)
        {
            heart2 = new Heart();
            addObject(heart2, 60, 48);
            heart2.setLocation(32, 28);
            heart3 = new Heart();
            addObject(heart3, 91, 34);
            heart3.setLocation(75, 28);

        }
        if( c == 1)
        {
            heart2 = new Heart();
            addObject(heart2, 60, 48);
            heart2.setLocation(32, 28);

        }

        addObject(scoreboard, 916, 22);
        
        manabar = new ManaBar(300, 300);
        regenCounter = 0;
        //addObject(manabar, 90, 75);
       
        
        
        addObject(timer1, 746, 37);
        timer1.setLocation(744, 19);
        
    }
    
    public void act()
    {
      heart();
      delay();
      regenCounter++;
      
      addMana();
      
    }
    
    public void shake(Heart h) {
        GreenfootImage img = h.getImage();
        h.setLocation(h.getX(),h.getY()+5);
        h.turn(10);
        
    }
    
    public void heart()
    {
        
        try {
            if(heart4.getY()>100) {
                heart4.shrink();
            }
        }
        catch(Exception e) {
            
        }
        try {
            if(heart3.getY()>100) {
                heart3.shrink();
            }
        }
        catch(Exception e) {
            
        }
        try {
            if (c == 2)
            {
                shake(heart4);
                
            }
        }
        catch(Exception e) {
            
        }
        try {
            if(heart4 != null && c==1) {
                    shake(heart4);
            }
        }
        catch(Exception e) {
            
        }
        try {
            if (c == 1)
            {
                shake(heart3);
            }
        }
        catch(Exception e) {
        
        }
        if (c == 0)
        {
            Death death = new Death();
            death.setStage(1);
            Greenfoot.setWorld(death);
        }
    }
    public void damage()
    {
        if ( h<=0)
        {
        c = c-1;
        h=500;
        }
    }
    public void damagetrap()
    {
         GreenfootSound sound1 = new GreenfootSound("sounds/Stab-SoundBible.com-766875573.mp3");
        if ( h<=0)
        {
          c = c-1;
        
           sound1.play();
          h=500;
        
        }
      
        
    }
    
    public void delay()
    {
        h = h-10;
    }
    public void reset()
    {
        c=3;
        timer1.reset();
    }
    public Scoreboard getScoreboard()
    {
        return scoreboard;
    }
    public Timer getTimer()
    {
       return timer1;
    }
    public ManaBar getManaBar()
    {
        return manabar;
    }
    
    public void subtractMana(int m)
    {
        
           //m-=5;
           manabar.add(-m);
           //System.out.println("Subtracted");
        
    }
    
    public void addMana()
    {
        //Can do it this way if we want mana to regen only while moving
        /*if (Greenfoot.isKeyDown("a"))
        {
            manabar.add(5);
        }
        if (Greenfoot.isKeyDown("d"))
        {
            manabar.add(5);
        }*/
        
        //otherwise this lets it just regen slowly
        if(regenCounter % 5 == 0)
        {
            manabar.add(1);
        }
    }
    
    public int getManaValue(ManaDroplet m)
    {
        return m.returnValue();
    }
    
    public void showVisual(String s, int x, int y) {
        visual = new Visual(s,scoreboard);
        addObject(visual,x,y);
    }
    
    
    
}
