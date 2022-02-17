package leetcode.leetCode2022_02;

public class k331 {
    public static void main(String[] args) {
        System.out.println(new k331().isValidSerialization("1"));
    }
    public boolean isValidSerialization(String preorder){
        if(preorder.length() == 0)
            return false;

        int stack = 0;
        int count = 0;
        String[] arr = preorder.split(",");
        int len = arr.length;

        String travel = arr[0];
        while ( !travel.equals("#") || stack != 0 ){
            if(travel.equals("#")){
                stack--;
            }else {
                stack++;
            }
            count++;
            if(count == len)
                return false;
            travel = arr[count];
        }

        return count == arr.length - 1;
    }
}
