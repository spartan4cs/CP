import java.util.*;
import java.io.*;

public class Word_K_Selection_4 {
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

        combination(ustr, unique, k, 0, new char[k], 0);
    }

    private static void combination(String ustr, HashMap<Character, Integer> unique, int k, int cl, char[] asf,
            int lo) {

        if (cl == k) {

            System.out.println(asf);
            return;
        }

        for (int i = lo; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            int n = unique.get(ch);
            if (n > 0) {

                asf[cl] = ch;
                unique.put(ch, n - 1);
                combination(ustr, unique, k, cl + 1, asf, i);
                asf[cl] = '\0';
                unique.put(ch, n);
            }

        }
    }
}
