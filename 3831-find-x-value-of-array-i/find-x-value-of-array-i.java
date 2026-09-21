class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            // 1. Start a new subarray with only num
            int rem = num % k;
            next[rem]++;

            // 2. Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {
                    int newRem = (r * rem) % k;

                    next[newRem] += dp[r];
                }
            }

            // 3. Every subarray ending here contributes to answer
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            // Move to next position
            dp = next;
        }

        return result;
    }
}