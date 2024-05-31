import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static boolean[] visited;
    static int[] answer;
    static PriorityQueue<Integer>[] arr;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        answer = new int[n+1];
        arr = new PriorityQueue[n+1];

        for(int i=0; i<=n; i++) {
            arr[i] = new PriorityQueue<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        visited[r] = true;
        answer[r] = cnt++;
        dfs(r);
        for(int i=1; i<answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int num) {
        while(!arr[num].isEmpty()) {
            Integer poll = arr[num].poll();
            if (!visited[poll]) {
                visited[poll] = true;
                answer[poll] = cnt++;
                dfs(poll);
            }
        }
    }
}
