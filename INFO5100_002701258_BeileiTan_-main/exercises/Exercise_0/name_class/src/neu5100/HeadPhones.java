package neu5100;

public class HeadPhones {
    int id;
    String brand;
    boolean isMuted;
    boolean isWireless;
    boolean isConnected;
    double volume;
    String color;
    double price;

    // Constructor Declaration of class
    public HeadPhones(int id, boolean isWireless, double price, String brand) {
        this.id = id;
        this.isWireless = isWireless;
        this.price = price;
        this.brand = brand;
    }

    //get id
    public int getId(){
        return id;
    }

    //Method 1
    public boolean isWireless(){
        return isWireless;
    }

    //Method 2
    public double getPrice(){
        return price;
    }

    //method 3
    public String getBrand(){
        return brand;
    }

    @Override
    public String toString()
    {
        return("the HeadPhones has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        HeadPhones f = new HeadPhones(6,false, 126.0, "Beats");
        System.out.println(f);
    }

}
