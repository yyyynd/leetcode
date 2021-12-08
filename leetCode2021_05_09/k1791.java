package leetCode2021_05_09;

public class k1791 {
    public int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0]  == edges[1][1])
            return edges[0][0];
        else
            return edges[0][1];
    }
}
