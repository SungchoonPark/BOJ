import java.util.*;

class Solution { 
    HashMap<String, List<String>> graph;
    HashMap<String, Boolean> visitedMap;
    
    public int solution(String begin, String target, String[] words) {
        boolean earlyExit = true;
        graph = new HashMap<>();
        visitedMap = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();
        
        uniqueWords.add(begin);
        visitedMap.put(begin, false);
        for(String s : words) {
            if(target.equals(s)) earlyExit = false;
            uniqueWords.add(s);
            visitedMap.put(s, false);
        }
        
        if(earlyExit) return 0;
        
        for(String unique : uniqueWords) {
            init(unique, uniqueWords);
        }
        
        return bfs(begin, target);
    }
    
    private int bfs(String start, String goal) {
        Queue<WordInfo> queue = new LinkedList<>();
        queue.offer(new WordInfo(start, 0));
        visitedMap.put(start, true);
        
        while(!queue.isEmpty()) {
            WordInfo curInfo = queue.poll();
            if(curInfo.word.equals(goal)) {
                return curInfo.depth;
            }
            
            List<String> names = graph.get(curInfo.word);
            for(String name : names) {
                if(!visitedMap.get(name)) {
                    visitedMap.put(name, true);
                    queue.offer(new WordInfo(name, curInfo.depth + 1));
                }
            }
        }
        
        return -1;
    }
    
    private void init(String pivotWord, Set<String> uniqueWords) {
        // 한자리만 차이나는 값들 미리 넣어놓는 함수
        List<String> oneDifferents = new ArrayList<>();
        
        for(String unique : uniqueWords) {
            if(pivotWord.equals(unique)) continue;
            
            if(isOneDiff(pivotWord, unique)) {
                oneDifferents.add(unique);
            }
        }
        
        graph.put(pivotWord, oneDifferents);
    }
    
    private boolean isOneDiff(String pivot, String other) {
        int diffCnt = 0;
        
        for(int i=0; i<pivot.length(); i++) {
            if(pivot.charAt(i) != other.charAt(i)) {
                diffCnt++;
            }
        }
        
        return diffCnt == 1;
    }
    
    class WordInfo {
        String word;
        int depth;
        
        public WordInfo(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}