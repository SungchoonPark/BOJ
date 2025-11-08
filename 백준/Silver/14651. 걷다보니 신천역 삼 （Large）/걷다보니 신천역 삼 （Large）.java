import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[33334][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[1][2] = 0;

        dp[2][0] = 2;
        dp[2][1] = 2;
        dp[2][2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1_000_000_009 + dp[i-1][2];
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % 1_000_000_009 + dp[i-1][2];
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 1_000_000_009 + dp[i-1][2];

            for (int i1 = 0; i1 < 3; i1++) {
                dp[i][i1] %= 1_000_000_009;
            }
        }

        System.out.println(dp[n][0]);
    }
}