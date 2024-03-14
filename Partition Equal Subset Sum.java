Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100



  class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (totSum % 2 == 1)
            return false;
        else {
            // Calculate the target sum for each subset
            int k = totSum / 2;
            // Create two arrays to store the DP results for the previous and current rows
            boolean prev[] = new boolean[k + 1];

            // Initialize the first row of the DP table
            prev[0] = true;

            // Initialize the first column of the DP table
            if (arr[0] <= k) {
                prev[arr[0]] = true;
            }

            // Fill in the DP table using bottom-up dynamic programming
            for (int ind = 1; ind < n; ind++) {
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    // Calculate if the current element is not taken
                    boolean notTaken = prev[target];

                    // Calculate if the current element is taken
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = prev[target - arr[ind]];
                    }

                    // Update the DP table for the current element and target sum
                    cur[target] = notTaken || taken;
                }
                // Update the previous row with the current row for the next iteration
                prev = cur;
            }

            // The result is stored in the last cell of the DP table
            return prev[k];
        }
    }
}
