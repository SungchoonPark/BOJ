import java.io.*;
import java.util.*;

public class Main {

    static long n, r, c;
    static int cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        search(0, 0, (long) Math.pow(2, n));
    }

    private static void search(long startX, long startY, long len) {
        if (len == 1) {
            System.out.println(cnt);
            return;
        }
        long tmpLen = len / 2;

        if (r < startY + tmpLen && c < startX + tmpLen) {
            search(startX, startY, tmpLen);
        }
        if (r < startY + tmpLen && startX + tmpLen <= c) {
            cnt += (len * len) / 4;
            search(startX + tmpLen, startY, tmpLen);
        }
        if (startY + tmpLen <= r && c < startX + tmpLen) {
            cnt += ((len * len) / 4) * 2;
            search(startX, startY + tmpLen, tmpLen);
        }
        if (startY + tmpLen <= r && startX + tmpLen <= c) {
            cnt += ((len * len) / 4) * 3;
            search(startX + tmpLen, startY + tmpLen, tmpLen);
        }
    }

}
