import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;

    static int[][] arr;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                if (dp[i][j] == 0) continue;

                int jumpValue = arr[i][j];

                int nx = j + jumpValue;
                if (nx < n) {
                    dp[i][nx] += dp[i][j];
                }

                int ny = i + jumpValue;
                if (ny < n) {
                    dp[ny][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}