import java.util.HashMap;
import java.util.Scanner;

public class Word_K_Selection_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();

        // need to select k distinct chars

        // get unique string
        HashMap<Character, Integer> fmap = new HashMap();

        String ustr = "";
        for (char c : s.toCharArray()) {
            if (fmap.containsKey(c)) {
                fmap.put(c, fmap.get(c) + 1);
            } else {
                fmap.put(c, 1);
                ustr += c;
            }
        }
        // System.out.println(ustr);

        selection(ustr, 0, "", k);

    }

    // cl -current level
    private static void selection(String ustr, int cl, String asf, int k) {
        // base

        if (cl == ustr.length()) {

            if (asf.length() == k) {
                System.out.println(asf);
            }
            return;
        }

        // yes call

        char ch = ustr.charAt(cl);// current character
        selection(ustr, cl + 1, asf + ch, k);

        // no call
        selection(ustr, cl + 1, asf, k);
    }
}
