package leetCode2021_05_09;

import java.util.*;

public class k1337 {

    class Node{
        int num;
        int indxe;

        public Node(int num, int indxe) {
            this.num = num;
            this.indxe = indxe;
        }

        public Node() {
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Node> list = new ArrayList<>(mat.length);
//        int[][] a = new int[mat.length][1];
//        for (int i = 0; i < mat.length; i++){
//            for (int n : mat[i]){
//                if(n != 0)
//                    a[i][0]++;
//                else
//                    break;
//            }
//        }



        for(int i = 0; i < mat.length; i++){
            int l = 0;
            int r = mat[0].length-1;
            while (l < r){
                int mid = l + (r-l)/2 ;
                if(mat[i][mid] == 1)
                    l = mid + 1;
                else
                    r = mid;
            }
            list.add(new Node(mat[i][l]==1? l+1:l,i));
        }

        list.sort((a,b)->{
            if(a.num > b.num)
                return 1;
            else if(a.num == b.num && a.indxe > b.indxe)
                return 1;
            else
                return -1;
        });

        int[] ans = new int[k];
        Iterator<Node> iterator = list.iterator();
        for (int i = 0; i < k; i++){
            Node curNode = iterator.next();
            ans[i] = curNode.indxe;
        }

        return ans;
    }


}
