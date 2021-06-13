import java.util.ArrayList;

public class CustomPriorityQueue {

    // min priority Queue

    private ArrayList<Integer> data;

    public CustomPriorityQueue() {
        data = new ArrayList<>();
    }

    // helper

    public void upheapify(int index) {
        if (index == 0) {
            return;
        }

        int pi = (index - 1) / 2;
        if (data.get(pi) > data.get(index)) {
            swap(pi, index);
            upheapify(pi);
        }
    }

    public void swap(int i, int j) {

        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public void downheapify(int index) {

        int minIdx = index;

        int lci = 2 * index + 1;
        int rci = 2 * index + 2;
        if (lci < data.size() && data.get(lci) < data.get(minIdx)) {
            minIdx = lci;
        }
        if (rci < data.size() && data.get(rci) < data.get(minIdx)) {
            minIdx = rci;

        }

        if (minIdx != index) {
            swap(index, minIdx);
            downheapify(minIdx);
        }
    }
    // add

    public void add(int val) {
        data.add(val);

        // maintain heap order property

        upheapify(data.size() - 1);
    }

    // remove
    public int remove() {
        if (data.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }

        swap(0, data.size() - 1);
        int val = data.remove(data.size() - 1);
        // maintain heap order property
        downheapify(0);
        return val;
    }

    // peek
    public int peek() {
        if (data.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return data.get(0);
    }

    // size
    public int size() {
        return data.size();
    }

    // display
    public void display() {
        System.out.println(data);
    }

    public static void main(String[] args) {
        CustomPriorityQueue pq = new CustomPriorityQueue();
        // add 10
        // add 20
        // add 30
        // add 40
        // peek
        // add 50
        // peek
        // remove
        // peek
        // remove
        // peek
        // remove
        // peek
        // remove
        // peek
        // quit
        pq.add(50);
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.display();
        pq.add(9);
        pq.display();

        System.out.println(pq.peek());
        System.out.println("r->" + pq.remove());
        pq.display();

        System.out.println(pq.peek());
        System.out.println("r->" + pq.remove());
        pq.display();

        System.out.println(pq.peek());
        System.out.println("r->" + pq.remove());
        pq.display();

        System.out.println(pq.peek());
        System.out.println("r->" + pq.remove());
        pq.display();

        System.out.println(pq.peek());
        System.out.println("r->" + pq.remove());
        pq.display();

        System.out.println(pq.peek());
        System.out.println("r->" + pq.remove());
        pq.display();

    }
}
