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
        String str = "JD\nJD\nJD";
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));

    }
}
