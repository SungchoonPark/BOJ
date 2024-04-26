class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = new String[]{"aya", "ye", "woo", "ma"};
        String[] repeat = new String[]{"ayaaya", "yeye", "woowoo", "mama"};
        
        for(int i=0; i<babbling.length; i++) {
            for(int j=0; j<4; j++) {
                babbling[i] = babbling[i].replaceAll(repeat[j], "1").replaceAll(arr[j], " ");
            }
            
            if(babbling[i].trim().length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}