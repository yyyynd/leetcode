package leetcode.leetCode2022_01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class k1966 {
    public static void main(String[] args) {
        System.out.println(new k1966().numberOfWeakCharacters(new int[][]{{6,2},{6,3},{3,6}}));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        /**
         * 同攻击力防御力按升序排，这样从后往前及时防御力变大也不会影响结果
         */
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        /**
         * 因为已经按照攻击力排序了，那么后续的比较只要比是否防御力更低就行
         * 那么我只要记录当前所选比较角色前段的角色中是否存在一位的防御力比其高
         * 就行，那么意味着一直更新前段中所有角色防御力最大的就行了（攻击力因为排序
         * 相当于已经比较了
         */
        int preDefencesMax = 0;
        for (int i = properties.length - 1; i >= 0; i--){
            if(properties[i][1] < preDefencesMax)
                ans++;
            else
                preDefencesMax = properties[i][1];
        }//for

        return ans;
    }
}
