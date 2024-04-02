import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // 이 문제는 수들을 어떻게 정렬할 것인가...에 대한 문제입니다.
//         앞자리가 크면 장땡임. 
//         앞자리가 같을 경우 다음 자리수들을 보며 더 큰 값이 먼저 오게
        String[] strs = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String str1, String str2) {
                int a1 = Integer.parseInt(str1 + str2);
                int a2 = Integer.parseInt(str2 + str1);
                
                return a2 - a1;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++) {
            sb.append(strs[i]);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}