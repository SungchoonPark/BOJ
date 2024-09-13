class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int max = Integer.MIN_VALUE;
        int mi = -1;
        
        for(int i=0; i<array.length; i++) {
            int tmp = array[i];
            
            if(tmp > max) {
                max = tmp;
                mi = i;
            }
        }
        
        answer[0] = max;
        answer[1] = mi;
        return answer;
    }
}