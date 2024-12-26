import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[][] arr;
    static int goalY;
    static int goalX;
    static int n;
    static int m;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int result = 1;
        if (k!=0) {
            if (k % m == 0) {
                goalY = k /m - 1;
                goalX = m - 1;
            } else {
                goalY = k / m;
                goalX = k % m - 1;
            }

            result *= dfs(0, 0, goalX, goalY);
            result *= dfs(goalX, goalY, m-1, n-1);
        } else {
            result *= dfs(0, 0, m-1, n-1);
        }

        System.out.println(result);
    }

    private static int dfs(int sx, int sy, int gx, int gy) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(sx, sy));

        int cnt=0;
        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();

            if (curPos.x == gx && curPos.y == gy) {
                cnt++;
                continue;
            }

            for (int i = 0; i < 2; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    // gx 보다 작아야함 && gy보다 작아야함
                    if (nx <= gx && ny <= gy) {
                        stack.push(new Pos(nx, ny));
                    }
                }
            }
        }

        return cnt;
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