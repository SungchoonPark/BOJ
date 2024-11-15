import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        int start = 0;
        int end = 0;
        int cnt = 0;

        while(end != n+1) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }

            if (sum > n) {
                // sum이 목표값 n보다 큰 경우 -> s 증가
                start++;
            } else if (sum == n) {
                // n과 같은 경우
                cnt++;
                end++;
            } else {
                // sum이 목표값 n보다 작은 경우 -> e 증가
                end++;
            }
        }

        System.out.println(cnt);
    }
}