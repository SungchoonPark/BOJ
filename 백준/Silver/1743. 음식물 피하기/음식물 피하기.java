import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int result = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visited;

    static StringTokenizer st;
    static StringBuilder sb;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()); // y
            int c = Integer.parseInt(st.nextToken()); // x
            arr[r][c] = 1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void dfs(int y, int x) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(x, y));
        visited[y][x] = true;
        int tmpSize = 1;

        while (!stack.isEmpty()) {
            Pos curPos = stack.pop();

            for (int i = 0; i < 4; i++) {
                int newX = curPos.x + dx[i];
                int newY = curPos.y + dy[i];

                if (newX > 0 && newX < m + 1 && newY > 0 && newY < n + 1) {
                    if (!visited[newY][newX] && arr[newY][newX] == 1) {
                        stack.push(new Pos(newX, newY));
                        visited[newY][newX] = true;
                        tmpSize++;
                    }
                }
            }
        }
        result = Math.max(tmpSize, result);
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
