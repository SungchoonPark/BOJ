import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static int[] days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        days = new int[n];

        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, days[i]);
            sum += days[i];
        }

        int start = max;
        int end = sum;

        while(start <= end) {
            int mid = (start + end + 1) / 2;

            if (canSolve(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        System.out.println(start);

    }

    private static boolean canSolve(int withdrawalPrice) {
        int cnt = 1;

        int curPrice = withdrawalPrice;
        for (int i = 0; i < n; i++) {
            int dayPrice = days[i];

            if (withdrawalPrice < dayPrice) {
                return false;
            }

            if (curPrice < dayPrice) {
                cnt++;
                curPrice = withdrawalPrice;
            }

            curPrice -= dayPrice;

            if (cnt > m) return false;
        }
        return true;
    }

}