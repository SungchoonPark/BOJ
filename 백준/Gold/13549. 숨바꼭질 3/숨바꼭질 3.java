import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[100_010];

        bfs(n, k);
        System.out.print(result);
    }

    private static void bfs(int start, int goal) {
        PriorityQueue<Pos> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        queue.offer(new Pos(start, 0));

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();

            if(!curPos.isValidPoint()) {
                continue;
            }
            if (curPos.value == goal) {
                result = curPos.time;
                return;
            }

            visited[curPos.value] = true;

            queue.offer(new Pos(curPos.value * 2, curPos.time));
            queue.offer(new Pos(curPos.value + 1, curPos.time + 1));
            queue.offer(new Pos(curPos.value - 1, curPos.time + 1));
        }
    }
    static class Pos {
        int value;
        int time;

        public Pos(int value, int time) {
            this.value = value;
            this.time = time;
        }

        public boolean isValidPoint() {
            if (this.value >= 0 && this.value < 100_010 && !visited[value]) return true;
            return false;
        }
    }
}


