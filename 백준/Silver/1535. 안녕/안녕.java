import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] health;
    static int[] pleasures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        health = new int[n + 1];
        pleasures = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pleasures[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        // dp[i][j] = i명을 뽑았을 때 j가 최대 체력일때 최대 기쁨 값
        int[][] dp = new int[20+5][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (health[i] < j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-health[i]] + pleasures[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][100]);
    }
}