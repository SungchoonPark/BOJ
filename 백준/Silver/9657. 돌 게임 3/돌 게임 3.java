import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static boolean[] dp = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        for(int i = 4; i<=n; i++) {
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) dp[i] = true;
            else dp[i] = false;
        }

        if (dp[n]) System.out.println("SK");
        else System.out.println("CY");
    }
}