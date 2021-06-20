
import java.io.*;
import java.util.*;

public class SpreadOfInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
        int t = Integer.parseInt(br.readLine());

        // write your code here

        System.out.println(soi(graph, src, t));
    }

    public static int soi(ArrayList<Edge>[] graph, int src, int t) {

        int vis[] = new int[graph.length];
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(src, 1));

        int count = 0;
        while (qu.size() > 0) {
            // rmwa

            Pair rem = qu.remove();

            // mark
            if (vis[rem.vtx] != 0) {
                continue;
            }

            vis[rem.vtx] = rem.level;

            if (rem.level > t) {
                break;
            }
            // add
            count++;

            for (Edge e : graph[rem.vtx]) {
                if (vis[e.nbr] == 0) {
                    qu.add(new Pair(e.nbr, rem.level + 1));
                }
            }

        }
        return count;
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