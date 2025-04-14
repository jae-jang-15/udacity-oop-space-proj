package SpaceProj;
import java.util.Random;

public class U1 extends Rocket{
    private double chanceLaunchExplosion = 0.05;
    private double chanceLandingCrash = 0.01;

    public U1(){
        this.currentWeight = 10000;
        this.maxWeight = 18000;
        this.cost = 100;

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
