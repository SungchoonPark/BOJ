import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            dfs(i, 1);
            if (flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int n, int d) {
        if (d == 5) {
            flag = true;
            return;
        }

        visited[n] = true;
        for (Integer i : arr[n]) {
            if (!visited[i]) {
                dfs(i, d + 1);
            }
        }
        visited[n] = false;
    }
}
