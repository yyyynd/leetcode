package leetcode.leetCode2022_09;

public class k684 {
    public static void main(String[] args) {
        new k684().findRedundantConnection(new int[][]{{3,4},{1,2},{2,4},{3,5},{2,5}});
    }
    public int[] findRedundantConnection(int[][] edges) {
        //利用并查集来进行判断
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        for (int[] e : edges){
            int node1 = e[0];
            int node2 = e[1];
            if (find(parent, node1) != find(parent, node2)){
                union(parent, node1, node2);
            }else
                return e;
        }

        return new int[0];
    }

    public void union(int[] parent, int index1, int index2){
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index){
        if (parent[index] != index)
            return find(parent, parent[index]);

        return parent[index];
    }
}
