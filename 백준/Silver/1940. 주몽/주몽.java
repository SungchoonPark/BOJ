import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;
        Arrays.sort(arr);
        int cnt = 0;
        while(start < end) {
            int value = arr[start] + arr[end];

            if (value > m) {
                end--;
            } else if (value == m) {
                cnt++;
                end--;
                start++;
            } else if (value < m) {
                start++;
            }
        }

        System.out.println(cnt);
    }
}