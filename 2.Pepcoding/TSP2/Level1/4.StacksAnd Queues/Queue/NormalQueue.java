import java.io.*;
import java.util.*;

class NormalQueue {
    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        void add(int val) {
            // write ur code here

            if (size == data.length) {
                System.out.println("Queue overflow");
                return;
            }
            int index = (this.front + this.size) % data.length;
            data[index] = val;
            this.size++;
        }

        int remove() {
            // write ur code here

            if (this.size == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            int val = data[front];
            this.front = (this.front + 1) % data.length;
            this.size--;
            return val;
        }

        int peek() {
            // write ur code here

            if (this.size == 0) {
                System.out.println("Queue underflow");
                return -1;
            }
            return data[this.front];
        }

        int size() {
            // write ur code here
            return this.size;
        }

        void display() {
            // write ur code here

            // till size -1 - > to display last element separately with "]"
            for (int i = 0; i < size; i++) {
                int index = (i + front) % data.length;
                System.out.print(data[index] + " ");

            }
            System.out.println();
        }

        @Override
        public String toString() {
            // write ur code here
            String str = "";
            str += "[";
            // till size -1 - > to display last element separately with "]"
            for (int i = 0; i < size - 1; i++) {
                int index = (i + front) % data.length;
                str += data[index] + ",";

            }
            // attaching last element and "]"
            if (this.size > 0)
                str += data[(size - 1 + front) % data.length] + "]";
            else {
                str += "]";
            }
            return str;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            } else if (str.startsWith("display")) {
                qu.display();
            }
            str = br.readLine();
        }
    }
}