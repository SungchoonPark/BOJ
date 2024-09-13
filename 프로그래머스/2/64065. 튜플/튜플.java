import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<String> list = new ArrayList<>();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        String[] result = s.split("\\},\\{");
        
        result[0] = result[0].replace("{", "");  
        result[result.length - 1] = result[result.length - 1].replace("}", "");

        // 각 덩어리를 출력
        for (String t : result) {
            list.add(t);
        }
        
        list.sort((s1, s2) -> {
            return s1.length() - s2.length();
        });
        
        for(String a : list) {
            String[] tmp = a.split(",");
            for(String st : tmp) {
                set.add(Integer.parseInt(st.trim()));
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for(Integer i : set) {
            // System.out.println("i + = " +i );
            answer.add(i);
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}