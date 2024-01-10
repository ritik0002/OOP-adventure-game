
/**
 * bossZombie inherits properties from zombie class and is able to do a additional attack
 *
 * @Ritik Desai
 * @version 1
 */
import java.awt.*;
import java.awt.event.*;
public class bossZombie extends Zombie
{
    // instance variables - replace the example below with your own
    private boolean ChargedAttack;
    private int bossHit;

    /**
     * Constructor for objects of class bossZombie
     */
    public bossZombie()
    {
        // initialise instance variables
        super("BOSS ZOMBIE",15,2,2);
        ChargedAttack=false;
    }

    @Override 
    public void attack(Player p,TextArea area)
    {
        setRange();
        chargedAttack();
        if(getRanged()==true && getChargedAttack()==true){  //Must be ranged and have a charged attack inorder to do 2.5x damage!
            Bigattack(p,area);
            SetChargedAttack();
        }else if(getRanged()==true){
                area.append("\nThe boss ZOMBIE is doing a RANGED ATTACK He will hit twice!!");
                p.setHealth(-getStrength(),area);
                p.setHealth(-getStrength(),area);
        
       }else{
            area.append("\nA boss Zombie has attack you!Watch out they can be pretty lethal!!!");
            p.setHealth(-getStrength(),area);
            area.append("\nPlayers health now is "+p.getHealth());

        }
    }
    //55% chance of getting charged attack
    public void chargedAttack()
    {
     double random = Math.random(); 
     if(random>0.45){
         ChargedAttack=true;
        }
        
    }
    //sets charged attack to false
    public void SetChargedAttack()
    {
        ChargedAttack=false;   
    }
    //getter
    public boolean getChargedAttack()
    {
        return ChargedAttack;
    }
    //The Stronger attack which the boss can do determined by the boolean ChargedAttack
    public void Bigattack(Player p,TextArea area){
        if(ChargedAttack==true){
            bossHit=(int)(getStrength()*2.5);
            area.append("\nTHE BOSS HAS USED HIS CHARGED ATTACK!:");
            p.setHealth(-bossHit,area);
        }
    }
}
