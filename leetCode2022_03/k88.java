package leetcode.leetCode2022_03;

public class k88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i_m = m - 1;
        int i_n = n - 1;
        int i = nums1.length - 1;
        while ( i_m >= 0 && i_n >= 0 ){
            if ( nums1[i_m] > nums2[i_n] ){
                nums1[i] = nums1[i_m];
                i_m--;
            }else {
                nums1[i] = nums2[i_n];
                i_n--;
            }
            i--;
        }

        int j;
        int[] surArr;
        if ( i_m >= 0 ){
            j = i_m;
            surArr = nums1;
        }else {
            j = i_n;
            surArr = nums2;
        }
        while ( j >= 0 ){
            nums1[i] = surArr[j];
            j--;
            i--;
        }
    }
}
