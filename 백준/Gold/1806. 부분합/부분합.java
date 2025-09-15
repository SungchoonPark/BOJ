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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrs[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = arrs[start];
        int minLength = Integer.MAX_VALUE;

        while(start <= end) {
            if (start == n || end == n) break;

            if (sum >= m) {
                // 합의 조건은 만족하는 상황
                minLength = Math.min(minLength, end - start + 1);
                if (start < n) sum -= arrs[start];
                start++;
            } else {
                end++;
                if (end < n) sum += arrs[end];
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.print(0);
        } else {
            System.out.println(minLength);
        }

    }

}