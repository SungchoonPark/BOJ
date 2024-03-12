import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int endCity;
    int cost;

    public Node(int endCity, int cost) {
        this.endCity = endCity;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

public class Main {
    static StringTokenizer st;
    static int cityNum;
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        for(int i=0; i<=cityNum; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<busNum; i++) {
            st = new StringTokenizer(br.readLine());

            int fromCity = Integer.parseInt(st.nextToken());
            int toCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 단방향 인접 리스트 구성
            list.get(fromCity).add(new Node(toCity, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int destCity = Integer.parseInt(st.nextToken());

        int result = dijkstra(startCity, destCity);
        System.out.println(result);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[cityNum + 1];
        int[] cost = new int[cityNum + 1];

        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(isVisited, false);

        pq.offer(new Node(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.endCity;

            if (!isVisited[cur]) {
                isVisited[cur] = true;

                for (Node node : list.get(cur)) {
                    if (!isVisited[node.endCity] && cost[node.endCity] > cost[cur] + node.cost) {
                        cost[node.endCity] = cost[cur] + node.cost;
                        pq.add(new Node(node.endCity, cost[node.endCity]));
                    }
                }
            }
        }

        return cost[end];
    }

}