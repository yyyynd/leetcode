package leetcode.leetCode2022_08;

/**
 * 这个写法耗时是2ms，但网上有一个1ms的方法
 * 那个方法的核心思想就是，剩余汽油的变化趋势是不会改变的，即假设你改变起始点
 * 使得你在不同站点剩余油量的数量发生改变，但这个油量的增减趋势是不会产生改变的
 * 因此只要保证all gas - all cost >= 0，那么这个升降趋势中的最低点的后一位必是一个
 * 符合条件的起始点
 */
public class k134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++)
            gas[i] -= cost[i];

        for (int i = 0; i < len; i++){
            if (gas[i] < 0)
                continue;
            int curGas = 0;
            int j = 0;
            while (j < len){
                curGas += gas[(i + j) % len];
                if (curGas < 0)
                    break;
                j++;
            }
            if (j == len)
                return i;
            i += j;
        }

        return -1;
    }
}
