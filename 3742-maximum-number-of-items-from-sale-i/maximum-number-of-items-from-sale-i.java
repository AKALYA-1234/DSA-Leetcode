
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] bonus = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j &&
                    items[j][0] % items[i][0] == 0) {
                    bonus[i]++;
                }
            }
        }
        int[] dp = new int[budget + 1];
        java.util.Arrays.fill(dp, -1000000000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int[] next = dp.clone();
            for (int b = price; b <= budget; b++) {
                if (dp[b - price] >= 0) {
                    next[b] = Math.max(
                        next[b],
                        dp[b - price] + 1 + bonus[i]
                    );
                }
                if (next[b - price] >= 0) {
                    next[b] = Math.max(
                        next[b],
                        next[b - price] + 1
                    );
                }
            }
            dp = next;
        }
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }
        return ans;
    }
}
