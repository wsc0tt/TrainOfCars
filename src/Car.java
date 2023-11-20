/**
 * @author William Scott
 * Car class, creates a Train car containing a factory name, a stop number, a material, and a reference to the next
 * car in the train, similar to a List Node
 */

public class Car {
    public String factory;
    public int stop;
    public String material;
    Car next;

    /**
     * default Constructor
     */
    public Car(){
    }

    /**
     * Custom constructor 1
     * @param fact, of String type, name of factory for car
     * @param s, of integer type, stop number for car
     * @param mat, of String type, name of materials in car
     */
    public Car(String fact, int s, String mat){    // constructor sets next to null
        this.factory = fact;
        this.stop = s;
        this.material = mat;
        this.next = null;
    }

    /**
     * Custom constructor 2, references the next car in the train
     * @param fact
     * @param s
     * @param mat
     * @param next, of Car type, the next Car in the train after this one
     */
    public Car(String fact, int s, String mat, Car next){    // constructor sets this.next=next;
        this.factory = fact;
        this.stop = s;
        this.material = mat;
        this.next = next;
    }
}



