import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num+1];

            st = new StringTokenizer(br.readLine());
            List<Integer>[] map = new List[num+1];
            for (int j = 1; j <= num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j <= num; j++) {
                map[j] = new ArrayList<>();
            }

            for (int j = 1; j < num + 1; j++) {
                map[j].add(arr[j]);
            }

            visited = new int[num+1];
            result = 0;
            Arrays.fill(visited, 0);
            for (int j = 1; j < num+1; j++) {
                if (visited[j] == 0) {
                    visited[j] = 1;
                    dfs(map, j);
                }
            }

            System.out.println(result);
        }
    }

    private static void dfs(List<Integer>[] map, int node) {
        if (visited[node] == 2) {
            // 방문한걸 또 온거니까 사이클 존재
            result++;
            return;
        }

        for (Integer neighbor : map[node]) {
            visited[neighbor]++;
            dfs(map, neighbor);
        }
    }
}