import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long oddSum  = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!isEven(arr[i])) {
                oddSum += cnt;
            } else {
                cnt++;
            }
        }

        long evenSum = 0;
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isEven(arr[i])) {
                evenSum += cnt;
            } else {
                cnt++;
            }
        }

        System.out.print(Math.min(evenSum, oddSum));

    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}