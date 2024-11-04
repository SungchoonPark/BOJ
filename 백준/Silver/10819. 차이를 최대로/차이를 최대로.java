import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            List<Integer> list = new ArrayList<>(n);
            visited[i] = true;
            list.add(arr[i]);

            dfs(visited, list, 1);
        }

        System.out.print(max);
    }

    private static void dfs(boolean[] visited, List<Integer> list, int depth) {
        if (depth == n) {
            int sum = calculate(list);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                dfs(visited, list, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static int calculate(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            sum += Math.abs(list.get(i) - list.get(i+1));
        }
        return sum;
    }
}