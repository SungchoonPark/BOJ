import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static List<Node>[] graph;
    static StringBuilder sb;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[V + 1];
        graph = new List[V + 1];

        for(int i=0; i<V+1; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<V+1; i++) dist[i] = Integer.MAX_VALUE;

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        pq.offer(new Node(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }

            for (Node nextNode : graph[curNode.idx]) {
                if (dist[nextNode.idx] > curNode.cost + nextNode.cost) {
                    dist[nextNode.idx] = curNode.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

        for (int i=1; i<dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }
}

class Node {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}
