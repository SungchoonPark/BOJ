import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        char[] parseArr = new char[4];
        parseArr[0] = 'U';
        parseArr[1] = 'R';
        parseArr[2] = 'D';
        parseArr[3] = 'L';

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        int startPr = Integer.parseInt(st.nextToken()) - 1;
        int startPc = Integer.parseInt(st.nextToken()) - 1;

        int maxRemainTime = 0;
        int resultDir = -1;
        for (int i = 0; i < 4; i++) {
            // 0 -> U
            // 1 -> R
            // 2 -> D
            // 3 -> L
            int remainTime = dfs(new Pos(startPc, startPr, i));
            
            if (remainTime > maxRemainTime) {
                maxRemainTime = remainTime;
                resultDir = i;
            }
        }

        System.out.println(parseArr[resultDir]);
        if (maxRemainTime == Integer.MAX_VALUE) {
            System.out.println("Voyager");
            return;
        }

        System.out.println(maxRemainTime);
    }

    private static int dfs(Pos start) {
        Deque<Pos> stack = new ArrayDeque<>();
        stack.push(start);

        int cnt = 0;
        int remainTime = 0;
        while(!stack.isEmpty()) {
            Pos curPos = stack.pop();

            if (cnt == 1000000) return Integer.MAX_VALUE;

            // 현재 방향으로만 직진하지만 바뀔 수 있음
            Pos nextPos = getNextPos(curPos);

            if (nextPos == null) {
                // 더이상 갈수 있는 곳이 없음
                return remainTime + 1;
            }

            stack.push(nextPos);
            remainTime++;
            cnt++;
        }

        return -1;
    }

    private static Pos getNextPos(Pos curPos) {
        int dir = curPos.dir;

        if (dir == 0) {
            // U
            int ny = curPos.y - 1;

            if (ny < 0) return null;

            if (map[ny][curPos.x] == '\\') {
                return new Pos(curPos.x, ny, 3);
            }

            if (map[ny][curPos.x] == '/') {
                return new Pos(curPos.x, ny, 1);
            }

            if (map[ny][curPos.x] == 'C') {
                return null;
            }

            return new Pos(curPos.x, ny, dir);
        } else if (dir == 1) {
            // R
            int nx = curPos.x + 1;

            if (nx >= m) return null;

            if (map[curPos.y][nx] == '\\') {
                return new Pos(nx, curPos.y, 2);
            }

            if (map[curPos.y][nx] == '/') {
                return new Pos(nx, curPos.y, 0);
            }

            if (map[curPos.y][nx] == 'C') {
                return null;
            }

            return new Pos(nx, curPos.y, dir);
        } else if (dir == 2) {
            // D
            int ny = curPos.y + 1;

            if (ny >= n) return null;

            if (map[ny][curPos.x] == '\\') {
                return new Pos(curPos.x, ny, 1);
            }

            if (map[ny][curPos.x] == '/') {
                return new Pos(curPos.x, ny, 3);
            }

            if (map[ny][curPos.x] == 'C') {
                return null;
            }

            return new Pos(curPos.x, ny, dir);
        } else {
            // L
            int nx = curPos.x - 1;

            if (nx < 0) return null;

            if (map[curPos.y][nx] == '\\') {
                return new Pos(nx, curPos.y, 0);
            }

            if (map[curPos.y][nx] == '/') {
                return new Pos(nx, curPos.y, 2);
            }

            if (map[curPos.y][nx] == 'C') {
                return null;
            }

            return new Pos(nx, curPos.y, dir);
        }
    }

    static class Pos {
        int x;
        int y;
        int dir;

        public Pos(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}