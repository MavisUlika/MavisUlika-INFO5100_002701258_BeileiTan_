package neu5100;

public class Phone {
    int id;
    String material;
    String color;
    boolean islatestVersion;
    String phoneNumbers;
    int numberOfSimCards;
    String manufacturer;
    int numberOfcameras;

    // Constructor Declaration of class
    public Phone(int id, String material, String manufacturer, boolean islatestVersion) {
        this.id = id;
        this.material = material;
        this.manufacturer = manufacturer;
        this.islatestVersion = islatestVersion;
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
    public String getManufacturer(){
        return manufacturer;
    }

    //method 3
    public boolean islatestVersion(){
        return islatestVersion;
    }

    @Override
    public String toString()
    {
        return("the phone has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        Phone c = new Phone(3,"tungsten", "iphone", true);
        System.out.println(c);
    }

}
