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

        int min1 = 0;
        int min2 = 0;

        int evenLen = 0;
        for (int i = 0; i < n; i++) {
            if (isEven(arr[i])) {
                evenLen++;
            } else {
                min1 += evenLen;
            }
        }

        int evenLen2  = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (isEven(arr[i])) {
                evenLen2++;
            } else {
                min2 += evenLen2;
            }
        }

        System.out.print(Math.min(min1, min2));

    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}