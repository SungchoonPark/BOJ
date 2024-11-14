import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (String s : br.readLine().split("")) {
                arr[i][j++] = Integer.parseInt(s);

            }
        }

        int max = -1;
        int maxLen = Math.max(n, m);
        for (int len = 0; len < maxLen; len++) {
            for (int i = 0; i < n - len; i++) {
                for (int j = 0; j < m - len; j++) {
                    int a1 = arr[i][j];
                    int a2 = arr[i+len][j];
                    int a3 = arr[i][j + len];
                    int a4 = arr[i + len][j + len];

                    if (a1 == a2 && a3 == a4 && a1== a3) {
                        max = (int)Math.pow(len + 1, 2);
                    }
                }
            }
        }

        System.out.println(max);
    }
}