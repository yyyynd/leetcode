package leetcode.leetCode2022_11;

import java.util.HashMap;
import java.util.Map;

/**
 * 可以预先减小搜索范围，但是计算的时候应该是每次选一个点，然后计算和所有塔的距离
 * 这样就不需要额外的存储来产生开销了
 */
public class k1620 {
    public static void main(String[] args) {
        new k1620().bestCoordinate(new int[][]{{1,2,5},{2,1,7},{3,1,9}}, 2);
    }
    public int[] bestCoordinate(int[][] towers, int radius) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int[] tower : towers){
            int row = Math.max(tower[0] - radius, 0);
            int col = Math.max(tower[1] - radius, 0);
            for (; row <= tower[0] + radius; row++){
                for (int k = col; k <= tower[1] + radius; k++){
                    double distance = Math.sqrt(Math.pow(row - tower[0],2) + Math.pow(k - tower[1],2));
                    if (distance > radius)
                        continue;
                    int p = (int)(tower[2]/(1+distance));
                    int id = getId(row, k, 100);
                    memo.put(id, memo.getOrDefault(id, 0) + p);
                }
            }
        }//for
        int p = 0;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : memo.entrySet()){
            if (p < entry.getValue()){
                p = entry.getValue();
                key = entry.getKey();
            }else if (p == entry.getValue() && key > entry.getKey())
                key = entry.getKey();
        }
        return new int[]{key/100, key%100};
    }

    public int getId (int row, int col, int len){
        return row * len + col;
    }
}
