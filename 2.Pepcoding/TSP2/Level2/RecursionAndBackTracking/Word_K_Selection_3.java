import java.util.HashMap;
import java.util.Scanner;

public class Word_K_Selection_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        combination(ustr, 0, unique, "", k);
    }

    private static void combination(String ustr, int cl, HashMap<Character, Integer> unique, String asf, int k) {
        if (cl == ustr.length()) {

            if (asf.length() == k) {
                System.out.println(asf);
            }
            return;
        }

        // yescall
        String ch = "" + ustr.charAt(cl);
        int n = unique.get(ustr.charAt(cl));
        for (int i = n; i >= 1; i--) {
            String ans = ch.repeat(i);
            // String newStr = String.join("", Collections.nCopies(3, str));
            String fans = asf + ans;
            if (fans.length() <= k) {

                combination(ustr, cl + 1, unique, asf + ans, k);
            }

        }
        // no call
        combination(ustr, cl + 1, unique, asf, k);

    }
}
