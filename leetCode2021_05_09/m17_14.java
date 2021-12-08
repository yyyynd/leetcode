package leetCode2021_05_09;

import java.util.Arrays;

public class m17_14 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new m17_14().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = arr[i];
        return ans;

//        int[] ans = new int[k];
//        if(k == 0)
//            return ans;
//        System.arraycopy(arr, 0, ans, 0, k);
//
//        Arrays.sort(ans);
//        int[] tmp = new int[k];
//        for (int i = k; i < arr.length; i++){
//            if(arr[i] < ans[k-1]){
//                int l = 0;
//                int r = k-1;
//                while (l < r){
//                    int mid = l + (r - l)/2;
//                    if(ans[mid] >= arr[i])
//                        r = mid;
//                    else
//                        l = mid+1;
//                }
//                System.arraycopy(ans,0,tmp,0,k);
//                System.arraycopy(tmp, l, ans, l+1, k-l-1);
//                ans[l] = arr[i];
//            }
//        }//for
//
//        return ans;
    }
}
