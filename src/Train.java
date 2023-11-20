/**
 * @author William Scott
 * Train class file, a Train is a linked list of Cars
 */

import java.util.*;
import java.io.*;

public class Train {
    private Car front; // car at the front of the train

    /**
     * default constructor; empty train
     */
    public Train(){
        front = null;
    }

    /**
     * Custom constructor; train from txt file
     * @param carFile, of String type, name of file
     * @throws FileNotFoundException, if file is not found throw exception
     */
    public Train(String carFile) throws FileNotFoundException {  // constructor: reads each tran car details form the file into the LInkedList
        Scanner file = new Scanner(new File(carFile));
        while (file.hasNextLine()){       // while there is still a line in the file
            String line = file.nextLine();
            String[] tokens = line.split(",");    // split the line into tokens
            String factory = tokens[0];
            int stopNumber = Integer.parseInt(tokens[1]);
            String material = tokens[2];
            attach(factory, stopNumber, material);   // attach car
        }


    }

    /**
     * detach method used to remove a car from the train given the user input factory name
     * @param factoryName, of String type, user input name of factory of which train car to remove or detach
     */
    public void detach(String factoryName){
        Car current = front;
        Car prev = current;
        while (!current.factory.equals(factoryName) && current.next != null){
            prev = current;
            current = current.next;
        }
        if (current.next == null && !current.factory.equals(factoryName))
            System.out.println("Could not find train car: Please enter a different factory name when detaching.");
        else {
            if (current.next != null && current.next.factory.equals(factoryName))
                prev.next = current.next.next;
            else
                prev.next = current.next;
        }
    }


    /**
     * attach method, used to attach a new car to the train given the factory name, stop number, materials
     * @param factoryName, name of factory
     * @param stopNumber, stop this factory is at
     * @param materialName, name of materials in the car
     */
    public void attach(String factoryName, int stopNumber, String materialName){
        Car current = front;
        Car prev = current;
        if (front == null){
            front = new Car(factoryName, stopNumber, materialName);
        } else {
            if (stopNumber <= front.stop){
                current = new Car(factoryName, stopNumber, materialName, front);
                front = current;
            }
            else {
                while (stopNumber > current.stop && current.next != null) {
                    prev = current;
                    current = current.next;
                }
                if (current.next == null){
                    current.next = new Car(factoryName, stopNumber, materialName);


                    /*if (stopNumber > current.stop)
                        current.next = new Car (factoryName, stopNumber, materialName);
                    else {
                        current = new Car (factoryName, stopNumber, materialName, current);
                    }*/
                } else {
                    prev.next = new Car (factoryName, stopNumber, materialName, current);
                }
            }

        }
    }

    // search for cars that correspond to the given factory name.
    // Note: there may be more than one car so you may use helper method
    // that follows

    /**
     * search method, used to search for cars that correspond to the given factory name
     * prints materials found on cars with matching name
     * @param factoryName, name of factory
     */
    public void search(String factoryName){
        int count = 0;
        Car current = front;
        while (current.next != null){
            if (current.factory.equals(factoryName) && count == 0){
                System.out.print("Material: " + current.material);
                count++;
            }
            else if (current.factory.equals(factoryName) && count > 0){
                System.out.print(", " + current.material);
            }

            current = current.next;
        }
        System.out.println();
        if (count == 0){
            System.out.println("Factory name not found");
        }
    }


    /**
     * displayTrainCars method used to display all the cars currently linked in the Train
     */
    public void displayTrainCars(){
        Car current = front;
        while (current != null){
            System.out.printf("%-20s %-4d %-20s %n", current.factory, current.stop, current.material);
            current = current.next;
        }
    }

    /**
     * merge method, used to merge 2 trains
     * @param other, other train merging with the current one
     */
    public void merge(Train other){
        Car current = other.front;
        while (current != null){
            attach(current.factory, current.stop, current.material);
            current = current.next;
        }

    }

}
