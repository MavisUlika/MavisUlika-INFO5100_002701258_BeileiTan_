import java.util.ArrayList;
import java.util.List;

public class Builder {

    // step 2: Create concrete classes implementing the Packing interface.
    public static class Wrapper implements Packing{
        public String pack(){
            return "Wrapper";
        }
    }

    public static class Packet implements Packing{
        public String pack(){
            return "Packet";
        }
    }

    // step 3: Create abstract classes implementing the item interface providing default functionalities
    public static abstract class pizza implements Selection{
        public Packing packing(){
            return new Wrapper();
        }
    }

    public static abstract class sauce implements Selection{
        public Packing packing(){
            return new Packet();
        }
    }

    // step 4: Create concrete classes extending pizza and source classes
    public static class beefPizza extends pizza{
        public String name(){
            return "Beef Pizza";
        }
        public double price(){
            return 9.0;
        }
    }
    public static class lambPizza extends pizza{
        public String name(){
            return "Lamb Beef";
        }
        public double price(){
            return 11.0;
        }
    }

    public static class bbqSauce extends sauce{
        public String name(){
            return "BBQ Sauce";
        }
        public double price(){
            return 0.5;
        }
    }

    public static class mustardSauce extends sauce{
        public String name(){
            return "Mustard Sauce";
        }
        public double price(){
            return 0.8;
        }
    }

    // step 5: Create a Combo class having Selection objects defined above.
    public static class Combo{
        private List<Selection> choices = new ArrayList<>();
        public void setChoices(Selection choice){
            choices.add(choice);
        }

        public double getCost(){
            double cost = 0.0;
            for(Selection choice: choices){
                cost += choice.price();
            }
            return cost;
        }

        public void printChoice(){
            for (Selection choice : choices){
                System.out.print("Selected Item: " + choice.name());
                System.out.print(", Type of Packing : "+ choice.packing().pack());
                System.out.println(", Price : "+ choice.price());
            }
        }
    }

    // step 6: Create a ComboBuilder class, the actual builder class responsible to create Combo objects.
    public static class ComboBuilder{
        public Combo SelectedCombo1(){
            Combo combo = new Combo();
            combo.setChoices(new beefPizza());
            combo.setChoices(new bbqSauce());
            return combo;
        }
        public Combo SelectedCombo2(){
            Combo combo = new Combo();
            combo.setChoices(new lambPizza());
            combo.setChoices(new mustardSauce());
            return combo;
        }
    }
}
