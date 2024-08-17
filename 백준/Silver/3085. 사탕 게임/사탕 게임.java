import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 행과 열 모두에 대해 인접한 사탕을 교환하고 최대 길이를 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 행 방향 교환
                swap(arr, i, j, i, j + 1);
                check(arr);
                swap(arr, i, j, i, j + 1); // 원상복구

                // 열 방향 교환
                swap(arr, j, i, j + 1, i);
                check(arr);
                swap(arr, j, i, j + 1, i); // 원상복구
            }
        }

        System.out.println(max);
    }

    private static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static void check(char[][] arr) {
        // 각 행과 열을 확인하여 최대 연속된 사탕의 길이 계산
        for (int i = 0; i < n; i++) {
            int rowCnt = 1;
            int colCnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    rowCnt++;
                } else {
                    max = Math.max(max, rowCnt);
                    rowCnt = 1;
                }

                if (arr[j][i] == arr[j + 1][i]) {
                    colCnt++;
                } else {
                    max = Math.max(max, colCnt);
                    colCnt = 1;
                }
            }
            max = Math.max(max, rowCnt);
            max = Math.max(max, colCnt);
        }
    }
}
