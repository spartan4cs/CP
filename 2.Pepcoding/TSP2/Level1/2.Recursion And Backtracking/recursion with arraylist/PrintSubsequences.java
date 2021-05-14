import java.util.Scanner;

public class PrintSubsequences {

    public static void printSubssequence(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        char first = str.charAt(0);
        String rem = str.substring(1);

        // yes calll
        printSubssequence(rem, asf + first);
        // no call
        printSubssequence(rem, asf);
    }

    public static void main(String[] args) {

        // String str = "yvTA";
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printSubssequence(str, "");
    }

}
