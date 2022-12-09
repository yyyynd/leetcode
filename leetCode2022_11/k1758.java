package leetcode.leetCode2022_11;

public class k1758 {
    public int minOperations(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < len; i++){
            if (str[i] % 2 == i % 2)
                count1 += 1;
            else
                count2 += 1;
        }

        return Math.min(count1, count2);
    }
}
