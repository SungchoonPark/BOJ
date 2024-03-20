import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int comNum = Integer.parseInt(br.readLine());
        int lineNum = Integer.parseInt(br.readLine());

        int[] parents = new int[comNum + 1];
        int[] depth = new int[comNum + 1];
        Edge[] edges = new Edge[lineNum];

        int answer = 0;

        for (int i = 1; i <= comNum; i++) {
            parents[i] = i;
        }

        for(int i=0; i<lineNum; i++) {
            st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(c1, c2, cost);
        }
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge.cost));

        for (Edge edge : edges) {
            if (findParent(parents, edge.u) == findParent(parents, edge.v)) continue;

            union(depth, parents, edge.u, edge.v);
            answer += edge.cost;
        }

        System.out.println(answer);
    }

    private static int findParent(int[] parents, int c) {
        if (parents[c] == c) return c;
        return parents[c] = findParent(parents, parents[c]);
    }

    private static void union(int[] depth, int[] parents, int c1, int c2) {
        int p1 = findParent(parents, c1);
        int p2 = findParent(parents, c2);
        
        if (depth[p1] > depth[p2]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;

            if (depth[p1] == depth[p2]) {
                depth[p1]++;
            }
        }
    }


}

class Edge {
    int u;
    int v;
    int cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}