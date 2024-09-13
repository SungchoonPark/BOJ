class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split("");
        for(String a : arr) {
            try {
                answer += Integer.parseInt(a);
            } catch(Exception e) {
                continue;
            }
        }
        return answer;
    }
}