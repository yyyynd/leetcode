package leetCode2021_09;

import java.util.HashMap;
import java.util.HashSet;

public class k292 {
    //剩余n个石头的情况下，先手是否能必胜
    HashMap<Integer,Boolean> dp;

    //理论上只需要有一种选择导致必胜就行
    public boolean canWinNim(int n) {
        dp = new HashMap<>();
        return dfs(n);
    }

    /**
     * @param restNum 当前剩余的石头数量
     * @return 返回值代表当前剩余石头数量能否做到必赢
     */
    public boolean dfs(int restNum){
        if(restNum <= 3)
            return true;

        if(dp.containsKey(restNum))
            return dp.get(restNum);

        //当前玩家选取1-3个，寻找一种能必胜的方式
        for(int i = 1; i <= 3; i++){
            //如果下一轮没有必胜的方式，代表当前选择的数量可以在本轮必胜
            if (!dfs(restNum-i)){
                dp.put(restNum,true);
                return true;
            }
        }
        //没有任何必胜的方式
        dp.put(restNum,false);
        return false;
    }
}
