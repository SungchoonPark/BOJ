import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] cntHack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        cntHack = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            visited[i] = true;
            q.offer(i);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int trust : list[cur]) {
                    if (!visited[trust]) {
                        q.offer(trust);
                        cntHack[trust]++;
                        visited[trust] = true;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int v : cntHack) {
            max = Math.max(v, max);
        }

        for (int i = 1; i < n + 1; i++) {
            if (cntHack[i] == max) sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}
