import java.io.*;
import java.util.*;

public class Main {
    static int subin, brother;
    static int minTime = Integer.MAX_VALUE;
    static int minCnt;
    static int[] visited = new int[500_001];

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        Arrays.fill(visited, Integer.MAX_VALUE);

        dfs();
        sb.append(minTime).append("\n").append(minCnt);
        System.out.println(sb);
    }

    private static void dfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(subin, 0));

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            if (curPos.x == brother) {
                if (curPos.time < minTime) {
                    minTime = curPos.time;
                    minCnt = 1;
                } else if (curPos.time == minTime) {
                    minCnt++;
                }
                continue;
            }

            if (minTime != Integer.MAX_VALUE && curPos.time + 1 > minTime) continue;

            int[] newPos = {curPos.x * 2, curPos.x +1, curPos.x - 1};
            for (int newPo : newPos) {
                if (newPo >= 0 && newPo < 500_001) {
                    if (visited[newPo] >= curPos.time + 1) {
                        visited[newPo] = curPos.time + 1;
                        queue.offer(new Pos(newPo, curPos.time + 1));
                    }
                }
            }
        }
    }

    static class Pos {
        int x;
        int time;

        public Pos(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
