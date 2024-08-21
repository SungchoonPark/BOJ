import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int townIdx = 1;
    static List<Integer> results;
    static int[][] arr;
    static boolean[][] visited;
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        arr = new int[n][n];
        visited = new boolean[n][n];
        results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(new Point(j, i));
                }
            }
        }

        Collections.sort(results);
        sb.append(results.size()).append("\n");
        results.forEach(r -> sb.append(r).append("\n"));
        System.out.print(sb);
    }

    private static void dfs(Point point) {
        int tmpCnt = 1;
        Stack<Point> stack = new Stack<>();
        stack.push(point);
        visited[point.y][point.x] = true;

        while (!stack.isEmpty()) {
            Point curPoint = stack.pop();

            for (int i = 0; i < 4; i++) {
                int newX = curPoint.x + dx[i];
                int newY = curPoint.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    if (!visited[newY][newX] && arr[newY][newX] == 1) {
                        visited[newY][newX] = true;
                        stack.push(new Point(newX, newY));
                        tmpCnt++;
                    }
                }
            }
        }
        results.add(tmpCnt);
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
