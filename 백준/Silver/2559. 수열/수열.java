import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        // 연속적인 날짜 수 k
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0 + k -1;
        int max = Integer.MIN_VALUE;
        while (right < n) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            if (sum > max) max = sum;
            left++;
            right++;
        }

        System.out.println(max);
    }

}