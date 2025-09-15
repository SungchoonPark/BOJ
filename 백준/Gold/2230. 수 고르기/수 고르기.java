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
        for (int i = 0; i < n; i++) {
            arrs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arrs);

        int start = 0;
        int end = 0;

        int result = Integer.MAX_VALUE;
        while(start <= end && end < n && start < n) {
            int diff = arrs[end] - arrs[start];

            if (diff < m) {
                end++;
            } else {
                start++;
                result = Math.min(result, diff);
            }
        }

        System.out.println(result);
    }

}