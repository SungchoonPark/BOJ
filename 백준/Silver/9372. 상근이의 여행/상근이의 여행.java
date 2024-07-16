import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(st.nextToken());

        for(int i=0; i<testNum; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list = new List[n+1];
            visited = new boolean[n + 1];
            for(int j=0; j<=n; j++) {
                list[j] = new ArrayList<>();
            }

            for(int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }
            sb.append(bfs(1)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        int path = 0;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : list[poll]) {
                if (!visited[i]) {
                    path++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return path;
    }
}
