import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[d];
        int[] b = new int[d];

        a[0] = 1;
        a[1] = 0;
        b[0] = 0;
        b[1] = 1;

        for (int i = 2; i < d; i++) {
            a[i] = a[i-1] + a[i-2];
            b[i] = b[i-1] + b[i-2];
        }

        int aIdx = 1;
        while(true) {
            int tmp  = k - (a[d - 1] * aIdx);
            if (tmp < 0) break;

            int bIdx = 1;
            while(true) {
                int tmp2 = tmp - (b[d - 1] * bIdx);
                if (tmp2 < 0) break;

                if(tmp2 == 0 && (aIdx <= bIdx)) {
                    System.out.println(aIdx);
                    System.out.println(bIdx);
                    return;
                } else {
                    bIdx++;
                }
            }

            aIdx++;
        }
    }
}
