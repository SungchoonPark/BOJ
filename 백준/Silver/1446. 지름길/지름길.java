import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        graph = new List[d + 1];
        dist = new int[d + 1];

        for (int i = 0; i <= d; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < d; i++) {
            graph[i].add(new Node(i + 1, 1));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end <= d) graph[start].add(new Node(end, cost));
        }

        dijkstra(0);

        System.out.println(dist[d]);

    }

    private static void dijkstra(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(n, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curN = curNode.node;
            int cost = curNode.cost;

            if (dist[curN] < cost) continue;

            for (Node node : graph[curN]) {
                int newDist = dist[curN] + node.cost;

                if (newDist < dist[node.node]) {
                    dist[node.node] = newDist;
                    pq.add(new Node(node.node, newDist));
                }
            }
        }
    }

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}