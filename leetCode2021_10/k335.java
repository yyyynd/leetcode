package leetCode2021_10;

/**
 * 如果要撞上有两种情况，一种是在之前围起来的内部绕圈最终撞上
 * 另外一种就是头先走出了之前的范围
 */
public class k335 {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if(n <= 3)
            return false;
        for (int i = 3; i < n; i++){
            //判断第一种情况
            if(distance[i] >= distance[i-2] &&
                    distance[i-1] <= distance[i-3])
                return true;
            //接下来是判断第二种情况
            if(i >= 4 && distance[i] >= distance[i-2] - distance[i-4] &&
                    distance[i-1] == distance[i-3])
                return true;
            if(i >= 5 && distance[i] >= distance[i-2] - distance[i-4] &&
                    distance[i-1] <= distance[i-3] &&
                    distance[i-1] >= distance[i-3] - distance[i-5])
                return true;
        }

        return false;
    }
}
