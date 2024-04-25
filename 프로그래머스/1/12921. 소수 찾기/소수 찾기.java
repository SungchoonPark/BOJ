class Solution {
    boolean[] arr = new boolean[1000001];
    public int solution(int n) {
        era();
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(!arr[i]) answer++;
        }
        return answer;
    }
    
    private void era() {
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i<=arr.length; i++) {
            for(int j=i*2; j<arr.length; j+=i) {
                if(!arr[j]) arr[j] = true;
            }
        }
    }
}