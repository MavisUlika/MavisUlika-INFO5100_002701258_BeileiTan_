package neu5100;

public class Bottle {
    int id;
    String material;
    double volume;
    boolean isfilled;
    double prices;
    String color;
    double weight;
    String brand;

    // Constructor Declaration of class
    public Bottle(int id, double volume, boolean isfilled, String material) {
        this.id = id;
        this.volume = volume;
        this.isfilled = isfilled;
        this.material = material;
    }

    //get id
    public int getId(){
        return id;
    }

    //Method 1
    public double getVolume(){
        return volume;
    }

    //Method 2
    public boolean isfilled(){
        return isfilled;
    }

    //method 3
    public String getMaterial(){
        return material;
    }

    @Override
    public String toString()
    {
        return("the Bottle has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        Bottle i = new Bottle(9,300, false, "glass");
        System.out.println(i);
    }

}
