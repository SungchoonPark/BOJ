import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb;
    private static int[] arr;
    private static long[] dp = new long[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 0;
        sb.append(dp[1]).append(" ");
        int min = arr[1];
        for (int i=2; i<=n; i++) {
            if(arr[i] < min) min = arr[i];
            dp[i] = Math.max(dp[i-1], arr[i] - min);
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);
    }
}