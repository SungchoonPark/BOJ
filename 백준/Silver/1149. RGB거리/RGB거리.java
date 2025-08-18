import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] infos = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            infos[i][1] = r;
            infos[i][2] = g;
            infos[i][3] = b;
        }

        int[][] dp = new int[n + 1][4];
        dp[1][1] = infos[1][1];
        dp[1][2] = infos[1][2];
        dp[1][3] = infos[1][3];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + infos[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + infos[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + infos[i][3];
        }

        int result = Math.min(dp[n][1], Math.min(dp[n][2], dp[n][3]));
        System.out.println(result);
    }
}