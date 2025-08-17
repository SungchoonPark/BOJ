import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static int n;
    static int[][] map;
    static int result;

    static boolean[] columnVisited;
    static boolean[] oneDiagonalVisited;
    static boolean[] twoDiagonalVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        columnVisited = new boolean[n];
        oneDiagonalVisited = new boolean[2 * n - 1];
        twoDiagonalVisited = new boolean[2 * n - 1];

        search(0);
        System.out.println(result);
    }

    private static void search(int y) {
        if (y == n) {
            result++;
            return;
        }

        for (int x = 0; x < n; x++) {
            int d1 = y + x;
            int d2 = y - x + n - 1;

            if (!columnVisited[x] && !oneDiagonalVisited[d1] && !twoDiagonalVisited[d2]) {
                columnVisited[x] = true;
                oneDiagonalVisited[d1] = true;
                twoDiagonalVisited[d2] = true;

                search(y + 1);

                columnVisited[x] = false;
                oneDiagonalVisited[d1] = false;
                twoDiagonalVisited[d2] = false;
            }
        }
    }
}