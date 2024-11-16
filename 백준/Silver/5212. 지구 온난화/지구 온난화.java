import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        char[][] laterMap = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
            laterMap[i] = s.toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {

                    int seaCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        if (nx >= -1 && ny >= -1 && nx <= c && ny <= r) {
                            if (nx == -1 || ny == -1 || nx == c || ny == r) {
                                seaCnt++;
                                continue;
                            }
                            if (map[ny][nx] == '.') seaCnt++;
                        }
                    }

                    if (seaCnt >= 3) {
                        laterMap[i][j] = '.';
                    }
                }
            }
        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        boolean islandExist = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (laterMap[i][j] == 'X') {
                    islandExist = true;
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        if (!islandExist) {
            System.out.println("X");
            return;
        }

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                System.out.print(laterMap[i][j]);
            }
            System.out.println();
        }
    }
}