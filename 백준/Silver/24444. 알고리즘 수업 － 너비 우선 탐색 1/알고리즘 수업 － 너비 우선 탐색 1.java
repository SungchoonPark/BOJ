import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static List<Integer>[] arr;
    static boolean[] vistied;
    static int[] vistiedCnt;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new List[n + 1];
        vistied = new boolean[n + 1];
        vistiedCnt = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }
        for (int i = 0; i < n + 1; i++) {
            Collections.sort(arr[i]);
        }

        bfs(r);
        for (int i = 1; i < vistied.length; i++) {
            if (vistiedCnt[i] != 0) {
                sb.append(vistiedCnt[i]).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void bfs(int startNum) {
        Queue<Integer> queue = new LinkedList<>();
        vistied[startNum] = true;
        vistiedCnt[startNum] = cnt++;
        queue.add(startNum);

        while(!queue.isEmpty()) {
            Integer curValue = queue.poll();

            for (Integer node : arr[curValue]) {
                if (!vistied[node]) {
                    vistied[node] = true;
                    vistiedCnt[node] = cnt++;
                    queue.add(node);
                }
            }
        }
    }
}