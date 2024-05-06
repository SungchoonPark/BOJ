import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // name, rank
        Map<String, Integer> playerMap = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            Integer rank = playerMap.get(callings[i]);
            String ddait = players[rank -1];
            Integer ddaitRank = playerMap.get(ddait);
            playerMap.put(callings[i], rank - 1);
            playerMap.put(ddait, ddaitRank + 1);
            String tmp = players[ddaitRank];
            players[ddaitRank] = players[rank];
            players[rank] = tmp;
        }
        
        return players;
    }
}