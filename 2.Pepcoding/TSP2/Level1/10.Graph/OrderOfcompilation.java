import java.io.*;
import java.util.*;

public class OrderOfcompilation {
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
        }

        // write your code here

        // it will work for Directed Acyclic graph

        int n = graph.length;
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (vis[v] == false) {
                dfs(graph, vis, v, st);
            }
        }
        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }

    // dfs with postorder push

    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int src, Stack<Integer> st) {
        vis[src] = true;

        for (Edge edge : graph[src]) {
            if (vis[edge.nbr] == false) {
                dfs(graph, vis, edge.nbr, st);
            }
        }

        st.push(src);
    }

}