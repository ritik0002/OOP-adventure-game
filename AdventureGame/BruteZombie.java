
/**
 * Brute Zombie inherits properties from zombie class and is able to have a additional weapon
 *
 * @Ritik Desai
 * @version 1
 */
import java.awt.*;
import java.awt.event.*;
public class BruteZombie extends Zombie
{
    // instance variables - replace the example below with your own
    String weapon;
    int weaponStrength;
   
    
    //Constructor 
    public BruteZombie()
    {
        super("bruteZombie",8,2,1);
        weapon="bat";
        weaponStrength=0;
        
    }
  
    @Override 
   public void attack(Player p,TextArea area)
   {
    if(getRanged()==true &&(p.getStrength()>2)){
            area.append("\nA ranged  BRUTE Zombie has attacked you! This means that He attacks you and lowers your Strength!");
            p.setHealth(-(getStrength()+getWeaponStrength()),area);
            p.setStrength(p.getStrength()-1);
            area.append("\nOUCHH your health is "+p.getHealth());
            area.append("\nOuch Your Strength is"+p.getStrength());
        }else{
            area.append("\nA  Brute Zombie has attacked you!Watch out they can be pretty lethal!!!");
            p.setHealth(-(getStrength()+getWeaponStrength()),area);
            area.append("\nPlayers health now is "+p.getHealth());

        }        
    }
    
    public void weapon(Player p,TextArea area){
        double random = Math.random(); 
        if(random<=0.25){
            //Halfs Player Speed
            weapon="Katana";
            p.setSpeed(p.getSpeed()/2);
            area.append("\nWeapon is the deadly katana, Player speed has been Halfed!");
        }
        else if(random<=0.5){
            weapon="bat";
            weaponStrength=1;
            area.append("\nThe Brute has a bat ");
        }
        else if(random<=0.75){
            weapon="Nothing";
            weaponStrength=0;
            area.append("\nThe brutes weapon Strength is 0!");
        }
        else{
            weapon="GOD AXE";
            area.append("\nThe brute has a GOD axe yikes! His weapon Has 3 damage and decreases the player Strength!");
            weaponStrength=3;
            p.setSpeed(p.getStrength()-1);
        }
    }
    
    //getter 
    public int getWeaponStrength(){
        return weaponStrength;
    }
    
     @Override           
    public void getStats(TextArea area)
    {
     super.getStats(area);
     area.append("\nWeapon he is holding is "+weapon);
     area.append("\nWeapon Strength is "+weaponStrength);
    }
    
  }
    
