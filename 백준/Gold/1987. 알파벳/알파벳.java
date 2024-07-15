import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static int[] distX = {1, -1, 0, 0}; // 좌우
    static int[] distY = {0, 0, 1, -1}; // 상하
    static char[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int bitmask = 1 << (arr[0][0] - 'A'); // 비트마스크 초기값
        dfs(0, 0, bitmask, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int bitmask, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + distX[i];
            int ny = y + distY[i];
            if (nx < 0 || ny < 0 || nx >= c || ny >= r) continue;
            int nextCharBit = 1 << (arr[ny][nx] - 'A');
            if ((bitmask & nextCharBit) == 0) { // 해당 알파벳을 방문하지 않았을 때
                dfs(nx, ny, bitmask | nextCharBit, count + 1);
            }
        }
    }
}
