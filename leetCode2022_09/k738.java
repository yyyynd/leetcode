package leetcode.leetCode2022_09;

public class k738 {
    public int monotoneIncreasingDigits(int n) {
        int index = 0;
        int tmp = n;
        while (tmp != 0){
            index++;
            tmp /= 10;
        }

        if (index == 1)
            return n;

        char[] num = new char[index];
        tmp = n;
        for (int i = index - 1; i >= 0; i--){
            num[i] = (char) (tmp % 10 + '0');
            tmp /= 10;
        }

        //这里用max和maxIndex记录最大值和第一次出现最大值的位置
        //因为要保持条件必须是 <=，如果出现位减1，只要改最大位第一次出现的位置即可
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < index - 1; i++){
            //直接比ASCII码
            if (max < num[i]) {
                max = num[i];
                maxIndex = i;
            }

            if (num[i] > num[i + 1]){
                num[maxIndex] -= 1;
                for (int j = maxIndex + 1; j < index; j++)
                    num[j] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(num));
    }
}
