import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leet {
    public static void main(String[] args) {

        String s = removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4);
        System.out.println(s);
    }

    public static String removeDuplicates(String s, int k) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);

            stack.push(s.charAt(i));

            if (map.get(element) == null) {
                map.put(element, 1);
                if (k == 1) {
                    int temp = k;
                    while (temp-- != 0) {
                        stack.pop();
                    }
                }
            } else {
                int val = map.get(element);
                map.put(element, val + 1);
                if (val + 1 == k) {
                    int temp = k;
                    while (temp-- != 0) {
                        stack.pop();
                    }
                    map.put(element, 0);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
