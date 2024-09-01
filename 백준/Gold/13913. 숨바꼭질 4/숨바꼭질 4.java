import java.io.*;
import java.util.*;

public class Main {
    static int subin, brother;
    static int result;
    static boolean[] visited = new boolean[200_000];
    static int[] parents = new int[100_100];
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        Arrays.fill(parents, -1);

        dfs();
        System.out.print(sb);
    }

    private static void dfs() {
        PriorityQueue<Pos> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        Stack<Integer> stack = new Stack<>();
        sb = new StringBuilder();
        queue.offer(new Pos(subin, 0));

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            if (curPos.x == brother) {
                result = curPos.time;
                sb.append(result).append("\n");
                stack.push(curPos.x);
                int tmp = parents[curPos.x];
                while(true) {
                    if(tmp != -1) {
                        stack.push(tmp);
                        tmp = parents[tmp];
                    } else {
                        break;
                    }
                }

                while(!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }

                break;
            }

            visited[curPos.x] = true;

            int curx = curPos.x;
            if (curx * 2 < 100_100 && !visited[curx * 2] && parents[curx*2] == -1) {
                parents[curx * 2] = curx;
                queue.offer(new Pos(curx * 2, curPos.time + 1));
            }
            if (curx + 1 < 100_100 && !visited[curx + 1] && parents[curx+1] == -1) {
                parents[curx + 1] = curx;
                queue.offer(new Pos(curx + 1, curPos.time + 1));
            }
            if (curx - 1 >= 0 && curx - 1 < 100_100 && !visited[curx - 1] && parents[curx-1] == -1) {
                parents[curx - 1] = curx;
                queue.offer(new Pos(curx - 1, curPos.time + 1));
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
