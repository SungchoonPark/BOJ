import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> reserveList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<reserve.length; i++) {
            reserveList.add(reserve[i]);   
        }
        
        for(int i=0; i<lost.length; i++) {
            lostList.add(lost[i]);   
        }
        
        List<Integer> tmpList = new ArrayList<>();
        for(int i=0; i<lostList.size(); i++) {
            int tmp = lostList.get(i);
            if(reserveList.contains(tmp)) {
                tmpList.add(tmp);
            }
        }
        
        reserveList.removeAll(tmpList);
        lostList.removeAll(tmpList);
        
        int answer = n - lostList.size();
        
        for(int i=0; i<lostList.size(); i++) {
            int tmp = lostList.get(i);
            if(reserveList.contains(tmp - 1)) {
                reserveList.remove(reserveList.indexOf(tmp - 1));
                answer++;
            } else if(reserveList.contains(tmp + 1)) {
                reserveList.remove(reserveList.indexOf(tmp + 1));
                answer++;
            }
        }
        
        return answer;
    }
}