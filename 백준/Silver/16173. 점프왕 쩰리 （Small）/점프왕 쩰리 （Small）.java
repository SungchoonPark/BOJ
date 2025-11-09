import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < n; i1++) {
                map[i][i1] = Integer.parseInt(st.nextToken());
            }
        }

        boolean bfs = bfs(new Pos(0, 0));

        if (bfs) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static boolean bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.y][start.x] = true;

        while(!queue.isEmpty()) {
            Pos curPos = queue.poll();

            if (map[curPos.y][curPos.x] == -1) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    // 가로 이동
                    int nx = curPos.x + map[curPos.y][curPos.x];

                    if (nx < n && !visited[curPos.y][nx]) {
                        visited[curPos.y][nx] = true;
                        queue.offer(new Pos(nx, curPos.y));
                    }
                } else {
                    int ny = curPos.y + map[curPos.y][curPos.x];

                    if (ny < n && !visited[ny][curPos.x]) {
                        visited[ny][curPos.x] = true;
                        queue.offer(new Pos(curPos.x, ny));
                    }
                }
            }

        }
        return false;
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