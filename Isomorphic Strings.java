Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.



  // class Solution {
//     public boolean isIsomorphic(String s, String t) {


//         if(s.length()!=t.length()) return false;


//         char[] s1=s.toCharArray();
//         HashMap<Character,Integer> h1=new HashMap<>();
//         for(char x:s1){
//                 if(!h1.containsKey(x)){
//                         h1.put(x,1);
//                 }else{
//                         h1.put(x,h1.get(x)+1);
//                 }
//         }

        
//         char[] s2=t.toCharArray();
//         HashMap<Character,Integer> h2=new HashMap<>();
//         for(char y:s2){
//                 if(!h2.containsKey(y)){
//                         h2.put(y,1);
//                 }else{
//                         h2.put(y,h2.get(y)+1);
//                 }
//         }

//         for(int i=0;i<s.length();i++){
//             if(h1.get(i)!=h2.get(i))
//             return false;
//         }
//         return true;

//     }
// }



class Solution {
    public boolean isIsomorphic(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}
