import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int result;
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
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
         }

        bfs(0, 0, 1);

        System.out.print(result);
    }

    private static void bfs(int x, int y, int count) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y, count));
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Pos curPos = queue.poll();
            if (curPos.x == m - 1 && curPos.y == n - 1) {
                result = curPos.count;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curPos.x + dx[i];
                int newY = curPos.y + dy[i];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (!visited[newY][newX] && arr[newY][newX] == 1) {
                        queue.offer(new Pos(newX, newY, curPos.count + 1));
                        visited[newY][newX] = true;
                    }
                }
            }
        }
    }

    static class Pos {
        int x;
        int y;
        int count;

        public Pos(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
