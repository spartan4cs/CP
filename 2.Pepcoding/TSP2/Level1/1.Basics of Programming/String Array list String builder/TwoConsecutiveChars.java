import java.util.Scanner;

public class TwoConsecutiveChars {
    public static String solution(String str) {
        // write your code here
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        char ch = str.charAt(0);
        sb.append(ch);
        for (int i = 1; i < n; i++) {
            char nch = str.charAt(i);
            sb.append(nch - ch).append(nch);
            ch = nch;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
