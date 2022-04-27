import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PermutationWord_1_BoxOnLevel {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // freq map

        HashMap<Character, Integer> fmap = new HashMap<>();
        for (Character str : s.toCharArray()) {
            if (fmap.containsKey(str)) {
                fmap.put(str, fmap.get(str) + 1);
            } else {
                fmap.put(str, 1);
            }
        }
        // for (Character c : fmap.keySet()) {
        // System.out.println(c + " " + fmap.get(c));
        // }

        // for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
        // System.out.println(entry.getKey() + " " + entry.getValue());
        // }

        char[] asf = new char[s.length()];
        permutationWord(fmap, asf, 0, s.length());
    }

    // cb -current box
    // tb=total box
    private static void permutationWord(HashMap<Character, Integer> fmap, char[] asf, int cb, int tb) {

        // base
        if (cb == tb) {
            System.out.println(asf);
        }

        for (Character c : fmap.keySet()) {

            if (fmap.get(c) > 0) {

                asf[cb] = c;
                fmap.put(c, fmap.get(c) - 1);
                permutationWord(fmap, asf, cb + 1, tb);
                asf[cb] = '\0';
                fmap.put(c, fmap.get(c) + 1);
            }
        }
    }
}
