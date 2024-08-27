import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int white, blue;
    static char[][] arr;
    static boolean[][] visited;

    static StringTokenizer st;
    static StringBuilder sb;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            arr[i] = br.readLine().toCharArray();
         }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(j, i, arr[i][j] == 'W');
                }
            }
        }

        sb.append(white).append(" ").append(blue);
        System.out.print(sb);
    }

    private static void dfs(int x, int y, boolean isWhite) {
        int tmp = 1;

        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(x, y));
        visited[y][x] = true;

        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();

            for (int i = 0; i < 4; i++) {
                int newX = curPos.x + dx[i];
                int newY = curPos.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (!visited[newY][newX]) {
                        if (!isWhite && arr[newY][newX] == 'B') {
                            // 적군의 수를 셀때
                            visited[newY][newX] = true;
                            stack.push(new Pos(newX, newY));
                            tmp++;
                        } else if (isWhite && arr[newY][newX] == 'W') {
                            // 아군의 수를 셀때
                            visited[newY][newX] = true;
                            stack.push(new Pos(newX, newY));
                            tmp++;
                        }
                    }
                }
            }
        }
        if (isWhite) white += (tmp * tmp);
        else blue += (tmp * tmp);
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
