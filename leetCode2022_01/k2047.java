package leetcode.leetCode2022_01;

public class k2047 {
    public static void main(String[] args) {
        System.out.println(new k2047().countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr " +
                " q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1" +
                "  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8" +
                "dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v " +
                "p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i" +
                "5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  " +
                "wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif "));
    }
    public int countValidWords(String sentence) {
        char[] str = sentence.toCharArray();
        int ans = 0;
        for(int i = 0; i < str.length;){
            int symbolFlag = 0;
            if(str[i] == ' ') {
                i++;
                continue;
            }

            if(str[i] < 'a' || str[i] > 'z')
                symbolFlag = 3;

            int j = i;
            for (i++ ;i < str.length; i++){
                char curChar = str[i];
                //遇到空结束
                if(curChar == ' ')
                    break;
                if (curChar < 'a'  || curChar > 'z') {
                    if(curChar == '-')
                        symbolFlag++;
                    else
                        symbolFlag += 3;
                }
            }//for
            //第一个if主要是希望能够防只有一个字符的情况判断
            if(str[i - 1] == '-' || (str[i-1] >= '0' && str[i-1] <= '9'))
                symbolFlag += 3;
            else if(str[i - 1] >= 'a' && str[i - 1] <= 'z')
                symbolFlag = symbolFlag < 2 ? symbolFlag : symbolFlag + 3;
            else if( i >= 2 && str[i - 2] != '-')
                symbolFlag -= 3;

            if (symbolFlag < 3)
                ans++;
            else if(symbolFlag == 3 && i - j == 1)
                ans++;
        }//for
        return ans;
    }
}
