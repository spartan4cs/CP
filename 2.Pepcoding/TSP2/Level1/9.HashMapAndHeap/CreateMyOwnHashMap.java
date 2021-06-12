import java.util.ArrayList;
import java.util.LinkedList;

public class CreateMyOwnHashMap {

    // helper
    private int hashFunction(String key) {
        return Math.abs(key.hashCode()) % bucket.length;
    }

    private int searchInBucket(String key, int bi) {

        int di = -1;
        for (Node node : bucket[bi]) {
            di++;
            if (node.key.equals(key)) {
                return di;
            }
        }
        return -1;
    }

    // 1. create node
    class Node {
        String key;
        int value;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 2. initialization
    int size = 0;
    private LinkedList<Node>[] bucket;

    private void init(int cap) {
        bucket = new LinkedList[cap];
        for (int i = 0; i < cap; i++) {
            bucket[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    public CreateMyOwnHashMap() {
        init(4);
    }

    // 3. Funcationalities

    // put

    public void put(String key, int value) {

        // find bucket index using hashfucntion
        int bi = hashFunction(key);

        // find data index of linkedlist from that particular bucket index
        int di = searchInBucket(key, bi);
        if (di == -1) {
            // if not present then insert
            bucket[bi].addLast(new Node(key, value));
            size++;

        } else {
            // if data index present then update existing node
            bucket[bi].get(di).value = value;
        }
    }

    // 4. get Functionality
    public int get(String key) {

        // find bucket index using hashfucntion
        int bi = hashFunction(key);

        // find data index of linkedlist from that particular bucket index
        int di = searchInBucket(key, bi);
        if (di == -1) {
            // if not present then return -1

            return -1;
        } else {
            // if data index present then remove

            Node n = bucket[bi].get(di);
            return n.value;
        }
    }

    // 5. remove functionaluty
    public int remove(String key) {

        // find bucket index using hashfucntion
        int bi = hashFunction(key);

        // find data index of linkedlist from that particular bucket index
        int di = searchInBucket(key, bi);
        if (di == -1) {
            // if not present then return -1

            return -1;
        } else {
            // if data index present then remove

            Node n = bucket[bi].remove(di);
            size--;
            return n.value;
        }
    }

    // 6 contains key
    public boolean containsKey(String key) {

        // find bucket index using hashfucntion
        int bi = hashFunction(key);

        // find data index of linkedlist from that particular bucket index
        int di = searchInBucket(key, bi);
        if (di == -1) {
            // if not present then return -1

            return false;
        }
        return true;
    }

    // 7. keyset
    public ArrayList<String> keySet() {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < bucket.length; i++) {
            for (Node node : bucket[i]) {
                al.add(node.key);
            }
        }
        return al;
    }

    // 8. display
    public void display() {
        for (int i = 0; i < bucket.length; i++) {
            for (Node node : bucket[i]) {
                System.out.println("[" + node.key + " - " + node.value + "]");
            }

        }
    }

    // 9. hashmap view
    public void hashmapview() {
        for (int i = 0; i < bucket.length; i++) {
            System.out.print("bucket : " + i + " -> ");
            for (Node node : bucket[i]) {
                System.out.print("[" + node.key + " - " + node.value + "], ");
            }
            System.out.println(".");
        }
    }

    // 9. size
    public int size() {
        return this.size;
    }

    public static void main(String[] args) {

        CreateMyOwnHashMap map = new CreateMyOwnHashMap();
        map.put("India", 130);
        map.put("Pak", 20);
        map.put("Bhutan", 2);
        map.put("Lanka", 1);
        map.put("Nepal", 10);
        map.put("China", 150);
        map.put("Afgan", 13);
        map.put("Aus", 50);
        map.put("India", 135);
        map.put("India", 140);
        map.put("India", 145);

        map.display();
        map.hashmapview();

        System.out.println(map.size());
        System.out.println(map.remove("abc"));
        System.out.println(map.remove("Pak"));
        map.hashmapview();
        System.out.println(map.size());
        System.out.println("keyset--->");

        map.keySet().forEach(s -> System.out.println(s));
        System.out.println(map.size());
        System.out.println(map.get("India"));
        System.out.println(map.containsKey("Lanka"));
        System.out.println(map.containsKey("Pak"));
    }
}
