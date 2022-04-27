import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Word_K_Length_2_LessOnLevel {
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

        perm(ustr, 0, k, "");

    }

    private static void perm(String ustr, int cl, int k, String asf) {

        if (cl == k) {
            System.out.println(asf);
        }

        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            perm(passRem(ustr, i), cl + 1, k, asf + ch);
        }
    }

    private static String passRem(String ustr, int i) {
        String f = ustr.substring(0, i);
        String l = ustr.substring(i + 1);

        return f + l;
    }
}
