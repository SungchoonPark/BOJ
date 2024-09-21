import java.util.*;
class Solution {
    
    public int solution(int storey) {
        return bfs(storey);
    }
    
    private static int bfs(int storey) {
        PriorityQueue<Magic> q = new PriorityQueue<>((m1, m2) -> m1.stone - m2.stone);
        q.add(new Magic(storey, 0));
        
        while(!q.isEmpty()) {
            Magic curMagic = q.poll();
            
            int first = curMagic.floor % 10;
        
            if(curMagic.floor < 10) {
                if(first <= 5) {
                    return curMagic.stone + first;
                } else {
                    return curMagic.stone + (10 - first) + 1;
                }
            }
            
            if(first < 5) {
                q.add(new Magic(curMagic.floor / 10, curMagic.stone + first));
            } else if(first == 5) {
                q.add(new Magic(curMagic.floor / 10, curMagic.stone + first));
                q.add(new Magic(curMagic.floor / 10 + 1, curMagic.stone + (10 - first)));
            } else {
                q.add(new Magic(curMagic.floor / 10 + 1, curMagic.stone + (10 - first)));
            }
        }
        
        return -1;
    }
    
    static class Magic {
        int floor;
        int stone;
        
        public Magic(int floor, int stone) {
            this.floor = floor;
            this.stone = stone;
        }
    }
}