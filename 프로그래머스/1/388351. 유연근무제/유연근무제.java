class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // startday가 6 7 일 경우엔 무시하면됨
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            int day = startday;
            int workStartTime = schedules[i];
            int maxTime = getMaxTime(workStartTime);
            int count = 0;
            
            for(int j=0; j<timelogs[i].length; j++) {
                // 10분 후까지만 지각아님
                // 주말은 미포함
                int enterTime = timelogs[i][j];
                if(day == 7 || day == 6) {
                    if(day == 7) day = 1;
                    else day++;
                    continue;
                }
                
                if(enterTime <= maxTime) {
                    count++;
                }
                
                if(day == 7) day = 1;
                else day++;
            }
            
            if(count == 5) answer++;
        }
        
        return answer;
    }
    
    public int getMaxTime(int time) {
        int orig = time + 10;
        int tmp = orig % 100;
        
        if(tmp >= 60) {
            orig += 100;
            orig -= 60;
        }
        
        return orig;
    }
}