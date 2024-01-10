
/**
 * Zombie class sets what each zombie is able to do 
 *
 * @Ritik Desai
 * @version 1
 */
import java.awt.*;
public class Zombie extends characters
{
    // instance variables - replace the example below with your own
    private boolean ranged;

    /**
     * Constructor for objects of class Zombie
     */
    public Zombie(String name,int health,int Speed,int Strength)
    {
        // initialise instance variables
        super(name,health,Speed,Strength);
        ranged=setRange();
    }
    
    //method randomises the chance for it be ranged or not
    public boolean setRange()
    {
        double random = Math.random();  
        if(random>=0.5){
            ranged=true;
        }else{
            ranged=false;
       
        }
        return ranged;
    }
    //getter for range
    public boolean getRanged()
    {
        return ranged;
    }
    //attack method used to deal damage to the player
    public void attack(Player p,TextArea area)
    {
        if(ranged==true){
            area.append("\n A ranged Zombie has attacked you! He gets double the attacks!!");
            p.setHealth(-getStrength(),area);
            p.setHealth(-getStrength(),area);
            area.append("\n OUCHH your health is "+p.getHealth());
        }else{
            area.append("\n A normal Zombie has attack you!Watch out they can be pretty lethal!!!\n");
            p.setHealth(-getStrength(),area);
            area.append("\n Players health now is "+p.getHealth());

        }
    }
        //Overrided method
    public void getStats(TextArea area)
    {
        super.getStats(area);
        area.append("\n Zombie is ranged = "+ranged);
    }
    
    
}
