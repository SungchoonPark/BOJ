class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int st = Math.min(a,b);
        int ed = Math.max(a,b);
        
        for(int i=st; i<=ed; i++) answer += i;
        return answer;
    }
}