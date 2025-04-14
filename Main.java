package SpaceProj;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        Simulation s1 = new Simulation();
        ArrayList<Item> phaseOneItems = s1.loadItems("SpaceProj/phase-1.txt");
        ArrayList<Rocket> s1Rockets = s1.loadU1(phaseOneItems);
        int s1Cost = s1.runSimulation(s1Rockets);

        Simulation s2 = new Simulation();
        ArrayList<Item> phaseTwoItems = s2.loadItems("SpaceProj/phase-2.txt");
        ArrayList<Rocket> s2Rockets = s2.loadU2(phaseTwoItems);
        int s2Cost = s2.runSimulation(s2Rockets);



        System.out.println("There are "+s1Rockets.size()+" U1 rockets ready to be launched in S1 simulation. And the total cost of S1 with phase 1 items is "+s1Cost+" million.");
        System.out.println("There are "+s2Rockets.size()+" U2 rockets ready to be launched in S2 simulation. And the total cost of S2 with phase 2 items is "+s2Cost+" million.");
    }
}
