//shape is defined as an abstract class
abstract class Shape {
    double area;
    double perimeter;
    //static variable: common property for all object
    static String color = "Red";
    static int count; //static variable will get the memory once, if an object change the value, it will retain its value
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
        System.out.println("id: " + count + ", shape: " + getName() + ", area: " + getComputerArea() + " , perimeter: " + getComputerPerimeter() + " , color for all Shape: " + color);
    }

}


// Rectangle class exhibits ability of polymorphism, since
// A Rectangle IS-A Shape
// A shape IS-A shape ... the behavior of overriden methods can take advantage of polymorphism


//Rectangle, Square, Circle, Triangle class inherit from an abstract class
class Rectangle extends Shape{
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

class Square extends Shape{
    public Square(){

    }
    public void BasicInfo(){
        super.BasicInfo();
    }
    @Override
    public void setComputerArea(double sideLength1, double sideLength2){
        super.setComputerArea(sideLength1, sideLength2);
    }

    @Override
    public double getComputerArea(){
        return area;
    }
    @Override
    public void setComputerPerimeter(double sideLength1, double sideLength2){
        super.setComputerPerimeter(sideLength1, sideLength2);
    }
    @Override
    public double getComputerPerimeter(){
        return perimeter;
    }
}

class Triangle extends Shape{
    public Triangle(){

    }
    @Override
    public void BasicInfo(){
        super.BasicInfo();
    }
    @Override
    public void setComputerArea(double sideLength1, double sideLength2){
        super.setComputerArea(sideLength1, sideLength2);
    }
    @Override
    public double getComputerArea(){
        return area / 2;
    }

    public void setComputerPerimeter(double sideLength1, double sideLength2, double sideLength3){
        perimeter = sideLength1 + sideLength2 + sideLength3;
    }
    @Override
    public double getComputerPerimeter() {
        return perimeter;
    }
}

class Cycle extends Shape {
    public Cycle() {

    }
    @Override
    public void BasicInfo() {
        super.BasicInfo();
    }

    public void setComputerArea(double radius){
        area = Math.PI * Math.pow(radius, 2);
    }
    @Override
    public double getComputerArea() {
        return area;
    }

    public void setComputerPerimeter(double radius){
        perimeter = Math.PI * (2 * radius);
    }
    @Override
    public double getComputerPerimeter() {
        return perimeter;
    }
}

public class Main {
    public static void main(String[] args) {
        //abstract class cannot be instantiated, hence cannot use new Shape()
        Rectangle rectangle = new Rectangle();
        rectangle.setName("Rectangle");
        rectangle.setComputerArea(8, 9);
        rectangle.setComputerPerimeter(8, 9);
        rectangle.BasicInfo();

        //cannot instantiate the Shape class, but Rectangle can be instantiated
        Shape shape = new Triangle(); //shape reference but Triangle object
        shape.setName("None");
        shape.setComputerArea(5, 5);
        shape.setComputerPerimeter(10, 10);
        shape.BasicInfo();

        Square square = new Square();
        square.setName("Square");
        square.setComputerArea(6, 6);
        square.setComputerPerimeter(6, 6);
        square.BasicInfo();

        Triangle triangle = new Triangle();
        triangle.setName("Triangle");
        triangle.setComputerArea(6, 6);
        triangle.setComputerPerimeter(6, 6, 5);
        triangle.BasicInfo();

        Cycle cycle = new Cycle();
        cycle.setName("Cycle");
        cycle.setComputerArea(5);
        cycle.setComputerPerimeter(5);
        cycle.BasicInfo();
    }
}
