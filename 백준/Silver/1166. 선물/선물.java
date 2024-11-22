import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int maxLen = Math.min(l, Math.min(w, h));

        double start = 0;
        double end = maxLen;

        double max = Integer.MIN_VALUE;
        int tmp = 0;
        while (true) {
            double middle = (start + end) / 2.0;

            long cnt = (long) (l / middle) * (long) (w / middle) * (long) (h / middle);
            if (cnt >= n) {
                max = middle;
                start = middle;
            } else {
                end = middle;
            }

            if (tmp++ > 5000) break;
        }

        System.out.println(max);
    }
}