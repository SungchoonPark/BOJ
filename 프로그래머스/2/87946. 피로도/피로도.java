import java.util.*;
class Solution {
    public int solution(int currentFatigue, int[][] dungeons) {
        int maxDungeon = 0;

        List<int[][]> permutations = new ArrayList<>();
        boolean[] visited = new boolean[dungeons.length];
        
        generatePermutations(dungeons, new ArrayList<>(), visited, permutations);

        for (int[][] permutation : permutations) {
            int fatigue = currentFatigue;
            int count = 0;
            for (int[] dungeon : permutation) {
                if (fatigue >= dungeon[0]) {
                    fatigue -= dungeon[1];
                    count++;
                } else {
                    break;
                }
            }
            maxDungeon = Math.max(maxDungeon, count);
        }
        
        return maxDungeon;
    }
    
    private void generatePermutations(int[][] dungeons, List<int[]> current, boolean[] visited, List<int[][]> result) {
        if (current.size() == dungeons.length) {
            result.add(current.toArray(new int[0][0]));
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(dungeons[i]);
                generatePermutations(dungeons, current, visited, result);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}