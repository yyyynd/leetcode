package leetCode2021_05_09;

public class k401 {

//    public static void main(String[] args) {
//        List<int[]> l = new LinkedList<>();
//    }
//
//    //小时最多3位表示1101,分钟最多5位表示111011(这里的位是指1)
//    public List<String> readBinaryWatch(int turnedOn) {
//        List<String> list = new LinkedList<>();
//        //最大的11:59就是用8位显示了
//        if(turnedOn >= 9)
//            return list;
//
//        for(int i = 0; i <= 5; i++){
//            int j = turnedOn - i;
//            if(j < 0 || j > 3)
//                continue;
//        }
//    }
//
//    public List<String> hourFun(int availableNum,int index){
//
//        List<String> list = new LinkedList<>();
//        List<String> follow;
//        if(index == 0) {
//            list.add("0");
//            if(availableNum )
//        }
//
//        list.add("0");
//        if(availableNum != 0)
//            list.add("1");
//
//        if(availableNum != 0)
//            follow = hourFun(availableNum-1,index-1);
//        else
//            follow = hourFun(0,index-1);
//
//        for (String f : follow){
//            list.add("0"+f);
//            if(availableNum != 0)
//                list.add("1"+f);
//        }
//
//        return list;
//
//    }
}
