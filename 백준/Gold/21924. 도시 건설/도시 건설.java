import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static PriorityQueue<Edge> edges;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        long maxCost = 0;
        long minCost = 0;

        int[] parents = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            parents[i] = i;
        }
        int[] rank = new int[num + 1];
        edges = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));

        for(int i=0; i<line; i++) {
            st = new StringTokenizer(br.readLine());

            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            maxCost += cost;
            edges.offer(new Edge(b1, b2, cost));
        }

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (find(parents, edge.b1) == find(parents, edge.b2)) continue;

            union(parents, rank, edge.b1, edge.b2);
            minCost += edge.cost;
        }

        int tmpParent = find(parents, 1);
        for (int i = 1; i <= num; i++) {
            if (find(parents, i) != tmpParent) {
                System.out.println(-1);
                return;
            }
        }
        sb.append(maxCost - minCost);
        System.out.println(sb);
    }

    private static int find(int[] parents, int n) {
        if (parents[n] == n) return n;
        return parents[n] = find(parents, parents[n]);
    }

    private static void union(int[] parents, int[] rank, int b1, int b2) {
        int p1 = find(parents, b1);
        int p2 = find(parents, b2);

        if (rank[p1] > rank[p2]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;

            if (rank[p1] == rank[p2]) {
                rank[p1]++;
            }
        }
    }

}

class Edge {
    int b1;
    int b2;
    int cost;

    public Edge(int b1, int b2, int cost) {
        this.b1 = b1;
        this.b2 = b2;
        this.cost = cost;
    }
}