import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][3];

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
                } else if (j == 1) {
                    dp[i][j] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
                } else if (j == 2) {
                    dp[i][j] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
                }
            }
        }

        int result = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % 9901;
        System.out.println(result);
    }
}