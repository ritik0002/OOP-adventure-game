import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Random;
import javax.swing.*;


public class AdventureGame extends Frame implements ActionListener
{  
       static  TextArea area=new TextArea(20,60);
        static TextField tf;
        static Button b;
         static String input;
        static Player Hero;
        static String[][] Filearray;
        static Waves wave;
        static int  i=0;
        static int Index=0;
        static Button power;
        static Button b1;
        static Button b2;
        static Button b3;
        static Button b4;
        static Button b5;
        static Label l;
        static Button start;
        private ArrayList<Integer> Damage;
        static boolean on=true;
        static Label title;
    public AdventureGame()
   {
     setSize(1200,1200);//frame size 1200 width and 1200 height  
     setLayout(null);
    
             start= new Button("Start");
             add(start);
                   start.addActionListener(this);

   setVisible(true);
        start.setBounds(550,300,150,80);
        setBackground(new Color(2, 76, 247));
  
     Damage=new ArrayList<>();
         //Creating objects and using the Substution principle : for zombies array of objects & the powerups array of objects
      ArrayList<Zombie>zombies =new ArrayList<>();
      zombies.add(createZombie("Zombie",5,1,2));
      zombies.add(createBrute());
      zombies.add(createZombie("Zombie",6,2,2));
      zombies.add(createZombie("Zombie",6,3,2));
      zombies.add(createBrute());
      zombies.add(createBoss());
      ArrayList <Powerup> Powerups=new ArrayList<>();
      Powerups.add(createGoldenApple());
      Powerups.add(createCursedEye());
     
      wave= new Waves(zombies,Powerups);
      Random rand = new Random();
      Index = rand.nextInt(Powerups.size());
      power=new Button("Activate Powerup!");
      add(power);
      power.addActionListener(this);
      power.setBounds(290,600,120,70);
      power.setVisible(false);
      title=new Label("Adventure Game!");
         add(title);
         title.setBounds(480,50,300,100);
         title.setFont(new Font("Verdana", Font.PLAIN,32));
         title.setVisible(true);
    }
    public void paint(Graphics g) {  
        if(on==true){
         

         setBackground(new Color(2, 76, 247));
          g.drawOval(425,150,400,400);
         g.fillOval(425,150,400,400);
         g.setColor(Color.RED);

         g.drawRect(350,200,300,300);
         g.fillRect(350,200,300,300);

         g.drawRect(600,200,300,300);
         g.fillRect(600,200,300,300);
         g.setColor(Color.BLACK);

        }  
    } 
    public void name(){
     area.setBounds(500,100, 500,400); 
       area.setBackground(new Color(42, 212, 42));
       add(area);
       area.setEditable(false);
       tf=new TextField("",20);

       tf.setEditable(true);
       add(tf);
       b=new Button("Enter");
       b.setBounds(500,700,100,50);
       l=new Label("Input:");
       l.setBounds(400,580,100,100);
       add(l);
       tf.setBounds(500,600,150,50);
       b.addActionListener(this);
       add(b);
       setVisible(true);
        
        
    }
    public void beginning(){
       area.append("Enter your heroes name");
       Hero=new Player(input,5,3);
       Filearray=readFile();
    }
    
    public void Objective(){
       Hero.setName(input);
         int rowIndex=0;
       boolean valid=false;
       try{
       for(int i=0;i<Filearray.length;i++){
       if(Hero.getName().equals(Filearray[i][0])){
           area.append("Welcome back!\n");
           Player p=new Player(Filearray[i][0],Integer.parseInt(Filearray[i][3]),Integer.parseInt(Filearray[i][2]));
           p.setHealth(-p.getHealth(),area);
           p.setHealth(Integer.parseInt(Filearray[i][1]),area);
           p.setUltimate(Integer.parseInt(Filearray[i][4]),area);
           Hero=p;
           rowIndex=i;
           valid=true;
           break;
        }
    }
    

}catch(NullPointerException e){ }
    if(valid==false){    
       area.append("Your Objective is to to become to ultimate hero! You must defeat the wave of zombies and a boss inorder to become a TRUE HERO!!!\n");
       area.append("Your base Stats: \n Strength:"+Hero.getStrength()+ " your strength determines how much damage you do! the more you fight the higher your strength");
       area.append("Your speed is: "+Hero.getSpeed()+" Your speed determines who attacks first!");
       area.append("Your health is : "+Hero.getHealth() + " if your health reaches 0 you lose! \n");
        }
        
        if(valid==true){
             i=Integer.parseInt(Filearray[rowIndex][5]); 
             valid=false;
        }
          
        
        
        
        
        
    choices();

    }
    
