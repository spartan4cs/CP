import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PatternMatching {
    public static void solution(String str, String pattern, Map<Character, String> map, int cl) {
        // write your code here
        if (cl == pattern.length()) {

            if (str.length() == 0) {
                for (Character c : map.keySet()) {

                    System.out.print(c + " -> " + map.get(c) + ", ");

                }
                System.out.println(".");
            }
            return;
        }
        char ch = pattern.charAt(cl);

        // if already present in map so just go to next level
        if (map.containsKey(ch)) {
            String prevMap = map.get(ch);
            if (str.length() >= prevMap.length()) {

                String newVal = str.substring(0, prevMap.length());
                if (newVal.equals(prevMap)) {
                    String rem = str.substring(prevMap.length());
                    solution(rem, pattern, map, cl + 1);
                }

            }
        } else {

            for (int i = 0; i < str.length(); i++) {

                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);
                map.put(ch, left);
                solution(right, pattern, map, cl + 1);
                map.remove(ch);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        Map<Character, String> map = new LinkedHashMap<>();
        solution(str, pattern, map, 0);
    }

}
