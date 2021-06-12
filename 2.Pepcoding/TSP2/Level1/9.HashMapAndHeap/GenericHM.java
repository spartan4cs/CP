
import java.io.*;
import java.util.*;

public class GenericHM {

    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        // helper
        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        private int searchInBucket(K key, int bi) {

            int di = -1;
            for (HMNode node : buckets[bi]) {
                di++;
                if (node.key.equals(key)) {
                    return di;
                }
            }
            return -1;
        }

        public void put(K key, V value) throws Exception {
            // write your code here
            int bi = hashFunction(key);
            int di = searchInBucket(key, bi);

            if (di == -1) {

                // not present
                buckets[bi].addLast(new HMNode(key, value));
                size++;
            } else {
                buckets[bi].get(di).value = value;
            } // rehash
            int n = size;
            int N = buckets.length;
            double lambda = n * 1.0 / N;

            if (lambda > 2.0) {
                rehash();
            }
        }

        private void rehash() throws Exception {
            LinkedList<HMNode>[] ob = buckets;
            initbuckets(2 * buckets.length);
            // travel old bucket ans filli in new one
            size = 0;
            for (int i = 0; i < ob.length; i++) {
                for (HMNode node : ob[i]) {
                    put(node.key, node.value);
                }
            }
        }

        public V get(K key) throws Exception {
            // write your code here
            // find bucket index using hashfucntion
            int bi = hashFunction(key);

            // find data index of linkedlist from that particular bucket index
            int di = searchInBucket(key, bi);
            if (di == -1) {
                // if not present then return -1

                return null;
            } else {
                // if data index present then remove

                HMNode n = buckets[bi].get(di);
                return n.value;
            }
        }

        public boolean containsKey(K key) {
            // write your code here
            // find bucket index using hashfucntion
            int bi = hashFunction(key);

            // find data index of linkedlist from that particular bucket index
            int di = searchInBucket(key, bi);
            if (di == -1) {
                // if not present then return -1

                return false;
            } else
                return true;
        }

        public V remove(K key) throws Exception {
            // write your code here
            // find bucket index using hashfucntion
            int bi = hashFunction(key);

            // find data index of linkedlist from that particular bucket index
            int di = searchInBucket(key, bi);
            if (di == -1) {
                // if not present then return -1

                return null;
            } else {
                // if data index present then remove

                HMNode n = buckets[bi].remove(di);
                size--;
                return n.value;
            }
        }

        public ArrayList<K> keyset() throws Exception {
            // write your code here
            ArrayList<K> al = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i]) {
                    al.add(node.key);
                }
            }
            return al;
        }

        public int size() {
            // write your code here
            return this.size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}