package leetCode2021_05_09;

public class k551 {

    public boolean checkRecord(String s) {
        char[] record = s.toCharArray();
        int a_count = 0;
        int successive_l_count = 0;
        for (char c : record) {
            switch (c) {
                case 'L':
                    successive_l_count++;
                    break;
                case 'A':
                    a_count++;
                    successive_l_count = 0;
                    break;
                default:
                    successive_l_count = 0;
                    break;
            }//switch

            if (a_count == 2 || successive_l_count == 3)
                return false;
        }

        return true;
    }
}
