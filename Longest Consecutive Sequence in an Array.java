Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

  class Solution {
    public int longestConsecutive(int[] a) {
         int n=a.length;
        Arrays.sort(a);
        int cnt=0;
        int lastsmall=Integer.MIN_VALUE;
        int longest=0;

        for(int i=0;i<n;i++){
            if(a[i]-1==lastsmall){
                cnt=cnt+1;
                lastsmall=a[i];
            }
            else if(a[i]==lastsmall){}
            else if(a[i]!=lastsmall){
                cnt=1;
                lastsmall=a[i];
            }

            longest=Math.max(longest,cnt);
        }

        return longest;
    }
}

















/*

import java.util.*;

public class tUf {
    public static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
*/
