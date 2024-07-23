import java.util.*;
class Solution {
    static boolean[] check;
    static int max;
    public int solution(int currentFatigue, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(currentFatigue, dungeons, 0);
        return max;
    }
    
    private static void dfs(int fatigue, int[][] dungeons, int cnt) {
        for(int i=0; i<dungeons.length; i++) {
            if(!check[i] && fatigue >= dungeons[i][0]) {
                check[i] = true;
                dfs(fatigue - dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        max = Math.max(cnt, max);
    }
}