import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                System.out.print(sb);
                return;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int islandCnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(j, i);
                        islandCnt++;
                    }
                }
            }

            sb.append(islandCnt).append("\n");
        }
    }

    private static void dfs(int x, int y) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(x, y));
        visited[y][x] = true;

        while (!stack.isEmpty()) {
            Pos curPos = stack.pop();

            for (int i = 0; i < 8; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length) {
                    if(arr[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        stack.push(new Pos(nx, ny));
                    }
                }
            }
        }
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