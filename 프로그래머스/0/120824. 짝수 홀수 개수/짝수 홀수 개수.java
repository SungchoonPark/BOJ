class Solution {
    public int[] solution(int[] num_list) {
        int n1 = 0;
        for(int n : num_list) {
            if(n % 2 == 0) n1++; 
        }
        
        return new int[]{n1, num_list.length - n1};
    }
}