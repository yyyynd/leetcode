package leetCode2022_01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 最优操作的意思就是，找到一个用户在当前回合必赢操作的
 * 所以本质就是在剩余石子的情况下找必胜选择
 */
public class k2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) cnts[i % 3]++;
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0) : !(Math.abs(cnts[1] - cnts[2]) <= 2);
    }

//    public static void main(String[] args) {
//        int[] n = new int[]{1,2,3,4};
//        System.out.println(Arrays.toString(n));
//    }
//    int len;
//    int[] select;
//    HashMap<String, Boolean> memo;
//    public boolean stoneGameIX(int[] stones) {
//        this.len = stones.length;
//        this.select = new int[len];
//        this.memo = new HashMap<>();
//        return dfs(0, 1, stones, 0);
//    }
//
//    /**
//     * @param sum   统计已选石子值总数
//     * @param flag  标记当前回合玩家 1 为Alice -1 为Bob
//     * @return  上一回合结果
//     */
//    public boolean dfs( int sum, int flag, int[] stones, int count){
//        if(memo.containsKey(Arrays.toString(select)))
//            return memo.get(Arrays.toString(select));
//
//        for (int i = 0; i < len; i++){
//            if(select[i] == 1)
//                continue;
//            count++;
//            //取当前手，查看是否触发条件
//            if((sum + stones[i]) % 3 == 0) {
//                count--;
//                continue;
//            }
//            else if(count == len)
//                return flag == -1;
//
//            select[i] = 1;
//            //如果dfs返false，证明下一回合的玩家必输，则当前的选择的是最佳选
//            //否则证明当前剩余石子的情况下，当前玩家不管选什么都是输
//            if(dfs(sum + stones[i], -flag, stones, count)){
//                select[i] = 0;
//                count--;
//            }else {
//                select[i] = 0;
//                memo.put(Arrays.toString(select), true);
//                return true;
//            }
//        }
//        memo.put(Arrays.toString(select), false);
//        return false;
//    }
}
