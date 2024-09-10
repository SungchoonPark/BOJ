import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> q = new LinkedList<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            String c = city.toLowerCase();
            if (q.contains(c)) {
                // 캐시 히트
                q.remove(c); // 기존 위치에서 제거
                q.offer(c); // 가장 최근에 사용된 것으로 맨 뒤에 추가
                answer += 1;
            } else {
                // 캐시 미스
                if (q.size() == cacheSize) {
                    q.poll(); // 캐시가 가득 찼을 경우 가장 오래된 항목 제거
                }
                q.offer(c); // 새로운 항목을 캐시에 추가
                answer += 5;
            }
        }
        return answer;
    }
}
