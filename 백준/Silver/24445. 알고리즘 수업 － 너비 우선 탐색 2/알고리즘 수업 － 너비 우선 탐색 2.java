import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;
    static List<Integer>[] map;
    static int seq = 0;
    static int[] seqs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }
        seqs = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u].add(v);
            map[v].add(u);
        }

        for (int i = 0; i < n + 1; i++) {
            map[i].sort(Collections.reverseOrder());
        }

        bfs(r);
        for (int i = 1; i < seqs.length; i++) {
            System.out.println(seqs[i]);
        }
    }

    private static void bfs(int startNum) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(startNum);
        seqs[startNum] = seq++;

        visited[startNum] = true;

        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            seqs[curNode] = seq++;

            for (Integer i : map[curNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}