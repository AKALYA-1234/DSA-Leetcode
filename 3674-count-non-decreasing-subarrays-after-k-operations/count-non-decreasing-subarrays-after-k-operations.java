
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        int LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 1: Find Next Greater Element
        int[] nge = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }

            nge[i] = (top == -1) ? n : stack[top];
            stack[++top] = i;
        }

        // Step 2: Binary lifting tables
        int[][] jump = new int[LOG][n];
        long[][] sum = new long[LOG][n];

        for (int i = 0; i < n; i++) {
            jump[0][i] = nge[i];

            int end = nge[i] - 1;

            sum[0][i] =
                (long) nums[i] * (end - i)
                - (prefix[end + 1] - prefix[i + 1]);
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int mid = jump[j - 1][i];

                if (mid < n) {
                    jump[j][i] = jump[j - 1][mid];

                    sum[j][i] =
                        sum[j - 1][i] + sum[j - 1][mid];
                } else {
                    jump[j][i] = n;
                    sum[j][i] = sum[j - 1][i];
                }
            }
        }

        // Step 3: Calculate operations needed
        // for subarray [l, r]
        long ans = 0;

        for (int l = 0; l < n; l++) {
            int low = l;
            int high = n - 1;

            while (low < high) {
                int mid = low + (high - low + 1) / 2;

                if (getCost(l, mid, nums, prefix, jump, sum, LOG) <= k) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            ans += low - l + 1;
        }

        return ans;
    }

    private long getCost(
        int l,
        int r,
        int[] nums,
        long[] prefix,
        int[][] jump,
        long[][] sum,
        int LOG
    ) {
        int n = nums.length;
        int cur = l;

        long total = 0;

        for (int j = LOG - 1; j >= 0; j--) {
            if (cur < n) {
                int dest = jump[j][cur];

                if (dest <= r + 1) {
                    total += sum[j][cur];
                    cur = dest;
                }
            }
        }

        if (cur <= r) {
            total += (long) nums[cur] * (r - cur)
                     - (prefix[r + 1] - prefix[cur + 1]);
        }

        return total;
    }
}
