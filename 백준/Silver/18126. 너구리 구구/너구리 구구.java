import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;
    static List<Node>[] graph;
    static boolean[] visited;
    static long maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList();
        }

        visited = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, length));
            graph[b].add(new Node(a, length));
        }

        visited[0] = true;
        visited[1] = true;
        search(1, 0);
        System.out.println(maxLength);
    }

    private static void search(int startNodeNum, long accLength) {
        int next = graph[startNodeNum].get(0).next;

        if (graph[startNodeNum].size() == 1 && visited[next]) {
            maxLength = Math.max(maxLength, accLength);
            return;
        }

        for (Node node : graph[startNodeNum]) {
            if (!visited[node.next]) {
                visited[node.next] = true;
                search(node.next, accLength + node.value);
            }
        }
    }

    static class Node {
        int next;
        int value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

}