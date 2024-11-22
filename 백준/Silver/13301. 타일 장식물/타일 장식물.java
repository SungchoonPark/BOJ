import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(4);
            return;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        long[] realdp = new long[n + 1];
        realdp[1] = 4;
        for (int i = 2; i <= n; i++) {
            realdp[i] = realdp[i-1] + (dp[i] * 2);
        }

        System.out.println(realdp[n]);
    }
}