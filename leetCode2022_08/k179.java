package leetcode.leetCode2022_08;

import java.util.Arrays;
import java.util.Comparator;

public class k179 {

    public String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strNums[i] = String.valueOf(nums[i]);

        sort(strNums,0 , nums.length - 1);
        if (strNums[0].charAt(0) == '0')
            return "0";
        for (String n : strNums)
            ans.append(n);
        return ans.toString();

    }

    public void sort(String[] nums, int left, int right){
        if (left >= right)
            return;

        String mid = nums[right];
        int i = left;
        int j = right;
        boolean flag = true;// true i++, false j--

        while (i < j){
            if (flag){
                if (compare(nums[i], mid)){
                    flag = false;
                    nums[j] = nums[i];
                    j--;
                }else
                    i++;
            }else {
                if (compare(mid, nums[j])){
                    flag = true;
                    nums[i] = nums[j];
                    i++;
                }else
                    j--;
            }
        }
        nums[i] = mid;
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }

    public boolean compare(String n1, String n2){
        String s1 = n1 + n2;
        String s2 = n2 + n1;
        for (int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 - c2 < 0)
                return false;
            else if (c1 - c2 > 0)
                return true;
        }

        return false;
    }
}
