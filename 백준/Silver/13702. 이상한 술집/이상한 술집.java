import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, k;

    static long[] macs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        macs = new long[n];

        for (int i = 0; i < n; i++) {
            macs[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = (long) Math.pow(2, 31) * 3;

        while(start <= end) {
            long mid = (start + end) / 2;

            if (canSolve(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }

    private static boolean canSolve(long mac) {
        long count = 0;

        for (long l : macs) {
            count += (l / mac);
        }

        if (count < k) return false;
        return true;
    }

}