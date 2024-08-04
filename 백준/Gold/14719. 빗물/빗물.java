import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        arr = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());

            for (int j = 0; j < height; j++) {
                arr[H - j - 1][i] = 1;
            }
        }

        int result = 0;

        for (int i = H - 1; i >= 0; i--) {
            boolean flag = false;
            int tmp = 0;
            for (int j = 0; j < W; j++) {
                if (j != W - 1 && !flag && arr[i][j] == 1 && arr[i][j + 1] == 0) {
                    flag = true;
                    continue;
                }

                if (flag && arr[i][j] == 0) {
                    tmp++;
                }

                if (flag && arr[i][j] == 1) {
                    result += tmp;
                    tmp = 0;

                    if (j != W - 1 && arr[i][j+1] == 0) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            }
        }

        System.out.println(result);
    }

}
