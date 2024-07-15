import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static int[] distX = {1, -1, 0, 0}; // 좌우
    static int[] distY = {0, 0, 1, -1}; // 상하
    static String[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[r][c];

        for(int i=0; i<r; i++) {
            String s = br.readLine();
            arr[i] = s.split("");
        }

        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        Set<String> set = new HashSet<>();
        set.add(arr[0][0]);
        dfs(0, 0, visited, set);
        System.out.println(max);
    }

    private static void dfs(int x, int y, boolean[][] visited, Set<String> set) {
        max = Math.max(max, set.size());
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + distX[i];
            int ny = y + distY[i];
            if (nx < 0 || ny < 0 || nx >= c || ny >= r) continue;
            if (!set.contains(arr[ny][nx]) && !visited[ny][nx]) {
                set.add(arr[ny][nx]);
                dfs(nx, ny, visited, set);
                set.remove(arr[ny][nx]);
            }
        }

        visited[y][x] = false;
    }
}
