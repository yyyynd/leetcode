package leetCode2021_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.插入值比查找到的区间左端点小，且连续（这种情况还有可能将两个区间连接起来了
 * 2.插入值和查找到的区间左端点相同
 * 3.插入值在查找的区间范围内
 */
public class k352 {
    List<int[]> list;

    public k352() {
        list = new ArrayList<>();
    }

    public void addNum(int val) {
        int n = list.size();
        if (n == 0) {
            list.add(new int[]{val, val});
            return ;
        }

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid)[0] <= val)
                l = mid;
            else r = mid - 1;
        }

        int[] cur = list.get(r);
        if (cur[0] > val) {
            if (val + 1 == cur[0]) {
                cur[0] = val;
            } else {
                list.add(r, new int[]{val, val});
            }
            return ;
        }
        if (cur[0] <= val && val <= cur[1]) {
            // pass
        } else if (r == n - 1) {
            if (cur[1] + 1 == val) {
                cur[1] = val;
            } else {
                list.add(new int[]{val, val});
            }
        } else {
            int[] next = list.get(r + 1);
            if (cur[1] + 1 == val && val == next[0] - 1) {
                cur[1] = next[1];
                list.remove(r + 1);
            } else if (cur[1] + 1 == val) {
                cur[1] = val;
            } else if (next[0] - 1 == val) {
                next[0] = val;
            } else {
                list.add(r + 1, new int[]{val, val});
            }
        }
    }

    public int[][] getIntervals() {
        int n = list.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) ans[i] = list.get(i);
        return ans;
    }
}
