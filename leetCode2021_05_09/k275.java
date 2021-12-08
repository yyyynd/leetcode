package leetCode2021_05_09;

/**
 * 一定要明确一点，本质上，限制hIndex其实主要是文章数量。。。
 */
public class k275 {
    public static void main(String[] args) {
        int[] t = {1,1,2,3,4,5,7};
        System.out.println(new k275().hIndex(t));
    }
    public int hIndex(int[] citations) {
        int result = 0;
        int l = 0, r = citations.length-1;
        while (l <= r){
            int mid = l + (r-l)/2;
            //如果被引数小于文章数量需要l右移
            if(citations[mid] < citations.length-mid){
                l = mid+1;
            }else if(citations[mid] >= citations.length-mid){
                int curIndex = citations[mid] == r-mid+1 ? citations[mid] : citations.length-mid;
                result = Math.max(curIndex,result);
                r = mid-1;
            }
        }

        return result;
    }
}
