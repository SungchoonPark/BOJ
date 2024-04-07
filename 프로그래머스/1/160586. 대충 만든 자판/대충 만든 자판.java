import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // n번 버튼을 비교하면서 더 가까운곳에 있으면 그걸 ++ 하면 될듯
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for(String target : targets) {
            int cnt = 0;
            for(char c : target.toCharArray()) {
                int minCnt = Integer.MAX_VALUE;
                // 하나는 존재하는데 하나는 아예 존재하지 않는 경우가 있을 수 있음.
                boolean flag = false;
                for(int i=0; i<keymap.length; i++) {
                    for(int j=0; j<keymap[i].length(); j++) {
                        if(keymap[i].charAt(j) == c) {
                            flag = true;
                            if(minCnt > j+1) minCnt = j+1;
                        }
                    }
                }
                if(!flag) {
                    cnt = Integer.MAX_VALUE;
                    break;
                }else {
                    cnt += minCnt;                    
                }
            }
            if(cnt == Integer.MAX_VALUE) list.add(-1);
            else list.add(cnt);
        }
        
        return list.stream().mapToInt(Integer::new).toArray();
    }
}