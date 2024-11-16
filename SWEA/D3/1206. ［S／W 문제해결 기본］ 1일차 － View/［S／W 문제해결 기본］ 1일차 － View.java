import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[255][n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int h = Integer.parseInt(st.nextToken());

                for (int k = 0; k < h; k++) {
                    arr[k][j] = 1;
                }
            }

            int cnt = 0;
            for (int j = 0; j < 255; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] == 1) {
                        if (arr[j][k - 1] == 0 && arr[j][k - 2] == 0 && arr[j][k + 1] == 0 && arr[j][k + 2] == 0) cnt++;
                    }
                }
            }

            System.out.println("#" + (i+1) + " " +cnt);

        }

    }
}