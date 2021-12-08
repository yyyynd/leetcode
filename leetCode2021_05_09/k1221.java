package leetCode2021_05_09;

public class k1221 {
    public static void main(String[] args) {
        System.out.println(new k1221().balancedStringSplit("RLLLLRRRLR"));
    }
    public int balancedStringSplit(String s) {
        int right = 0;
        int left = 0;
        char[] str = s.toCharArray();
        int ans = 0;
        for (char c : str){
            if (c == 'L')
                left++;
            else
                right++;
            if(left == right)
                ans++;
        }

        return ans;
    }
}
