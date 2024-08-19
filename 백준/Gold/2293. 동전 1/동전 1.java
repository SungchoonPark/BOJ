import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        dp[0] = 1;
        int[] costs = new int[n];
        for (int i = 0; i <n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(costs);
        for (int i = 0; i < n; i++) {
            for (int j = costs[i]; j <= k; j++) {
                dp[j] += dp[j - costs[i]];
            }
        }
        System.out.print(dp[k]);
    }
}
