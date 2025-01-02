import java.util.ArrayList;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
public class CycleInDirectGraph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            int v = sc.nextInt();
            int e = sc.nextInt();
            for (int i = 0; i < v; i++) {
                list.add(i, new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                list.get(src).add(dest);

            }

            if (new Solution().isCyclic(v, list) == true) {
                System.out.println("1");
            } else
                System.out.println("0");
        }
    }

}

class Solution {

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> graph) {
        // code here

        boolean vis[] = new boolean[n];
        boolean mypath[] = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (vis[v] == false) {

                boolean res = dfswithmypath(graph, vis, v, mypath);
                if (res == true) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean dfswithmypath(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int src, boolean[] mypath) {

        vis[src] = true;
        mypath[src] = true;
        for (Integer nbr : graph.get(src)) {

            if (mypath[nbr] == true) {
                return true;
            } else if (vis[nbr] == false) {
                boolean res = dfswithmypath(graph, vis, nbr, mypath);
                if (res == true) {
                    return true;
                }
            }
        }
        mypath[src] = false;

        return false;
    }
}