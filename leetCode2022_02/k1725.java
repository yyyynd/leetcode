package leetcode.leetCode2022_02;

public class k1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int ans = 0;

        for (int[] rectangle : rectangles){
            int edgeLen = Math.min(rectangle[0], rectangle[1]);
            if(edgeLen > maxLen) {
                ans = 1;
                maxLen = edgeLen;
            }else if(edgeLen == maxLen)
                ans++;
        }

        return ans;
    }
}
