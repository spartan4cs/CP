import java.io.*;
import java.util.*;

public class GetConnectedComponent {
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

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        // write your code here

        boolean[] vis = new boolean[graph.length];
        for (int v = 0; v < graph.length; v++) {
            if (vis[v] == false) {

                ArrayList<Integer> ans = new ArrayList<>();
                gcc(graph, v, ans, vis);
                comps.add(ans);
            }
        }

        System.out.println(comps);
    }

    public static void gcc(ArrayList<Edge>[] graph, int src, ArrayList<Integer> ans, boolean[] vis) {

        // mark
        vis[src] = true;

        ans.add(src);
        // for every neighbour not visited
        for (Edge e : graph[src]) {
            if (vis[e.nbr] == false) {
                gcc(graph, e.nbr, ans, vis);
            }
        }
    }
}