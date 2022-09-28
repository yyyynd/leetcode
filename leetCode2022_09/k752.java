package leetcode.leetCode2022_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class k752 {
    public static void main(String[] args) {
        System.out.println(new k752().openLock(new String[]{"1111"}, "0000"));
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> memo = new HashSet<>();
        HashSet<String> queue1 = new HashSet<>();
        HashSet<String> queue2 = new HashSet<>();
        int step = 0;
        Collections.addAll(memo, deadends);
        queue1.add("0000");
        queue2.add(target);

        if (target.equals("0000"))
            return 0;
        if (memo.contains("0000"))
            return -1;

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            HashSet<String> queue;
            HashSet<String> comp;
            HashSet<String> tmp = new HashSet<>();
            queue = queue1.size() >= queue2.size() ? queue1 : queue2;
            comp = queue1.size() >= queue2.size() ? queue2 : queue1;
            step++;
            for (String s : queue){
                List<String> list = get(s);
                for (String l : list){
                    if (comp.contains(l))
                        return step;
                    if (!memo.contains(l)) {
                        memo.add(l);
                        tmp.add(l);
                    }
                }
            }
            if (queue1.size() >= queue2.size()) {
                queue1.clear();
                queue1 = tmp;
            }else{
                queue2.clear();
                queue2 = tmp;
            }
        }

        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }
}
