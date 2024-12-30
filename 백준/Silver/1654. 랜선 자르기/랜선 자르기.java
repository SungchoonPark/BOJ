import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long start = 1;
        long end = Integer.MIN_VALUE;

        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = Integer.parseInt(br.readLine());
            arr[i] = i1;
            end = Math.max(end, i1);
        }

        long result = 0;
        while(start <= end) {
            long length = (start + end) / 2;

            long tmp = 0;
            for (int i : arr) {
                tmp += i / length;
            }

            if (tmp >= m) {
                start = length + 1;
                result = Math.max(result, length);
            } else {
                end = length - 1;
            }
        }

        System.out.println(result);
    }
}