import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        String ansc = "";
        for (Character k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
            // ans = Math.max(ans, map.get(k));
            if (map.get(k) > ans) {
                ans = map.get(k);
                ansc = k.toString();
            }
        }
        System.out.println(ansc);
    }

}
