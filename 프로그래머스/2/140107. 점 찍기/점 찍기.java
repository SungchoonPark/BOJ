class Solution {
    public long solution(int k, int d) {

        long count = 0;
        for(int i = 0 ; i <= d ; i+=k){
            int Y = (int) Math.sqrt( Math.pow(d,2) - Math.pow(i,2)) ;
            count += 1 + Y/k;
        }
        return count;
    }
}
