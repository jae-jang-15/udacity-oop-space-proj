package SpaceProj;

public class Rocket implements SpaceShip {
    protected int currentWeight;
    protected int maxWeight;
    protected int cost;

    @Override
    public boolean launch(){return true;}
        
    @Override
    public boolean land(){return true;}

    @Override
    public boolean canCarry(Item item){
    // a method that takes an Item as an argument and returns true if the rocket 
    // can carry such item or false if it will exceed the weight limit.
        return currentWeight + item.getWeight() <= maxWeight;
    }

    @Override
    public void carry(Item item){
    // a method that also takes an Item object and updates the current weight of the rocket.
        currentWeight += item.getWeight();
    }
}
