import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static List<Island>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int maxWeight = 0;

        arr = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        int maxCost = 0; // 이분탐색시 max값으로 설정될 값.
        int minCost = Integer.MAX_VALUE; // 이분탐색시 min값으로 설정될 값.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maxCost = Math.max(maxCost, c);
            minCost = Math.min(minCost, c);
            arr[a].add(new Island(b, c));
            arr[b].add(new Island(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int startN = Integer.parseInt(st.nextToken());
        int goalN = Integer.parseInt(st.nextToken());

        while(minCost <= maxCost) {
            int middle = (minCost + maxCost) / 2; // 탐색시 사용될 중량값
            boolean[] isVisited = new boolean[n + 1];
            isVisited[startN] = true;

            if (bfs(startN, goalN, middle, isVisited)) {
                // ✅ 해당 중량으로 목적지 섬까지 도달 가능함
                // 중량을 더 키워보기
                minCost = middle + 1;
                maxWeight = middle;
            } else {
                // ❌ 해당 중량으로 목적지 섬까지 도달 불가능
                // 중량을 더 작게하기
                maxCost = middle - 1;
            }
        }

        System.out.println(maxWeight);
    }

    private static boolean bfs(int startN, int goalN, int w, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startN);

        while(!queue.isEmpty()) {
            Integer curIslandNum = queue.poll();

            if (curIslandNum == goalN) return true;

            for (Island island : arr[curIslandNum]) {
                if (!isVisited[island.num] && island.weight >= w) {
                    isVisited[island.num] = true;
                    queue.offer(island.num);
                }
            }
        }

        return false;
    }

    static class Island {
        public int num;
        public int weight;

        public Island(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
