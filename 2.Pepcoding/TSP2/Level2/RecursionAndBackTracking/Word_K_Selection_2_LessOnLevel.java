import java.util.HashMap;
import java.util.Scanner;

public class Word_K_Selection_2_LessOnLevel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();

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

        selection(k, ustr, "", -1);
    }

    private static void selection(int k, String ustr, String asf, int lo) {

        if (k == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = lo + 1; i < ustr.length(); i++) {

            selection(k - 1, ustr, asf + ustr.charAt(i), i);
        }
    }

}