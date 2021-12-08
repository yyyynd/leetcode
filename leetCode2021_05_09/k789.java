package leetCode2021_05_09;

public class k789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int curGhostStep;
        int my_step = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] g : ghosts) {
            curGhostStep = Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]);
            if (curGhostStep <= my_step)
                return false;
        }
        return true;
    }
}
