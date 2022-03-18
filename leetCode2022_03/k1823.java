package leetcode.leetCode2022_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class k1823 {
    public static void main(String[] args) {
        System.out.println(new k1823().findTheWinner(5,3));
    }
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int startIndex = 0;

        if( k == 1)
            return n;

        for (int i = 1; i <= n; i++)
            list.add(i);
        k -= 1;
        while (list.size() > 1){
            startIndex  = (startIndex + k) % list.size();
            list.remove(startIndex);
            if (startIndex == list.size())
                startIndex = 0;
        }
        return list.poll();
    }

}
