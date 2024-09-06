import java.util.*;
class Solution {
    static int[] bigtop = new int[10_001];
    public int solution(int[] topping) {
        // 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 '동일한 가짓수의 토핑이 올라가면 공평한 롤케이크임.'
        // 즉, 롤케이크를 두개로 나눴을 때, 토핑 종류의 수가 같으면 공평한것
        // 그냥 Set에서 remove하면 안됨. 왜냐하면 1이 3개 있을 때 1개만 없어졌어도 1이 있으니까...
        // 그러니까 자르고 Set에 넣어서 비교하면 되나..?
        // 토핑종류 배열 만들어놓고 각 수마다 빼면되나? 
        Arrays.fill(bigtop, 0);
        
        Set<Integer> small = new HashSet<>();
        Set<Integer> big = new HashSet<>();
        int answer = 0;
        
        small.add(topping[0]);
        for(int i=1; i < topping.length; i++) {
            bigtop[topping[i]]++;
            big.add(topping[i]);
        }
        
        if(isSameSize(small, big)) answer++;
        
        for(int i=1; i < topping.length; i++) {
            // System.out.println("small : " + small);
            // System.out.println("big : " + big);
            small.add(topping[i]);
            
            if(bigtop[topping[i]] != 0) {
                if(bigtop[topping[i]] == 1) {
                    big.remove(topping[i]);
                }
                bigtop[topping[i]]--;
            }
            
            if(isSameSize(small, big)) answer++;
        }
        
        return answer;
    }
    
    private boolean isSameSize(Set<Integer> set1, Set<Integer> set2) {
        if(set1.size() == set2.size()) return true;
        return false;
    }
}