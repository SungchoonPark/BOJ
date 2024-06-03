import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[5001];
        Arrays.fill(dp, 99999);

        dp[3] = 1;
        dp[5] = 1;

        for(int i=6; i<=n; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
        if(dp[n] >= 99999) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
