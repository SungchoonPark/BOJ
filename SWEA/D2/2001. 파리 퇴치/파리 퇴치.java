import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int j = 0; j < n - m + 1; j++) {
                for (int k = 0; k < n - m + 1; k++) {

                    int sum = 0;
                    for (int h = j; h< j + m; h++) {
                        for(int w = k; w < k+m; w++) {
                            sum += arr[h][w];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#" + (i+1) + " " + max);
        }
    }
}