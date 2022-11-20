package neu5100;

public class WhiteBoard {
    int id;
    double height;
    double width;
    String material;
    String manufacturer;
    boolean isCleaned;
    boolean isFixed;
    boolean isrectangle;

    // Constructor Declaration of class
    public WhiteBoard(int id, String material, boolean isFixed, double width) {
        this.id = id;
        this.material = material;
        this.isFixed = isFixed;
        this.width = width;
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
    public boolean isFixed(){
        return isFixed;
    }

    //method 3
    public double getWidth(){
        return width;
    }

    @Override
    public String toString()
    {
        return("the WhiteBoard has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        WhiteBoard e = new WhiteBoard(5,"steel", false, 6.2);
        System.out.println(e);
    }
}
