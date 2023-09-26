Given a string s, return the 
lexicographically smallest
 
subsequence
 of s that contains all the distinct characters of s exactly once.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.










  class Solution {
    public String smallestSubsequence(String s) {
         int[] last = new int[26];
        boolean[] vis = new boolean[26];
        StringBuilder ans = new StringBuilder();
        
        int n = s.length();
        Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            if (vis[s.charAt(i) - 'a']) continue;
            
            while (ans.length() > 0 && ans.charAt(ans.length() - 1) > s.charAt(i) && last[ans.charAt(ans.length() - 1) - 'a'] > i) {
                vis[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }
            
            ans.append(s.charAt(i));
            vis[s.charAt(i) - 'a'] = true;
        }
        
        return ans.toString();
    }
}
