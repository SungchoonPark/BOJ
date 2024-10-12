import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new ArrayList<>();
        
        // 기존 배열의 원소를 ArrayList로 복사
        for (int num : num_list) {
            list.add(num);
        }
        
        // 마지막 원소와 그 전 원소 비교
        int last = num_list[num_list.length - 1];
        int secondLast = num_list[num_list.length - 2];
        
        // 조건에 따라 값을 추가
        if (last > secondLast) {
            list.add(last - secondLast);
        } else {
            list.add(last * 2);
        }
        
        // ArrayList를 다시 배열로 변환하여 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
