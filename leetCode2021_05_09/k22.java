package leetCode2021_05_09;

import java.util.LinkedList;
import java.util.List;

/**
 * 这种固定元素（这里左右括号就是元素）排序的题，一般都是递归深度遍历得出所有结果
 * 优化的点就看情况，一般都是可以剪枝（去除重复or无用选项）
 *
 * 这里隐藏的限制条件就是一定是先放左括号才行，否则无法形成闭合
 */
public class k22 {
    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new LinkedList<>();
        DFS(n,n,"");
        return list;
    }

    public void DFS(int left, int right, String curString){
        if(left > right)
            return;
        if(left == 0 && right == 0){
            list.add(curString);
            return;
        }

        if(left > 0)
            DFS(left-1,right, curString + "(");
        if(right > 0)
            DFS(left,right-1,curString+")");
    }

}
