import java.io.*;

//This exercise will make one object in exercise 2 to be serializable
// Test of serialization and deserialization of the objects will be given

abstract class Shape implements java.io.Serializable{
    double area;
    double perimeter;
    //static variable: common property for all object
    static String color = "Red";
    static int count;
    String name;

    public Shape(){
        count++;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getComputerArea(){
        return area;
    }

    public double getComputerPerimeter(){
        return area;
    }

    public void setComputerArea(double sideLength1, double sideLength2){
        area = sideLength1 * sideLength2;
    }

    public void setComputerPerimeter(double sideLength1, double sideLength2){
        perimeter = (sideLength1 + sideLength2) * 2;
    }

    public void BasicInfo(){
        System.out.println("shape: " + getName() + ", area: " + getComputerArea() + " , perimeter: " + getComputerPerimeter() + " , color for all Shape: " + color);
    }

}
//Even through most abstract class don't implement Serializable, the subclass can do
class Rectangle extends Shape implements java.io.Serializable{
    transient int id;
    int Number;
    static int NumberOfSide;

    public Rectangle(){

    }
    public void BasicInfo(){
        super.BasicInfo(); //use keyword super to invoke overridden method in parent class
    }

    @Override
    public void setComputerArea(double sideLength1, double sideLength2){
        super.setComputerArea(sideLength1, sideLength2);
    }

    public double getComputerArea(){
        return area;
    }

    @Override
    public void setComputerPerimeter(double sideLength1, double sideLength2){
        super.setComputerPerimeter(sideLength1,sideLength2);
    }

    public double getComputerPerimeter(){
        return perimeter;
    }

}

//object serialization: allows an object to be represented as a sequence of bytes that includes
// the object's data as well as information about the object's type and the types of data stored in the object.

public class Main{
    public static void main(String[] args){
        //following program instantiates a rectangle object and serializes it to a file.
        Rectangle rectangle = new Rectangle();
        rectangle.id = 1;
        rectangle.Number = 1;
        Rectangle.NumberOfSide = 3;
        rectangle.setName("Rectangle");
        rectangle.setComputerArea(7, 9);
        rectangle.setComputerPerimeter(7, 9);

        System.out.println("Data before Deserialization");
        System.out.println("shape: " + rectangle.getName());
        System.out.println("Transient id Before: " + rectangle.id); //transient variable is not serialized during process
        System.out.println("Non-Transient id Before: " + rectangle.Number); //Non-transient field will be sent to the output stream
        System.out.println("Area: " + rectangle.getComputerArea());
        System.out.println("Perimeter: " + rectangle.getComputerPerimeter());
        //static variable is not serialized during process. The variable will be loaded with current value defined in the class during deserization
        System.out.println("number of length Before: " + rectangle.NumberOfSide);

        String filename = "file.ser";

        //Serialzation
        try { //saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(rectangle); //a serialized object has been written into a file
            out.close();
            file.close();
            System.out.println("Object has been serialized");
            //value of static variable changed
            Rectangle.NumberOfSide = 4;
        }
        catch (IOException ex){
            System.out.println("IOException is caught");
        }

        Rectangle rectangle1 = null;

        //Deserialization
        // Reading the object from a file
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            rectangle1 = (Rectangle)in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized ");
            System.out.println("Data After Deserialization");
            System.out.println("shape: " + rectangle1.getName());
            System.out.println("Transient id After: " + rectangle1.id); //transient variable is not serialized during process
            System.out.println("Non-Transient After: " + rectangle1.Number); //Non-transient field will be sent to the output stream
            System.out.println("Area: " + rectangle1.getComputerArea());
            System.out.println("Perimeter: " + rectangle1.getComputerPerimeter());
            //static variable is not serialized during process. The variable will be loaded with current value defined in the class during deserization
            System.out.println("number of length After: " + rectangle1.NumberOfSide);

        }catch (IOException ex){
            System.out.println("IOException is caught");
            //if cannot find a class during the deseralization of an object.
        }catch (ClassNotFoundException c){
            System.out.println("Given class not Found");
        }
    }
}