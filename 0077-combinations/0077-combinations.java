class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n + 1];
        for(int i=1; i<=n; i++) nums[i] = i;

        for(int i=1; i<=n + 1 - k; i++) {
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            List<Integer> path = new ArrayList<>();
            path.add(i);
            search(res, path, nums, visited, k, i);
        }
        return res;
    }

    private void search(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited, int limit, int start) {
        if(path.size() == limit) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i <= visited.length - 1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                search(res, path, nums, visited, limit, i);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}