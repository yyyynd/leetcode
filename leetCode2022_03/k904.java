package leetcode.leetCode2022_03;

import java.util.HashSet;

/**
 * 如果新加入的节点属于已经两种当前种类right++
 * 如果为新的种类，应该以当前right的种类，倒叙遍历找到下标值最大的right位置水果同类
 *
 */
public class k904 {
    public static void main(String[] args) {
        System.out.println(new k904().totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
    }
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 1;
        int ans = 0;
        int k1 = -1;
        int k2 = -1;

        k1 = fruits[0];
        while (right < fruits.length && k2 != -1) {
            if (fruits[right] != k1)
                k2 = fruits[right];
            right++;
        }

        while ( right < fruits.length ){
            int curFruit = fruits[right];
            if ( k1 != curFruit && k2 != curFruit ){
                ans = Math.max(right - left, ans);//这里因为right为新加入的点了，所以长度计算不想计入所以right - left 未+1
                int tmp = right - 2;
                while (tmp >= left){
                    if( fruits[tmp] != fruits[right - 1]) {
                        left = tmp-- + 1;
                        break;
                    }
                }//while
                if(k1 == fruits[right - 1])
                    k2 = curFruit;
                else
                    k1 = curFruit;
            }//if
            right++;
        }//while

        ans = Math.max( ans, right - left);
        return ans;
    }
}
