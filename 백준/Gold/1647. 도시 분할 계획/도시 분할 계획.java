import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int homeCount, roadCount;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        homeCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());

        parent = new int[homeCount + 1];
        PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> i1.cost - i2.cost);

        for (int i = 0; i < homeCount + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < roadCount; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Info(a, b, c));
        }

        int count = 0;
        int result = 0;
        while(!pq.isEmpty()) {
            Info minInfo = pq.poll();

            int p1 = find(minInfo.to);
            int p2 = find(minInfo.from);

            if (p1 == p2) continue;

            union(p1, p2);
            count++;
            if (count == homeCount - 1) break;

            result += minInfo.cost;

        }

        System.out.println(result);
    }

    private static int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    private static void union(int n1, int n2) {
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);

        parent[max] = min;
    }

    static class Info {
        int to;
        int from;
        int cost;

        public Info(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }
}