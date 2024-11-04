import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            List<Integer> list = new ArrayList<>(n);
            visited[i] = true;
            list.add(i);
            dfs(visited, list, 1);
        }

        System.out.print(sb);
    }

    private static void dfs(boolean[] visited, List<Integer> list, int depth) {
        if (depth == n) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfs(visited, list, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}