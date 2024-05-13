import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Fruit> list = new ArrayList<>();
        for(int i=0; i<tangerine.length; i++) {
            int tmp = tangerine[i];
            if(!map.containsKey(tmp)) {
                map.put(tmp, 1);
                continue;
            }
            map.put(tmp, map.get(tmp) + 1);
        }
        
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            list.add(new Fruit(key, value));
        }
        
        Collections.sort(list, (f1, f2) -> {
            if(f1.cnt == f2.cnt) {
                return f1.n - f2.n;
            }
            return f2.cnt - f1.cnt;
        });
        
        for(Fruit f : list) {
            // System.out.println("종류 : " + f.n + " 개수 : " + f.cnt);
            if(k == 0) break;
            if(f.cnt >= k) {
                answer++;
                break;
            }
            answer++;
            k -= f.cnt;
        }
        
        
        
        return answer;
    }
}

class Fruit {
    int n;
    int cnt;
    
    public Fruit(int n, int cnt) {
        this.n = n;
        this.cnt = cnt;
    }
}