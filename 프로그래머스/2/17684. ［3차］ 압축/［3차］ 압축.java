import java.util.*;

class Solution {
    static Map<String, Integer> dir = new HashMap<>();
    static int idx = 27;
    static List<Integer> result = new ArrayList<>();
    
    public int[] solution(String msg) {
        // 알파벳 세팅
        for(char c = 'A'; c <= 'Z'; c++) {
            dir.put(String.valueOf(c), c - 'A' + 1);
        }
        
        int i = 0;
        while (i < msg.length()) {
            // 문자열 탐색 시작
            String tmp = String.valueOf(msg.charAt(i));
            int tmpIdx = dir.get(tmp);
            int j = i + 1;
            
            // 더 긴 문자열을 찾을 수 있으면 계속 찾기
            while (j < msg.length() && dir.containsKey(tmp + msg.charAt(j))) {
                tmp += msg.charAt(j);
                tmpIdx = dir.get(tmp);
                j++;
            }
            
            // 결과에 현재 찾은 문자열의 인덱스 추가
            result.add(tmpIdx);
            
            // 새로운 문자열을 사전에 등록 (사전에 없는 경우)
            if (j < msg.length()) {
                dir.put(tmp + msg.charAt(j), idx++);
            }
            
            // i를 새롭게 찾은 문자열 길이만큼 증가시켜 다음으로 넘어감
            i = j;
        }
        
        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
