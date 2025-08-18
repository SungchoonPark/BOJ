import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static int n, s;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            search(visited, i, 0, 0);
        }

        System.out.println(result);
    }

    private static void search(boolean[] visited, int depth, int value, int idx) {
        if (depth == 0 && value == s) {
            result++;
            return;
        }

        for (int i = idx; i < n; i++) {
            visited[i] = true;
            search(visited, depth - 1, value + arr[i], i + 1);
            visited[i] = false;
        }
    }
}