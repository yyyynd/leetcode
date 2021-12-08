package leetCode2021_12;

import java.util.*;

public class k102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> preLayerList;

        if(root == null)
            return result;
//        result.add(Arrays.asList(root.val));
        preLayerList = Arrays.asList(root);

        while (!preLayerList.isEmpty()){
            List<TreeNode> curLayerList = new LinkedList<>();
            List<Integer> preLayerRes = new LinkedList<>();
            Iterator<TreeNode> iterator = preLayerList.listIterator();
            while (iterator.hasNext()){
                TreeNode travel = iterator.next();
                preLayerRes.add(travel.val);
                if(travel.left != null)
                    curLayerList.add(travel.left);
                if(travel.right != null)
                    curLayerList.add(travel.right);
            }
            preLayerList = curLayerList;
            result.add(preLayerRes);
        }

        return result;
    }
}
