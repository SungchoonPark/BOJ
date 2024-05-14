import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        int person = 0;
        int num = 0;
        boolean flag = false;
        for(int i=0; i<words.length; i++) {
            String tmp = words[i];
            
            if(list.isEmpty()) {
                list.add(tmp);
                continue;
            }
            String tmpStr = list.get(list.size() - 1); 
            char c = tmpStr.charAt(tmpStr.length() - 1);
            
            if(list.contains(tmp) || c != tmp.charAt(0)) {
                flag = true;
                person = (i + 1 - 1) % n + 1;
                num = (i + 1 - 1) / n + 1;
                // System.out.println("문자열 : " + tmpStr + " 현재 문자 : " + tmp);
                // System.out.println("사람: " + person + " 몇번째 : " + num);
                // System.out.println();
                break;
            }
            list.add(tmp);
        }
        if(!flag) return new int[]{0, 0};
        return new int[]{person, num};
    }
}