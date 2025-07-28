class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int n : nums) maxOR |= n;

        int[] count = new int[1]; // use array to mutate in recursion
        dfs(nums, 0, 0, maxOR, count);
        return count[0];
    }

    private void dfs(int[] nums, int index, int currentOR, int maxOR, int[] count) {
        if (index == nums.length) {
            if (currentOR == maxOR) {
                count[0]++;
            }
            return;
        }
        // Option 1: skip nums[index]
        dfs(nums, index + 1, currentOR, maxOR, count);
        // Option 2: include nums[index]
        dfs(nums, index + 1, currentOR | nums[index], maxOR, count);
    }
}
