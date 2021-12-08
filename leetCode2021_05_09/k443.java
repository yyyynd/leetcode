package leetCode2021_05_09;

public class k443 {

    public static void main(String[] args) {
        System.out.println(new k443().compress(new char[]{'o','o','o','o','o','o','o','o','o','o'}));
    }

    public int compress(char[] chars) {
        int ans = 0;

        for(int i = 0; i < chars.length; i++){
            int count = 0;
            for (int j = i; j < chars.length;j++) {
                if (chars[j] == chars[i])
                    count++;
                else
                    break;
            }//for
            chars[ans++] = chars[i];
            i += count-1;
            if (count == 1)
                continue;
            else {
                int k = 1;
                while (count / k > 0 && k <= 1000)
                    k *= 10;
                k /= 10;

                while (k > 0){
                    int mutli = count/k;
                    chars[ans++] = (char) (mutli + '0');
                    count -= mutli * k;
                    k /= 10;
                }
            }//else
        }
        return ans;
    }
}
