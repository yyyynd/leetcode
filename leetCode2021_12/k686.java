package leetCode2021_12;

/**
 * 首先因为b是由1-n个a拼接的字符串的中一个子串
 * 那么意味着只要重复的a组成的字符串长度大于(b.len/a.len + 2)*a.len，就必定包含了
 * 因为b的开头和结尾可能是部分a，也就是需要两个a来构成，中间部分必是n个重复的完整的a组成的，
 * 所以理论上2 + n个a必定组出来b
 *
 * 本题最难的点还是求子串，这里用的是哈希+前缀和
 * 哈希其实就是将每个字母得出一个哈希值，然后通过前缀和计算得出整字符串的哈希值
 * 再利用前缀和相减得出子串的哈希值
 */
public class k686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = strHash(sb.toString(), b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }
    int strHash(String ss, String b) {
        int P = 131;
        int n = ss.length(), m = b.length();
        String str = ss + b;
        int len = str.length();
        int[] h = new int[len + 10], p = new int[len + 10];
        p[0] = 1;
        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + str.charAt(i);
        }
        int r = len, l = r - m + 1;
        int target = h[r] - h[l - 1] * p[r - l + 1]; // b 的哈希值
        for (int i = 1; i <= n; i++) {
            int j = i + m - 1;
            int cur = h[j] - h[i - 1] * p[j - i + 1]; // 子串哈希值
            if (cur == target) return i - 1;
        }
        return -1;
    }



//    public int repeatedStringMatch(String a, String b) {
//        int ans = 0;
//        int index = -1;
//        int a_len = a.length();
//        int b_len = b.length();
//
//        for(int i = 0; i < a_len; i++){
//            if(a.substring(i, a_len).equals(b.substring(0,a_len - i))){
//                index = a_len - i;
//                ans++;
//                break;
//            }
//        }
//
//        if(index == -1)
//            return -1;
//
//        while (index + a_len < b_len){
//            for (int i = 0; i < a_len; i++){
//                if (!a.equals(b.substring(index, index + a_len)))
//                    return -1;
//            }
//            ans++;
//            index += a_len;
//        }
//
//        if(index < b_len) {
//            if (!a.substring(0, b_len - index).equals(b.substring(index, b_len)))
//                return -1;
//            ans++;
//        }
//        return ans;
//    }
}
