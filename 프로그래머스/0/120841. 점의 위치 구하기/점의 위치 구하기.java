class Solution {
    public int solution(int[] dot) {
        int x = dot[0];
        int y = dot[1];
        int result = 0;
        if(x > 0 && y > 0) {
            result = 1;
        } else if (x > 0 && y < 0) {
            result = 4;
        } else if (x < 0 && y < 0) {
            result = 3;
        } else if (x < 0 && y > 0) {
            result = 2;
        }
        return result;
    }
}