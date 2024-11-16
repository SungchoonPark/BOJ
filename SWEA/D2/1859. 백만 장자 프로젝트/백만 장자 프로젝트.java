import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long max = 0;
            int pivotCoin = arr[n - 1];

            int cnt = 1;
            int q = n - 2;
            while (cnt != n) {
                if (arr[q] > pivotCoin) {
                    pivotCoin = arr[q--];
                } else {
                    max += (pivotCoin - arr[q--]);
                }
                cnt++;
            }

            System.out.println("#" + (i + 1) + " " + max);
        }

    }
}