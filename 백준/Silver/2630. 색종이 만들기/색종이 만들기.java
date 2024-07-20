import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int white, blue;
    static StringTokenizer st;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkBox(0, 0, n);
        sb.append(white).append("\n").append(blue);
        System.out.print(sb);
    }

    private static void checkBox(int startX, int startY, int len) {
        int initialColor = arr[startY][startX];
        boolean valid = true;

        for (int i = startY; i < startY + len; i++) {
            for (int j = startX; j < startX + len; j++) {
                if (arr[i][j] != initialColor) {
                    valid = false;
                    break;
                }
            }
            if (!valid) break;
        }

        if (valid) {
            if (initialColor == 1) blue++;
            else white++;
        } else {
            int half = len / 2;
            checkBox(startX, startY, half);
            checkBox(half + startX, startY, half);
            checkBox(startX, half + startY, half);
            checkBox(half + startX, half + startY, half);
        }
    }
}
