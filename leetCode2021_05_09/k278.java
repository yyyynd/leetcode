package leetCode2021_05_09;

public class k278 {

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        while (left<right){
            //这里这种计算方法是考虑到如果直接left+right进行除2，很可能会在相加的部分超int范围上限
            //所以可以采用下述方法或者直接用long，但long也是有可能爆范围的，所以还是下述方法好
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                /**
                 * 为什么这里不是right = mid-1：
                 * 不应该执行mid-1赋值，因为这应该视为一个可能的结果，
                 * 如果执行mid-1相当于把这个点可能性抛弃了
                 *
                 * 这里和查找某一个数的二分查找还是有点不同的
                 * 中间点如果是错误版本确实该左移右区间坐标，
                 * 但不代表该点不可能为结果了
                 */
                right = mid;
            }else
                left = mid+1;
        }//while

        return left;
    }

    boolean isBadVersion(int version){
        return true;
    }
}
