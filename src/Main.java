/**
 * @author William Scott
 * Programming Assignment 3
 * Train of Cars Main java file, Train Depot menu method, helper method, files
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner (System.in);
        String file1 = "car.txt";
        String file2 = "update.txt";
        Train t = new Train(file1);
        Train x = new Train(file2);
        menu(console, t, x);

        //t.displayTrainCars();

    }

    /**
     *
     * @param console, a Scanner object to read in user input
     * @param t, og train from car.txt file
     * @param x, new train from update.txt file
     */
    public static void menu(Scanner console, Train t, Train x) {
        String choice;
        do {                // menu options
            System.out.println("------------------------");
            System.out.println("Train Depot Menu Options");
            System.out.println("------------------------");
            System.out.println("Enter A to Attach a train car");
            System.out.println("Enter R to Detach a train car");
            System.out.println("Enter D to Display all the train cars");
            System.out.println("Enter S to Search for a train car");
            System.out.println("Enter M to merge two trains");
            System.out.println("Enter Q to Quit");
            System.out.print("\nPlease enter your choice: ");
            choice = console.next().toUpperCase();  // get user input for menu choice and convert to uppercase
            switch (choice) {
                case "A":
                    System.out.println("Enter the factory name: ");
                    String factory = getLine();
                    System.out.println("Enter the stop #: ");
                    int stop = console.nextInt();
                    System.out.println("Enter the material name: ");
                    String material = getLine();
                    t.attach(factory, stop, material);
                    System.out.println("...Car Attached!\n");
                    break;
                case "R":
                    System.out.println("Enter factory name: ");
                    t.detach(getLine());
                    System.out.println("...Car Detached!\n");
                    break;
                case "D":
                    System.out.println();
                    t.displayTrainCars();
                    break;
                case "S":
                    System.out.println("Enter factory name: ");
                    t.search(getLine());
                    break;
                case "M":
                    t.merge(x);
                    System.out.println("...Train's merged successfully\n");
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("I'm sorry that option does not exist. Please enter a valid option " +
                            "from the menu or enter Q to Quit");
                    break;
            }
        } while (!choice.equals("Q"));

    }

    /**
     * getLine method used to get user input for menu options
     * @return a String of user input, (factory name/ materials)
     */
    public static String getLine(){
        Scanner line = new Scanner(System.in);
        return line.nextLine();
    }
}