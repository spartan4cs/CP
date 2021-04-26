import java.util.Scanner;

public class PrintKPC {

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printKpc(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);

            return;
        }

        char first = str.charAt(0);
        String rem = str.substring(1);
        int f = first - 48;
        String code = codes[f];
        for (int i = 0; i < code.length(); i++) {// no of calls

            char option = code.charAt(i);

            printKpc(rem, asf + option);
        }

    }

    public static void main(String[] args) {

        // String str = "179";
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKpc(str, "");
    }

}
