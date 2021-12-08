package leetCode2021_10;

/**
 * 这里第一个方法相比第二个方法，虽然使用了递归来产生前项，由于函数的调用产生了额外的开销
 * 但在第二个方法中为了节省空间，每次都是把stringBuilder删除其中的内容，这计算长度要调用一次
 * 然后删除本身还需要调用一次，最终因为函数调用产生的额外开销反而比第一种更多了
 */
public class k38 {
    public static void main(String[] args) {
        System.out.println(new k38().countAndSay(30));
    }
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        StringBuilder res = new StringBuilder();
        String preItem = countAndSay(n-1);//初始化给1
        int preNum;
        int count;
        preNum = preItem.charAt(0) - 48;
        count = 1;
        for (int j = 1; j < preItem.length(); j++){
            int curNum = preItem.charAt(j) - 48;
            if(preNum != curNum) {
                res.append(count).append(preNum);
                preNum = curNum;
                count = 1;
            }
            else
                count++;
        }
        res.append(count).append(preNum);

        return res.toString();

//        StringBuilder stringBuilder = new StringBuilder();
//        String ans = "1";//初始化给1
//        int preNum;
//        int count;
//        for(int i = 1; i < n; i++){
//            preNum = ans.charAt(0) - 48;
//            count = 1;
//            for (int j = 1; j < ans.length(); j++){
//                int curNum = ans.charAt(j) - 48;
//                if(preNum != curNum) {
//                    stringBuilder.append(count).append(preNum);
//                    preNum = curNum;
//                    count = 1;
//                }
//                else
//                    count++;
//            }
//            stringBuilder.append(count).append(preNum);
//            ans = stringBuilder.toString();
//            stringBuilder.delete(0,stringBuilder.length());
//        }
//
//        return ans;
    }
}
