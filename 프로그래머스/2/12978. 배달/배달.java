import java.util.*;

class Solution {
    static List<Town>[] towns;
    static int[] arr;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        towns = new List[51];
        arr = new int[51];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        
        for(int i=1; i<=50; i++) {
            towns[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++) {
            int t1 = road[i][0];
            int t2 = road[i][1];
            int time = road[i][2];
            
            towns[t1].add(new Town(t2, time));
            towns[t2].add(new Town(t1, time));
        }
        
        dijkstra();
        for(int i : arr) {
            if(i <= K) answer++;
        }
        return answer;
    }
    
    private static void dijkstra() {
        PriorityQueue<Town> pq = new PriorityQueue<>((t1, t2) -> t1.time - t2.time);
        pq.offer(new Town(1, 0));
        
        while(!pq.isEmpty()) {
            Town curTown = pq.poll();
            // System.out.println("들어온 마을 번호 : " + curTown.num);
            for(Town relatedTown : towns[curTown.num]) {
                int relatedTownNum = relatedTown.num;
                int relatedTownTime = relatedTown.time;
                
                
                
                if(arr[relatedTownNum] > arr[curTown.num] + relatedTownTime) {
                    arr[relatedTownNum] = arr[curTown.num] + relatedTownTime;
                    pq.offer(relatedTown);
                }
            }
        }
        
    }
    
    static class Town {
        int num;
        int time;
        
        public Town(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}