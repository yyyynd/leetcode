package leetcode.leetCode2022_09;

import java.util.Arrays;

/**
 * 为什么这样的计算可以正确计算出最终结果？
 * 这里maxCount计算的是能够一次填充所有桶的任务的种类数量，如果我们没有把每个桶的冷却时间都填满，那么(maxTimes - 1) *(n + 1) + maxCount
 * 就是完整时间，因为除了最后一个桶其它桶都必须等待一个完整的冷却时间，剩余种类的任务必不可能加入最后一个桶，
 *
 * 但理论上是完成有可能剩余的任务种类数量 ，可以填满这些冷却时间，因此有了Math.max(res, tasks.length)这一步的判断，这个时候
 */
public class k621 {
    public static void main(String[] args) {
        new k621().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2);
    }
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for(int i = 0; i < tasks.length; i++){
            buckets[tasks[i] - 'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(buckets[i] == buckets[i - 1])
                maxCount++;
            else
                break;
        }
        int res = (maxTimes - 1) *(n + 1) + maxCount;
        //判断如果完全不存在冷却时
        return Math.max(res, tasks.length);
    }
}
