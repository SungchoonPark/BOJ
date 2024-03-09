import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static long[][] mem = new long[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        Arrays.fill(mem[1], 1);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=2; i<=m; i++) {
            mem[i][1] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                mem[i][j] = (mem[i-1][j] + mem[i][j-1] + mem[i-1][j-1]) % 1_000_000_007;
            }
        }

        System.out.println(mem[m][n]);
    }
}