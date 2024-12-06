import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static char[][] arr;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int r;
    static int c;
    static int ships;
    static int wolfs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = true;
                dfs(j, i);
            }
        }

        System.out.println(ships + " " + wolfs);
    }

    private static void dfs(int startx, int starty) {
        Stack<Pos> stack = new Stack<>();
        stack.add(new Pos(startx, starty));

        int shipCnt = 0;
        int wolfCnt = 0;
        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                    if(!visited[ny][nx] && arr[ny][nx] != '#') {
                        visited[ny][nx] = true;
                        if (arr[ny][nx] == 'v') wolfCnt++;
                        else if(arr[ny][nx] == 'o') shipCnt++;

                        stack.add(new Pos(nx, ny));
                    }
                }
            }
        }

        if (shipCnt > wolfCnt) {
            ships += shipCnt;
        } else {
            wolfs += wolfCnt;
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