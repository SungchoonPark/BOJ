// 시간 t를 변경해가며 t시간동안 받을 수 있는 손님의 수를 구하여 현재 전체 손님수 이상으로 나오는
// 제일 작은 t를 구하는 이진탐색 문제이다.
class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1_000_000_000_000_000_000L;
        
        while(end > start) {
            long middle = (start + end) / 2;
            long cntPerson = cntPersoneFromTime(middle, times);
            
            if(cntPerson >= n) {
                // 받을 수 있는 손님수가 전체 손님 수 이상인 경우
                // 더 최적의 시간이 있을 수 있으니 middle을 포함하여 다시 탐색 시작
                end = middle;
            } else {
                // 받을 수 있는 손님수가 전체 손님 수 미만인 경우
                start = middle + 1;
            }
        }
        return start;
    }
    
    // 시간 t가 주어졌을 때 받을 수 있는 최대 손님수를 구하는 메서드
    private static long cntPersoneFromTime(long time, int[] times) {
        // times[] 각각의 원소값 t / times[i] 로 구하여 다 더함
        long cntPerson = 0;
        for(int t : times) {
            cntPerson += (time / t);
        }
        return cntPerson;
    }
}