Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
  
  import java.math.*;
class Solution {
    public String addStrings(String num1, String num2) {
        return String.valueOf((new BigInteger(num1)).add(new BigInteger(num2)));
    }
}
