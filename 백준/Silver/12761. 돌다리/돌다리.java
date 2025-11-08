import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int a, b;
    static boolean[] visited = new boolean[100_001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int bfs = bfs(n, m);

        System.out.println(bfs);
    }

    private static int bfs(int start, int goal) {
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(start, 0));

        while(!queue.isEmpty()) {
            Info curInfo = queue.poll();

            int cnt = curInfo.cnt;
            int pos = curInfo.pos;

            if (pos == goal) {
                return cnt;
            }
            if (pos * a < 100_001 && !visited[pos * a]) {
                visited[pos * a] = true;
                queue.offer(new Info(pos * a, cnt + 1));
            }

            if (pos * b < 100_001 && !visited[pos * b]) {
                visited[pos * b] = true;
                queue.offer(new Info(pos * b, cnt + 1));
            }

            if (pos + a < 100_001 && !visited[pos + a]) {
                visited[pos + a] = true;
                queue.offer(new Info(pos + a, cnt + 1));
            }

            if (pos + b < 100_001 && !visited[pos + b]) {
                visited[pos + b] = true;
                queue.offer(new Info(pos + b, cnt + 1));
            }

            if (pos - a > 0 && !visited[pos - a]) {
                visited[pos - a] = true;
                queue.offer(new Info(pos - a, cnt + 1));
            }

            if (pos - b > 0 && !visited[pos - b]) {
                visited[pos - b] = true;
                queue.offer(new Info(pos - b, cnt + 1));
            }

            if (pos + 1 < 100_001 && !visited[pos + 1]) {
                visited[pos + 1] = true;
                queue.offer(new Info(pos + 1, cnt + 1));
            }

            if (pos - 1 > 0 && !visited[pos - 1]) {
                visited[pos - 1] = true;
                queue.offer(new Info(pos - 1, cnt + 1));
            }
        }

        return -1;
    }

    static class Info {
        int pos;
        int cnt;

        public Info(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}