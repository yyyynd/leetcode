package leetCode2021_05_09;

import java.util.*;

/**
 * 如果是字母排列组合，基本就是要DFS走一遍
 * 这里的思路就是每次递归的时候固定前面位置上的字符，来达到组合的目的
 *
 * k95建二叉树也是个dfs问题，只不过那里要考虑二叉树的性质
 */
public class o_k38 {
    char[] c;
    List<String> arr = new LinkedList<>();
    public String[] permutation(String s) {
        this.c = s.toCharArray();
        dfs(0);
        return arr.toArray(new String[arr.size()]);
    }

    public void dfs(int index){
        //用于排除当前位置产生重复元素
        HashSet<Character> set = new HashSet<>();
        //遍历到最后的节点了,直接加入
        if(index == c.length-1) {
            arr.add(String.valueOf(c));
            return;
        }

        for(int x = index; x < c.length; x++){
            if(set.contains(c[x]))
                continue;
            set.add(c[x]);
            swap(index,x);
            dfs(index+1);
            swap(index,x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
