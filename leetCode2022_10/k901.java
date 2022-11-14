package leetcode.leetCode2022_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class k901 {
    ArrayList<int[]> list;
    public k901() {
        this.list = new ArrayList<>();
    }

    public int next(int price) {
        if (list.size() == 0){
            list.add(new int[]{price, 1});
            return 1;
        }
        int index = list.size() - 1;
        int[] comp;
        int count = 1;
        while (index >= 0){
            comp = list.get(index);
            if (comp[0] > price)
                break;
            count += comp[1];
            index -= comp[0];
        }

        list.add(new int[]{price, count});
        return count;
    }
}
