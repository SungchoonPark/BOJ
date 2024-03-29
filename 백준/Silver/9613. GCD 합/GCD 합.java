import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int k = j+1; k < n; k++) {
                    sum += gcd(arr[j], arr[k]);
                }
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }
}
