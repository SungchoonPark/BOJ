import java.util.*;
class Solution {
    public int solution(String my_string, String is_suffix) {
        for(int i=0; i<my_string.length(); i++) {
            String tmp = my_string.substring(i, my_string.length());
            if(tmp.equals(is_suffix)) return 1;
        }
        
        return 0;
    }
}