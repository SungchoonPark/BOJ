import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // name, rank
        Map<String, Integer> playerMap = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        for(String calling : callings) {
            Integer rank = playerMap.get(calling);
            
            String tmp = players[rank];
            players[rank] = players[rank - 1];
            players[rank - 1] = tmp;
            
            playerMap.put(calling, rank - 1);
            playerMap.put(players[rank], rank);
        }
        
        return players;
    }
}