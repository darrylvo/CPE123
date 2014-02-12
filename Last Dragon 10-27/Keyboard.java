import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) 
import java.io.*;
import java.util.*;
/** 
praise l3noy bas3d g0d
  me(darryl) and lenoy created this class to store scores into a text file. it will check the scores and place them in teh correct order, highest to lowest
 
 */
public class Keyboard extends Actor 
{ 
     private GreenfootImage board; 
    private GreenfootImage sb; 
    public static int score; 
    private String label = "Score: " ; 
    public String string1;
    public String string2="";
    String ha;
    String haha;
    int a;
    public int z=0;
     
     ArrayList<String> name1= new ArrayList<String>();
     ArrayList<Integer> score1 = new ArrayList<Integer>();
    public Keyboard() 
    { 
          
        super(); 
          
        int boardWidth = 150; 
        int boardHeight = 30; 
        int boardTransparency = 125; 
          
        board = new GreenfootImage(boardWidth, boardHeight); 
        board.setColor(java.awt.Color.gray); 
  
        board.setTransparency(boardTransparency); 
        board.fillRect(0, 0, boardWidth, boardHeight); 
        this.setImage(board); 
          
        update(); 
          
        
    } 
    public void act()
    {
        string1=Greenfoot.getKey();
        if (string1 !=null&& string1 !="space" && string1 !="control" && string1 != "shift" &&string1 !="backspace")
        {
            string2 = string2+string1;
            update();
        }
        else if (string1=="backspace"&&string2!=" ")
        {   
            if (string2.length()>0)
            {
            string2 = string2.substring(0,string2.length()-1);
            update();
        }
        }
       // else if (string1=="space"&&string2.isEmpty()==false)
        //{
       //     string2=string2+(" ");
       //     update();
       // }
        
        
        
        
    }
    
    private void update() 
    { 
        sb = new GreenfootImage(board); 
       
        
        sb.drawImage(new GreenfootImage(string2, 18, java.awt.Color.white, new java.awt.Color(0,0,0,0)),25,5); 
    
        this.setImage(sb); 
          
    } 
    public String getString()
    {
        return string2.trim();
        
    }
    public void writeScore()
    {
        Scanner s;
        PrintStream printstream;
        int f;
        EndScore endscore;
        File file;
        try
        {
            file = new File("score/score.txt");
            if(file.exists())
                file.createNewFile();
            file.setWritable(true);
            printstream = new PrintStream(new BufferedOutputStream(new FileOutputStream(file, true)));  
            s = new Scanner(file);
            endscore = new EndScore();
            f = endscore.getEndScore();
        }                                                     
        catch(Exception e)
        {
            e.printStackTrace();
            return;
        }
            if (s.hasNext() == false)
            {
            printstream.println(string2);            
            
            printstream.println(f);  
            
            
            }
            else
            {
                 while (s.hasNext())
               {               
                name1.add(s.next());
                //  System.out.println(name1[z]);
                
                score1.add(s.nextInt());
                // System.out.println(score1[z]);
                z= z+1;
               }
               
               //System.out.println(z);
               
               z=z-1;
               for (int k = name1.size()-1;k>=0;k=k-1)
               {
                  //  System.out.println("stop");
                 if(k==0) {
                     if(f <=score1.get(0)) {
                        name1.add(1,string2);
                        score1.add(1,f);
                        break;
                    }
                     else {
                        name1.add(0,string2);
                        score1.add(0,f);
                        break;
                     }
                 }
                 
                 if( f <=score1.get(k))
                 {  
                        name1.add(k+1,string2);
                        score1.add(k+1,f);
                        break;
                   
             
                 }                                     
               }                                                            
            }    
           s.close();
            printstream.close();
            file.delete();
            File file2;
            PrintStream printstream2;
            try
        {
            file2 = new File("score/score.txt");
            
            file2.setWritable(true);
            printstream2 = new PrintStream(new BufferedOutputStream(new FileOutputStream(file2, true)));  
           
        }                                                     
        catch(Exception e)
        {
            e.printStackTrace();
            return;
        }
        
        for (int p = 0; p<=name1.size()-1;p=p+1)
            {
             //   System.out.println(name1.get(p));
              //  System.out.println(score1.get(p));
                printstream2.println(name1.get(p));
                printstream2.println(score1.get(p));
            }
            
            printstream2.close();
            z=0;
            
            
         
        
            
        
    


}
}







