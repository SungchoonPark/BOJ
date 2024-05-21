import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 무조건 10일 연속으로 일치하는 경우에만 회원가입 할거임.
        // 그럼 연속된 10일 안에 자신이 원하는 상품이 있는지를 봐야함
        // 최대 10만이라서 1씩 증가하면서 보는건 좀 에바지않나 싶은데
        int answer = 0;
        for(int i=0; i < discount.length-9; i++) {
            int j;
            for(j=0;j<want.length;j++) {
                int check=0;
                for(int k=i; k < i+10; k++) {
                    if(discount[k].equals(want[j])) check++;
                }
                if(check<number[j]) {
                     break;
                }
            }
           if(j==want.length) answer++;
        }
        return answer;
    }
}