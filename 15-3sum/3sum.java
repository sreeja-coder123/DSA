class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lt = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            int target = -nums[i];
            twoSum(nums, target, i, lt);
        }
        return lt;
    }

    void twoSum(int[] nums, int target, int ignore, List<List<Integer>> lt) {
        int left = ignore + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                lt.add(Arrays.asList(nums[ignore], nums[left], nums[right]));
                int bl = nums[left], br = nums[right];
                while (left < right && nums[left] == bl) left++;
                while (left < right && nums[right] == br) right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}