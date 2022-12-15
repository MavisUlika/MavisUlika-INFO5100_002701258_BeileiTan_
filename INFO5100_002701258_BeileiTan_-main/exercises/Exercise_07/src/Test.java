import java.util.*;

// Create implementation of class to count the odd number
class OddNumber implements SomeSpecialCollection<Integer>{
    public boolean match(Integer i){
        return (i % 2 != 0);
    }
}
// Create implementation of class to count the prime number
class PrimeNumber implements SomeSpecialCollection<Integer>{
    public boolean match(Integer i){
        for(int j = 2; j < i; j++){
            if(i % j == 0) return false;
        }
        return true;
    }
}

//Create implementation of class to count the number of Palindrome
class isPalindrome implements SomeSpecialCollection<Integer>{
    public boolean match(Integer i){
        if(i < 0) return false;
        long div = 1;
        while (i >= div * 10){
            div *= 10;
        }
        while (i > 0){
            int last_digital = i % 10;
            int first_digital = i / (int) div;
            if(first_digital != last_digital) return false;
            //delete the first digital
            i = i % (int) div;
            //delete the last digital
            i = i / 10;
            //update the divider after deleting two digits
            div = div / 100;
        }
        return true;
    }
}

public class Test {
    public static void main(String[] args){
        Algorithm a = new Algorithm();
        System.out.println("--------------Question 1 : Counting number of elements in a collection that have a specific property -----------");
        Collection<Integer> list = Arrays.asList(1,7,121,89,44,56745);
        OddNumber odd = new OddNumber();
        PrimeNumber prime = new PrimeNumber();
        isPalindrome palindrome = new isPalindrome();
        System.out.println("The original collection: " + list);
        System.out.println("Count the odd number: " + a.countNumber(list, odd));
        System.out.println("Count the prime number: " + a.countNumber(list, prime));
        System.out.println("Count the number of Palindrome: " + a.countNumber(list, palindrome));

        System.out.println("--------------Question 2 : Exchange the positions of two different elements in an array. -----------");
        Integer[] arr = { 11, 22, 33, 44, 55 };
        System.out.println("The original integer array: " + Arrays.toString(arr));
        int index_i = 0;
        int index_j = 3;
        a.swap(arr, index_i, index_j);
        System.out.println("The integer array after swapping index " + index_i + ", " + index_j + " : " + Arrays.toString(arr));

        System.out.println("--------------Question 3 :  find the maximal element in the range [begin, end) of a list. -----------");
        ArrayList al = new ArrayList<>();
        Random rand = new Random();
        for(int j = 0; j < 5; j++){
            int pick = rand.nextInt(100);
            al.add(pick);
        }
        System.out.println("The content of arraylist: " + al);
        int begin = 1;
        int end = al.size() - 1;
        System.out.println("Maximum in the list: " + a.max(al, begin, end) + ", with the given start and end index: " + begin + ", "+ end);
    }
}
