import java.io.*;
import java.util.*;

public class Word_K_Length_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> loc = new HashMap<>();
        for (char c : str.toCharArray()) {
            loc.put(c, -1);
        }

        perm(str, 0, k, loc, new char[k], 0, k);

    }

    private static void perm(String str, int cl, int k, HashMap<Character, Integer> loc, char[] asf, int ssf, int ts) {

        if (cl == str.length()) {
            if (ssf == ts) {
                System.out.println(asf);
            }

            return;
        }

        // yes call
        char ch = str.charAt(cl);
        int lo = loc.get(ch);
        for (int i = lo + 1; i < asf.length; i++) {
            if (asf[i] == '\0') {
                asf[i] = ch;
                loc.put(ch, i);
                perm(str, cl + 1, k, loc, asf, ssf + 1, ts);
                loc.put(ch, lo);
                asf[i] = '\0';
            }
        }
        // no call only when there is no occurence

        if (lo == -1) {
            perm(str, cl + 1, k, loc, asf, ssf, ts);
        }
    }
}
