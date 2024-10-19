class Solution {
    public int solution(int a, int b) {
        int a1 = 2 * a * b;
        int a2 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        
        return a1 > a2 ? a1 : a2;
    }
}