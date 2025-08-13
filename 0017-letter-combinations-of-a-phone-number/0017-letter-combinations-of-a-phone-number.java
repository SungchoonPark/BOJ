import java.util.*;

class Solution {
    static List<String> result;
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return List.of();
        }

        Map<String, List<String>> map = new HashMap<>();
        result = new ArrayList<>();
        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));

        List<String> chars = new ArrayList<>();
        String[] nums = digits.split("");

        for(int i=0; i<nums.length; i++) {
            String n = nums[i];
            chars.addAll(map.get(n));
        }

        search(0, new StringBuilder(), digits, map);
        return result;
    }

    private void search(int idx, StringBuilder makeS, String digits, Map<String, List<String>> map) {
        if(idx == digits.length()) {
            System.out.println("s : " + makeS);
            result.add(makeS.toString());
            return;
        }

        List<String> letters = map.get(String.valueOf(digits.charAt(idx)));
        for(String ls : letters) {
                makeS.append(ls);
                search(idx + 1, makeS, digits, map);
                makeS.deleteCharAt((makeS.length() - 1));
        }
        
    }
}