import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        PriorityQueue<Link> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.cost));

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int i1 = 0; i1 < n; i1++) {
                int cost = Integer.parseInt(st.nextToken());

                if (i == i1) continue;
                pq.add(new Link(i, i1, cost));
            }
        }

        int count = 0;
        long result = 0;
        while (!pq.isEmpty()) {
            Link minLink = pq.poll();

            int p1 = find(minLink.to);
            int p2 = find(minLink.from);

            if (p1 == p2) continue;

            union(p1, p2);
            count++;
            result += minLink.cost;
            if (count == n - 1) break;
        }

        System.out.println(result);
    }

    private static void union(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        parent[max] = min;
    }

    private static int find(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    static class Link {
        int to;
        int from;
        int cost;

        public Link(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }
}