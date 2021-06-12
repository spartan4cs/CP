import java.util.HashMap;

public class HashMapUsage {
    public static void main(String[] args) {

        HashMap<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(2, true);
        int arr[] = { 1, 2, 3, 4, 5 };
        for (int i : arr) {
            // if (map.containsKey(i)) {
            while (map.get(i + 1) == true) {
                i++;
                System.out.println("in while - > " + i);
            }
            // }
            System.out.println(i);
        }

    }
}
