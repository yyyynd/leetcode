package leetcode.leetCode2022_02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 可以编码的时候整理使用先序遍历，解码的时候通过排序获取中序顺序最终构成树
 */
public class k449 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String s = new k449().serialize(root);
        new k449().deserialize(s);

    }

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder codeBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode travel = root;
        while (travel != null || !stack.isEmpty()){

            if(travel == null){
                travel = stack.pop();
                travel = travel.right;
                continue;
            }

            codeBuilder.append(travel.val).append(',');
            stack.push(travel);
            travel = travel.left;
        }

        if(!codeBuilder.isEmpty())
            codeBuilder.deleteCharAt(codeBuilder.length() - 1);

        return codeBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;

        String[] code = data.split(",");
        int[] order = new int[code.length];
        for (int i = 0; i < order.length; i++)
            order[i] = Integer.parseInt(code[i]);
//        String[] midOrder = Arrays.copyOf(preOrder, preOrder.length);
//        Arrays.sort(midOrder, Comparator.comparingInt(Integer::parseInt));

        return create(0, order.length - 1, order);
    }

    private TreeNode create(int left, int right, int[] order){
        if(left > right)
            return null;

        int curNode = order[left];
        TreeNode root = new TreeNode(curNode);
        int mid = left;

        while (mid <= right && order[mid] <= curNode )
            mid++;

        root.left = create(left + 1, mid - 1, order);
        root.right = create(mid, right, order);
        return root;
    }

}
