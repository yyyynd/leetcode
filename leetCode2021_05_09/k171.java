package leetCode2021_05_09;

public class k171 {

    public int titleToNumber(String columnTitle) {
        int count = 0;
        int length = columnTitle.length();
        for (int i = length; i > 0; i --)
            count += (columnTitle.charAt(i-1) - 'A' + 1)*((int)Math.pow(26,length-i));

        return count;
    }
}
