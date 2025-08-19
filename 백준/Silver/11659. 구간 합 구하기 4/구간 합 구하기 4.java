import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] i번째부터 j번째까지의 합
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int si = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());

            sb.append(dp[ei] - dp[si - 1]).append("\n");
        }

        System.out.print(sb);
    }
}