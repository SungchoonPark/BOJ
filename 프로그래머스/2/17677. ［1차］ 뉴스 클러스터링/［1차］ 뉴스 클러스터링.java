import java.util.*;
import java.util.regex.Pattern;
class Solution {
    public int solution(String str1, String str2) {
        // 문자열의 자카드 유사도는 문자열을 2개씩 잘라서 집합해서 가지고있으면됨.
        // 기타 공백이나 숫자, 특수 문자가 들어있으면 버려야함. ab+ -> ab, b+는 버림
        // 대소문자 구분안함.
        // 자카드 유사도는 두 집합 A, B의 교집합과 합집합의 원소 개수를 통해 구하면 됨.
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        processing(str1, setA, mapA);
        processing(str2, setB, mapB);
        
        int interSectionSize = makeIntersection(setA, setB, mapA, mapB);
        int unionSize = makeUnion(setA, setB, mapA, mapB);
        
        return result(interSectionSize, unionSize);
    }
    
    private static int result(int a, int b) {
        if(a == 0 && b == 0) return 65536;
        double tmp = (double) a / b;
        return (int) (tmp * 65536);
    }
    
    private static int makeIntersection(Set<String> set1, Set<String> set2, Map<String, Integer> mapA, Map<String, Integer> mapB) {
        int size = 0;
        
        Set<String> standard = set1.size() > set2.size() ? set2 : set1;
        
        for(String s : standard) {
            size += Math.min(mapA.getOrDefault(s, 0), mapB.getOrDefault(s, 0));
        }
        return size;
    }
    
    private static int makeUnion(Set<String> set1, Set<String> set2, Map<String, Integer> mapA, Map<String, Integer> mapB) {
        int size = 0;
        Set<String> standard = new HashSet<>();
        standard.addAll(set1);
        standard.addAll(set2);
        
        for(String s : standard) {
            size += Math.max(mapA.getOrDefault(s, 0), mapB.getOrDefault(s, 0));
        }
        return size;
    }
    
    private static void processing(String s, Set<String> set, Map<String, Integer> map) {
        // 문자열을 2개씩 쪼개면서 Set 및 Map에 넣어야함.
        for(int start = 0; start < s.length() - 1; start++) {
            String tmp = s.substring(start, start + 2);
            if(isValid(tmp)) {
                set.add(tmp);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
    }
    
    private static boolean isValid(String s) {
        String REGEXP_PATTERN_CHAR = "^[a-zA-Z]*$";
        return Pattern.matches(REGEXP_PATTERN_CHAR, s);
    }
}