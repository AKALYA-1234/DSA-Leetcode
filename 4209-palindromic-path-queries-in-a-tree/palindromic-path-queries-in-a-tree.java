
import java.util.*;

class Solution {
    private int[] tin, tout, depth, parent, basePrefix;
    private int LOG;
    private int[][] up;
    private List<Integer>[] adj;
    private Fenwick bit;

    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        basePrefix = new int[n];
        Arrays.fill(parent, -1);

        char[] chars = s.toCharArray();

        int[] iter = new int[n];
        int[] stack = new int[n];
        int top = 0, timer = 0;

        stack[top++] = 0;
        parent[0] = 0;
        basePrefix[0] = mask(chars[0]);

        while (top > 0) {
            int u = stack[top - 1];

            if (iter[u] == 0) {
                tin[u] = timer++;
            }

            if (iter[u] < adj[u].size()) {
                int v = adj[u].get(iter[u]++);

                if (parent[v] != -1) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                basePrefix[v] = basePrefix[u] ^ mask(chars[v]);
                stack[top++] = v;
            } else {
                tout[u] = timer - 1;
                top--;
            }
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        up = new int[LOG][n];
        for (int u = 0; u < n; u++) up[0][u] = parent[u];

        for (int k = 1; k < LOG; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        bit = new Fenwick(n);
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = mask(chars[u]) ^ mask(c);

                if (delta != 0) {
                    bit.rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int w = lca(u, v);

                int pu = basePrefix[u] ^ bit.pointQuery(tin[u]);
                int pv = basePrefix[v] ^ bit.pointQuery(tin[v]);

                int pathMask = pu ^ pv ^ mask(chars[w]);

                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    private int mask(char c) {
        return 1 << (c - 'a');
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) != 0) u = up[k][u];
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index + 1; i <= n; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int prefixXor(int index) {
            int result = 0;
            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }
            return result;
        }

        void rangeXor(int left, int right, int value) {
            update(left, value);
            if (right + 1 < n) update(right + 1, value);
        }

        int pointQuery(int index) {
            return prefixXor(index);
        }
    }
}
