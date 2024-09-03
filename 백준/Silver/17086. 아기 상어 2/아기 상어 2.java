import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int maxSafeDist = 0;
    static int[][] map;
    static boolean[][] visited;
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] dx = {1, 1, -1, -1, 0, 1, -1, 0};
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 1) bfs(i, j);
            }
        }
        System.out.print(maxSafeDist);
    }

    private static void bfs(int y, int x) {
        visited = new boolean[n][m];
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y, 0));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Pos curPos = q.poll();

            if (map[curPos.y][curPos.x] == 1) {
                maxSafeDist = Math.max(maxSafeDist, curPos.cnt);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new Pos(nx, ny, curPos.cnt + 1));
                    }
                }
            }
        }
    }

    static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
