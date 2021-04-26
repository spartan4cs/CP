import java.util.Scanner;

public class PrintEncodings {

    public static void printEncoding(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        // one digit
        int n1 = str.charAt(0) - '0'; // 5
        if (n1 == 0) {
            return;
        }
        char ch1 = (char) (n1 + 'a' - 1); // 'e'
        String rem1 = str.substring(1);
        printEncoding(rem1, asf + ch1);

        if (str.length() > 1) {
            // 2 diggit
            int n2 = str.charAt(1) - '0'; // 1
            int n = n1 * 10 + n2; // 51
            if (n <= 26) {
                char ch2 = (char) (n + 'a' - 1);
                String rem2 = str.substring(2);
                printEncoding(rem2, asf + ch2);
            }

        }

    }

    public static void main(String[] args) {

        // String str = "655196";
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printEncoding(str, "");
    }
}
