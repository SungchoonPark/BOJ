import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        return answer;
    }
    
    private void dfs(String word, String target, String[] words, int cnt) {
        if(word.equals(target)) {
            answer = cnt;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(visit[i]) continue;
            
            int tmp = 0;
            // 단어 갯수 세야함
            for(int j=0; j<words[0].length(); j++) {
                if(word.charAt(j) == words[i].charAt(j)) tmp++;
            }
            
            if(tmp == word.length() - 1) {
                visit[i] = true;
                dfs(words[i], target, words, cnt+1);
                visit[i] = false;
            }
        }
    }
    
    
}