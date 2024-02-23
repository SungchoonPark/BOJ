import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static long[] mem = new long[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        System.out.println(dp(n));
    }

    private static long dp(int remainW) {
        if (mem[remainW] != -1) return mem[remainW];
        return mem[remainW] = (dp(remainW - 1) + dp(remainW - 2)) % 10007;
    }
}