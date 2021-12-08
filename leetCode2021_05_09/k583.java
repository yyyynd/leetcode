package leetCode2021_05_09;

import java.util.HashMap;

/**
 * 要求删除最少的元素使两个字符串相等，那么意味着就是找出两个字符串最大的匹配集
 *
 * 第一版的写法只关注了w1剩余元素，实际上w1剩余元素能匹配上多少个和w2剩余元素也有关的
 */
public class k583 {

//    int[] dp;
    HashMap<Integer,Integer> map;
    char[] w1;
    char[] w2;

    public static void main(String[] args) {
        System.out.println(new k583().minDistance("usctkftieusmmkwqmcbsbjfnxoxdxhqxqdstecwcijbunjjlgdkjcorkwrkuh",
                "usqykfydecsdywjomqjpuyfnvkhdfsrwqwysvuwciwlyvwjlvgoekkxtyrmuz"));
    }

    public int minDistance(String word1, String word2) {
        if(word1.length() < word2.length()) {
            w1 = word2.toCharArray();
            w2 = word1.toCharArray();
        }else{
            w1 = word1.toCharArray();
            w2 = word2.toCharArray();
        }
//        dp = new int[w1.length];
//        Arrays.fill(dp,-1);
        map = new HashMap<>();

        return w1.length + w2.length - 2*dfs(0,0);
    }

    /**
     * @param w1_index 指代当前w1剩余未选择元素的数量
     * @param w2_index 指代当前w2剩余未选择元素的数量
     * @return 当前剩余元素最大匹配数
     */
    public int dfs(int w1_index, int w2_index){
        //任一一个字符串没有剩余可匹配元素了，则直接反0
        if(w1_index == w1.length || w2_index == w2.length)
            return 0;

//        if(dp[w1_index] != -1)
//            return dp[w1_index];
        if(map.containsKey((w1_index << 5) + w2_index))
            return map.get((w1_index << 5) + w2_index);

        int ans = 0;
        for(int i = w1_index; i < w1.length; i++){
            for(int j = w2_index; j < w2.length; j++){
                if(w1[i] == w2[j])
                    ans = Math.max(ans, 1 + dfs(i + 1, j + 1));
            }//for
        }//for

//        dp[w1_index] = ans;
        map.put((w1_index << 5) + w2_index,ans);
        return ans;
    }
}
