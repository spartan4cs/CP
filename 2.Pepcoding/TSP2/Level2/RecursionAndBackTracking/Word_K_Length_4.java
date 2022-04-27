import java.io.*;
import java.util.*;

public class Word_K_Length_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> fmap = new HashMap<>();
        String ustr = "";
        for (char c : str.toCharArray()) {
            if (fmap.containsKey(c)) {
                fmap.put(c, fmap.get(c) + 1);
            } else {
                fmap.put(c, 1);
                ustr += c;
            }
        }

        perm(ustr, fmap, k, 0, new char[k]);
    }

    private static void perm(String ustr, HashMap<Character, Integer> fmap, int k, int cl, char[] asf) {

        // base
        if (cl == k) {
            System.out.println(asf);
            return;
        }
        for (char c : fmap.keySet()) {
            int n = fmap.get(c);
            if (n > 0) {

                asf[cl] = c;
                fmap.put(c, n - 1);
                perm(ustr, fmap, k, cl + 1, asf);
                asf[cl] = '\0';
                fmap.put(c, n);
            }
        }
    }
}
