import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int[][] arr;
    static int minusCnt;
    static int zeroCnt;
    static int oneCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(n, 0, n - 1, 0, n - 1);

        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.print(oneCnt);
    }

    private static void search(int len, int startX, int endX, int startY, int endY) {
        int initialValue = arr[startY][startX];
        boolean flag = true;

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (arr[i][j] != initialValue) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) {
            update(initialValue);
        } else {
            int plus = len / 3;
            int endPlus = plus - 1;

            for (int i = startY; i <= endY; i += plus) {
                for (int j = startX; j <= endX; j += plus) {
                    search(plus, j, j + endPlus, i, i + endPlus);
                }
            }
        }
    }

    private static void update(int value) {
        if (value == -1) minusCnt++;
        if (value == 0) zeroCnt++;
        if (value == 1) oneCnt++;
    }
}