package leetcode.leetCode2022_03;


/**
 * 其实就是需要一个记录每个种类数量，和一个记录种类个数两个
 * 纠结的点是如果每次记录当前窗口中出现最多的字符数量（更新）
 * 其实每次滑动都会加一个新的字母，既然只可能更新这一个字母那就每次滑动
 * 取该字母的数量来更新，同时记录数量最高频率
 */
public class k424 {

    public int characterReplacement(String s, int k) {
        int[] memo = new int[26];
        char[] str = s.toCharArray();
        int left = 0;
        int right = -1;
        int maxNum = 0;

        for (int i = 0; i < s.length(); i++){
            int index = str[i] - 'A';
            memo[index]++;
            maxNum = Math.max(maxNum, memo[index]);
            /**
             *      这个更新最大出现数量的方式很容易想到如果之后再无出现比历史记录大的数量，那么这个是如何正确得出结果的
             * 其实从我们扩大窗口的判断就可以看出，只有满足剩余字母数量小于k才会扩大窗口，也就意味着只有存在比这个
             * 历史记录值更大的数出现时，我们才有机会扩大窗口，而之前的旧记录并不会影响我们滑动窗口
             *      所以我们只需要简单的把每次新加频率的字母数量比较一下即可，能出现更大的才代表能够扩大窗口
             *
             */
            if(right - left + 2 - maxNum <= k )
                right++;
            else {
                memo[str[left] - 'A']--;
                left++;
                right++;
            }
        }

        return right - left + 1;
    }
}
