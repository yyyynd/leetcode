package leetcode.leetCode2022_07;

public class k592 {
    public static void main(String[] args) {
        System.out.println(new k592().fractionAddition("-5/2+10/3+7/9"));
    }
    public String fractionAddition(String expression) {
        int molecule = 0;
        int denominator = 0;
        int len = expression.length();
        char[] e = expression.toCharArray();

        int i = 0;
        int flag = 1;
        if (e[i] == '-') {
            i++;
            flag = -1;
        }

        if (e[i+1] != '/') {
            molecule = 10;
            i += 3;
        }else{
            molecule = e[i] - '0';
            i += 2;
        }

        if (i + 1 < len && e[i+1] != '+' && e[i+1] != '-'){
            denominator = 10;
            i += 2;
        }else {
            denominator = e[i] - '0';
            i += 1;
        }

        molecule *= flag;

        while (i < e.length){
            int cur_molecule;
            int cur_denominator;
            flag = 1;
            if (e[i++] == '-') {
                flag = -1;
            }

            if (e[i+1] != '/') {
                cur_molecule = 10;
                i += 3;
            }else{
                cur_molecule = e[i] - '0';
                i += 2;
            }

            if (i + 1 < len && e[i+1] != '+' && e[i+1] != '-'){
                cur_denominator = 10;
                i += 2;
            }else {
                cur_denominator = e[i] - '0';
                i += 1;
            }

            cur_molecule *= flag;

            if (cur_denominator % denominator == 0){
                int m = cur_denominator/ denominator;
                denominator *= m;
                molecule *= m;
            }else if (denominator % cur_denominator == 0){
                int m = denominator / cur_denominator;
                cur_molecule *= m;
            }else {
                cur_molecule *= denominator;
                denominator *= cur_denominator;
                molecule *= cur_denominator;
            }

            molecule += cur_molecule;
            if (molecule == 0)
                denominator = 1;

            int m = measure(Math.abs(molecule), denominator);
            molecule /= m;
            denominator /= m;
        }
        String ans = molecule + "/" + denominator;
        return ans;
    }

    public int measure(int x, int y) {
        int z = y;
        while(x % y != 0) {
            z = x % y;
            x = y;
            y = z;
        }
        return z;
    }

}
