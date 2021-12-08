package leetCode2021_05_09;

import java.util.*;

public class k863 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      int N = 501;
      int M = N*3;
      int idx = 0;
      //标记该边所指向的结点
      int[] e = new int[M];
      //标记每个结点边链表集合的头节点
      int[] he = new int[N];
      //当前边的下一条边位置（所有的边使用静态链表存储）
      int[] ne = new int[M];
      //a是起点，b是终点
      void add(int a, int b){
          e[idx] = b;
          ne[idx] = he[a];
          he[a] = idx++;
      }

      public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
          //访问控制防止重复访问导致循环
          boolean[] vis = new boolean[N];
          List<Integer> ans = new LinkedList<>();
          Arrays.fill(he,-1);
          dfs(root);
          Deque<Integer> deque = new ArrayDeque<>();
          deque.addLast(target.val);
          vis[target.val] = true;
          while (!deque.isEmpty() && k >= 0){
              int size = deque.size();
              //遍历当前距离的所有节点
              while (size > 0){
                  //获取队列中的元素
                  int poll = deque.pollFirst();
                  if(k == 0){
                      ans.add(poll);
                      continue;
                  }
                  int edge = he[poll];
                  while (edge != -1){
                      if(!vis[e[edge]]){
                          vis[e[edge]] = true;
                          deque.addLast(e[edge]);
                      }
                      edge = ne[edge];
                  }
                  size--;
              }
              k--;
          }
        return ans;
    }

    public void dfs(TreeNode root){
          if(root.left != null){
              add(root.val,root.left.val);
              add(root.left.val,root.val);
              dfs(root.left);
          }

        if(root.right != null){
            add(root.val,root.right.val);
            add(root.right.val,root.val);
            dfs(root.right);
        }
    }
}
