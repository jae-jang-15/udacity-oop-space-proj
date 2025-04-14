package SpaceProj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    /*
    read the text file line by line and create an Item object for each and then 
    add it to an ArrayList of Items. The method should then return that ArrayList.
    */
    ArrayList<Item> loadItems(String fileName){
        ArrayList<Item> items = new ArrayList<>();

        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String [] newLine = scanner.nextLine().split("=");
                String name = newLine[0];
                int weight = Integer.parseInt(newLine[1]);

                Item item = new Item(name,weight);
                items.add(item);
            }
            scanner.close();

        }catch(FileNotFoundException exception){
            System.out.println("File not found!");
        }
        return items;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> items){
    /* 
    this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets. 
    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object 
    and filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets 
    that are fully loaded. 
    */

        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        Rocket u1 = new U1();
        u1Rockets.add(u1);
        int index = 0;

        for (int i=0;i < items.size();i++){
            
            Rocket currentRocket = u1Rockets.get(index);
            Item currentItem = items.get(i);

            if (currentRocket.canCarry(currentItem)){
                currentRocket.carry(currentItem);

            }else{
                Rocket newU1 = new U1();
                u1Rockets.add(newU1);
                newU1.carry(currentItem);
                index ++;
            }
        }

        return u1Rockets;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> items){
    /* 
    this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets. 
    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object 
    and filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets 
    that are fully loaded. 
    */

        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        Rocket u2 = new U2();
        u2Rockets.add(u2);
        int index = 0;

        for (int i=0;i < items.size();i++){
            
            Rocket currentRocket = u2Rockets.get(index);
            Item currentItem = items.get(i);

            if (currentRocket.canCarry(currentItem)){
                currentRocket.carry(currentItem);

            }else{
                Rocket newU2 = new U2();
                u2Rockets.add(newU2);
                newU2.carry(currentItem);
                index ++;
            }
        }

        return u2Rockets;
    }

    int runSimulation(ArrayList<Rocket> rockets){
    /*
    this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList. 
    Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again. 
    All while keeping track of the total budget required to send each rocket safely to Mars. 
    runSimulation then returns the total budget required to send all rockets (including the crashed ones).
    */
        int totalCost = 0;

        for (int i =0; i < rockets.size();i++){
            Rocket currentRocket = rockets.get(i);

            if (!currentRocket.launch() || !currentRocket.land()){
                i--;
            }
            totalCost += currentRocket.cost;
        }

        return totalCost;
    }


}

