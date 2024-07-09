import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int d;
    static ArrayList<ArrayList<Shortcut>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dist = new int[10001];
        for(int i=0; i<dist.length; i++) dist[i] = i;

        for(int i=0; i<=10001; i++) graph.add(new ArrayList<>());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int startPos = Integer.parseInt(st.nextToken());
            int endPos = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (endPos > d) continue;
            graph.get(startPos).add(new Shortcut(endPos, cost));
        }

        dijkstra(0);
        System.out.println(dist[d]);
    }

    private static void dijkstra(int startPos) {
        if (startPos > d) return;

        if (dist[startPos + 1] > dist[startPos] + 1) dist[startPos + 1] = dist[startPos] + 1;

        for(int i=0; i<graph.get(startPos).size(); i++) {
            if (dist[startPos] + graph.get(startPos).get(i).cost < dist[graph.get(startPos).get(i).toPos]) {
                dist[graph.get(startPos).get(i).toPos] = dist[startPos] + graph.get(startPos).get(i).cost;
            }
        }

        dijkstra(startPos + 1);
    }

    static class Shortcut {
        int toPos;
        int cost;

        public Shortcut(int toPos, int cost) {
            this.toPos = toPos;
            this.cost = cost;
        }
    }
}