import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class RemovePrimes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        int data = sc.nextInt();
        removeData(al, data);
        // removePrimes(al);
    }

    public static void display(List<Integer> al) {
        for (Integer integer : al) {
            System.out.println(integer);
        }

    }

    public static void removePrimes(List<Integer> al) {

        // al.removeIf(x -> isPrime(x));

        int i = al.size() - 1;
        while (i >= 0) {
            if (isPrime(al.get(i)))
                al.remove(i);

            i--;
        }
        display(al);
    }

    public static boolean isPrime(Integer n) {

        boolean flag = true;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // best possible complexity No extra space allowed. no order maintained
    public static void removeData(List<Integer> al, int data) {

        // this takaes O(n) as we are managing the shifting
        int i = al.size() - 1;
        while (i >= 0) {
            if (al.get(i) == data) {
                int n = al.size();
                int last = al.get(n - 1);
                al.set(i, last);
                al.remove(last);
            }
        }

        // this takes O (n^2 ) for n elements having haldf element with our data
        // as shifting is takes O(n)
        /*
         * int i = al.size() - 1; while (i >= 0) { if (al.get(i) == data) {
         * al.remove(i); } i--; }
         */
        display(al);
    }
}