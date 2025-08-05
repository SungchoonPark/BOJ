class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int findNum = target - nums[i];

            if(map.get(findNum) == null) {
                map.put(nums[i], i);
            } else {
                Integer idx = map.get(findNum);
                return new int[]{idx, i};
            }
        }
        return new int[]{0, 0};

    }
}