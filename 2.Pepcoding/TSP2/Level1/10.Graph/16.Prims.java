
import java.io.*;
import java.util.*;

public class Prims {
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

        // creatign minimum spannig tree
        // not cyclic + connected to all vertex--> tree
        // all nodes connected with wire and wt is min
        ArrayList<Edge>[] mst = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            mst[i] = new ArrayList<>();
        }
        bfsWithPQ(graph, mst);
        display(mst);

    }

    public static void bfsWithPQ(ArrayList<Edge>[] graph, ArrayList<Edge>[] mst) {

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));

        while (pq.size() > 0) {
            // rmwa

            Pair rem = pq.remove();

            // mark
            if (vis[rem.vtx] == true) {
                continue;
            }
            vis[rem.vtx] = true;

            // syso
            if (rem.par != -1) {
                // o/p
                System.out.println("[" + rem.vtx + "-" + rem.par + "@" + rem.wgt + "]");
                // crating mst
                addEdge(mst, rem.vtx, rem.par, rem.wgt);

            }
            // add
            for (Edge e : graph[rem.vtx]) {
                if (vis[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, rem.vtx, e.wt));

                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int vtx;
        int par;
        int wgt;

        public Pair(int vtx, int par, int wgt) {
            this.vtx = vtx;
            this.par = par;
            this.wgt = wgt;
        }

        public int compareTo(Pair o) {
            return this.wgt - o.wgt;
        }

    }

    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt) {
        graph[src].add(new Edge(src, nbr, wt));
        graph[nbr].add(new Edge(nbr, src, wt));
    }

    public static void display(ArrayList<Edge>[] graph) {
        for (int v = 0; v < graph.length; v++) {
            System.out.print("[" + v + "] -> ");
            for (int n = 0; n < graph[v].size(); n++) {
                Edge e = graph[v].get(n);
                System.out.print("[" + e.src + "-" + e.nbr + " @ " + e.wt + "], ");
            }
            System.out.println();
        }
    }
}