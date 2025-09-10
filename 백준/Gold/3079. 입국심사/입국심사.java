import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static long m;
    static int[] arrs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stt.nextToken());
        m = Long.parseLong(stt.nextToken());

        arrs = new int[n];
        int maxT = 0;
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            arrs[i] = t;
            if (t > maxT) maxT = t;
        }

        long st = 1;                         // 0도 되지만 1로 시작해도 무방
        long end = (long) maxT * m;          // 상한을 정확히
        long ans = end;

        while (st <= end) {
            long mid = st + (end - st) / 2;

            if (canFinish(mid)) {            // mid 시간 내 m명 처리 가능
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean canFinish(long time) {
        long cnt = 0;
        for (int t : arrs) {
            cnt += time / t;
            if (cnt >= m) return true;       // 조기 종료로 시간 절약
        }
        return false;
    }
}