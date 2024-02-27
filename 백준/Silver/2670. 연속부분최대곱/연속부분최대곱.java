import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static double[] arr;
    private static double[] dp = new double[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = arr[0];
        double result = dp[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1]*arr[i], arr[i]);
            result = Math.max(result, dp[i]);
        }
        
        System.out.println(String.format("%.3f", result));
    }
}