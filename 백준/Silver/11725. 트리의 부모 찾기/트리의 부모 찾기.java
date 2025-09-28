import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    static int n;
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        trees = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            trees[i] = new ArrayList();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            trees[a].add(b);
            trees[b].add(a);
        }

        visited[0] = true;
        visited[1] = true;
        dfs(1);

        for (int i = 2; i < n + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            Integer curNode = stack.pop();

            for (Integer i : trees[curNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                    parent[i] = curNode;
                }
            }
        }
    }
}