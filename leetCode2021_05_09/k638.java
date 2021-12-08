package leetCode2021_05_09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class k638 {

    public static void main(String[] args) {
        List<Integer> p = Arrays.asList(9,9);
        List<Integer> n = Arrays.asList(2,2);
        List<Integer> s1 = Arrays.asList(1,1,1);
//        List<Integer> s2 = Arrays.asList(1,2,10);
        List<List<Integer>> s = Arrays.asList(s1);
        System.out.println(new k638().shoppingOffers(p,s,n));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int dp = 0;
        //用于计算存储的累值
        int k = 0;
        //先直接假设所有的需求都是靠买单品满足的
        for(int i = 0; i < needs.size(); i++) {
            int curNeed = needs.get(i);
            int curPrice = price.get(i);
            for (int j = 0; j < curNeed; j++){

                dp += 1 << i * 4;
                k += curPrice;
                map.put(dp,k);
            }
        }

        //这里添加一下对0容量的初始化
        map.put(0,0);
        dp = 0;

        //最外层循环选择一个需求开始增涨
        for (int i = 0; i < needs.size(); i++){
            int curNeed = needs.get(i);
            for (int j = 1; j <= curNeed; j++){
                dp += 1 << i*4;
                for (List<Integer> s : special){
                    int preDp = checkFun(s,dp);
                    if(preDp != -1)
                        map.put(dp, Math.min( map.get(dp), map.getOrDefault(preDp,defaultNum(preDp,price)) + s.get(needs.size()) ) );
                }//for
            }//for
        }//for

        return map.get(dp);
    }

    public int defaultNum(int preDp,List<Integer> price){
        int c = 0;
        int i = 0;
        while (preDp != 0){
            c += (preDp & 15)*price.get(i);
            i++;
            preDp = preDp >> 4;
        }

        return c;
    }
    /**
     * 检查选择当前礼包是否会超出界限(这里我们已经限制了上界，主要是差下界）
     * @param s 当前礼包
     * @param dp 当前可选容量
     * @return 可以选择则返回选择后的剩余容量，否则返回-1
     */
    public int checkFun(List<Integer> s, int dp){
        for(int i = 0; i < s.size()-1; i++){
            int curNum = s.get(i);
            if(curNum == 0)
                continue;
            //获取该物品的可选容量
            if( ((dp >> i*4) & 15) < curNum)
                return -1;
            else
                dp -= curNum << i*4;
        }
        return dp;
    }

}
