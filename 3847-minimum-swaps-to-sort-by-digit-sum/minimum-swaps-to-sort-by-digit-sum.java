import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int m = nums[i];
            int sum = 0;

            while (m != 0) {
                sum += m % 10;
                m /= 10;
            }

            arr[i][0] = sum;
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i][1];
        }

        Map<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.put(nums[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || sorted[i] == nums[i]) {
                continue;
            }

            int j = i;
            int cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = pos.get(sorted[j]);
                cycle++;
            }

            if (cycle > 1) {
                swaps += cycle - 1;
            }
        }

        return swaps;
    }
}