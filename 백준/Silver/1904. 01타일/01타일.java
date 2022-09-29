import javax.management.BadBinaryOpValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        if( n>= 3) {
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
        }

        System.out.println(dp[n]);
    }
}