Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.



  // class Solution {
//     public int longestPalindrome(String s) {
//         if(s==null || s.length()==0) return 0;
//         HashSet<Character> hs = new HashSet<Character>();
//         int count = 0;
//         for(int i=0; i<s.length(); i++){
//             if(hs.contains(s.charAt(i))){
//                 hs.remove(s.charAt(i));
//                 count++;
//             }else{
//                 hs.add(s.charAt(i));
//             }
//         }
//         if(!hs.isEmpty()) return count*2+1;
//         return count*2;
// }

// }




class Solution {
    public int longestPalindrome(String s) {
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) % 2 == 1)
                oddCount++;
            else
                oddCount--;
        }
        if (oddCount > 1)
            return s.length() - oddCount + 1;
        return s.length();
    }
}
