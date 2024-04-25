class Solution {
    boolean[] arr = new boolean[1000001];
    public int solution(int n) {
        era(n);
        int answer = 0;
        for(int i=2; i<=n; i++) {
            if(!arr[i]) answer++;
        }
        return answer;
    }
    
    private void era(int n) {
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i*i<=n; i++) {
            if(!arr[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    arr[j] = true;
                }
            }
        }
    }
}