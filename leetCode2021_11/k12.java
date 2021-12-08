package leetCode2021_11;

/**
 *  I - 1， V - 5
 *  X - 10, L - 50
 *  C - 100, D - 500
 *  M - 1000
 *
 *  [1, 3999]
 */
public class k12 {
    public static void main(String[] args) {
        System.out.println(new k12().intToRoman(4));
    }
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int tmp = num / 1000;
        ans.append(func('M', ' ', ' ', num/1000));
        num %= 1000;

        ans.append(func('C', 'D', 'M', num/100));
        num %= 100;

        ans.append(func('X', 'L', 'C', num/10));
        num %= 10;

        ans.append(func('I', 'V', 'X', num));

        return ans.toString();
    }

    public String func(char base, char middle, char carry, int num){
        if (num == 0)
            return "";
        StringBuilder tmp = new StringBuilder();
        if(num > 5 && num < 9) {
            tmp.append(middle);
            num -= 5;
        }else if(num == 9 || num == 4) {
            tmp.append(base);
            tmp.append(num == 9 ? carry : middle);
            num = 0;
        }else if( num == 5) {
            tmp.append(middle);
            num = 0;
        }

        for(int i = 0; i < num; i++)
            tmp.append(base);

        return tmp.toString();
    }
}
