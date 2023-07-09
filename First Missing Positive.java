Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.




  class Solution {
    public int firstMissingPositive(int[] A) {
        int n=A.length;
        //  boolean vis[]=new boolean[n+1];
        // for(int i=0;i<n;i++){
        
        //     if(arr[i]>0 && arr[i]<=n)
        //     vis[arr[i]]=true;
        // }
        
        // for(int i=1;i<=n;i++){
        //     if(!vis[i])
        //     return i;
        // }
        // return n+1;
          for(int i = 0; i < n; ++ i) {
            while(A[i] >= 1 && A[i] <= n && A[i] != A[A[i]-1])
                // swap(A[i], A[A[i] - 1]);
                {
                    int t = A[A[i] - 1]; A[A[i] - 1] = A[i];  A[i]=t;
                }
        }
        
        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;
        
        return n + 1;
      
    }
}
