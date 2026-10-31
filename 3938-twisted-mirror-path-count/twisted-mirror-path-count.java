class Solution {
    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        long[][] right = new long[m][n];
        long[][] down = new long[m][n];

        // Start from (0,0), which is empty.
        if (n > 1) {
            right[0][1] = 1;
        }

        if (m > 1) {
            down[1][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if (grid[i][j] == 1) {

                    // Entered mirror while moving right.
                    // Reflection sends robot down.
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % MOD;
                    }

                    // Entered mirror while moving down.
                    // Reflection sends robot right.
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % MOD;
                    }

                } else {

                    // Empty cell: robot can move either right or down.
                    long ways = (right[i][j] + down[i][j]) % MOD;

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + ways) % MOD;
                    }

                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + ways) % MOD;
                    }
                }
            }
        }

        return (int) (
            (right[m - 1][n - 1] + down[m - 1][n - 1]) % MOD
        );
    }
}