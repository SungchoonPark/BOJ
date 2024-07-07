import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static List<Integer>[] graph;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }
        bfs(x, k);
        Collections.sort(result);

        if (result.isEmpty()) sb.append(-1);
        else {
            result.forEach(num -> sb.append(num).append("\n"));
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int startNum, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNum);
        visited[startNum] = true;
        int dis = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Integer curPoll = queue.poll();

                for (Integer integer : graph[curPoll]) {
                    if (!visited[integer]) {
                        visited[integer] = true;
                        if (dis == k) {
                            result.add(integer);
                        }
                        queue.offer(integer);
                    }
                }
            }
            if (dis > k) return;
            else dis++;
        }
    }
}
