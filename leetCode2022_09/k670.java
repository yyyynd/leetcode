package leetcode.leetCode2022_09;

import java.util.ArrayList;
import java.util.List;

public class k670 {
    public static void main(String[] args) {
        System.out.println(new k670().maximumSwap(98368));
    }
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10); num /= 10;
        }
        int n = list.size(), ans = 0;
        int[] idx = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            if (list.get(i) > list.get(j))
                j = i;
            idx[i] = j;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(idx[i]) != list.get(i)) {
                int c = list.get(idx[i]);
                list.set(idx[i], list.get(i));
                list.set(i, c);
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--)
            ans = ans * 10 + list.get(i);
        return ans;
    }
}
