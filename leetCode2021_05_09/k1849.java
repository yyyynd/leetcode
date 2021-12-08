package leetCode2021_05_09;

public class k1849 {
    final int INCREASE = 1;//递增
    final int DECREASE = 0;//递减
    final int NO_MODEL = 2;//暂无模式

    /**
     * 如果相距是只相差1的话，那么起码子串得出的数据的位数不会相距很大，最多就是进一位或退一位的关系
     * 那么完全可以从头开始取，我取出第一个子串后，读取它的位数，然后往后开始取，如果取出的字串位数
     * 差距大于±1了，则有问题（如果取串的时候进过一次位则后续不再应该有位数差距了）
     *
     * 在取串的时候，如果是以0为开头则理论上不算进数字当中（逻辑上跳过），一定要碰到个非零的作为开头
     * 这里假设第一个子串得出的数据为两位，那么可能需要分别取1位，2位，3位进行比较(这里举个例子），如果均不符合要求
     * 则重新取第一个子串；如果没有产生进位or退位，则接下来还需要执行该操作，如果产生了，则开始计数，
     * 取多少个子串才会再次产生进位or退位（不过这里好像最长才20，怎么取都不会产生第二次退位or进位）
     */

    public static void main(String[] args) {
        String test = "59376699145";
        new k1849().splitString(test);
    }

    public boolean splitString(String s) {
        int firstNum;
        int model = NO_MODEL;
        boolean result = false;

        for(int firstEnd = 1;firstEnd < s.length();firstEnd++){
            firstNum = Integer.parseInt(s.substring(0,firstEnd));
            if(firstNum == 0)
                continue;
            result = false;
            model = NO_MODEL;
            int preNum = firstNum;
            int currentDifference = 0;

            for (int subHead = firstEnd,subEnd = firstEnd+1; subEnd <= s.length();){
                int currentNum = Integer.parseInt(s.substring(subHead,subEnd));
                //如果相减绝对值大于1肯不符合要求(当前这个数就没有为
                currentDifference = preNum-currentNum;
                //如果当前的误差小于10，进一位也不可能找到比邻值,但如果>=10，进位还是有可能找到的
                //如果差距小于10，且当前这个数为0，也是可能找到符合条件的值的
                if(currentDifference != 1 && currentDifference < 10 &&currentNum != 0){
                    result = false;
                    break;
                }else if(currentDifference >= 10){
                    subEnd++;
                    continue;
                }else if(currentDifference != 1){
                    subEnd++;
                    continue;
                }

                switch (model){
                    case NO_MODEL:
                        if(preNum - currentNum == 1){
                            model = DECREASE;
                            result = true;
                        }else
                            result = false;
                        break;
                    case DECREASE:
                        result = preNum - currentNum == 1;
                        break;
                }
                if(result){
                    preNum = currentNum;
                    subHead = subEnd;
                    subEnd++;
                }else
                    break;
            }//for (int subHead

            if (result)
                break;
        }//for(int firstEnd

        return result;
    }
}
