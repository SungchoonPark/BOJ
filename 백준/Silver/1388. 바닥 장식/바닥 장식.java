import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static String[][] arr;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < split.length; j++) {
                arr[i][j] = split[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    answer++;
                    visited[i][j] = true;
                    if (Objects.equals(arr[i][j], "-")) dfs(i, j, "-");
                    else dfs(i, j, "|");
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x, String type) {
        if (type.equals("-")) {
            int newX = x + 1;
            if(newX < arr[0].length && !visited[y][newX] && arr[y][newX].equals("-")) {
                visited[y][newX] = true;
                dfs(y, newX, "-");
            }
        } else {
            int newY = y + 1;
            if(newY < arr.length && !visited[newY][x] && arr[newY][x].equals("|")) {
                visited[newY][x] = true;
                dfs(newY, x, "|");
            }
        }
    }
}
