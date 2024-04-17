class Solution {
    static class Alpha {
        char c;
        int idx;
        public Alpha(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
        public void setIdx(int idx) {
            this.idx = idx;
        }
    }
    public int[] solution(String s) {
        Alpha[] alpha = new Alpha[26];
        for(int i=0; i<26; i++) {
            alpha[i] = new Alpha((char)('a' + i), -1);
        }
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            Alpha a = alpha[c - 'a'];
            if(a.idx == -1) {
                answer[i] = -1;
                a.setIdx(i);
            } else {
                answer[i] = i - a.idx;
                a.setIdx(i);
            }
            System.out.println();
        }
        return answer;
    }
}