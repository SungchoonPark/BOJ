import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N+1];
        int[] p = new int[N+1];
        int[] dp = new int[N+1];
        int maxPrice = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            if (i + t[i] <= N) {
                dp[i+t[i]] = max(dp[i + t[i]], dp[i] + p[i]);
            }

            dp[i+1] = max(dp[i], dp[i+1]);
        }

        System.out.println(dp[N]);

    }

}
