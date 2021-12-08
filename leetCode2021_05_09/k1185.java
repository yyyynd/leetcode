package leetCode2021_05_09;

public class k1185 {
    static String[] date = { "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday","Sunday"};

    public static void main(String[] args) {
        System.out.println(new k1185().dayOfTheWeek(28,2,2100));
    }

    /**
     *1971年1月1日是星期五
     * 可被4整除但不能被100整除，可被400整除的是闰年
     */
    public String dayOfTheWeek(int day, int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] sum = new int[12];
        for (int i = 1;i < 12; i++)
            sum[i] = sum[i-1] + days[i-1];

        int basicIndex = 4;//1971.1.1

        //如果当前月数为1或者2，则要考虑一个问题就是当年如果为闰年则要少考虑1偏移量
        if(month <= 2){
            if((year % 4 == 0 && year%100 !=0) || year %400 ==0 )
                return date[((year -1968)/4 - 1 + sum[month-1]%7 + (day-1)%7 +(year-1971) +basicIndex)%7];
        }

        /**
         * 上述(year -1968)/4 - 1是计算与1971之间有多少闰年数量时，如果本年为闰年，且月数小于3时
         * 不应该把当前闰年产生的偏移算入，但要考虑一种情况就是，可以被4整除，但不是闰年的年份，
         * 单纯的(year -1968)/4是会把这种年份与1971之间多计算一次闰年数量（比如2100）
         */
        if(year%4 == 0 && year%100 == 0){
            return date[((year -1968)/4 - 1 + sum[month-1]%7 + (day-1)%7 +(year-1971) +basicIndex)%7];
        }

        return date[((year -1968)/4+ sum[month-1]%7+ (day-1)%7 +(year-1971) +basicIndex)%7];
    }
}
