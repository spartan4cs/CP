import java.io.*;
import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int vtx;
        String psf;

        Pair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here

        boolean vis[] = new boolean[graph.length];
        // rmwa

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(src, src + ""));

        while (qu.size() > 0) {

            // remove
            Pair rem = qu.remove();

            //work
            if (vis[rem.vtx] == true) {
                continue;
            }
            // mark
            vis[rem.vtx] = true;

            // print
            System.out.println(rem.vtx + "@" + rem.psf);

            // add neighbour
            for (Edge e : graph[rem.vtx]) {
                if (vis[e.nbr] == false) {
                    qu.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }

        }
    }
}
