import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=n; i++) {
            int three = i % 3 == 0 ? dp[i/3] : 99999;
            int two = i % 2 == 0 ? dp[i/2] : 99999;
            int one = dp[i-1];

            dp[i] = Math.min(one, Math.min(two, three)) + 1;
        }
        System.out.println(dp[n]);
    }
}