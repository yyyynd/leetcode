package leetCode2021_05_09;

import java.util.Arrays;

/**
 * 论文数量 == 最小被引数 才可以称作hIndex
 * 肯定尽量希望取最大值，这里分为两种情况
 * 一开始肯定是论文数量小，那么肯定只能取低的被引数才能符合条件
 * 而之后论文数量提升之后，被引数开始变小了，这就不像之前的情况，调整被引数条件就行了
 * 文章数量是无法进行动态调整了（基本可以说是文章数量在限制被引数量条件的大小）
 *
 * 因为被引数越大的文章对于被引数的限制受到的影响越小（可以更容易地计算到数量中）
 * 我们肯定是优先考虑
 */
public class k274 {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);
        //这里假设的是如果我们每次遍历一本书都要找到当前组合的hIndex
        for(int i = citations.length-1 ; i >= 0; i--){
            //当前被引数大于已经计入的文章数时,进行对被引数限制想修正（下调
            //因为条件就限制了 citeNum == paperNum
            if((citations.length - i) <= citations[i]){
                hIndex = Math.max(hIndex,citations.length - i);
            }else
                break;
        }

        return hIndex;
    }
}