    public void choices(){
        
     b1=new Button("Fight!");
           add(b1);
    b2=new Button("Rest!");
           add(b2);
     b3=new Button("Ultimate!");
           add(b3);
   b4=new Button("Display Stats");
       add(b4);
    b5=new Button("Quit button/Checkpoint");
       add(b5);
       b1.setBounds(420,600,120,70);
       b2.setBounds(550,600,120,70);
       b3.setBounds(680,600,120,70);
       b4.setBounds(810,600,120,70);
       b5.setBounds(940,600,120,70);
       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       b4.addActionListener(this);
       b5.addActionListener(this);
       setVisible(true);
      
       Hero.getStats(area);
       area.append("\nYou Are fighting:\n");
       wave.getZombie(i).getStats(area);
       check();

          
        
    }
         public void actionPerformed(ActionEvent evt){
             
             if(evt.getActionCommand().equals("Start")){
                on=false;
                name();
                start.setVisible(false);
                title.setVisible(false);
                repaint();     

            }
             if(evt.getActionCommand().equals("Enter")){
                input=tf.getText();
                tf.setText("");
                area.append("\n");
                area.append("hello "+input);
                area.append("\n");
                tf.setEditable(false);
                tf.setVisible(false);
                b.setVisible(false);
                l.setVisible(false);
                Objective();
            }
            if(i>=wave.getZombieLength()){
                    area.append("\nCongratulations you have defeated the wave!!!");
                    area.append("\nyou have now become the Hero the town deserved!");
                    try{     
                        Thread.sleep(4000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    System.exit(0);
             }
              if(evt.getActionCommand().equalsIgnoreCase("Activate Powerup!")){
                                    ((GoldenApple)(wave.getPowerup(Index))).damageTaken(Hero,wave.getZombie(i),area);
                                    area.append("\n POWERUP HAS BEEN ACTIVATED!");
                                    power.setVisible(false);
                                }
            if(evt.getActionCommand().equals("Fight!")){
                 area.append("\nYou choose to fight!!");
                 Damage.add(Hero.getStrength());
                 if(Damage.size()>=5){
                    area.append("\n Before you fight a A mysterious smoke smells the bloodlust");
                    Collections.shuffle(Damage);
                    int range=Damage.get(Damage.size()-1)-Damage.get(0);
                    Damage.clear();
                    if(range<0){
                        int absDamage=Math.abs(range);
                        area.append("\n you have taken "+absDamage+" Damage");
                        Hero.setHealth(range,area);
                    }else if(range>0){
                        area.append("\n you have gained "+range +"health .");
                        Hero.setHealth(range,area);

                    }else{
                     area.append("\n the smoke clears");   
                    }
                }
                 Hero.Fight(wave.getZombie(i),area);
                 if(i>=(wave.getZombieLength()/2) && wave.getZombie(i).dead()==false){

                       if(wave.getPowerup(Index) instanceof CursedEye){
                           if(((CursedEye)(wave.getPowerup(Index))).getCurse()==true){
                               ((CursedEye)(wave.getPowerup(Index))).Cursed(Hero,area);
                            }
                            
                  }if(wave.getPowerup(Index) instanceof GoldenApple){
                             if(((GoldenApple)(wave.getPowerup(Index))).getDamageTaken()==1){
                                area.append("\npress Activate powerup button to use GOLDEN Apply abillity to restore health!(1 time use) ");
                                power.setBounds(290,600,120,70);
                                power.setVisible(true);
    
                            }
                               
                           }
                   }
                 if(wave.getZombie(i).dead()==true && i<wave.getZombieLength()){
                    i++;
                    Hero.getStats(area);
                    area.append("\nYou Are fighting:\n");
                    wave.getZombie(i).getStats(area);
                
                    
    
                    
                    
                }
              Hero.setUltimate(1,area);

            }
            
         
         
         if(evt.getActionCommand().equals("Rest!")){
                    area.append("\nYou choose to Rest!!");
                    Hero.Rest(area);
                    Hero.setUltimate(1,area);
                    area.append("\nAs you rest The Zombies Attack!!!!");
                    wave.getZombie(i).attack(Hero,area);
                    area.append("");
                    Hero.dead(area);
                    Hero.getStats(area);
                   
         }
         if(evt.getActionCommand().equals("Ultimate!")){
             area.append("\nYou choose to use your ULTIMATE!!");
             Hero.useUltimate(area);
              Hero.getStats(area);
              Hero.resetUltimate();
         }
         if(evt.getActionCommand().equals("Display Stats")){
             area.append("\nYou choose to display your STATS!!");
      
             Hero.getStats(area);
             area.append("");
         }
         if(evt.getActionCommand().equals("Quit button/Checkpoint")){
            area.append("\nYou choose to quit-when you reenter the game please enter The correct hero name or it will start a new character and previous data may be deleted!!");
            writeNameScore(Hero,i);
            System.exit(0);
        }
    }
        
    public void check(){
     if(wave.getZombie(i) instanceof BruteZombie){
              ((BruteZombie)wave.getZombie(i)).weapon(Hero,area); //Casts so it can do the non inherited method
      }
           //Gain a buff or negative powerup at the middle of the wave!
           if(i==((int)(wave.getZombieLength()/2))){
               area.append("\n");
               area.append("\nYou have Found a  RANDOM BOX it may contain Something good Or Something bad...");
                        area.append("\nYou open it!! What could it be!? lets see....");
                        area.append("\nYou got a "+wave.getPowerup(Index).getName());
                        wave.getPowerup(Index).effect(Hero,area); //Polymorphism
                        if(wave.getPowerup(Index) instanceof GoldenApple){  
                            area.append("\nThe Golden apple has another ability once you've been attacked you can choose to press q");
                            area.append("\nThis lets you Regain health lost from 1 attack!");
                        }else{
                          area.append("\nYou got the Cursed Eye!");
                          area.append("\nHAHAHAHA EXTRA ZOMBIE has been SPAWNED\n");
                          wave.AddZombie(i,area);
                        }
                    }
                }
            
         //This method takes gets the users input and returns the the user input as the input.
    public static String InputString(String message) {
        String input;
        Scanner scanner= new Scanner(System.in); //creates a link to the keyboard 
        area.append(message);
        input=scanner.nextLine();
        return input;
    }
    //This method creates a zombie object
    public static Zombie createZombie(String name,int health,int speed,int Strength)
    {
     Zombie z=new Zombie(name,health,speed,Strength);
     return z;
    }
   //Creates a brute zombie
    public static Zombie createBrute(){
        Zombie z =new BruteZombie();
        return z;
    }
    //Creates a boss zombie object
    public static Zombie createBoss(){
     Zombie z =new bossZombie(); 
     return z;   
    }
    //creates a golden apple object
    public static Powerup createGoldenApple()
    {
        Powerup p=new GoldenApple();
        return p;
    }
    //Creates a cursed eye object
     public static Powerup createCursedEye()
    {
        Powerup p=new CursedEye();
        return p;
    }
    //This method writes the names and scores
    public static void writeNameScore(Player p,int index){
           try{
               PrintWriter Writer =new PrintWriter(new FileWriter("savefile.txt",false)); 
               Writer.println(p.getName()+","+p.getHealth()+","+p.getSpeed()+","+p.getStrength()+","+p.getUltimate()+","+index); //writes the names and scores (split by a comma) to the fil
        Writer.close(); 
           }catch(IOException e){ 
               System.out.println("ERROR");
           }
            

        }
        public static String[][] readFile(){
            try{
            String[] rowSplit; 
        BufferedReader reader=new BufferedReader(new FileReader("savefile.txt")); //reads the contents of the buffer
        int rowCount=0;
        while (reader.readLine() != null) {  //Counts how many rows are in the file
            rowCount++; //increment rowCount (determines how many rows there are)
        }
        reader.close(); //closes the file so the reader can be reset
        BufferedReader Reader=new BufferedReader(new FileReader("savefile.txt")); //reads the contents of the buffer 
        String[][] Array=new String[rowCount][6]; //creates a array with 5 columns and the total rows in the file
        for(int i=0;i<rowCount;i++) {
            rowSplit=Reader.readLine().split(","); //splits the 2d array into rows using the rowSplit array
            for(int j=0;j<6;j++) {
            Array[i][j]=rowSplit[j];
        } 
         Reader.close(); //closes the file
         return Array;
    }   
        }catch(IOException e){ 
               System.out.println("ERROR");
               return null;
            }
       
         return null;       
        }
 
    
    public static void main(String [] args)
    {
       
     AdventureGame t= new AdventureGame();
         t.beginning();


   }
}

