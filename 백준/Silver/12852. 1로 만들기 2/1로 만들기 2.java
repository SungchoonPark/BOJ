import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_001];
        int[] path = new int[1_000_001];

        dp[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + 1;
            path[i] = i-1;
            if (i % 3 == 0) {
                int before = dp[i];
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
                if(before != dp[i]) {
                    path[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                int before = dp[i];
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
                if(before != dp[i]) {
                    path[i] = i / 2;
                }
            }
        }

        int idx = n;
        while(dp[idx] != 0) {
            sb.append(idx).append(" ");
            idx = path[idx];
        }
        sb.append(1);

        System.out.println(dp[n]);
        System.out.print(sb);

    }
}