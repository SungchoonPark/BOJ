import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int r, c, w;
    private static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 31; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i < 31; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        int tmp = 1;
        long result = 0;
        for (int i = r; i <= r + w - 1; i++) {
            for (int j = c; j < c+tmp; j++) {
                result += dp[i][j];
            }
            tmp++;
        }

        System.out.println(result);
    }
}