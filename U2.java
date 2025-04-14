package SpaceProj;
import java.util.Random;

public class U2 extends Rocket{
    private double chanceLaunchExplosion = 0.04;
    private double chanceLandingCrash = 0.08;

    public U2(){
        this.currentWeight = 18000;
        this.maxWeight = 29000;
        this.cost = 120;

    }

    @Override
    public boolean launch(){
        Random random = new Random();
        double randomNumber = random.nextDouble(); // Generates a random number between 0.0 - 1.0(exclusive)
        double survivalRate = chanceLaunchExplosion * (maxWeight / currentWeight);
        if (randomNumber > survivalRate){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean land(){
        Random random = new Random();
        double randomNumber = random.nextDouble(); // Generates a random number between 0.0 - 1.0(exclusive)
        double survivalRate = chanceLandingCrash * (maxWeight / currentWeight);
        if (randomNumber > survivalRate){
            return true;
        }else{
            return false;
        }
    }
}
