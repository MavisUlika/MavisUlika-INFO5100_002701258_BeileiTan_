
public class Main {
    static String langauges[] = {"Engish", "Chinese", "Germany", "French","Hindi"};
    public static void main(String[] args) {
        // provides a bunch of selections
        System.out.println("This is 1st design pattern --> Builder Pattern");
        Builder.ComboBuilder comboBuilder = new Builder.ComboBuilder();
        Builder.Combo combo1 = comboBuilder.SelectedCombo1();
        System.out.println("--------------Selected Combo 1: ----------------");
        combo1.printChoice();
        System.out.println("Total Cost: " + combo1.getCost());

        Builder.Combo combo2 = comboBuilder.SelectedCombo2();
        System.out.println("--------------Selected Combo 2: ----------------");
        combo2.printChoice();
        System.out.println("Total Cost: " + combo2.getCost());
        System.out.println();
        System.out.println();

        // Write 10 books but only creates 5 objects. Language property is used to check already existing Book objects by implementing HashMap.
        System.out.println("This is 1st design pattern --> Flyweight Pattern");
        for(int i = 0; i < 10; i++){
            Flyweight.Book book = (Flyweight.Book) Flyweight.bookStorage.getBook(Flyweight.getRandomLanguage());
            book.setNumberOfPage(Flyweight.getRandomPage());
            book.setPubishedYear(Flyweight.getRandomYear());
            book.setAuthor("Thakurbari");
            book.write();
        }
        System.out.println();
        System.out.println();

        // Write a car class in Car model file, CarView will print detail of car and CarController acts intermediately between view and model
        System.out.println("This is 1st design pattern --> Model View Controller Pattern");
        //Fetch car record form database
        CarModel model = CarModelDataBase();

        //Create a view : to write car details on console
        CarView view = new CarView();

        CarController controller = new CarController(model, view);
        System.out.println("This is car engine speed before accelerating:");
        controller.updateView();

        //update car data by making it accelerate
        System.out.println("This is car engine speed after accelerating:");
        controller.setCarEngine(180);
        controller.updateView();

        }
    private static CarModel CarModelDataBase(){
        CarModel car = new CarModel();
        car.setSpeed(150);
        car.setName("No.1");
        return car;
    }
}