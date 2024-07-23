import java.io.*;
import java.util.*;

public class Main {

    static int childNum, snackNum;
    static int[] arr;
    static StringTokenizer st;
    static long maxLen = Integer.MIN_VALUE;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        childNum = Integer.parseInt(st.nextToken());
        snackNum = Integer.parseInt(st.nextToken());
        arr = new int[snackNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < snackNum; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            maxLen = Math.max(tmp , maxLen);
            arr[i] = tmp;
        }

        long left = 1;
        long right =  maxLen;

        while (left <= right) {
            long cn = childNum;
            long middle = (left + right) / 2;

            for (int i = 0; i < snackNum; i++) {
                int tmpSnackLen = arr[i];

                cn = cn - tmpSnackLen / middle;
            }

            if (cn <= 0) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(result);
    }
}
