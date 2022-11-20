//Write a console program in Java to exercise at least 5 regular expressions patterns and demonstrate positive and
// negative cases using at least one subject string for each case.
import java.util.regex.*;
public class Main {
    //set variable to final, to prevent it from being overridden/modified
    //* zero or more
    private static final String REGEX1 = "foo*";
    private static final String INPUT1_P = "fooooooooooooooooo";
    private static final String INPUT1_N = "fooooooooooooooooa";

    //contains exactly {zzz}
    private static final String REGEX2 = "z{3}";
    private static final String INPUT2_P = "zzz"; 
    private static final String INPUT2_N = "zz";

    //[] -> means exactly one character
    private static final String REGEX3 = "[^abc]"; // any character except a, b, c
    private static final String INPUT3_P = "m"; //not a or b or c
    private static final String INPUT3_N = "a";

    //^good$ is exacly "good"
    private static final String REGEX4 = "^good$";
    private static final String INPUT4_P = "good";
    private static final String INPUT4_N = "kgood";

    //a through e or 1 through 5, inclusive(range)
    private static final String REGEX5 = "[a-e1-5]";
    private static final String INPUT5_P = "2";
    private static final String INPUT5_N = "f";



    public static void main(String[] args) {
        //Use matches() test whether the regular expression matches the pattern
        //example1
        System.out.println("Example 1");
        System.out.println("Current REGEX is: "+ REGEX1);
        System.out.print("Current INPUT is: "+ INPUT1_P);
        System.out.print(", matches(): "+Pattern.matches(REGEX1,INPUT1_P));
        System.out.print(", Current INPUT is: "+ INPUT1_N);
        System.out.println(", matches(): "+Pattern.matches(REGEX1,INPUT1_N));

        //example2
        System.out.println("Example 2");
        System.out.println("Current REGEX is: "+ REGEX2);
        System.out.print("Current INPUT is: "+ INPUT2_P);
        System.out.print(", matches(): "+Pattern.matches(REGEX2,INPUT2_P));
        System.out.print(", Current INPUT is: "+ INPUT2_N);
        System.out.println(", matches(): "+Pattern.matches(REGEX2,INPUT2_N));

        //example3
        System.out.println("Example 3");
        System.out.println("Current REGEX is: "+ REGEX3);
        System.out.print("Current INPUT is: "+ INPUT3_P);
        System.out.print(", matches(): "+Pattern.matches(REGEX3,INPUT3_P));
        System.out.print(", Current INPUT is: "+ INPUT3_N);
        System.out.println(", matches(): "+Pattern.matches(REGEX3,INPUT3_N));

        //example4
        System.out.println("Example 4");
        System.out.println("Current REGEX is: "+ REGEX4);
        System.out.print("Current INPUT is: "+ INPUT4_P);
        System.out.print(", matches(): "+Pattern.matches(REGEX4,INPUT4_P));
        System.out.print(", Current INPUT is: "+ INPUT4_N);
        System.out.println(", matches(): "+Pattern.matches(REGEX4,INPUT4_N));

        //example5
        System.out.println("Example 5");
        System.out.println("Current REGEX is: "+ REGEX5);
        System.out.print("Current INPUT is: "+ INPUT5_P);
        System.out.print(", matches(): "+Pattern.matches(REGEX5,INPUT5_P));
        System.out.print(", Current INPUT is: "+ INPUT5_N);
        System.out.println(", matches(): "+Pattern.matches(REGEX5,INPUT5_N));

    }
}