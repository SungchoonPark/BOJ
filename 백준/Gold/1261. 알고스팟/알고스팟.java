import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int minBlock = Integer.MAX_VALUE;
    static int[] distX = {1, -1, 0, 0}; // 좌우
    static int[] distY = {0, 0, 1, -1}; // 상하
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            arr[i] = Arrays.stream(a.split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(new Pos(0,0,0));
        System.out.println(minBlock);
    }

    private static void bfs(Pos pos) {
        PriorityQueue<Pos> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.breakBlock));
        pq.offer(pos);
        visited[pos.y][pos.x] = true;

        while(!pq.isEmpty()) {
            Pos curPos = pq.poll();

            if (curPos.y == n-1 && curPos.x == m-1) {
//                System.out.println("curPos = " + curPos);
                if (curPos.breakBlock < minBlock) {
                    minBlock = curPos.breakBlock;
                    return;
                }
            }

            for(int i=0; i<4; i++) {
                int nx = curPos.x + distX[i];
                int ny = curPos.y + distY[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx]) continue;

                if (arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    pq.offer(new Pos(nx, ny, curPos.breakBlock + 1));
                } else {
                    visited[ny][nx] = true;
                    pq.offer(new Pos(nx, ny, curPos.breakBlock));
                }
            }
        }

    }

    static class Pos {
        int x, y, breakBlock;

        public Pos(int x, int y, int breakBlock) {
            this.x = x;
            this.y = y;
            this.breakBlock = breakBlock;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    ", breakBlock=" + breakBlock +
                    '}';
        }
    }
}
