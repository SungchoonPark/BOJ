import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1}; // 동서남북
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int surfaceArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int h = arr[i][j];
                if (h > 0) {
                    surfaceArea += 2; // top + bottom
                }

                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    int neighbor = 0;
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        neighbor = arr[ni][nj];
                    }

                    surfaceArea += Math.max(0, h - neighbor);
                }
            }
        }

        System.out.println(surfaceArea);
    }
}