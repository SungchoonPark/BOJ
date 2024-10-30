import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (n > 2) {
                dp[0][0] = arr[0][0];
                dp[1][0] = arr[1][0];
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];

                for (int j = 2; j < n; j++) {
                    dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + arr[0][j];
                    dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + arr[1][j];
                }
            } else if (n == 2){
                int result = Math.max(arr[0][0] + arr[1][1], arr[1][0] + arr[0][1]);
                System.out.println(result);
                continue;
            } else if (n == 1) {
                int result = Math.max(arr[0][0], arr[1][0]);
                System.out.println(result);
                continue;
            }

            int result = Math.max(dp[0][n-1], dp[1][n-1]);
            System.out.println(result);
        }
    }
}