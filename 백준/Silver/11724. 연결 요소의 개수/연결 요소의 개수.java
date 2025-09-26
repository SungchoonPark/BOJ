import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                search(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void search(int x) {
        Stack<Integer> stack = new Stack<>();
        stack.push(x);

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();

            for (Integer con : graph[pop]) {
                if (!visited[con]) {
                    visited[con] = true;
                    stack.push(con);
                }
            }
        }
    }
}