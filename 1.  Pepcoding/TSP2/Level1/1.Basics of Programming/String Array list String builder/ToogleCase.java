import java.util.Scanner;

class ToogleCase {

    public static String toggleCase(String str) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) (ch - 32));
            } else {
                sb.append((char) (ch + 32));
            }
        }
        return sb.toString();
    }

    // sir approach
    public static String toggleCaseSir(String str) {
        // write your code here

        // x-'a' = X-'A'
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) (ch - 'a' + 'A'));
            } else {
                sb.append((char) (ch - 'A' - 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}