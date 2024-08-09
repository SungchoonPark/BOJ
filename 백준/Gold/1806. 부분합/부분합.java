import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, s;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }

        int left = 0;
        int right = 0;
        int sum = arr[left];
        while (left <= right) {
            if (left == n || right == n) break;
            int tmpLen = right - left + 1;

            if (sum >= s) {
                if (tmpLen < min) {
                    min = tmpLen;
                }
                left++;
                if (left != n) sum -= arr[left - 1];
            } else {
                right++;
                if (right != n) sum += arr[right];
            }
        }
        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.print(min);
    }
}