package leetCode2021_12;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 这里选择map的原因也只不过是为了统计每个元素是否被访问了
 * 还有一种方法就是对数组排序之后，创建一个Boolean visit数组
 * 来记录该元素是否被访问过了，不一定只是通过计数来记忆
 */
public class k846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;

        Arrays.sort(hand);
        Queue<Integer> queue = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int preIndex = 0;
        for (int i = 0; i < hand.length;){
            queue.add(hand[i]);
            int curNum = hand[i];
            while (i < hand.length && hand[i] == curNum)
                i++;
            map.put(curNum, i - preIndex);
            preIndex = i;
        }


        while (!queue.isEmpty()){
            int firstNum = queue.poll();
            int firstCount = map.get(firstNum);
            if(firstCount == 0)
                continue;
            for (int j = 1; j <= groupSize - 1; j++){
                //如果不包含这个数字
                if(!map.containsKey(firstNum + j))
                    return false;
                int nextNumCount = map.get(firstNum + j);
                if(nextNumCount < firstCount || nextNumCount == 0)
                    return false;
                map.put(firstNum + j, nextNumCount - firstCount);
            }
        }

        return true;
    }
}
