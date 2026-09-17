class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;

        int ones = 0;

        // Count total number of 1s
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }

        // If there are no 1s or all are already 1
        if (ones == 0 || ones == n) {
            return 0;
        }

        int currentOnes = 0;
        int maxOnes = 0;

        for (int i = 0; i < n + ones - 1; i++) {

            // Add new element
            if (nums[i % n] == 1) {
                currentOnes++;
            }

            // Keep window size = ones
            if (i >= ones) {
                if (nums[(i - ones) % n] == 1) {
                    currentOnes--;
                }
            }

            maxOnes = Math.max(maxOnes, currentOnes);
        }

        return ones - maxOnes;
    }
}