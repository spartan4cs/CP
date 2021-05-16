import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Linklist_To_Stack_Adapter {
    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            // write your code here
            return list.size();
        }

        void push(int val) {
            // write your code here
            list.addFirst(val);

        }

        int pop() {
            // write your code here
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int top() {
            // write your code here
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            str = br.readLine();
        }
    }
}
