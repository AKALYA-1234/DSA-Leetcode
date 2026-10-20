class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i += k) {
                int drops = 0;
                int curMin = nums[i];
                int curMax = nums[i];
                for (int j = i; j < i + k - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        drops++;
                    }
                    curMin = Math.min(curMin, nums[j + 1]);
                    curMax = Math.max(curMax, nums[j + 1]);
                }
                if (nums[i + k - 1] > nums[i]) {
                    drops++;
                }
                if (drops > 1 || curMin < prevMax) {
                    valid = false;
                    break;
                }
                prevMax = curMax;
            }
            if (valid) {
                ans += k;
            }
        }
        return ans;
    }
}