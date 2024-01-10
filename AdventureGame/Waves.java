
/**
 This class is to put the 2 arrays together to make it easier to code and change later on
 *
 * @Ritik Desai
 * @version 1
 */
import java.util.*;
import java.awt.*;

public class Waves
{
    // instance variables(states)
    private ArrayList<Zombie>zombies;
    private ArrayList<Powerup> powerups;
    
    /**
     * Constructor for objects of class Waves
     */
    public Waves(ArrayList<Zombie> z,ArrayList<Powerup> p)
    {
        // initialise instance variables
        zombies=z;
        powerups=p;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    //getter for zombie
    public Zombie getZombie(int index)
    {
        return zombies.get(index);
    }
    //gets the zombie array length
    public int getZombieLength()
    {
        return zombies.size();
    }
    //getter for powerup array
    public Powerup getPowerup(int index)
    {
        return powerups.get(index);
    }
    //gets the length of the array 
    public int getPowerupLength()
    {
       return powerups.size();
    }
    //used to add a new zombie in the arraylist!
    public void AddZombie(int index,TextArea area){
        double random = Math.random();  
        if(random>=0.5){
                area.append("\nYIKES you got a extra BRUTE ZOMBIE TO FIGHT");
                Zombie z =new BruteZombie();
                zombies.add(index+1,z);

        }else{
                 area.append("\nYOU GOT A EXTRA ZOMBIE TO FIGHT");
                 Zombie z=new Zombie("Zombie",5,2,2);
                 zombies.add(index+1,z);

        }
    }
}
