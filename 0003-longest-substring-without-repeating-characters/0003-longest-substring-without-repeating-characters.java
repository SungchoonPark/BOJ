class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }

        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right<s.length(); right++) {
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0) + 1);

            while(map.get(rc) > 1) {
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}