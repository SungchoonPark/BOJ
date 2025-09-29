import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int v, e;
    static int[] ps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        ps = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            ps[i] = i;
        }

        PriorityQueue<Link> priorityQueue = new PriorityQueue<>((l1, l2) -> l1.cost - l2.cost);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Link(a, b, c));
        }

        int count = 0;
        int result = 0;
        while(!priorityQueue.isEmpty()) {
            Link minLink = priorityQueue.poll();

            int p1 = find(minLink.to);
            int p2 = find(minLink.from);
            if (p1 == p2) continue;

            union(p1, p2);
            count++;
            result += minLink.cost;

            if (count == v - 1) {
                break;
            }
        }

        System.out.println(result);
    }

    private static int find(int node) {
        if (ps[node] == node) {
            return node;
        }

        return ps[node] = find(ps[node]);
    }

    private static void union(int parent, int child) {
        ps[child] = parent;
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