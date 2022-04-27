import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Word_K_Length_1_MoreOnLevel {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        perm(ustr, 0, new char[k], 0, k);

    }

    // cl - current level
    private static void perm(String ustr, int cl, char[] asf, int ssf, int ts) {

        // base
        if (cl == ustr.length()) {

            if (ssf == ts) {

                System.out.println(asf);
            }
            return;
        }

        
        char ch = ustr.charAt(cl);
        // yes call
        for (int i = 0; i < asf.length; i++) {
            if (asf[i] == '\0') {

                asf[i] = ch;
                perm(ustr, cl + 1, asf, ssf + 1, ts);
                asf[i] = '\0';
            }
        }
        
        // no call
        perm(ustr, cl + 1, asf, ssf + 0, ts);
    }

}
