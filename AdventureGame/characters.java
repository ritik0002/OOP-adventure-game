
/**
 * This class is the super class used for all my characters in my game
 *
 * @Ritik Desai
 * @version 1
 */
import java.awt.*;
public abstract class characters
{
    //instance variables (States)
    private int health;
    private String name;
    private int strength;
    private int speed;
    /**
     * Constructor for objects of class characters
     */
    public characters(String name,int health,int speed, int strength)
    {
        // initialise instance variables
        this.health=health;
        this.name=name;
        this.speed=speed;
        this.strength=strength;
    }
    //getter for health
    public int getHealth()
    {
     return health;   
    
    }
    //getter for speed
    public int getSpeed()
    {
        return speed;
    }
    //setter for speed
    public void setSpeed(int speed)
    {
         this.speed=speed;
    }
    //getter for strength
    public int getStrength()
    {
        return strength;
    }
    //setter for strength
    public void setStrength(int value)
    {
        strength=value;
    }
    //setter for health
    public void setHealth(int h,TextArea area)
    {
        health+=h;
        if(health<0){
         health=0;   
        }
        area.append("\n"+name+" health is "+getHealth());
    }
    //setter for name
    public String getName()
    {
        return name;
    }
    public void setName(String n){
        name=n;   
    }
    //outputs the description 
    public void getStats(TextArea area)
    {
        
     if(health<0){
         setHealth(-getHealth(),area);
      }
     area.append(name);
     area.append("\nA health of "+getHealth());
     area.append("\nA strength of "+getStrength());
     area.append("\nA speed of "+getSpeed());
     
    }
    //checks if character is dead 
    public boolean dead(){
        if(health<=0){
            return true;
        }
        else{
            return false;
        }
    }
    
}
