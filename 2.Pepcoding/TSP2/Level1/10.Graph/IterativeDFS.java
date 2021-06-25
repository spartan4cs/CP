import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {

    static class Edge {

        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;

        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vt = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vt];
        for(int i=0;i<vt;i++){
            graph[i]=new ArrayList<>();
        }
        
        int edge = Integer.parseInt(br.readLine());


        for (int i = 0; i < edge; i++) {

            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        // write you code

        // bfs with stack

        bfsWithStack(graph, src);
    }

    static class Pair {
        int vt;
        String psf;

        Pair(int vt, String psf) {
            this.vt = vt;
            this.psf = psf;
        }
    }

    public static void bfsWithStack(ArrayList<Edge>[] graph, int src) {

        int n = graph.length;
        boolean vis[] = new boolean[n];

        // rmwa;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src + ""));

        while (st.size() > 0) {

            Pair rem = st.pop();

            if (vis[rem.vt] == true) {
                continue;
            }

            vis[rem.vt] = true;

            System.out.println(rem.vt + "@" + rem.psf);

            for (Edge e : graph[rem.vt]) {

                if (vis[e.nbr] == false) {
                    st.push(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }

    }
}
