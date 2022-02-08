import java.util.*;
import java.util.stream.Collectors;

public class Java11 {
    public static void main(String[] args) {

        // execute java in single line

        // string utility

        System.out.println(" ".isBlank()); // true

        String s = "Anupam";
        System.out.println(s.isBlank()); // false

        String s1 = "";
        System.out.println(s1.isBlank()); // true

        // /lines()
        // This method returns a stream of strings, which is a collection of all
        // substrings split by lines.
        String str1 = "JD\nJD\nJD";
        System.out.println(str1);
        System.out.println(str1.lines().collect(Collectors.toList())); // [JD, JD, JD]

        /**
         * strip() is “Unicode-aware evolution of trim()
         * strip(), stripLeading(), stripTrailing()
         * 
         * strip() – Removes the white space from both, beginning and the end of string.
         */

        String str = " JD ";
        System.out.print("Start");
        System.out.print(str.strip());
        System.out.println("End"); // StartJDEnd

        System.out.print("Start");
        System.out.print(str.stripLeading());
        System.out.println("End");// StartJD End

        System.out.print("Start");
        System.out.print(str.stripTrailing());
        System.out.println("End"); // Start JDEnd

        /**
         * repeat(int)
         */
        String str2 = "=".repeat(2);
        System.out.println(str2); // prints ==

        /**
         * 
         * 
         */

    }
}
