package leetcode.leetCode2022_12;

public class k1812 {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0' ) % 2 == 0;
    }
}
