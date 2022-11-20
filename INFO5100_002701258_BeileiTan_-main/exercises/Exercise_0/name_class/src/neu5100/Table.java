package neu5100;

public class Table{
    // Instance variables
    int id;
    String material;
    int numberOfLegs;
    boolean isFixed;
    int capacity;
    boolean isDamaged;
    boolean isColored;
    String manufacturer;

    // Constructor Declaration of class
    public Table(int id, String material, int capacity, boolean isColored) {
        this.id = id;
        this.material = material;
        this.capacity = capacity;
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
    public int getCapacity(){
        return capacity;
    }

    //method 3
    public boolean isColored(){
        return isColored;
    }

    @Override
    public String toString()
    {
        return("the table has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        Table a = new Table(1,"steel", 4, true);
        System.out.println(a);
    }
}