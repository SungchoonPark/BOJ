import java.util.*;
class Solution {
    public boolean solution(int x) {
        int tmp = 0;
        for(String s : String.valueOf(x).split("")) {
            tmp += Integer.parseInt(s);
        }
        if(x % tmp == 0) return true;
        else return false;
    }
}