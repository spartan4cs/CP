import java.util.Scanner;

public class PalindromicSubstring {

    public static boolean isPalindrome(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }

    public static void findAllSubstring(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String s = str.substring(i, j + 1);
                if (isPalindrome(s, 0, s.length() - 1)) {
                    System.out.println(s);
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        findAllSubstring(s);
    }

}
