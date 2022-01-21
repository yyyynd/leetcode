package leetCode2022_01;

public class k117 {

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
        if(root == null)
            return null;

        Node pre_travel = root;

        while (pre_travel != null){
            Node left = new Node();
            Node head = left;
            while (pre_travel != null){
                if(pre_travel.left != null){
                    left.next = pre_travel.left;
                    left = pre_travel.left;
                }
                if(pre_travel.right != null){
                    left.next = pre_travel.right;
                    left = pre_travel.right;
                }
                pre_travel = pre_travel.next;
            }
            pre_travel = head.next;
        }

        return root;
    }
}
