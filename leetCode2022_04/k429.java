package leetcode.leetCode2022_04;

import java.util.LinkedList;
import java.util.List;

public class k429 {
    public static void main(String[] args) {
        System.out.println(new k429().levelOrder(new Node(1)));
    }
    static class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> subRes = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        int preCount = 1; //上一层节点数量统计
        int curCount = 0; //当前新加入层次节点数量统计

        if (root == null)
            return res;

        queue.add(root);
        while (!queue.isEmpty()){
            Node travel = queue.poll();

            if(travel.children != null) {
                queue.addAll(travel.children);
                curCount += travel.children.size();
            }

            subRes.add(travel.val);
            preCount--;

            if(preCount == 0){
                res.add(subRes);
                subRes = new LinkedList<>();
                preCount = curCount;
                curCount = 0;
            }
        }
        return res;
    }
}
