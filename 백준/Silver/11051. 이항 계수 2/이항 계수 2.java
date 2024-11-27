import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] Triangle = new int[n+1][n+1];

        for(int i = 0; i < Triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0) Triangle[i][j] = 1;
                else Triangle[i][j] = (Triangle[i-1][j-1] + Triangle[i-1][j]) % 10007;
            }
        }
        System.out.println(Triangle[n][m]);
    }
}