
/**
 * Superclass inwhich all powerups have the properties of
 *
 * @Ritik Desai
 * @version 1
 */
import java.awt.*;
public abstract class Powerup
{
    // instance variables 
    private String name;
    private int Health;

    /**
     * Constructor for objects of class Powerup
     */
    public Powerup(String name,int health)
    {
      this.name=name;
      Health=health;
    }
    //getter 
    public String getName(){
     return name;   
    }
    //setter
    public int getHealth(){
        return Health;
    }

    //effect of the powerup 
    public abstract void effect(Player p,TextArea area);
}
