import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        int totalWolfCnt = 0;
        int totalSheepCnt = 0;

        for (int i = 0; i < r; i++) {
            char[] charArray = br.readLine().toCharArray();

            for (int i1 = 0; i1 < charArray.length; i1++) {
                map[i][i1] = charArray[i1];

                if (map[i][i1] == 'v') {
                    totalWolfCnt++;
                } else if (map[i][i1] == 'k') {
                    totalSheepCnt++;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'k')) {
                    visited[i][j] = true;
                    FarmInfo farmInfo = dfs(new Pos(j, i));

                    if (farmInfo.sheepCnt > farmInfo.wolfCnt) {
                        totalWolfCnt -= farmInfo.wolfCnt;
                    } else {
                        totalSheepCnt -= farmInfo.sheepCnt;
                    }
                }
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
    }

    private static FarmInfo dfs(Pos start) {
        Deque<Pos> stack = new ArrayDeque<>();
        stack.push(start);

        int wolfCnt = 0;
        int sheepCnt = 0;

        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();

            if (map[curPos.y][curPos.x] == 'v') {
                wolfCnt++;
            } else if (map[curPos.y][curPos.x] == 'k') {
                sheepCnt++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];

                if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                    if (!visited[ny][nx] && map[ny][nx] != '#') {
                        visited[ny][nx] = true;
                        stack.push(new Pos(nx, ny));
                    }
                }
            }
        }

        return new FarmInfo(wolfCnt, sheepCnt);
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FarmInfo {
        int wolfCnt;

        int sheepCnt;

        public FarmInfo(int wolfCnt, int sheepCnt) {
            this.wolfCnt = wolfCnt;
            this.sheepCnt = sheepCnt;
        }
    }
}