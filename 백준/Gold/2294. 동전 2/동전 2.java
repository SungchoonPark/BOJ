import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] costs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        costs = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(costs);

        Arrays.fill(dp, k + 1);  // dp 배열을 k+1로 초기화 (k+1은 불가능한 값으로 설정)
        dp[0] = 0; // 0원을 만드는데 필요한 동전 개수는 0

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i - costs[j] < 0) break;
                dp[i] = Math.min(dp[i], dp[i - costs[j]] + 1);
            }
        }

        System.out.println(dp[k] > k ? -1 : dp[k]);
    }
}
