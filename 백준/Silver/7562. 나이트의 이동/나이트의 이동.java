import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[][] dir = {
            {-2, 1},
            {-1, 2},
            {-2, -1},
            {-1, -2},
            {2, 1},
            {1, 2},
            {2, -1},
            {1, -2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            int chessSize = Integer.parseInt(br.readLine());
            int[][] chess = new int[chessSize][chessSize];
            st = new StringTokenizer(br.readLine());
            int currentKnightY = Integer.parseInt(st.nextToken());
            int currentKnightX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int destKnightY = Integer.parseInt(st.nextToken());
            int destKnightX = Integer.parseInt(st.nextToken());

            System.out.println(bfs(currentKnightY, currentKnightX, destKnightY, destKnightX, chessSize, chess));
        }

    }

    private static int bfs(int cY, int cX, int dY, int dX, int chessSize, int[][] chess) {
        boolean[][] isVisited = new boolean[chessSize][chessSize];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{cY, cX});
        isVisited[cY][cX] = true;

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            int currentY = poll[0];
            int currentX = poll[1];
            if (currentY == dY && currentX == dX) return chess[currentY][currentX];

            for (int i = 0; i < dir.length; i++) {
                int nY = currentY + dir[i][0];
                int nX = currentX + dir[i][1];

                if (nY >= 0 && nY < chessSize && nX >= 0 && nX < chessSize) {
                    if (!isVisited[nY][nX]) {
                        queue.offer(new Integer[]{nY, nX});
                        isVisited[nY][nX] = true;
                        chess[nY][nX] = chess[currentY][currentX] + 1;
                    }
                }
            }
        }
        return -1;
    }
}