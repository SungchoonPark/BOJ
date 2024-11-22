import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i <n; i++) {
            int cnt = 0;
            for (String s : br.readLine().split("")) {
                arr[i][cnt++] = Integer.parseInt(s);
            }
        }

        search(0, n, 0, n);
        System.out.println(sb);
    }

    private static void search(int startX, int endX, int startY, int endY) {
        int pivot = arr[startY][startX];
        boolean flag = false;

        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (arr[i][j] != pivot) {
                    // 4등분으로 쪼개야함
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }


        if (!flag) {
            // 1 또는 0으로만 이루어진 경우
            sb.append(pivot);
            return;
        }
        sb.append("(");

        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;
        search(startX, midX, startY, midY);
        search(midX, endX, startY, midY);
        search(startX, midX, midY, endY);
        search(midX, endX, midY, endY);

        sb.append(")");
    }
}