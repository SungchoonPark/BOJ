import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int tmp = 0;
        int curNum = 0;
        int prevNum = 0;
        char[] arr = dartResult.toCharArray();
        for(int i=0; i<arr.length; i++) {
            char c = arr[i];
            if(c >= '0' && c<= '9') {
                if(arr[i+1] == '0') {
                    tmp = 10;
                    i++;
                } else {
                    tmp = c - '0';
                }
            } else if (c == 'S' || c == 'D' || c == 'T') {
                if(c == 'S') {
                    curNum = (int) Math.pow(tmp, 1);
                    answer += curNum;
                }
                else if(c == 'D') {
                    curNum = (int) Math.pow(tmp, 2);
                    answer += curNum;
                }
                else {
                    curNum = (int) Math.pow(tmp, 3);
                    answer += curNum;
                }
                if(i < arr.length-1 && arr[i+1] == '*') continue;
            } else {
                if(c == '*') {
                    answer = answer + prevNum + curNum;
                    curNum *= 2;
                } else if(c == '#'){
                    tmp = curNum;
                    curNum *= -2;
                    answer += curNum;
                    curNum += tmp;
                }
            }
            // System.out.println("c : " + c);
            // System.out.println("이전 값 : " + prevNum);
            prevNum = curNum;
            // System.out.println("tmp : " + tmp);
            // System.out.println("현재값 : " + curNum);
            // System.out.println("누적합 : " + answer);
            // System.out.println();
            
        }
        
        return answer;
    }
}