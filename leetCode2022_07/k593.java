package leetcode.leetCode2022_07;

import java.util.HashSet;

public class k593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] a,b,c;
        double e;
        if (Math.pow(p1[0] - p2[0],2) + Math.pow(p1[1] - p2[1],2) ==
                Math.pow(p1[0] - p3[0],2) + Math.pow(p1[1] - p3[1],2) ){
            a = p4;
            b = p2;
            c = p3;
            e = Math.pow(p1[0] - p2[0],2) + Math.pow(p1[1] - p2[1],2);
        }else if ( Math.pow(p1[0] - p2[0],2) + Math.pow(p1[1] - p2[1],2) ==
                Math.pow(p1[0] - p4[0],2) + Math.pow(p1[1] - p4[1],2)){
            a = p3;
            b = p2;
            c = p4;
            e = Math.pow(p1[0] - p2[0],2) + Math.pow(p1[1] - p2[1],2);
        }else if(Math.pow(p1[0] - p3[0],2) + Math.pow(p1[1] - p3[1],2) ==
                Math.pow(p1[0] - p4[0],2) + Math.pow(p1[1] - p4[1],2)){
            a = p2;
            b = p4;
            c = p3;
            e = Math.pow(p1[0] - p3[0],2) + Math.pow(p1[1] - p3[1],2);
        }else
            return false;

        if (e == 0)
            return false;

        if (b[0] == c[0] && b[1] == c[1])
            return false;

        if (e != Math.pow(a[0] - b[0],2) + Math.pow(a[1] - b[1],2) ||
                e != Math.pow(a[0] - c[0],2) + Math.pow(a[1] - c[1],2)){
            return false;
        }


        return 2 * e == Math.pow(p1[0] - a[0], 2) + Math.pow(p1[1] - a[1], 2);
    }
}
