package leetcode.leetCode2022_07;

import java.util.HashMap;

/**
 * 这题的难点就是在于剪枝的选择，如果剪枝条件比较容易其实hash map就够了
 * 否则还是状态转移（像这里就是有两个选取位置的原因，所以条件比较复杂）
 */
public class k1143 {
    public static void main(String[] args) {
        System.out.println(new k1143().longestCommonSubsequence("oxcpqrsvwf",
                "shmtulqrypy"));
    }
    HashMap<Integer, Integer> memo = new HashMap<>();
    int len1;
    int len2;
    public int longestCommonSubsequence(String text1, String text2) {
        this.len1 = text1.length();
        this.len2 = text2.length();

        int[][] memo = new int[len1 + 1][len2 +1 ];
        for (int i = len1 - 1; i >= 0; i--){
            for (int j = len2 - 1; j >= 0; j--){
                if (text1.charAt(i) == text2.charAt(j))
                    memo[i][j] = memo[i+1][j+1] + 1;
                else
                    memo[i][j] = Math.max(memo[i+1][j], memo[i][j+1]);
            }
        }
        return memo[0][0];
    }

    public int dfs(int index1, int index2, String text1, String text2){
        if (index1 == len1 || index2 == len2)
            return 0;

        int max = 0;
        for (int i = index1; i < len1; i++){
            char cur = text1.charAt(i);
            for (int j = index2; j < len2; j++){
                if (cur == text2.charAt(j)){
                    int hash = (i << 15) + (index2 << 5) + cur - 'a';
                    int len;
                    if (memo.containsKey(hash))
                        len = memo.get(hash);
                    else {
                        len = dfs(i + 1, j + 1, text1, text2) + 1;
                        memo.put(hash, len);
                    }
                    max = Math.max(len, max);
                    break;
                }
            }//for
        }//for

        return max;
    }
}
