class Solution {
    public int solution(int[][] sizes) {
        // 제일 큰수의 가로 또는 세로 길이보다 크지만 제일 작은수를 찾아라
        
        int result = Integer.MAX_VALUE;
        int maxW = 0;
        int maxH = 0;
        for(int i=0; i<sizes.length; i++) {
            int tmpW = Math.max(sizes[i][0], sizes[i][1]);
            int tmpH = Math.min(sizes[i][0], sizes[i][1]);
            
            maxW = Math.max(maxW, tmpW);
            maxH = Math.max(maxH, tmpH);
        }

        return maxW * maxH;
    }
}