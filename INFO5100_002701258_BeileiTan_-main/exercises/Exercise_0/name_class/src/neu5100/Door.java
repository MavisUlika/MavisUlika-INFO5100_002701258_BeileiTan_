package neu5100;

public class Door {
    // Instance variables
    int id;
    String material;
    double width;
    double height;
    boolean isclosed;
    boolean isDamaged;
    boolean isColored;
    String manufacturer;

    // Constructor Declaration of class
    public Door(int id, String material, double height, boolean isColored) {
        this.id = id;
        this.material = material;
        this.height = height;
        this.isColored = isColored;
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
    public double getHeight(){
        return height;
    }

    //method 3
    public boolean isColored(){
        return isColored;
    }

    @Override
    public String toString()
    {
        return("the door has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        Door b = new Door(2,"wood", 3.2, true);
        System.out.println(b);
    }

}
