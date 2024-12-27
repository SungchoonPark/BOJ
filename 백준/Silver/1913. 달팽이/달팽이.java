import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] arr;
    static int n, findNum;

    static int resultX;
    static int resultY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        findNum = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int startValue = (int) Math.pow(n, 2);

        print(startValue, 0, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print(resultY + " " + resultX);
    }

    private static void print(int value, int y, int x, int dist) {
        if (value == 0) return;
        if (value == findNum) {
            resultY = y + 1;
            resultX = x + 1;
        }

        arr[y][x] = value;
        if (dist == 0) {
            int ny = y + 1;
            if (ny < n && arr[ny][x] == 0) {
                print(value - 1, ny, x, dist);
            } else {
                print(value -1, y, x + 1, 1);
            }
        } else if (dist == 1) {
            int nx = x + 1;
            if (nx < n && arr[y][nx] == 0) {
                print(value - 1, y, nx, dist);
            } else {
                print(value -1, y - 1, x, 2);
            }
        } else if (dist == 2) {
            int ny = y - 1;
            if (ny >= 0 && arr[ny][x] == 0) {
                print(value - 1, ny, x, dist);
            } else {
                print(value -1, y, x - 1, 3);
            }
        } else if (dist == 3) {
            int nx = x - 1;
            if (nx >= 0 && arr[y][nx] == 0) {
                print(value - 1, y, nx, dist);
            } else {
                print(value -1, y + 1, x, 0);
            }
        }
    }
}