Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
  
  
  

StringBuilder ans= new StringBuilder();
        while(n>0)
        {
            --n;
            int d= n%26;
            n/=26;
            ans.append((char)('A'+d));            
        }
        ans.reverse();
        return ans.toString(); 
