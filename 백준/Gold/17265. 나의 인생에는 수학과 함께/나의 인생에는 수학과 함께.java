import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int n;
    static String[][] map;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new String[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = st.nextToken();
            }
        }

        search(new Pos(1, 1), Integer.parseInt(map[1][1]), null);
        System.out.print(max + " " + min);
    }

    private static void search(Pos curPos, int calNum, String prevOp) {
        // 만약 prevS기 연산자라면
        if (curPos.x == n && curPos.y == n) {
            max = Math.max(calNum, max);
            min = Math.min(calNum, min);
            return;
        }

        // 아래로 이동하기
        int nx = curPos.x;
        int ny = curPos.y + 1;
        if (ny <= n) {
            String cell = map[ny][nx];

            if (isOpe(cell)) {
                search(new Pos(nx, ny), calNum, cell);
            } else{
                int num = Integer.parseInt(cell);
                int nextCal = (prevOp == null) ? num : apply(calNum, prevOp, num);
                search(new Pos(nx, ny), nextCal, null);
            }
        }

        // 오른쪽으로 이동하기
        nx = curPos.x + 1;
        ny = curPos.y;
        if (nx <= n) {
            String cell = map[ny][nx];
            if (isOpe(cell)) {
               search(new Pos(nx, ny), calNum, cell);
            } else {
                int num = Integer.parseInt(cell);
                int nextCal = (prevOp == null) ? num : apply(calNum, prevOp, num);
                search(new Pos(nx, ny), nextCal, null);
            }
        }
    }

    private static boolean isOpe(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*")) {
            return true;
        }
        return false;
    }

    private static int apply(int a, String op, int b) {
        switch (op.charAt(0)) {
            case '+': return a + b;
            case '-': return a - b;
            default : return a * b;
        }
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}