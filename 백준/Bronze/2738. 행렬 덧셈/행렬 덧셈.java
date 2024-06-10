import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2 * n][m];
        int[][] result = new int[n][m];

        for (int j = 0; j < 2 * n; j++) {
            st = new StringTokenizer(br.readLine());

            int k = 0;
            while (st.hasMoreTokens()) {
                arr[j][k++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j] + arr[i + n][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
