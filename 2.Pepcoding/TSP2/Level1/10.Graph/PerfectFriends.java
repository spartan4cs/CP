import java.io.*;
import java.util.*;

public class PerfectFriends {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here

        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();

        }
        for (int i = 0; i < k; i++) {
            int src = sc.nextInt();
            int nbr = sc.nextInt();
            g[src].add(nbr);
            g[nbr].add(src);
        }

        // display
        for (int i = 0; i < n; i++) {
            System.out.print("i-> ");
            for (Integer nbr : g[i]) {
                System.out.print(nbr + ", ");
            }
            System.out.println();
        }

    }
}
