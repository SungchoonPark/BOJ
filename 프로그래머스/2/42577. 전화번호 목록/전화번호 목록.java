import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> sets = new HashSet<>();
        for(String s : phone_book) sets.add(s);
        for(String s : phone_book) {
            sets.remove(s);
            for(int i=1; i<=s.length(); i++) {
                String newS = s.substring(0, i);
                // System.out.println("newS : " + newS);
                if(sets.contains(newS)) return false;
            }
            sets.add(s);
        }
        return true;
    }
}