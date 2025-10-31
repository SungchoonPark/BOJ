class Solution {
    public int[] solution(int brown, int yellow) {
        // 중앙은 무조건 노랑, 테두리는 갈색
        // 각 색 격자의 개수는 기억하지만 전체 카펫 크기는 모름
        // 가로 >= 세로
        // 노란색 가로, 세로 길이를 완전탐색을 통해서 찾아나가면 됨.
        
        int[] result = new int[2];
        boolean isEnd = false;
        for(int yw = 1; yw <= 2_000_000; yw++) {
            for(int yh = 1; yh <=yw; yh++) {
                if(yw * yh == yellow) {
                    if((yw + 2 + yh) * 2 == brown) {
                        result[0] = yw + 2;
                        result[1] = yh + 2;
                        isEnd = true;
                        break;
                    }
                }
            }
            
            if(isEnd) break;
        }
        
        return result;
    }
}