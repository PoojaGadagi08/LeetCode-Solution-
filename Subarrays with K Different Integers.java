Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length




  class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}





// class Solution {
//     public int fun(int []A, int K){
       
//         if (K == 0)
//             return 0;
        
//         int n = A.length;
//         int total = 0;
//         int diff = 0;
//         int j = 0;
//         int[] cnt = new int[20002];
        
//         for (int i = 0; i < n; i++) {
//             if (cnt[A[i]] == 0) {
//                 diff++;
//                 cnt[A[i]]++;
//             } else {
//                 cnt[A[i]]++;
//             }
            
//             if (diff <= K) {
//                 total += (i - j + 1);
//             } else {
//                 while (j < n && j <= i && diff > K) {
//                     cnt[A[j]]--;
//                     if (cnt[A[j]] == 0)
//                         diff--;
//                     j++;
//                 }
//                 total += (i - j + 1);
//             }
//         }
//         return total;
//     }

    
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         return fun(nums, k);
//     }
// }
