import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    static class Node {
        int data;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Node node = new Node();
        a.add(10);
        a.add(20);
        a.add(30);
        fun(a);
        node.data = 10;
        fun2(node);
        System.out.println(node.data);

        a.forEach(s -> System.out.println(s));
    }

    public static void fun2(Node node) {
        node = null;
    }

    public static void fun(ArrayList<Integer> a) {

        a.add(40);
    }
}
