import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        Queue<Top> q = new LinkedList<>();
        Stack<Top> size = new Stack<>();
        Queue<Integer> result = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] tops = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j <= n ; j++) {
            q.offer(new Top(tops[j], j));
        }

        size.push(new Top(Integer.MAX_VALUE, 0));
        while(!q.isEmpty()) {
            Top curTop = q.poll();

            while(true) {
                if (curTop.value <= size.peek().value) {
                    result.offer(size.peek().num);
                    size.push(new Top(curTop.value, curTop.num));
                    break;
                } else {
                    size.pop();
                }
            }
        }

        while(!result.isEmpty()) {
            Integer pop = result.poll();
            if (pop == Integer.MAX_VALUE) sb.append(0).append(" ");
            else sb.append(pop).append(" ");
        }
        System.out.print(sb);
    }

    static class Top {
        int value;
        int num;

        public Top(int value, int num) {
            this.value = value;
            this.num = num;
        }
    }
}
