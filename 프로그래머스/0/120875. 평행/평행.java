import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        // [0-1, 2,3]
        if ((double) (dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]) == (double) (dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0])) return 1;
        // [0-2, 1-3]
        if ((double) (dots[2][1] - dots[0][1]) / (dots[2][0] - dots[0][0]) == (double) (dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0])) return 1;
        // [0-3, 1-2]
        if ((double) (dots[3][1] - dots[0][1]) / (dots[3][0] - dots[0][0]) == (double) (dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0])) return 1;
        return 0;
    }
}

