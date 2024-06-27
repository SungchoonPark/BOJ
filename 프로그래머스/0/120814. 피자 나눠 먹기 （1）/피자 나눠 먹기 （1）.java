class Solution {
    public int solution(int n) {
        int tmp = n / 7;
        double result = (double) n / 7.0;
        return tmp < result ? tmp + 1 : tmp;
    }
}