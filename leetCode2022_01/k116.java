package leetCode2022_01;

public class k116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        Node parent = root;
        while (parent.left != null){
            Node tmp = parent;//暂存一下最开始最左侧的父节点
            Node left = parent.right;//暂存对于后续遍历的当前层次子结点来说的最左节点（即上次遍历最后访问的右节点
            parent.left.next = parent.right;
            parent = parent.next;
            while (parent != null){
                left.next = parent.left;
                parent.left.next = parent.right;
                left = parent.right;
                parent = parent.next;
            }
            parent = tmp.left;
        }

        return root;
    }
}
