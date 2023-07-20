Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1



  class Solution {
    public void moveZeroes(int[] a) {
        int n=a.length;
        ArrayList<Integer> temp = new ArrayList<>();
        //copy non-zero elements
        //from original -> temp array:
        for (int i = 0; i < n; i++) {
            if (a[i] != 0)
                temp.add(a[i]);
        }

        // number of non-zero elements.
        int nz = temp.size();

        //copy elements from temp
        //fill first nz fields of
        //original array:
        for (int i = 0; i < nz; i++) {
            a[i] = temp.get(i);
        }

        //fill rest of the cells with 0:
        for (int i = nz; i < n; i++) {
            a[i] = 0;
        }
       // return a;
    }

    // public static void main(String[] args) {
    //     int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
    //     int n = 10;
    //     int[] ans = moveZeros(n, arr);
    //     for (int i = 0; i < n; i++) {
    //         System.out.print(ans[i] + " ");
    //     }
    //     System.out.println("");
    // }
}

















//Optimal Solution
// Swaping 
