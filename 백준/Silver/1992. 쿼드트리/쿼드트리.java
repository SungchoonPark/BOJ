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

        // 현재 영역이 같은 숫자로 이루어졌는지 확인
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (arr[i][j] != pivot) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        // 같은 숫자로 이루어진 경우
        if (!flag) {
            sb.append(pivot);
            return;
        }

        // 다른 숫자가 있는 경우 4등분
        sb.append("(");
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;

        search(startX, midX, startY, midY); // 왼쪽 위
        search(midX, endX, startY, midY); // 오른쪽 위
        search(startX, midX, midY, endY); // 왼쪽 아래
        search(midX, endX, midY, endY); // 오른쪽 아래
        sb.append(")");
    }
}