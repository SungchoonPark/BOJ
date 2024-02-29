import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[][] arr = new int[16][16];
    private static int[][] dp = new int[16][16];
    private static int recurCnt;
    private static int dpCnt;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<16; i++) {
            Arrays.fill(dp[i], -1);
        }

        recursive(arr);
        dynamic();
        System.out.println(recurCnt+ " " + dpCnt);
    }

    private static int recursive(int[][] arr) {
        return recur(arr, n, n);
    }

    private static int recur(int[][] arr, int i, int j) {
        if (i == 0 || j == 0) {
            recurCnt++;
            return 0;
        } else return (arr[i][j] + (Math.max(recur(arr, i - 1, j), recur(arr, i, j - 1))));

    }

    private static int dynamic() {
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int j = 1; j <= n; j++) dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dpCnt++;
                dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}