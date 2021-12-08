package leetCode2021_10;

import java.util.ArrayList;

/**
 * 这里节点的isEnd就是为了防止出现某个单词恰巧是另一个单词的前缀的情况
 * 因此如果存储单词的时候到该位置结束会用isEnd来标记这个前缀是一个存储过的单词
 */
public class k211 {
    class TreeNode{
        //利用判断是否为null来判断这个位置是否填有字符
        TreeNode[] child = new TreeNode[26];
        //判断到当前位置为止，是否为一个单词的结尾
        boolean isEnd;
    }
    //Trie根节点
    private TreeNode root = new TreeNode();

    public void addWord(String word) {
        TreeNode travel = root;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++){
            int offset = w[i] - 'a';
            //如果之前未存储过，就创建新节点进行存储
            if(travel.child[offset] == null)
                travel.child[offset] = new TreeNode();
            travel = travel.child[offset];
        }
        travel.isEnd = true;

    }

    public boolean search(String word) {
        char[] w = word.toCharArray();
        return dfs(root, w, 0);
    }

    private boolean dfs(TreeNode root, char[] w, int index){
        if(w.length == index)
            return root.isEnd;

        if(w[index] == '.'){
            for(int i = 0; i < 26; i++){
                if(root.child[i] != null && dfs(root.child[i], w, index + 1 ))
                    return true;
            }
        }else{
            if(root.child[w[index] - 'a'] != null)
                return dfs(root.child[w[index] - 'a'], w, index + 1);
        }

        return false;
    }
}
