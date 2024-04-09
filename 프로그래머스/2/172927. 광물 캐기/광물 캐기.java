import java.util.*;

class Solution {   
    // 모든 광물을 캐거나 곡괭이가 더 없을 때까지 광물을 캠.
    // 이론적 해답은 -> 비싼 광물을 비싼 곡괭이로 최대한 많이 부시는것 근데 광물은 주어진 순서로 부셔야함
    // 즉, 곡괭이 선택 순서가 메인인 문제 -> 이는 dp 또는 완전탐색으로 풀수있을거같음
    static int minScore = Integer.MAX_VALUE;
    static int totalNum;
    public int solution(int[] picks, String[] minerals) {
        for(int i=0; i<3; i++) totalNum += picks[i];
        dfs(picks, minerals, 0, 0, 0);
        
        return minScore;
    }
    
    private void dfs(int[] picks, String[] minerals, int num, int score, int startIdx) {
        if(num == totalNum || startIdx == minerals.length) {
            if(score < minScore) {
                minScore = score;
            }
            return;
        }
        for(int i=0; i<3; i++) {
            if(picks[i] != 0) {
                int[] newPicks = picks.clone();
                newPicks[i] -= 1;
                int endIdx = Math.min(startIdx + 5, minerals.length);
                int tmpScore = getScore(minerals, startIdx, endIdx, i, score);
                dfs(newPicks, minerals, num+1, tmpScore, endIdx);
            }
        }
    }
    
    // 0 -> dia, 1 -> iron, 2 -> stone
    private int getScore(String[] minerals, int startIdx, int endIdx, int a, int score) {
        for(int i=startIdx; i<endIdx; i++) {
            // i는 mineral의 광물, a는 곡괭이임
            if(a == 0) {
                score += 1;
            } else if(a == 1) {
                if(minerals[i].equals("diamond")) {
                    score += 5;
                } else {
                    score += 1;
                }      
            } else if(a == 2) {
                if(minerals[i].equals("diamond")) {
                    score += 25;
                } else if (minerals[i].equals("iron")) {
                    score += 5;
                } else {
                    score += 1;
                }
            }
        }
        return score;
    }
    
    private void print(String str, int a) {
        System.out.println(str + a);
    }
}