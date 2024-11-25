import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1){
            System.out.println(1);
            return;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int tmpM = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] > tmpM) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }


        System.out.println(max);
    }
}