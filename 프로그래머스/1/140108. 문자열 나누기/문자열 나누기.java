import java.util.*;
class Solution {
    public static int solution(String s) {
        List<String> list = new ArrayList<>();

        while(!s.isEmpty()) {
            int isX = 0;
            int notX = 0;
            char[] arr = s.toCharArray();
            char x = arr[0];

            for(int i=0; i<arr.length; i++) {
                char c = arr[i];
                if(c == x) isX++;
                else notX++;

                if(isX == notX) {
                    list.add(s.substring(0, i + 1));
                    if(i == arr.length - 1) s = "";
                    else s = s.substring(i + 1);
                    break;
                }
            }
            if(isX != notX) {
                list.add(s);
                break;
            }
        }

        return list.size();
    }
}