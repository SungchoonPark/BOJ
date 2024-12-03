import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;
    static int[][] arr;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String init = String.valueOf(arr[i][j]);
                dfs(j, i, 1, init);
            }
        }

        System.out.println(set.size());
    }

    private static void dfs(int startx, int starty, int depth, String str) {
        if (depth == 6) {
            set.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = startx + dx[i];
            int ny = starty + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                String s = String.valueOf(arr[ny][nx]);
                dfs(nx, ny, depth + 1, s + str);
            }
        }
    }
}