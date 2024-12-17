import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[][] arr;
    static int k;
    static int c;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        if (k > c * r) {
            System.out.println(0);
            return;
        }

        arr = new int[r][c];
        search(0, r - 1, 1, 1);
    }

    private static void search(
            int x, int y, int value,
            int dir
    ) {
        if (value == k) {
            System.out.println((x + 1) + " " + (r - y));
            return;
        }
        arr[y][x] = value;
        if (dir == 1) {
            // up
            if (y - 1 >= 0 && y - 1 < r) {
                if (arr[y - 1][x] != 0) {
                    search(x + 1, y, value + 1, 2);
                } else {
                    search(x, y - 1, value + 1, dir);
                }
            } else {
                search(x + 1, y, value + 1, 2);
            }
        } else if (dir == 2) {
            // right
            if (x + 1 >= 0 && x + 1 < c) {
                if (arr[y][x + 1] != 0) {
                    search(x, y + 1, value + 1, 3);
                } else {
                    search(x + 1, y, value + 1, dir);
                }
            } else {
                search(x, y + 1, value + 1, 3);
            }
        } else if (dir == 3) {
            // down
            if (y + 1 >= 0 && y + 1 < r) {
                if (arr[y + 1][x] != 0) {
                    search(x - 1, y, value + 1, 4);
                } else {
                    search(x, y + 1, value + 1, dir);
                }
            } else {
                search(x - 1, y, value + 1, 4);
            }
        } else if (dir == 4) {
            // left
            if (x - 1 >= 0 && x - 1 < c) {
                if (arr[y][x - 1] != 0) {
                    search(x, y - 1, value + 1, 1);
                } else {
                    search(x - 1, y, value + 1, dir);
                }
            } else {
                search(x, y - 1, value + 1, 1);
            }
        }
    }
}