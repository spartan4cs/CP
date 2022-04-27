import java.util.HashMap;
import java.util.Scanner;

public class PermutationWord_2_ItemOnLevel {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] asf = new char[str.length()];

        // last-occurence of char
        HashMap<Character, Integer> loc = new HashMap();
        for (char c : str.toCharArray()) {
            loc.put(c, -1);
        }
        permutationWord2(str.toCharArray(), 0, str.length(), asf, loc);
    }

    // cl -current level
    // tl - total level
    // lc -last occurence
    private static void permutationWord2(char[] str, int cl, int tl, char[] asf, HashMap<Character, Integer> loc) {

        // base
        if (cl == tl) {
            System.out.println(asf);
            return;
        }

        // s - spot
        // start from last occurence of string
        int lc = loc.get(str[cl]);
        for (int s = lc + 1; s < asf.length; s++) {

            if (asf[s] == '\0') {

                asf[s] = str[cl];
                loc.put(str[cl], s);
                permutationWord2(str, cl + 1, tl, asf, loc);
                asf[s] = '\0';
                loc.put(str[cl], lc);

            }
        }

    }

}
