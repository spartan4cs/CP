import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public static long add(long n) {
        long addition = n / 2 + n / 3 + n / 4;
        if (n < addition) {
            return add(n / 2) + add(n / 3) + add(n / 4);
        } else {
            return n;
        }

    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        long i = 0;
        while (sc.hasNext()) {
            i = sc.nextLong();
            System.out.println(add(i));

        }
    }
}