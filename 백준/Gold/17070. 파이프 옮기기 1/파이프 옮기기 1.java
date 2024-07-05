import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int result;
    static int[][] arr;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new int[n][n][3];  // 3: 가로, 세로, 대각선

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 파이프 상태: (0, 0) - (0, 1) 가로 방향
        dfs(0, 1, 0);
        System.out.println(result);
    }

    private static void dfs(int y, int x, int dir) {
        // 도착 지점에 도달한 경우
        if (y == n - 1 && x == n - 1) {
            result++;
            return;
        }

        // 가로로 놓여있는 경우
        if (dir == 0) {
            // 오른쪽으로 이동
            if (x + 1 < n && arr[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
            // 대각선으로 이동
            if (y + 1 < n && x + 1 < n && arr[y + 1][x] == 0 && arr[y][x + 1] == 0 && arr[y + 1][x + 1] == 0) {
                dfs(y + 1, x + 1, 2);
            }
        }
        // 세로로 놓여있는 경우
        else if (dir == 1) {
            // 아래로 이동
            if (y + 1 < n && arr[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
            // 대각선으로 이동
            if (y + 1 < n && x + 1 < n && arr[y + 1][x] == 0 && arr[y][x + 1] == 0 && arr[y + 1][x + 1] == 0) {
                dfs(y + 1, x + 1, 2);
            }
        }
        // 대각선으로 놓여있는 경우
        else if (dir == 2) {
            // 오른쪽으로 이동
            if (x + 1 < n && arr[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
            // 아래로 이동
            if (y + 1 < n && arr[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
            // 대각선으로 이동
            if (y + 1 < n && x + 1 < n && arr[y + 1][x] == 0 && arr[y][x + 1] == 0 && arr[y + 1][x + 1] == 0) {
                dfs(y + 1, x + 1, 2);
            }
        }
    }
}
