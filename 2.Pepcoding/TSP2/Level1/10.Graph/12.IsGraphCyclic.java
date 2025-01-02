
import java.io.*;
import java.util.*;

public class IsGraphCyclic {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        System.out.println(isCyclic(graph));

    }

    public static boolean isCyclic(ArrayList<Edge>[] graph) {

        int n = graph.length;
        boolean vis[] = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (vis[v] == false) {
                boolean res = bfs(graph, v, vis);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfs(ArrayList<Edge>[] graph, int src, boolean vis[]) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(src);
        while (qu.size() > 0) {

            // rwma

            Integer rem = qu.remove();

            //work
            if (vis[rem] == true) {
                // cycle dected
                return true;
            }
            // mark
            vis[rem] = true;

            // add
            for (Edge e : graph[rem]) {
                if (vis[e.nbr] == false) {
                    qu.add(e.nbr);
                }
            }
        }
        return false;
    }
}