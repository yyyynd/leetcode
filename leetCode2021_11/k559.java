package leetCode2021_11;

import java.util.List;

public class k559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        return dfs(root);
    }

    public int dfs(Node root){
        if (root == null)
            return 0;
        int childDepth = 0;
        for (Node n : root.children)
            childDepth = Math.max(childDepth, dfs(n));

        return childDepth + 1;
    }
}
