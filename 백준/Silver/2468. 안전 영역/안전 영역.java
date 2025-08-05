import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[i][j]);
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        int maxArea = 0;
        for (int i = 0; i <= 100; i++) {
            int[][] tmpMap = map.clone();
            boolean[][] visited = new boolean[n][n];

            int tmpArea = 0;
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map.length; k++) {
                    if (tmpMap[j][k] > i && !visited[j][k]) {
                        search(i, tmpMap, visited, new Pos(k, j));
                        tmpArea++;
                    }
                }
            }

            maxArea = Math.max(tmpArea, maxArea);
        }

        System.out.println(maxArea);
    }

    private static void search(int h, int[][] map, boolean[][] visited, Pos startPos) {
        Stack<Pos> stack = new Stack<>();
        stack.push(startPos);
        visited[startPos.y][startPos.x] = true;

        while (!stack.isEmpty()) {
            Pos curPos = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                    if (map[ny][nx] > h && !visited[ny][nx]) {
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