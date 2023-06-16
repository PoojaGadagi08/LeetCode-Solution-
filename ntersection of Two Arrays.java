Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
  
  
  class Solution {
    public int[] intersection(int[] n1, int[] n2) {
        Set<Integer> s1=new HashSet<>();
        for(int i:n1)
        s1.add(i);

        Set<Integer> s2=new HashSet<>();
        for(int i:n2)
        s2.add(i);

        Set<Integer> s=new HashSet<>();
        for(Integer v: s1){
            if(s2.contains(v))
            s.add(v);
        }

        int ans[]=new int[s.size()];
        int j=0;
        for(Integer val:s){
            ans[j]=val.intValue();
            j++;
        }
        return ans;
    }
}
