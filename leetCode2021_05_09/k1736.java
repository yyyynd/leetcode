package leetCode2021_05_09;

public class k1736 {

    public String maximumTime(String time) {
        int flag = 0;
        char[] a = new char[5];
        for(int i = 0; i < 2; i++){
            if(time.charAt(i) == '?')
                flag = flag | 1 << i;
            else
                a[i] = time.charAt(i);
        }

        switch (flag) {
            case 1 :
                a[0] = a[1] <= 3 ? '2' : '1';
                break;
            case 2 :
                a[1] = a[0] <= '1' ? '9' : '3';
                break;
            case 3:
                a[0] = '2';
                a[1] = '3';
                break;
        }//switch

        flag = 0;
        a[2] = ':';

        for(int i = 0; i < 2; i++){
            if(time.charAt(i+3) == '?')
                flag = flag | 1 << i;
            else
                a[i+3] = time.charAt(i+3);
        }

        switch (flag){
            case 1 :
                a[3] = '5';
                break;
            case 2 :
                a[4] = '9';
                break;
            case 3 :
                a[3] = '5';
                a[4] = '9';
                break;
        }//switch
        return String.valueOf(a);
    }
}
