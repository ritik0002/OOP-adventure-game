
/**
 * Cursed eye is the bad powerup where the player loses strength and a additional effect
 *
 * @Ritik Desai
 * @version 1
 */
import java.awt.*;
public class CursedEye extends Powerup
{
    // instance variables - replace the example below with your own
    private int Strength;
    private boolean curse;

    /**
     * Constructor for objects of class CursedEye
     */
    public CursedEye()
    {
        // initialise instance variables
        super("Cursed Eye",-2);
        Strength=-2;
        curse=true;
    }
    //getter
    public int getStrength()
    {
        return Strength;
    }
    //setter
    public void setStrength(int value)
    {
        Strength=value;
    }
    
    public void effect(Player p,TextArea area)
    {
       p.setHealth(getHealth(),area);
       p.setStrength(p.getStrength()-getStrength());
    }
    //after effect  player loses Strength until their Strength is less than 4
    public void Cursed(Player p,TextArea area)
    {
     area.append("\nYou picked up a cursed OBJECT!");
     area.append("\nYou become Cursed! you lose Strength  each round until your strength becomes less than 4!");
     if(p.getStrength()<=3){
         curse=false;
     }else{
         setStrength(1);
         p.setStrength(p.getStrength()-getStrength());
         area.append("Your Strength from being cursed is..."+p.getStrength());
  
         
     }
    }
    //getter
    public boolean getCurse(){
         return curse;   
    }
}
