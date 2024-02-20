import java.util.*;
class Solution {
    private static List<String> list = new ArrayList<>();
    public String solution(String my_string) {
        String result = "";
        String[] strs = my_string.split("");
        for(String s : strs) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        for (String s : list) {
            result+=s;
        }
        return result;
    }
}