import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String>[] setArr = new HashSet[id_list.length];
        Map<String, Integer> reportCnt = new HashMap<>();
        List<String> bad = new ArrayList<>();
        for(int i=0; i<id_list.length; i++) {
            setArr[i] = new HashSet<>();
            reportCnt.put(id_list[i], 0);
        }
        // 싹다 set으로 담아서 그 set돌면서 Map으로 신고횟수 ㄱㄱ 하는거지
        // 그리고 정지될 사람들을 list에 담고 set에 그 이름이 포함된 애를 
        for(int i=0; i<report.length; i++) {
            String[] tmp = report[i].split(" ");
            String reportPerson = tmp[0];
            String reportedPerson = tmp[1];
            
            setArr[getIdx(id_list, reportPerson)].add(reportedPerson);
        }
        for(int i=0; i<setArr.length; i++) {
            Set tmpSet = setArr[i];
            for(Object o : tmpSet) {
                String s = (String) o;
                reportCnt.put(s, reportCnt.get(s) + 1);
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            int cnt = reportCnt.get(id_list[i]);
            if(cnt >= k) bad.add(id_list[i]);
        }
        
        for(int i=0; i<setArr.length; i++) {
            Set tmp = setArr[i];
            for(int j=0; j<bad.size(); j++) {
                if(tmp.contains(bad.get(j))) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
    
    private int getIdx(String[] arr, String name) {
        int idx = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(name)){
                idx = i;
            }
        }
        return idx;
    }
}