package leetcode.leetCode2022_08;

public class k672 {

    public int flipLights(int n, int presses) {

        if (presses == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) {
            return presses == 1 ? 3 : 4;
        }
        return presses == 1 ? 4 : presses == 2 ? 7 : 8;

    }
}
