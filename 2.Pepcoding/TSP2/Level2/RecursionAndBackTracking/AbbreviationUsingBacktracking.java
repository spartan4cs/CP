import java.util.Scanner;

public class AbbreviationUsingBacktracking {
    public static void solution(String str, String asf, int count, int pos) {
        // write your code here\

        if (pos == str.length()) {

            System.out.println(asf + (count > 0 ? count : ""));
            return;
        }

        char ch = str.charAt(pos);

        // yes call
        solution(str, asf + (count > 0 ? count : "") + ch, 0, pos + 1);

        // no call
        solution(str, asf, count + 1, pos + 1);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "", 0, 0);
    }
}
