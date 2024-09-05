class Solution {
    public int[] solution(int money) {
        int[] result = new int[2];
        int cnt = money / 5500;
        int a = money - (5500 * cnt);
        result[0] = cnt;
        result[1] = a;
        return result;
    }
}