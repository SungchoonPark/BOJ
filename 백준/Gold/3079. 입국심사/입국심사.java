import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static int[] arrs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrs = new int[n];
        int maxT = 0;

        for (int i = 0; i < n; i++) {
            arrs[i] = Integer.parseInt(br.readLine());
            if (arrs[i] > maxT) maxT = arrs[i];
        }

        long st = 0;
        long end = (long) maxT * m;

        while(st <= end) {
            long  mid = (st + end) / 2;
            if (solve(mid)) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        System.out.println(st);

    }

    private static boolean solve(long time) {
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += (time / arrs[i]);
            if (cnt >= m) return true;
        }

        return false;
    }

}