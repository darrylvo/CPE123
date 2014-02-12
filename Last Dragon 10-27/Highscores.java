import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Highscores extends World
{
    Fill fill = new Fill(100,100,155);
    
    public Highscores()
    {    
        //Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

   public void act()
   {
     if (Greenfoot.mouseClicked(fill))
     {
         IntroScreen intro = new IntroScreen();
        
         Greenfoot.setWorld(intro);
     }
       
       
       
    }
    private void prepare()
    {
        addObject(fill,300,300);
        Leaderboard leaderboard = new Leaderboard(0);
        addObject(leaderboard, 388, 177);
        leaderboard.setLocation(90, 26);
        Leaderboard leaderboard2 = new Leaderboard(2);
        addObject(leaderboard2, 90, 106);
        leaderboard2.setLocation(88, 64);
        Leaderboard leaderboard3 = new Leaderboard(3);
        addObject(leaderboard3, 76, 115);
        leaderboard3.setLocation(89, 101);
        Leaderboard leaderboard4 = new Leaderboard(4);
        addObject(leaderboard4, 89, 165);
        leaderboard4.setLocation(87, 139);
        removeObject(leaderboard4);
        Leaderboard leaderboard5 = new Leaderboard(0);
        addObject(leaderboard5, 110, 160);
        removeObject(leaderboard5);
        Leaderboard leaderboard6 = new Leaderboard(3);
        addObject(leaderboard6, 73, 164);
        leaderboard6.setLocation(87, 147);
        removeObject(leaderboard6);
        Leaderboard leaderboard7 = new Leaderboard(3);
        addObject(leaderboard7, 183, 198);
        removeObject(leaderboard7);
        Leaderboard leaderboard8 = new Leaderboard(4);
        addObject(leaderboard8, 188, 170);
        leaderboard8.setLocation(89, 142);
        removeObject(leaderboard8);
        removeObject(leaderboard3);
        removeObject(leaderboard2);
        removeObject(leaderboard);
        Leaderboard leaderboard9 = new Leaderboard(0);
        addObject(leaderboard9, 97, 54);
        leaderboard9.setLocation(97, 51);
        Leaderboard leaderboard10 = new Leaderboard(1);
        addObject(leaderboard10, 81, 105);
        leaderboard10.setLocation(103, 102);
        Leaderboard leaderboard11 = new Leaderboard(2);
        addObject(leaderboard11, 120, 171);
        leaderboard11.setLocation(126, 152);
        Leaderboard leaderboard12 = new Leaderboard(3);
        addObject(leaderboard12, 115, 214);
        leaderboard9.setLocation(111, 37);
        leaderboard10.setLocation(108, 79);
        leaderboard11.setLocation(126, 130);
        leaderboard12.setLocation(117, 190);
        Leaderboard leaderboard13 = new Leaderboard(4);
        addObject(leaderboard13, 95, 262);
        leaderboard13.setLocation(110, 236);
        Leaderboard leaderboard14 = new Leaderboard(5);
        addObject(leaderboard14, 93, 297);
        Leaderboard leaderboard15 = new Leaderboard(6);
        addObject(leaderboard15, 101, 346);
        Leaderboard leaderboard16 = new Leaderboard(7);
        addObject(leaderboard16, 442, 44);
        Leaderboard leaderboard17 = new Leaderboard(8);
        addObject(leaderboard17, 436, 103);
        Leaderboard leaderboard18 = new Leaderboard(9);
        addObject(leaderboard18, 426, 168);
    }
}
