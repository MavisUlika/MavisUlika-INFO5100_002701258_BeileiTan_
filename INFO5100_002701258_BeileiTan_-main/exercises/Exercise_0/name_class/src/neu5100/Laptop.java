package neu5100;

public class Laptop {
    class MemoryCard {
        int id;

        public MemoryCard() {
            this.id = 11;
            System.out.println("the MemoryCard has id:" + this.id);
        }
    }

    class GraphicsCard{
        int id;

        public GraphicsCard(){
            this.id = 12;
            System.out.println("the GraphicsCard has id:" + this.id);
        }
    }

    int id;
    String stringSize;
    String laptopDimensions;
    double weight;
    String brand;
    boolean isLatest;
    boolean isDamged;
    int numberOfUSBPorts;

    // Constructor Declaration of class
    public Laptop(int id, boolean isLatest, String brand, int numberOfUSBPorts) {
        this.id = id;
        this.isLatest = isLatest;
        this.brand = brand;
        this.numberOfUSBPorts = numberOfUSBPorts;
    }

    //get id
    public int getId(){
        return id;
    }

    //Method 1
    public boolean isLatest(){
        return isLatest;
    }

    //Method 2
    public String getBrand(){
        return brand;
    }

    //method 3
    public double getNumberOfUSBPorts(){
        return numberOfUSBPorts;
    }

    @Override
    public String toString()
    {
        return("the Laptop has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        Laptop j = new Laptop(10,false, "mac", 3);
        Laptop.MemoryCard mc = j.new MemoryCard(); //inner class 1
        Laptop.GraphicsCard gc = j.new GraphicsCard(); //inner class 2
        System.out.println(j);
    }

}
