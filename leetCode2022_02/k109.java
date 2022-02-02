package leetcode.leetCode2022_02;

import java.util.ArrayList;

public class k109 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
     }

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null){
            arr.add(head.val);
            head = head.next;
        }

        return dfs(0, arr.size() - 1, arr);
    }

    public TreeNode dfs(int left, int right, ArrayList<Integer> arr){
        if(right < left)
            return null;
        int centre = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr.get(centre));
        root.left = dfs(left, centre - 1, arr);
        root.right = dfs(centre + 1, right, arr);
        return root;
    }
}
