import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[7][7];
        int startX = 0;
        int startY = 0;

        int prevX = 0;
        int prevY = 0;
        boolean isFirst = true;
        for (int i = 0; i < 36; i++) {
            String pos = br.readLine();
            int x = getIdx(pos.split("")[0]);
            int y = Integer.parseInt(pos.split("")[1]);
            if (isFirst) {
                startX = x;
                startY = y;
                prevX = x;
                prevY = y;
                arr[y][x]++;
                isFirst = false;
                continue;
            }

            if (arr[y][x] != 0 || !isValidPos(prevX, prevY, x, y)) {
                System.out.println("Invalid");
                return;
            }

            arr[y][x]++;
            prevX = x;
            prevY = y;

            if (i == 35) {
                if (isValidPos(x, y, startX, startY)) {
                    System.out.println("Valid");
                    return;
                }
            }
        }

        System.out.println("Invalid");
    }

    private static int getIdx(String s) {
        if (s.equals("A")) {
            return 1;
        } else if (s.equals("B")) {
            return 2;
        } else if (s.equals("C")) {
            return 3;
        } else if (s.equals("D")) {
            return 4;
        } else if (s.equals("E")) {
            return 5;
        } else if (s.equals("F")) {
            return 6;
        }

        return -1;
    }

    private static boolean isValidPos(int prevX, int prevY, int curX, int curY) {
        for (int j = 0; j < 8; j++) {
            int nx = prevX + dx[j];
            int ny = prevY + dy[j];

            if (nx >= 1 && ny >= 1 && nx < 7 && ny < 7) {
                if (ny == curY && nx == curX) {
                    return true;
                }
            }
        }

        return false;
    }
}