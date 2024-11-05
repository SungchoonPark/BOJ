import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;  // 카드를 구매하지 않을 때의 최대 금액은 0
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }
        
        System.out.println(dp[n]);
    }
}