import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        bfs();
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(n);
        q.offer(new Pos(n, list));
        visited.add(n);

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            int curNum = cur.num;
            List<Integer> curList = cur.list;

            if(curNum == 1) {
                System.out.println(curList.size() - 1);
                curList.forEach(num -> System.out.print(num + " "));
                return;
            }

            if (curNum % 3 == 0 && !visited.contains(curNum / 3)) {
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(curNum / 3);
                q.offer(new Pos(curNum / 3, newList));
                visited.add(curNum / 3);
            }

            if (curNum % 2 == 0 && !visited.contains(curNum / 2)) {
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(curNum / 2);
                q.offer(new Pos(curNum / 2, newList));
                visited.add(curNum / 2);
            }

            if (!visited.contains(curNum - 1)) {
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(curNum - 1);
                q.offer(new Pos(curNum - 1, newList));
                visited.add(curNum - 1);
            }
        }
    }

    static class Pos {
        int num;
        List<Integer> list;

        public Pos(int num, List<Integer> list) {
            this.num = num;
            this.list = list;
        }
    }
}
