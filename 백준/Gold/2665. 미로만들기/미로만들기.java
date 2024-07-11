import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] distX = {1, -1, 0, 0}; // 좌우
    static int[] distY = {0, 0, 1, -1}; // 상하
    static String[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            arr[i] = a.split("");
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<Pos> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.breakRoom));

        pq.offer(new Pos(0,0,0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Pos curPos = pq.poll();

            if (curPos.x == n-1 && curPos.y == n-1) {
                return curPos.breakRoom;
            }

            for(int i=0; i<4; i++) {
                int nx = curPos.x + distX[i];
                int ny = curPos.y + distY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx]) continue;

                if (arr[ny][nx].equals("0"))  pq.offer(new Pos(nx, ny, curPos.breakRoom + 1));
                else pq.offer(new Pos(nx, ny, curPos.breakRoom));
                visited[ny][nx] = true;
            }
        }

        return 0;
    }

    static class Pos {
        int x, y, breakRoom;

        public Pos(int x, int y, int breakRoom) {
            this.x = x;
            this.y = y;
            this.breakRoom = breakRoom;
        }
    }


}
