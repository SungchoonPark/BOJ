import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m, result;
    static boolean[] visited;
    static List<Friend>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(new Friend(b, 0));
            list[b].add(new Friend(a, 0));
        }

        visited[1] = true;
        bfs();

        System.out.println(result);
    }

    private static void bfs() {
        Queue<Friend> q = new LinkedList<>();

        q.offer(new Friend(1, 1));
        while(!q.isEmpty()) {
            Friend curFriend = q.poll();
            for (Friend friend : list[curFriend.num]) {
                if (!visited[friend.num] && curFriend.depth < 3) {
                    visited[friend.num] = true;
                    friend.depth = curFriend.depth + 1;
                    q.offer(friend);
                    result++;
                }
            }
        }
    }
}

class Friend {
    int num;
    int depth;

    public Friend(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}
