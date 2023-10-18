// public class Solution {
//     public static int[] twoOddNum(int []arr){
//         // // Write your code here.
//         // int ans[]=new int[2];
//         // int xor=0;
//         // for(int i=0;i<arr.length;i++)
//         // xor=xor^arr[i];

//         // int cnt=0;
//         // while(xor!=0){
//         //     if((xor & 1)==1) break;
//         //     cnt++;
//         //     xor=xor>>1;
//         // }

//         // int xor1=0;
//         // int xor2=0;
//         // for(int i=0;i<arr.length;i++){
//         //     if( (arr[i] & (1<<cnt)==1))
//         //     xor1=xor1 ^ arr[i];
//         //     else 
//         //     xor2=xor2 ^ arr[i];
//         // }
//         // ans[0]=xor1;
//         // ans[1]=xor2;

//         // return ans;

//           int ans[] = new int[2];
//         int xor = 0;
//         for (int i = 0; i < arr.length; i++) {
//             xor ^= arr[i];
//         }

//         int cnt = 0;
//         while ((xor & 1) != 1) {
//             cnt++;
//             xor = xor >> 1;
//         }

//         int xor1 = 0;
//         int xor2 = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if ((arr[i] & (1 << cnt)) == 0) {
//                 xor1 ^= arr[i];
//             } else {
//                 xor2 ^= arr[i];
//             }
//         }
//         ans[0] = xor1;
//         ans[1] = xor2;

//         return ans;
//     }
// }





public class Solution {

    public static int[] twoOddNum(int []arr){

        int n = arr.length;

        int num = 0;

        // step 1

        for (int i = 0; i < arr.length; i++) {

            num^=arr[i];

        }

 

        // step 2

        int rmbm = num & (-num); //rmbm -> right most bit mask

 

        // step 3 and 4

        int x = 0, y=0;

        for (int i : arr) {

            if((i&rmbm)==0){

                x^=i;

            }else{

                y^=i;

            }

        }

        // Question asks for array in decreasing order;

        return new int[]{Math.max(x, y),Math.min(x, y)};

    }

}

