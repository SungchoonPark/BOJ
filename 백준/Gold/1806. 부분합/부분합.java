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
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = arr[0];
        int length = 1;
        int minLength = Integer.MAX_VALUE;

        while (true) {
            if (sum < s) {
                right++;
                length++;
                if (right >= n) break;
                sum += arr[right];
            }
            else {
                length--;
                minLength = Math.min(minLength, length);
                sum -= arr[left];
                left++;
                if (left >= n || left > right) break;
            }
        }
        if (minLength == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLength + 1);
    }

}