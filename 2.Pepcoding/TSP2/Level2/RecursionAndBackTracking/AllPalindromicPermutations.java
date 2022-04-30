import java.util.HashMap;
import java.util.Scanner;

public class AllPalindromicPermutations {
    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {

        if (cs == ts) {

            
        }

        for (char ch : fmap.keySet()) {

            int freq = fmap.get(ch);
            if (freq > 0) {

                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        // write your code here
        // approach
        // divide even and odd both by 2freq char
        // there should be only 1 odd freq char
        // if more tthan one then we cannot form palindromic perm
        // perm1+odd char + rev(perm1)

        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch : fmap.keySet()) {

            int freq = fmap.get(ch);

            if (freq % 2 == 1) {

                odd = ch;
                odds++;
            }
            fmap.put(ch, freq / 2);
            len += freq / 2;

        }

        // if there are char having freq odd, more than 1, we cannot form palindromic
        // perm

        if (odds > 1) {
            System.out.println(-1);
            return;
        }
        generatepw(0, len, fmap, odd, "");
    }
}
