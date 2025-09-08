import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int k, n;
    static int[] lans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        lans = new int[k];
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        long st = 0;
        long end = Integer.MAX_VALUE;
        while (st < end) {
            long mid = (st + end + 1) / 2;

            if (solve(mid)) {
                st = mid;
                continue;
            }

            end = mid - 1;
        }

        System.out.println(st);
    }

    private static boolean solve(long tmpLan) {
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            cnt += (lans[i] / tmpLan);
        }

        if (cnt >= n) {
            return true;
        }

        return false;
    }

}