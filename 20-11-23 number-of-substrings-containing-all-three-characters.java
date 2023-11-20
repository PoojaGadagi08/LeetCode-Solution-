Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.




  
// class Solution {
//     public boolean containsAll(String s) {
//         HashMap<Character, Integer> h = new HashMap<>();
//         for (char ch : s.toCharArray()) {
//             h.put(ch, h.getOrDefault(ch, 0) + 1);
//         }

//         return h.containsKey('a') && h.containsKey('b') && h.containsKey('c');
//     }

//     public int numberOfSubstrings(String s) {
//         int cnt = 0;
//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i + 1; j <= s.length(); j++) {
//                 String subStr = s.substring(i, j);
//                 if (containsAll(subStr))
//                     cnt++;
//             }
//         }
//         return cnt;
//     }
// }





class Solution {
   public int numberOfSubstrings(String s) {
         int n = s.length();

        int i = 0, j = 0, count = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);

            while (mp.getOrDefault('a', 0) >= 1 && mp.getOrDefault('b', 0) >= 1 && mp.getOrDefault('c', 0) >= 1) {
                count += (n - j);

                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) {
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }

        return count;
    }
}





// import java.util.*;

// public class Solution {

//     public static int countSubstring(String s){

//         Map<Character,Integer> map = new HashMap<>();

//         int left=0;

//         int count=0;

//         int n=s.length();

//         for(int right=0;right<s.length();right++)

//         {

//             map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+1);

 

//             while(map.size()>2)

//             {

//                 map.put(s.charAt(left),map.get(s.charAt(left))-1);

//                 if(map.get(s.charAt(left))==0)

//                 {

//                     map.remove(s.charAt(left));

//                 }

//                 left++;

//             }

//             count=count+(right-left+1);

//         }

 

//         int totalsubarrays = (n*(n+1))/2;

//         int ressubarray = totalsubarrays-count;

//         return ressubarray;

//     }

// }

