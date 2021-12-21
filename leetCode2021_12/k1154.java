package leetCode2021_12;

import java.util.Arrays;
import java.util.List;

public class k1154 {
    public int dayOfYear(String date) {
        String[] list = date.split("-");
        int ans = 0;
        int[] days = new int[]{0,31,59,90,120,151,181,212,243,273,304,334};
        int month = Integer.parseInt(list[1]);
        int year = Integer.parseInt(list[0]);

        ans += Integer.parseInt(list[2]);
        ans += days[month - 1];

        if ( ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) && month > 2)
            ans++;

        return ans;

    }
}
