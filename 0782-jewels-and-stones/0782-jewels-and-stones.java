class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        List<String> js = new ArrayList<>();
        for(int i=0; i<jewels.length(); i++) {
            js.add(String.valueOf(jewels.charAt(i)));
        }

        int result = 0;
        for(int i=0; i<stones.length(); i++) {
            String s = String.valueOf(stones.charAt(i));

            if(js.contains(s)) {
                result++;
            }
        }

        return result;
    }
}