package leetcode.leetCode2022_08;

import leetCode2021_10.k38;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class k386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            ans.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n)
                    j /= 10;
                j++;
            }
        }
        return ans;

    }


}
