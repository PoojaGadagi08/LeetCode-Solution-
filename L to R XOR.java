public class Solution {
    public static int xor(int n){
        int ans=0;
        if(n%4==0)
        ans=n;
        if(n%4==1)
        ans=1;
        if(n%4==2)
        ans=n+1;
        if(n%4==3)
        ans=0;

        return ans;
    }
    public static int findXOR(int L, int R){
        // Write your code here.
        return xor(R) ^ xor(L-1);
    }
}
