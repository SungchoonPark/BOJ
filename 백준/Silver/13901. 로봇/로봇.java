import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int r, c;
    static int sr, sc;
    static int[][] map;
    static boolean[][] visited;
    static int[] dir = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new int[r][c];
        visited = new boolean[r][c];

        int blockCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < blockCount; i++) {
            st = new StringTokenizer(br.readLine());

            int blockR = Integer.parseInt(st.nextToken());
            int blockC = Integer.parseInt(st.nextToken());

            map[blockR][blockC] = -1;
        }

        st = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        visited[sr][sc] = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }

        search(new Pos(sc, sr), 0);
    }

    private static void search(Pos robotPos, int dirIdx) {
        if (!canMove(robotPos)) {
            System.out.print(robotPos.y + " " + robotPos.x);
            return;
        }

        int direction = dir[dirIdx];

        if (direction == 1) {
            // 위
            if (robotPos.y - 1 >= 0 && !visited[robotPos.y - 1][robotPos.x] && map[robotPos.y - 1][robotPos.x] != -1) {
                visited[robotPos.y - 1][robotPos.x] = true;
                search(new Pos(robotPos.x, robotPos.y - 1), dirIdx);
            } else {
                int nextDirIdx = (dirIdx + 1) % 4;
                search(robotPos, nextDirIdx);
            }
        } else if (direction == 2) {
            // 아래
            if (robotPos.y + 1 < r && !visited[robotPos.y + 1][robotPos.x] && map[robotPos.y + 1][robotPos.x] != -1) {
                visited[robotPos.y + 1][robotPos.x] = true;
                search(new Pos(robotPos.x, robotPos.y + 1), dirIdx);
            } else {
                int nextDirIdx = (dirIdx + 1) % 4;
                search(robotPos, nextDirIdx);
            }
        } else if (direction == 3) {
            // 왼
            if (robotPos.x - 1 >= 0 && !visited[robotPos.y][robotPos.x - 1] && map[robotPos.y][robotPos.x - 1] != -1) {
                visited[robotPos.y][robotPos.x - 1] = true;
                search(new Pos(robotPos.x - 1, robotPos.y), dirIdx);
            } else {
                int nextDirIdx = (dirIdx + 1) % 4;
                search(robotPos, nextDirIdx);
            }
        } else {
            // 오
            if (robotPos.x + 1 < c && !visited[robotPos.y][robotPos.x + 1] && map[robotPos.y][robotPos.x + 1] != -1) {
                visited[robotPos.y][robotPos.x + 1] = true;
                search(new Pos(robotPos.x + 1, robotPos.y), dirIdx);
            } else {
                int nextDirIdx = (dirIdx + 1) % 4;
                search(robotPos, nextDirIdx);
            }
        }
    }

    private static boolean canMove(Pos curPos) {
        boolean upCan = false;
        boolean downCan = false;
        boolean leftCan = false;
        boolean rightCan = false;

        if (curPos.y - 1 >= 0) {
            if (!visited[curPos.y - 1][curPos.x] && map[curPos.y - 1][curPos.x] != -1) {
                upCan = true;
            }
        }

        if (curPos.y + 1 < r) {
            if (!visited[curPos.y + 1][curPos.x] && map[curPos.y + 1][curPos.x] != -1) {
                downCan = true;
            }
        }

        if (curPos.x - 1 >= 0) {
            if (!visited[curPos.y][curPos.x - 1] && map[curPos.y][curPos.x - 1] != -1) {
                leftCan = true;
            }
        }

        if (curPos.x + 1 < c) {
            if (!visited[curPos.y][curPos.x + 1] && map[curPos.y][curPos.x + 1] != -1) {
                rightCan = true;
            }
        }

        if (!upCan && !downCan && !leftCan && !rightCan) {
            return false;
        }

        return true;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pos{" +
                "y=" + y +
                ", x=" + x +
                '}';
        }
    }
}