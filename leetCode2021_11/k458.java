package leetCode2021_11;

public class k458 {
    public static void main(String[] args) {
        System.out.println(new k458().poorPigs(4,15,30));
    }
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(Math.log(buckets)/Math.log(minutesToTest/minutesToDie + 1));
    }
}
