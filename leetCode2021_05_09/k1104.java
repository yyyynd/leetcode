package leetCode2021_05_09;

import java.util.LinkedList;
import java.util.List;

public class k1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int count = 1;
        LinkedList<Integer> ans = new LinkedList<>();

        if(label == 1){
            ans.add(1);
            return ans;
        }

        while (Math.pow(2,count)-1 < label)
            count++;

        ans.add(label);
        count--;
        while (count >= 2){
            int curLayer = (int) Math.pow(2,count) - 1;
            int preLayer = (int) Math.pow(2,count-1);
            label = curLayer+preLayer - label/2;
            ans.addFirst(label);
            count--;
        }

        ans.addFirst(1);
        return ans;
    }
}
