package leetcode.leetCode2022_04;


import java.util.*;

/**
 * 堆排序常用于于大数据取前k个数
 */
public class k347 {
    public static void main(String[] args) {
        new k347().topKFrequent(new int[]{5,2,5,3,5,3,1,1,3},2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);

        int c = 0;
        for (Map.Entry<Integer, Integer> i : count.entrySet()){
            if (c != k) {
                queue.add(i);
                c++;
            }else{
                if (queue.peek().getValue() < i.getValue()){
                    queue.poll();
                    queue.add(i);
                }
            }
        }

        int[] res = new int[k];

        c = 0;
        for (Map.Entry<Integer, Integer> n : queue)
            res[c++] = n.getKey();

        return res;
    }
}
