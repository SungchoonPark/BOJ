import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, startCity, goalCity;
    static int[] cost;
    static List<Node>[] busInfos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        busInfos = new List[n + 1];
        cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < busInfos.length; i++) {
            busInfos[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int startCityNum = Integer.parseInt(st.nextToken());
            int goalCityNum = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busInfos[startCityNum].add(new Node(goalCityNum, cost));
        }

        st = new StringTokenizer(br.readLine());

        startCity = Integer.parseInt(st.nextToken());
        goalCity = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    private static void dijkstra() {
        cost[startCity] = 0;
        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.node.cost));
        pq.offer(new Path(new Node(startCity, 0), Arrays.asList(startCity)));

        while (!pq.isEmpty()) {
            Path curPath = pq.poll();

            if (curPath.node.toCity == goalCity) {
                sb.append(cost[curPath.node.toCity]).append("\n");
                sb.append(curPath.path.size()).append("\n");
                for (Integer path : curPath.path) {
                    sb.append(path).append(" ");
                }
                System.out.println(sb);
                return;
            }

            if (cost[curPath.node.toCity] < curPath.node.cost) {
                continue;
            }

            for (Node nextNode : busInfos[curPath.node.toCity]) {
                if (cost[nextNode.toCity] > cost[curPath.node.toCity] + nextNode.cost) {
                    cost[nextNode.toCity] = cost[curPath.node.toCity] + nextNode.cost;
                    List<Integer> tmpList = new ArrayList<>(curPath.path);
                    tmpList.add(nextNode.toCity);
                    pq.offer(new Path(new Node(nextNode.toCity, cost[nextNode.toCity]), tmpList));
                }
            }
        }
    }

    static class Node {
        int toCity;
        int cost;

        public Node(int toCity, int cost) {
            this.toCity = toCity;
            this.cost = cost;
        }
    }

    static class Path {
        Node node;
        List<Integer> path;

        public Path(Node node, List<Integer> path) {
            this.node = node;
            this.path = path;
        }
    }
}