package leetCode2021_09;

public class k8 {
    public static void main(String[] args) {
        System.out.println(new k8().myAtoi(" -42"));
    }
    public int myAtoi(String s) {
        //-2(31) - 2(31)-1如果为正数在判断绝对值范围要减1
        //所以flag通过0/1可以判断该数的正负性
        boolean flag = true;
        int symbol = 1;
        int length = s.length();
        char[] str = s.toCharArray();
        long ans = 0;
        final long abs = 1L << 31;
        int i;
        //对开头进行处理
        //要求先去掉开头所有非数字符合，一旦遇到数字则不能再出现非数字字符
        for (i = 0; i < length; i++){
            if(str[i] == '-' || str[i] == '+') {
                symbol = str[i] == '-' ? 0 : 1;
                i++;
                break;
            } else if(str[i] >= '0' && str[i] <= '9')
                break;
            else if(str[i] == ' ')
                continue;
            else
                return 0;
        }

        for (; i < length; i++ ){
            if(str[i] >= '1' && str[i] <= '9')
                break;
            else if(str[i] == '0')
                continue;
            else
                return 0;
        }//for

        if(i == length)
            return 0;

        //开始计算数据
        for (; i < length; i++){
            int num = str[i] - '0';
            if(num < 0 || num > 9)
                break;
            ans = ans*10 + num;
            if(ans > abs - symbol)
                return (int)(abs - symbol)* (symbol == 0 ? -1 : 1);
        }

        return (int)ans * (symbol == 0 ? -1 : 1);
    }
}
