import java.io.*;
import java.util.*;

public class Dijkstra {
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

        int src = Integer.parseInt(br.readLine());
        // write your code here
        bfsWithPQ(graph, src);
    }

    //single source shortest path
    //from single source to all vertex shortest path
    //doesnot work for -ve wgts
    public static void bfsWithPQ(ArrayList<Edge>[] graph, int src) {

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> qu = new PriorityQueue<>();
        qu.add(new Pair(src, "" + src, 0));

        while (qu.size() > 0) {
            // rmwa
            Pair rem = qu.remove();

            // mark

            if (vis[rem.vtx] == true) {
                continue;
            }
            vis[rem.vtx] = true;

            // work
            System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wgt);

            // add neighbout
            for (Edge e : graph[rem.vtx]) {
                if (vis[e.nbr] == false) {
                    qu.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wgt + e.wt));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int vtx;
        String psf;
        int wgt;

        public Pair(int vtx, String psf, int wgt) {
            this.vtx = vtx;
            this.psf = psf;
            this.wgt = wgt;

        }

        public int compareTo(Pair o) {
            return this.wgt - o.wgt;
        }

    }
}
