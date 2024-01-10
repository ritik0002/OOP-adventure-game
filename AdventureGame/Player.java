
/**
 This class is what attributes and methods the player has 
 *
 * @Ritik Desai
 * @version 1
 */
import java.awt.*;

public class Player extends characters
{
    
    private int ultimateCount; //Check to see if Ultimate is ready or not
    
    public Player(String name,int Strength,int speed)
    {
       super(name,12,Strength,speed);
       ultimateCount=0;
    }
    
  

    //if player chooses to fight attack zombie!
    public void Fight(Zombie Enemy,TextArea area)
    {
       if(getSpeed()>Enemy.getSpeed()){ //checks if player speed is higher  if so player attacks first!
            area.append("\nYour speed is "+getSpeed()+" you are quicker!!! you attack first\n");
            Enemy.setHealth(-this.getStrength(),area);
            decreaseSpeed(area);
            if(Enemy.dead()==true){
                area.append(Enemy.getName()+" is dead");
                area.append("\nYou were victorous your speed will be reset and gain 2 additional health!");
                setHealth(3,area);
                setSpeed(7);
                setStrength(5);
                return; //exit method
            }
            area.append("\nThe "+Enemy.getName()+" now attacks!!!");
            Enemy.attack(this,area);
            dead(area);
            
        }
        else{ //else checks if enemy speed is higher they attack first then the player attacks
            area.append("\nYou are slower and thus attacked second!!");
            Enemy.attack(this,area);
            dead(area);
            Enemy.setHealth(-this.getStrength(),area);
            decreaseSpeed(area);
            if(Enemy.dead()==true){
                area.append("\n"+Enemy.getName()+" is dead");
                System.out.println("\nYou were victorous your speed will be reset and gain 2 additional health!");
                setHealth(3,area);
                setSpeed(7);
                setStrength(3);
                return;
            }

        }
        
    } //getter
    public int getUltimate(){
     return ultimateCount;   
    }
    //This method is when the user rests which gives the user health,strength and speed
    public void Rest(TextArea area){
        if(getSpeed()<=6){
            setSpeed(getSpeed()+2);    
            setStrength(getStrength()+3);
            setHealth(1,area);
            area.append("\nYou decide to rest! your speed is now "+getSpeed()+" and your strength is "+getStrength() +"and your health is "+getHealth());;
        }else{
            setSpeed(7);
        area.append("\nYou have the max amount of speed!!"+getSpeed());    
        }
    }//ultimate gives user health,speed,strength (ultimate takes 5 charges to charge)
    public void useUltimate(TextArea area){
     if(getUltimate()==5){
        setStrength(getStrength()+2);; 
        setSpeed(7);
        setHealth(3,area);
      }else
      {
          area.append("\nUltimate is NOT READY");
      }
    }//setter
    public void setUltimate(int value,TextArea area){
     if(ultimateCount==5){
         area.append("\nYour ultimate is fully charged!");
     }else{
         ultimateCount+=value;
         }
    }//resets instance variable to 0
    public void resetUltimate(){
     ultimateCount=0;   
    }//decreases speed
    public void decreaseSpeed(TextArea area){
        if(getSpeed()>1){
            setSpeed(getSpeed()-1);
            area.append("\nYou grow tired your speed decreases!Your speed is now "+getSpeed());
        }
    }

    public void getStats(TextArea area)
    {
        area.append("\nYour Stats:\n");
        area.append("\nYour health is: "+getHealth());
        area.append("\nYour Current Strength: "+getStrength());
        area.append("\nYour Current Speed :"+getSpeed());
        if(getUltimate()==5){
            area.append("\nUltimate Status: UlTIMATE IS READY!");

        }else{
            area.append("\nUltimate Status:"+ getUltimate()+"/5");
        }
  
        
    }
   
    public boolean dead(TextArea area){
        if(getHealth()<=0){
           try {
                area.append("\n\nYOU DIED! GAME OVER GOODBYE!");
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
             }
            System.exit(0);
            return true;
        }
        else{
         return false;   
        }
    }
}