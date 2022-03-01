package leetcode.leetCode2022_03;

public class k395 {
    public static void main(String[] args) {
        System.out.println(new k395().longestSubstring("aaaabb", 3));
    }
    public int longestSubstring(String s, int k) {
        return fun(s, k);
    }

    public int fun(String s, int k){
        //进来判断一下长度
        if(s.length() < k)
            return 0;

        int ans = 0;
        int[] count = new int[26];

        //统计当前整个字符串每个字母出现频率
        for (int i = 0;  i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        StringBuilder formation = new StringBuilder();
        formation.append("[");

        for (int i = 0; i < 26; i++){
            if(count[i] < k && count[i] != 0)
                formation.append((char) ('a' + i));
        }
        formation.append(']');
        //如果不存在不符合条件的截断点
        if(formation.length() == 2)
            return s.length();

        String[] arr = s.split(formation.toString());
        for (String c : arr)
            ans = Math.max(ans, fun(c, k));

        return ans;
    }
}
