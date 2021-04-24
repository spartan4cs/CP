import java.util.Scanner;

public class PrintPermutation {

    // no need to aadd for loop
    public static String passRemaining(String str, int k) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i != k) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    // improvised
    public static String passRemainingImprovised(String str, int i) {

        String part1 = str.substring(0, i);
        String part2 = str.substring(i + 1);
        return part1 + part2;
    }

    public static void printPermutation(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        int option = str.length();
        for (int i = 0; i < option; i++) {
            printPermutation(passRemainingImprovised(str, i), asf + str.charAt(i));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPermutation(str, "");
    }
}
