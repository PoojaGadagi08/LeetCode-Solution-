Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character


  // class Solution {
//     public void reverseString(char[] s) {
//         Arrays.sort(s);
//     }
// }







// class Solution {
//     public void reverseString(char[] s) {
//         int i = 0;
//         int j = s.length - 1;
//         solve(s, i, j);
//     }
//     public void solve(char[] s, int i, int j){
//         if(i >= j) return;
//         char temp = s[i];
//         s[i] = s[j];
//         s[j] = temp;
//         solve(s, ++i, --j);
//     }
// }






class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        // String str = new String(s);
        for(int i = 0; i < s.length; i++){
            st.push(s[i]);
        }
        // char ans[] = new char[s.length];
        int i = 0;
        while(st.size() > 0){
            s[i++] = st.pop();
        }
        // for(int j = 0; j < str.length(); j++){
        //     ans[j] = str.charAt(j);
        // }
    }
}
