import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n;
    static int m;
    static boolean[][] visited;
    static char[][] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        int sx = 0;
        int sy = 0;
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                arr[i][j] = charArray[j];
                if (charArray[j] == 'I') {
                    sx = j;
                    sy = i;
                }
            }
        }
        dfs(sx, sy);

        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    private static void dfs(int sx, int sy) {
        Stack<Pos> stack = new Stack<>();
        stack.add(new Pos(sx, sy));
        visited[sy][sx] = true;

        while (!stack.isEmpty()) {
            Pos curPos = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (!visited[ny][nx] && arr[ny][nx] != 'X') {
                        visited[ny][nx] = true;
                        stack.add(new Pos(nx, ny));
                        if (arr[ny][nx] == 'P') cnt++;
                    }
                }
            }
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