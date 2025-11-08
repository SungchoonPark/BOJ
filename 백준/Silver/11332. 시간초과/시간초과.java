import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String over = "TLE!";
        String pass = "May Pass.";

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String tc = st.nextToken();      // e.g. O(N), O(N^2), O(N^3), O(2^N), O(N!)
            int range = Integer.parseInt(st.nextToken());
            int testCnt = Integer.parseInt(st.nextToken());
            int timeLimit = Integer.parseInt(st.nextToken());

            if (isPass(tc, range, testCnt, timeLimit)) sb.append(pass).append("\n");
            else sb.append(over).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPass(String tc, int range, int testCnt, int timeLimit) {
        long limit = 100_000_000L * timeLimit;

        // testCnt가 0일 일은 없겠지만, 방어적으로
        if (testCnt <= 0) return true;

        // 총연산 = testCnt * f(range) <= limit  ⇔  f(range) <= limit / testCnt
        long cap = limit / testCnt;

        if (tc.contains("N!")) {
            return factLe(range, cap);
        } else if (tc.contains("2^N")) {
            return powLe(2L, range, cap);
        } else if (tc.contains("N^3")) {
            return powLe(range, 3, cap);
        } else if (tc.contains("N^2")) {
            return powLe(range, 2, cap);
        } else { // O(N)
            return range <= cap;
        }
    }

    // res *= base를 하기 전에 res > cap / base 이면 cap 초과가 확정 → false
    private static boolean powLe(long base, int exp, long cap) {
        long res = 1L;
        for (int i = 0; i < exp; i++) {
            if (base == 0) return true;      // 0의 거듭제곱은 0 또는 1
            if (res > cap / base) return false;
            res *= base;
        }
        return res <= cap;
    }

    private static boolean factLe(int n, long cap) {
        long res = 1L;
        for (int i = 2; i <= n; i++) {
            if (res > cap / i) return false;
            res *= i;
        }
        return res <= cap;
    }
}