import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int homeCount;
    static int bridgeCount;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        homeCount = Integer.parseInt(st.nextToken());
        bridgeCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Bridge> pq = new PriorityQueue<>((b1, b2) -> b2.weight - b1.weight);
        parent = new int[homeCount + 1];
        for (int i = 0; i < homeCount + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < bridgeCount; i++) {
            st = new StringTokenizer(br.readLine());

            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Bridge(h1, h2, w));
        }

        while(!pq.isEmpty()) {
            Bridge maxBridge = pq.poll();

            int p1 = find(maxBridge.h1);
            int p2 = find(maxBridge.h2);

            if (p1 == p2) continue;

            union(p1, p2);
            if (find(s) == find(e)) {
                System.out.println(maxBridge.weight);
                return;
            }
        }

        System.out.println(0);
    }

    static int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    static void union(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        parent[max] = min;
    }

    static class Bridge {
        int h1;
        int h2;
        int weight;

        public Bridge(int h1, int h2, int weight) {
            this.h1 = h1;
            this.h2 = h2;
            this.weight = weight;
        }
    }
}