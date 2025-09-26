import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    bfs(new Pos(j, i));
                }
            }
        }

        System.out.println(count);
        if (max == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }
    }

    private static void bfs(Pos startPos) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(startPos);
        int area = 0;

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.offer(new Pos(nx, ny));
                    }
                }
            }
        }

        max = Math.max(max, area);
    }

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}