class Solution {
    static boolean[] primes = new boolean[50_001];
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        era();

        for(int i=0; i<len - 2; i++) {
            for(int j=i+1; j<len - 1; j++) {
                for(int k=j+1; k<len; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if(!primes[tmp]) answer++;
                }
            }
        }

        return answer;
    }
    
    private void era() {
        // false가 소수
        primes[0] = true;
        primes[1] = true;
        
        for(int i=2; i*i<=50000; i++) {
            for(int j=i*i; j<=50000; j+=i) {
                primes[j] = true;
            }
        }
    }
    
}