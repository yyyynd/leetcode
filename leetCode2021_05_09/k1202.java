package leetCode2021_05_09;

import java.util.*;

public class k1202 {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new LinkedList<>();
        pairs.add(new LinkedList<>());
        pairs.get(0).add(0);
        pairs.get(0).add(3);
        pairs.add(new LinkedList<>());
        pairs.get(1).add(1);
        pairs.get(1).add(2);
        pairs.add(new LinkedList<>());
        pairs.get(2).add(0);
        pairs.get(2).add(2);
        System.out.println(new k1202().smallestStringWithSwaps(s,pairs));
    }

    /**
     * 并查集常应用于需要找出连通集合的题目中
     * 这里通过分析题目得知，只有pairs中的两点才可以进行交换，换言之就是可以连通
     * 那么进行交换只能在可以连通的点之间进行，近似就可以看作，我只要把每个极大连通子图
     * 进行排序就可以得出最终的结果，那么问题就是我该如何找出这所有的连通子图
     *
     * 这里就用到了并查集了，并查集就是应用于寻找连通集合的，所以如果以后遇到这种
     * 需要找出连通子图的题目，就可以使用并查集
     */
    class UnionFind {
        int[] parent;
        int[] ranks;
        int pointNum;

        public UnionFind(int pointNum) {
            this.pointNum = pointNum;
            this.parent = new int[pointNum];
            this.ranks = new int[pointNum];
            init();
        }

        //首先第一步肯定每个点还未连接时，其父节点肯定为自身
        private void init() {
            for (int i = 0; i < pointNum; i++) {
                parent[i] = i;
                ranks[i] = 1;
            }
        }

        //获取该点的父点
        public int find(int point) {
            //因为只有point == parent[point]的点才是一棵树的根节点
            if (point != parent[point])
                //这样的似乎find也承载了更新父节点的作用？
                parent[point] = find(parent[point]);
            return parent[point];
        }

        //判断是否当前两点连通（有相同的父节点）
        public boolean ifConnected(int p, int q) {
            return find(p) == find(q);
        }

        //合理的合并方法是，每次合并比较两个集合的秩，
        // 较小的那个直接找root作为较大的root的孩子
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if(pRoot == qRoot)
                return;

            if(ranks[pRoot] < ranks[qRoot]){
                parent[pRoot] = qRoot;
                ranks[qRoot] += ranks[pRoot];
            } else{
                parent[qRoot] = pRoot;
                ranks[pRoot] += ranks[qRoot];
            }
            pointNum--;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] string = s.toCharArray();
        int pointNum = string.length;
        UnionFind unionFind = new UnionFind(pointNum);

        for(List<Integer> list : pairs){
            int start = list.get(0);
            int end = list.get(1);

            unionFind.union(start,end);
        }

        //根据并查集组成子串们
        HashMap<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i < pointNum; i++){
            int root = unionFind.find(i);
            if(!map.containsKey(root))
                map.put(root,new LinkedList<>());
            map.get(root).add(string[i]);
        }

        //对子串进行排序
        Collection<List<Character>> collection = map.values();
        for (List<Character> subStr : collection) {
            if(subStr.size() == 1)
                continue;
            subStr.sort(Comparator.naturalOrder());
        }

        for(int i = 0; i < pointNum; i++){
            List<Character> list = map.get(unionFind.find(i));
            string[i] = list.remove(0);
        }

        return String.valueOf(string);
    }
}
