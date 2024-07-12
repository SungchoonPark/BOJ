import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] distX = {1, -1, 0, 0}; // 좌우
    static int[] distY = {0, 0, 1, -1}; // 상하
    static String[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            arr[i] = a.split("");
        }

        System.out.println(bfs(new PosInfo(0,0,0,1)));
    }

    private static int bfs(PosInfo posInfo) {
        Queue<PosInfo> q = new LinkedList<>();

        q.offer(posInfo);
        visited[posInfo.y][posInfo.x][posInfo.breakNum] = true;

        while (!q.isEmpty()) {
            PosInfo curPos = q.poll();

            if (curPos.x == m-1 && curPos.y == n-1) return curPos.blockNum;

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + distX[i];
                int ny = curPos.y + distY[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx][curPos.breakNum]) continue;

                if (arr[ny][nx].equals("0")) {
                    // 벽 아닌경우
                    visited[ny][nx][curPos.breakNum] = true;
                    q.offer(new PosInfo(nx, ny, curPos.breakNum, curPos.blockNum + 1));
                } else if (curPos.breakNum == 0) {
                    // 벽 만낫는데 벽 부순적 없는 경우
                    visited[ny][nx][1] = true;
                    q.offer(new PosInfo(nx, ny, 1, curPos.blockNum + 1));
                }
            }
        }
        return -1;
    }

    static class PosInfo {
        int x;
        int y;
        int breakNum;
        int blockNum;

        public PosInfo(int x, int y, int breakNum, int blockNum) {
            this.x = x;
            this.y = y;
            this.breakNum = breakNum;
            this.blockNum = blockNum;
        }
    }
}
