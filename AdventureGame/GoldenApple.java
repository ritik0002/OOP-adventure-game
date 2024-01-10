
/**
 * Golden apple is the good powerup inwhich the player gains health and a additional effect
 *
 * @author Ritik Desai
 * @version 1
 */
import java.awt.*;
//Gives health and strength for the next 2 rounds
public class GoldenApple extends Powerup
{
    // instance variables - replace the example below with your own
    private int damageTaken;

    /**
     * Constructor for objects of class GoldenApple
     */
    public GoldenApple()
    {
       super("Golden Apple",2);
       damageTaken=1;
    }

    
    public void effect(Player p,TextArea area)
    {
            if(p.getHealth()<=3){
                p.setHealth(getHealth()+2,area);
            }else if(p.getHealth()<=6){
                p.setHealth(getHealth()+1,area);
            }else{
                p.setHealth(getHealth(),area);
            }
    }
    //This method is the after effect which the player can gain the health of a zombie attack once attacked
    public void damageTaken(Player p,Zombie z,TextArea area){
        if(damageTaken==1){
            if(z instanceof BruteZombie){
                p.setHealth(((BruteZombie)z).getWeaponStrength(),area);
                area.append("\n"+((BruteZombie)z).getWeaponStrength()+" has been added");

            }else{
                p.setHealth(z.getStrength(),area);
                area.append("\n"+z.getStrength()+" has been added");
            }
         damageTaken=0;
        }
    }
    //getter 
    public int getDamageTaken()
    {
        return damageTaken;   
    }
    
}
