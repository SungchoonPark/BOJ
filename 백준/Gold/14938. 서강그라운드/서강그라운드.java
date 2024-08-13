import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Region>[] areas;
    static boolean[] visited;
    static int[] cost;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int regionNum = Integer.parseInt(st.nextToken());
        int searchArea = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());

        int[] itemCntInArea = new int[regionNum + 1];
        areas = new List[regionNum + 1];
        visited = new boolean[regionNum + 1];
        for (int i = 0; i < regionNum + 1; i++) {
            areas[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < regionNum + 1; i++) {
            itemCntInArea[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int areaA = Integer.parseInt(st.nextToken());
            int areaB = Integer.parseInt(st.nextToken());
            int roadLen = Integer.parseInt(st.nextToken());

            areas[areaA].add(new Region(areaB, roadLen));
            areas[areaB].add(new Region(areaA, roadLen));
        }

        for (int i = 1; i < regionNum + 1; i++) {
            cost = new int[regionNum + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            dijkstra(i, searchArea, itemCntInArea);
        }

        System.out.print(max);
    }

    private static void dijkstra(int startArea, int searchArea, int[] itemCntInArea) {
        PriorityQueue<Region> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.loadCost));
        pq.offer(new Region(startArea, 0));
        cost[startArea] = 0;

        while (!pq.isEmpty()) {
            Region curRegion = pq.poll();

            if (cost[curRegion.regionNum] < curRegion.loadCost) {
                continue;
            }

            for (Region nextRegion : areas[curRegion.regionNum]) {
                if (cost[nextRegion.regionNum] > cost[curRegion.regionNum] + nextRegion.loadCost) {
                    cost[nextRegion.regionNum] = cost[curRegion.regionNum] + nextRegion.loadCost;
                    pq.offer(nextRegion);
                }
            }
        }

        int itemCnt = 0;
        for(int i=1; i<cost.length; i++) {
            if (cost[i] <= searchArea) {
                itemCnt += itemCntInArea[i];
            }
        }

        max = Math.max(itemCnt, max);
    }

    static class Region {
        int regionNum;
        int loadCost;

        public Region(int regionNum, int loadCost) {
            this.regionNum = regionNum;
            this.loadCost = loadCost;
        }
    }
}