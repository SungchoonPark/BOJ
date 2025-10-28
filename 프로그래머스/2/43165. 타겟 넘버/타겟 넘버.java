class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers.length, numbers, target, 0);
        return count;
    }
    
    private void dfs(int curDepth, int maxDepth, int[] numbers, int target, int curValue) {
        if(curDepth == maxDepth) {
            if(target == curValue) count++;
            return;
        }
        
        dfs(curDepth + 1, maxDepth, numbers, target, curValue + numbers[curDepth]);
        dfs(curDepth + 1, maxDepth, numbers, target, curValue - numbers[curDepth]);
    }
}