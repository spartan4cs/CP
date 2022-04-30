import java.util.Scanner;

public class AllPalindromicPartitions {

    public static void solution(String str, String asf) {
        // write you code here

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            String op = str.substring(0, i + 1);
            String rem = str.substring(i + 1);
            if (isPalindrome(op)) {
                solution(rem, asf + "(" + op + ")");
            }
        }

    }

    private static boolean isPalindrome(String op) {
        int i = 0;
        int j = op.length() - 1;
        while (i < j) {
            if (op.charAt(i) != op.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }
}
