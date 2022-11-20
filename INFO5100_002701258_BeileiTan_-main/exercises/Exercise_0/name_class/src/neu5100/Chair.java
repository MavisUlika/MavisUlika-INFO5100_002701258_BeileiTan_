package neu5100;

public class Chair {
    int id;
    String material;
    int numberOflegs;
    boolean hasWheels;
    boolean hasArmRest;
    String color;
    double weight;
    String brand;

    // Constructor Declaration of class
    public Chair(int id, boolean hasWheels, int numberOflegs, String color) {
        this.id = id;
        this.hasWheels = hasWheels;
        this.numberOflegs = numberOflegs;
        this.color = color;
    }

    //get id
    public int getId(){
        return id;
    }

    //Method 1
    public boolean hasWheels(){
        return hasWheels;
    }

    //Method 2
    public int getNumberOflegs(){
        return numberOflegs;
    }

    //method 3
    public String getColor(){
        return color;
    }

    @Override
    public String toString()
    {
        return("the Chair has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        Chair h = new Chair(8,true, 4, "black");
        System.out.println(h);
    }


}
