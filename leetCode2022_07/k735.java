package leetcode.leetCode2022_07;

import java.util.LinkedList;

public class k735 {
    public int[] asteroidCollision(int[] asteroids) {
        int cur = 0;
        for (int i = 1; i < asteroids.length; i++){
            if (asteroids[cur] > 0 && asteroids[i] < 0){
                while (cur >= 0 && asteroids[cur] > 0 && asteroids[cur] < Math.abs(asteroids[i]))
                    cur--;
                //判断是还有剩余数字且该值是否为正数
                if (cur != - 1 && asteroids[cur] > 0){
                    //如果是因为相等结束了，不添加新的同时cur退一个
                    if (asteroids[cur] == Math.abs(asteroids[i])) {
                        cur--;
                        //如果退一个退到-1了,新添加一个
                        if (cur == -1 && i + 1 < asteroids.length) {
                            cur = 0;
                            asteroids[cur] = asteroids[i + 1];
                            i++;
                        }
                    }
                    continue;
                }
            }//if
            //如果未发生碰撞，或者新加入的负数遇到负数停止了, 或者新加入的负数把左侧全部消除完了
            cur++;
            asteroids[cur] = asteroids[i];
        }//for

        int[] ans = new int[cur + 1];
        for (int i = 0; i < ans.length; i++){
            ans[i] = asteroids[i];
        }

        return ans;
    }
}
