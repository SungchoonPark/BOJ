import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[][] arr;
    private static long[][] mem;
    private static int n, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            arr[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        System.out.println(arr[n-1][r-1]);
    }
}