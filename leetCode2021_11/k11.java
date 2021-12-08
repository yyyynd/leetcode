package leetCode2021_11;

import javax.swing.text.MaskFormatter;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 如果之前取过该边长，肯定不可能获得更大的结果
 * 同理，如果当前边没有之前最大边大也不可能取到更大的结果
 */
public class k11 {

    public int maxArea(int[] height) {
//        int ans = 0;
//        int leftMaxLen = 0;
//        int rightMaxLen = 0;
//
//        for(int i = 0; i < height.length-1; i++){
//            if( leftMaxLen > height[i])
//                continue;
//            int tmp = 0;
//            for (int j = i+1; j < height.length; j++)
//                tmp = Math.max(tmp, Math.min(height[i], height[j]) * (j - i));
//            ans = Math.max(ans, tmp);
//            leftMaxLen = height[i];
//        }
//
//        return ans;

        int ans = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right){
            ans = Math.max(Math.min(height[left], height[right]) * (right - left), ans);
            if(height[left] >= height[right])
                right--;
            else
                left++;
        }
        synchronized(this) {

        }
        return ans;
    }
}
