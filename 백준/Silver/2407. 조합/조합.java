import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }

        // nCm = n! / (m! * (n-m)!)
        BigInteger result = dp[n].divide(dp[m].multiply(dp[n - m]));

        System.out.println(result);
    }
}