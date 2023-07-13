Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]




// class Solution {
//     public void rotate(int[] nums, int k) {
//         int t[]=new int[k];
//         int n=nums.length;

//         for(int i=k;i<0;i--){
//             t[i]=nums[n-k];

//         }

//         int t1[]=new int[n-k];
//         for(int i=0;i<t1.length;i++){
//             t1[i]=nums[i];
//         }

//         // int l=t.length+t1.length;

//         // int t2[]=new int[l];
//         // for(int i=0;i<)

//         for(int i=0;i<t.length;i++){
//             nums[i]=t[i];
//         }
//         for(int i=n-k-1;i<n;i++){
//             nums[i]=t1[i];
//         }
    
//     }
// }

class Solution {
    public void rotate(int[] nums, int k) {
       k %= nums.length;
       reverse(nums, 0, nums.length - 1); // Reverse the entire array
       reverse(nums, 0, k - 1); // Reverse the first k elements
       reverse(nums, k, nums.length - 1); // Reverse the rest of the elements
    }
    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
