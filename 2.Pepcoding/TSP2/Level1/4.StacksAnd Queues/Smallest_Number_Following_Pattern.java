import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Smallest_Number_Following_Pattern {

    public static void pattern(String str) {

        Stack<Integer> st = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'd') {
                st.push(count);
                count++;
            } else if (str.charAt(i) == 'i') {
                st.push(count);
                count++;
                while (!st.empty()) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(count);
        while (!st.empty()) {
            System.out.print(st.pop());
        }
        // System.out.println(sb.toString());

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code

        pattern(str);
    }

}
