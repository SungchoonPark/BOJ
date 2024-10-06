import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1 - i2);
        int total = n;
        int result = 0;
        
        boolean flag = false;
        for(int i=0; i<enemy.length; i++) {
            int roundEnemyNum = enemy[i];

            // 무적권 을 일단 쓸 수 있는 만큼 씀
            if(pq.size() < k) {
                pq.offer(roundEnemyNum);
                result++;
                continue;
            }
            
            // 무적권 다 쓴 경우 -> 무적권 쓴 거중에 젤 작은 라운드 적 수
            int curMinNum = pq.peek();
            // System.out.println("젤 작은 무적권 : " + curMinNum);
            // System.out.println("현재 적 수 : " + roundEnemyNum);
            if(roundEnemyNum > curMinNum) {
                // 현재 라운드 적이 무적권 쓴 거보다 큰 경우 -> 현재 라운드에 무적권을 써야함, 이전껀 빼버리기
                // System.out.println("pq 갈아야함.");
                if(curMinNum > total) {
                    break;
                }
                pq.poll();
                pq.offer(roundEnemyNum);
                
                total -= curMinNum;
                
                result++;
            } else {
                // System.out.println("total 에서 빼야함");
                if(roundEnemyNum > total) break;
                
                total -= roundEnemyNum;
                
                result++;
            }
        }
        
        return result;
    }
}