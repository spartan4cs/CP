import java.io.*;
import java.util.*;

public class PerfectFriends {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

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

        boolean vis[] = new boolean[n];

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            ArrayList<Integer> comp = new ArrayList<>();
            if (vis[v] == false) {
                getgcc(g, vis, v, comp);
                res.add(comp);
            }
        }

        // System.out.println(res);[[0, 1], [2, 3], [4, 5, 6]]

        // display arr
        // for (int i = 0; i < n; i++) {
        // System.out.print(i + "-> ");
        // for (Integer nbr : g[i]) {
        // System.out.print(nbr + ", ");
        // }
        // System.out.println();
        // }

        // get p and c
        int sum = res.get(res.size() - 1).size(); // last ka size
        // iterate form back

        int ans = 0;
        for (int i = res.size() - 2; i >= 0; i--) {
            int eleSize = res.get(i).size();
            ans += eleSize * sum;
            sum += eleSize;

        }
        System.out.println(ans);
    }

    public static void getgcc(ArrayList<Integer>[] g, boolean[] vis, int src, ArrayList<Integer> comp) {

        vis[src] = true;
        comp.add(src);

        for (Integer e : g[src]) {
            if (vis[e] == false) {
                getgcc(g, vis, e, comp);
            }
        }
    }
}
