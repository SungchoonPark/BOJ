import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int lineNum = Integer.parseInt(st.nextToken());
        rank = new int[nodeNum+1];
        int[] parent = new int[nodeNum + 1];
        Edge[] edges = new Edge[lineNum];
        long answer = 0;

        for (int i = 1; i <= nodeNum; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, cost);
        }
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge.cost));

        for (Edge edge : edges) {
            // 부모가 같으면 같은 그래프내에 있는거므로 안됨
            if (find(parent,edge.u) == find(parent, edge.v)) continue;

            union(parent, edge.u, edge.v);
            answer += edge.cost;
        }

        System.out.println(answer);
    }

    private static void union(int[] parent, int u, int v) {
        int parent1 = find(parent, u);
        int parent2 = find(parent, v);

        if (rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        } else {
            parent[parent2] = parent1;

            if (rank[parent1] == rank[parent2]) {
                rank[parent1]++;
            }
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
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

    @Override
    public String toString() {
        return u + " " + v + " " + cost;
    }
}