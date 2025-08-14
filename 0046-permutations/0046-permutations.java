class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        boolean[] visited = new boolean[nums.length];
        search(nums, visited, new ArrayList<>(), res);

        return res;
    }

    private void search(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                search(nums, visited, list, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}