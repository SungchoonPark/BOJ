import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new BigInteger[10001];
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("1");
        for (int j = 3; j < 10001; j++) {
            dp[j] = dp[j-1].add(dp[j -2]);
        }
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            BigInteger q = new BigInteger(st.nextToken());

            if (p < 3) {
                System.out.println("Case #" + i + ": " + BigInteger.ONE.remainder(q));
                continue;
            }

            System.out.println("Case #" + i + ": " + (dp[p].remainder(q)));
        }
    }

}