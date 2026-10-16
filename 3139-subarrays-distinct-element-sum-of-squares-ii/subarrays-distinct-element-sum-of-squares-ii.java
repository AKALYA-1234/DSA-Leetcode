class Solution {
    static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];

            update(1, 0, n - 1, prev, i, sum, sq, lazy);

            ans = (ans + sq[1]) % MOD;
            last[x] = i + 1;
        }

        return (int) ans;
    }

    void apply(int node, int l, int r, long val,
               long[] sum, long[] sq, long[] lazy) {
        long len = r - l + 1;
        sq[node] = (sq[node] + 2 * val % MOD * sum[node] % MOD
                    + len * val % MOD * val % MOD) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int l, int r,
              long[] sum, long[] sq, long[] lazy) {
        if (lazy[node] == 0 || l == r) return;

        int mid = (l + r) / 2;
        apply(node * 2, l, mid, lazy[node], sum, sq, lazy);
        apply(node * 2 + 1, mid + 1, r, lazy[node], sum, sq, lazy);
        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr,
                long[] sum, long[] sq, long[] lazy) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            apply(node, l, r, 1, sum, sq, lazy);
            return;
        }

        push(node, l, r, sum, sq, lazy);

        int mid = (l + r) / 2;
        update(node * 2, l, mid, ql, qr, sum, sq, lazy);
        update(node * 2 + 1, mid + 1, r, ql, qr, sum, sq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}