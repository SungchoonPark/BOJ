import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        graph = new List[v + 1];
        dist = new int[v + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        dist[0] = 0;
        dist[start] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(n, w));
        }
        
        dijkstra(start);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v + 1; i++) {
            int d = dist[i];
            
            if (d == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(d).append("\n");
            }
        }

        System.out.print(sb);
    }
    
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.node] < curNode.cost) continue;

            for (Node next : graph[curNode.node]) {
                int newDist = dist[curNode.node] + next.cost;

                if (dist[next.node] > newDist) {
                    dist[next.node] = newDist;
                    pq.offer(new Node(next.node, newDist));
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