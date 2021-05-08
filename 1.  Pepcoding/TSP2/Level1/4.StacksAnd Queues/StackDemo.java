import java.util.Stack;

class StackDemo {

    // oops
    public static class Human {
        private String name;
        private int age;
        private double ht;

        public void display() {
            System.out.println(name + " " + age + " " + ht);
        }

        public void changeData(String n, int a, double h) {
            name = n;
            age = a;
            ht = h;
        }

    }

    public static void main(String[] args) {

        Human h1 = new Human();
        h1.changeData("abc", 23, 6);
        h1.name = "xyz";
        h1.display();
        Human h2 = new Human();
        h2.changeData("def", 25, 7);
        h2.display();

        // creation
        Stack<Integer> st = new Stack<>();

        // addition
        st.push(50);
        st.push(40);
        st.push(30);
        st.push(20);
        st.push(10);

        // printing
        System.out.println(st);

        // removal
        while (st.size() > 0) {
            int rem = st.peek();
            int rem2 = st.pop();
            System.out.println(rem + " , remaining stack " + st + ", rem2 : " + rem2);
        }

        // peek

    }
}