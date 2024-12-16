import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[2][n];
        long[][] dp = new long[2][n];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = Math.max(arr[0][0], arr[0][0] + arr[1][0]);
        dp[1][0] = arr[0][0] + arr[1][0];

        // idea : 탑의 맨 위에서 아래로 내려온다는 아이디어를 통해 시작
        // 왼쪽 기준으로 설명

        // 1. 바로 위 최대값(dp값)에서 바로 아래로 내려온 경우
        // 2. 바로 위 최대값과 오른쪽으로 한번 갔다온 경우
        // 3. 오른쪽 상단 대각선에서 시작한 경우

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 1] + arr[1][i]);
            dp[0][i] = Math.max(dp[0][i], dp[1][i - 1] + arr[1][i]) + arr[0][i];

            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 1] + arr[0][i]);
            dp[1][i] = Math.max(dp[1][i], dp[0][i - 1] + arr[0][i]) + arr[1][i];
        }

        System.out.println(dp[1][n - 1]);
    }
}