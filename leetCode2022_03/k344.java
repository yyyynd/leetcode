package leetcode.leetCode2022_03;

/**
 * 位运算交换的思路就是
 * 第一次异或，a获得了i和j的独有位
 * 第二次，利用i中j的不同位，消除j原本的独有位，换上i的独有位，b变为原本i的值
 * 第三次，同理，利用a中有ij独有位，现在b为i值，消除a中的i独有位，加上共有位，a变j值
 */
public class k344 {
    public void reverseString(char[] s) {
        int len  = s.length;
        for (int i = 0; i < len/2; i++){
            int j = len - 1 - i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
}
