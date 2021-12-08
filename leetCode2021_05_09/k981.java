package leetCode2021_05_09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 要注意不同的写法会产生二分查找的结果实质上会有区别（元素不存在时
 *
 * 这里第一种写法
 * while (l < r){
 *      int mid = l + (r-l)/2;
 *      if(test[mid] >= t)
 *         r = mid;
 *     else
 *         l = mid + 1;
 * }
 * 第一种写法如果该元素不存在，找出的位置其实是第一个大于查询元素的元素的位置
 * 也就是得出的下标其实是第一个大于该元素的下标（当然，如果查找元素比全部元素都大
 * 实际上这个下标应该是数组边界+1）
 *
 * 第二种写法
 * while (l < r) {
 *    int mid = (l+r+1)/2;
 *    if(list.get(mid).t <= t)
 *        l = mid;
 *    else
 *        r = mid - 1;
 *}
 * 第二种写法如果元素不存在，找出的位置其实第一个小于查询元素的元素的位置
 * 也就是说，得出的下标其实是第一个小于查询元素的下标（如果查询元素就是最小的，位置
 * 得出的下标应该就是队头的0）
 *
 * 为什么会第一种写法得出这种结果，就是因为我们固定如果  n[mid] >= target时我们是更新r = mid。
 * 同时l的更新是l = mid+1，也就意味着其实 r 实际上就代表了最终的结果了（最后肯定是l慢慢迫近r结束循环），
 * 即得出的下标所代表的元素肯定是大于等于查询值的
 *
 * 而在第二种写法，因为改为了 n[mid] <= target 时更新 l = mid，而 r = mid-1的更新，
 * 这也就说实际上 l 代表了最终结果了，即得出的下标所代表的元素肯定是小于等于目标元素的
 *
 * 第二种写法在取mid点的时候有一个+1的动作，为什么第一种没有呢？
 * 首先分析第一种的情况，r肯定是代表最终结果了，最后只需要l迫近r就行了，那么这时的情况
 * r = result, l < result, mid进行计算肯定得出是 （r+l)/2 < result，而根据判断n[mid]必小于target
 * 也就会执行l = mid+1的修正，不断计算得出结果
 *
 * 但在第二种的时候就有问题了，因为这里l = result ,r > result了，那么这时肯定希望让r = mid-1来迫近 result
 * 我们就希望 n[mid] > target，但考虑一种情况，如果 l = i, r = i+1，那么根据公式mid = (l+r)/2，我们会发现
 * mid = i,根本不可能执行 r = mid-1，这就是因为整数除法导致的误差，
 *
 * 所以这里执行一个+1动作，而且这并不会影响结果（因为得出的mid肯定是在范围内的+1也不会影响），只是对于最后一次的计算
 * 进行补偿，使mid能等于 result+1
 *
 * 回到本题，因为找的其实是第一个时间戳小于等于查询时间戳的元素，那么明显第二种方法更为合适
 * 可以直接得出结果，仅仅需要判断一下队头情况（下标0）
 *
 */

public class k981 {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,4,5,6,8,12};
        int l = 0 , r = test.length-1;
        int t = 3;
        //发现这样得出的结果，如果输入值小于最大值，得出的会是它第一个比它大的数的结果
        //这样直接改成 if <= ; l = mid; else r = mid - 1 不行。。。
        while (l < r){
            int mid = l + (r-l)/2;
            if(test[mid] >= t)
                r = mid;
            else
                l = mid + 1;
//            int mid = l + r +1 >>1;
//            if(test[mid] <= t)
//                l = mid;
//            else
//                r = mid - 1;
        }
        System.out.println(r);
    }

    class TimeMap {
        class Node {
            String k, v;
            int t;
            Node (String _k, String _v, int _t) {
                k = _k; v = _v; t = _t;
            }
        }

        Map<String, List<Node>> map = new HashMap<>();
        public void set(String k, String v, int t) {
            List<Node> list = map.getOrDefault(k, new ArrayList<>());
            list.add(new Node(k, v, t));
            map.put(k, list);
        }

        public String get(String k, int t) {
            List<Node> list = map.getOrDefault(k, new ArrayList<>());
            if (list.isEmpty()) return "";
            int n = list.size()-1;
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r +1 >>1;
                if(list.get(mid).t <= t)
                    l = mid;
                else
                    r = mid - 1;
            }

            return list.get(l).t <= t ? list.get(l).v : "";
        }
    }
}
