
import java.io.*;
import java.util.*;

public class IsGraphBipartite {
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

        System.out.println(isGraphBipartite(graph));
    }

    public static boolean isGraphBipartite(ArrayList<Edge>[] graph) {
        // we wil store the level in visited arr
        int n = graph.length;
        int vis[] = new int[n];
        Arrays.fill(vis, -1);
        for (int v = 0; v < n; v++) {
            if (vis[v] == -1) {
                boolean res = bfs(graph, vis, v);
                if (res == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bfs(ArrayList<Edge>[] graph, int[] vis, int src) {

        // if i get different level then return false

        // rmwa

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(src, 0));
        while (qu.size() > 0) {
            // remove
            Pair rem = qu.remove();

            // mark
            // already discovered
            // 1. if again discovered with same level-> continue
            // 2. if again discovered, but with different level -> return false,
            // because odd size cycle is present in graph
            if (vis[rem.vtx] != -1) {
                // already visited
                if (vis[rem.vtx] == rem.level) {
                    // same level continue
                    continue;
                } else {
                    // different level
                    return false;
                }
            }
            vis[rem.vtx] = rem.level;

            // add
            for (Edge e : graph[rem.vtx]) {
                if (vis[e.nbr] == -1) {
                    qu.add(new Pair(e.nbr, rem.level + 1));
                }
            }
        }
        return true;
    }

    static class Pair {
        int vtx;
        int level;

        public Pair(int vtx, int level) {
            this.vtx = vtx;
            this.level = level;
        }
    }
}