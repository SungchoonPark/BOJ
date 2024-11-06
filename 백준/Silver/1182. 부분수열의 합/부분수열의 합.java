import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

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
        for (int j = 1; j <= n; j++) {
            comb(visited, 0, n, j);
        }

        System.out.print(result);
    }

    private static void comb(boolean[] visited, int start, int num, int r) {
        if (r == 0) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) tmp += arr[i];
            }

            if (tmp == s) result++;
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(visited, i + 1, num, r - 1);
            visited[i] = false;
        }
    }
}