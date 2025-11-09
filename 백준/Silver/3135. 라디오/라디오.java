import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int a, b;
    static int n;
    static boolean[] visited;
    static List<Integer> stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        stars = new ArrayList<>();
        visited = new boolean[1000];

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            stars.add(v);
        }

        System.out.println(bfs(new Pos(a, 0)));
    }

    private static int bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x] = true;

        while(!queue.isEmpty()) {
            Pos curPos = queue.poll();

            if (curPos.x == b) {
                return curPos.cnt;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    int nx = curPos.x + 1;

                    if (nx < 1000 && !visited[nx]) {
                        visited[nx] = true;
                        queue.offer(new Pos(nx, curPos.cnt + 1));
                    }
                } else if (i == 1) {
                    int nx = curPos.x - 1;

                    if (nx > 0 && !visited[nx]) {
                        visited[nx] = true;
                        queue.offer(new Pos(nx, curPos.cnt + 1));
                    }
                } else {
                    for (Integer star : stars) {
                        if (!visited[star]) {
                            visited[star] = true;
                            queue.offer(new Pos(star, curPos.cnt + 1));
                        }
                    }
                }


            }

        }

        return -1;
    }

    static class Pos {
        int x;
        int cnt;

        public Pos(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}