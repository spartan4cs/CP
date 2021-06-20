
import java.io.*;
import java.util.*;

public class IsGraphConnected {
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

        int n = graph.length;
        boolean vis[] = new boolean[n];
        // travel each vertex
        int count = 0;
        for (int v = 0; v < n; v++) {
            if (vis[v] == false) {

                count++;
                if (count > 1) {

                    break;
                }
                isgcc(graph, vis, v);
            }

        }
        if (count > 1) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    public static void isgcc(ArrayList<Edge>[] graph, boolean[] vis, int src) {

        vis[src] = true;

        for (Edge e : graph[src]) {
            if (vis[e.nbr] == false) {
                isgcc(graph, vis, e.nbr);
            }
        }
    }
}