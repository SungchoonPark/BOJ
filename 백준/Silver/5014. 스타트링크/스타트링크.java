import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int F, S, G, U, D;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isVisited = new boolean[1000001];
        st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int result = bfs();
        if (result == -1) System.out.println("use the stairs");
        else System.out.println(result);
    }

    private static int bfs() {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        isVisited[S] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == G) {
                    return cnt;
                }

                int a = poll + U;
                int b = poll - D;
                if (a <= F && !isVisited[a]) {
                    isVisited[a] = true;
                    queue.offer(a);
                }
                if (b >= 1 && !isVisited[b]) {
                    isVisited[b] = true;
                    queue.offer(b);
                }
            }

            cnt++;
        }
        return -1;
    }
}