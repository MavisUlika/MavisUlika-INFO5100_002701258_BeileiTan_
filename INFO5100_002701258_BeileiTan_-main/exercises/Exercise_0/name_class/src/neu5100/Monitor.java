package neu5100;

public class Monitor {
    int id;
    String material;
    String color;
    boolean islatestVersion;
    boolean isConnected;
    double maxResolution;
    double height;
    double weight;

    // Constructor Declaration of class
    public Monitor(int id, String material, boolean isConnected, double weight) {
        this.id = id;
        this.material = material;
        this.isConnected = isConnected;
        this.weight = weight;
    }

    //get id
    public int getId(){
        return id;
    }

    //Method 1
    public String getMaterial(){
        return material;
    }

    //Method 2
    public boolean isConnected(){
        return isConnected;
    }

    //method 3
    public double getWeight(){
        return weight;
    }

    @Override
    public String toString()
    {
        return("the Monitor has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        Monitor d = new Monitor(4,"aluminum", true, 10);
        System.out.println(d);
    }

}
