import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * https://www.codechef.com/CDIG2021/problems/RJ3
 * 
 * convert to binary and count 1
 */
class RJ3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> res = new ArrayList<>();
            int temp = n;
            while (temp > 0) {
                int q = temp / 2;
                int r = temp % 2;
                res.add(r);
                temp /= 2;
            }
            // res.forEach(s -> System.out.println(s));
            int count = 0;
            for (Integer i : res) {
                if (i == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}