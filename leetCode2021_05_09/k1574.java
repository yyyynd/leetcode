package leetCode2021_05_09;

public class k1574 {
    public static void main(String[] args) {
        int[] arr = {6,3,10,11,15,20,13,3,18,12};
        System.out.println(new k1574().findLengthOfShortestSubarray(arr));
    }

    /**
     * 只能删除一次，所以删除的位置只能是左侧，中间或者右侧选一个地方删
     * 如果删左侧或者右侧，证明中间部分是不应该存在递减子串的
     * 如果删中间，则左右都是递增的
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int row = arr.length;
        int subStrLength = 0;
        int leftEnd = 0;
        int rightStart = 0;
        for(int i = 1; i <= row; i++){
            if(i == row) {
                leftEnd = row - 1;
                break;
            }
            if(arr[i-1] > arr[i]) {
                leftEnd = i - 1;
                break;
            }
        }//for


        for(int i = row -2; i >= -1;i--){
            if(i == -1){
                rightStart = 0;
                break;
            }
            if(arr[i] > arr[i+1]){
                rightStart = i + 1;
                break;
            }
        }//for

        //1.整个都是递增，无需删除子串
        if(leftEnd == row-1)
            subStrLength = 0;
        //2.如果leftEnd >= rightStart，没中间删除，但左右相交了，
        // 需要确定删除左右区域其中的一部分(不是整个左或者右
        else if(leftEnd >= rightStart)
            subStrLength = Math.min(row-1-leftEnd, rightStart+1);
        //3.如果leftEnd < rightStart 就只能删中间了,但还有考虑左右合并的问题
        else{
            //arr[leftEnd] <= arr[rightStart]无所谓，直接合并就行
            if(arr[leftEnd] <= arr[rightStart])
                subStrLength = rightStart - leftEnd -1;
            //如果是arr[leftEnd] > arr[rightStart],要么在左边找小的匹配右边头
            //要么在右边找更大的匹配左尾，或者两边都要减。。。
            else {
                //找中间+左部分or中间+右部分or中间+左右部分
                int leftSubLength = 0;
                int rightSubLength = 0;
                int leftRightSubLength = 0;

                while (leftEnd - leftSubLength >=0
                        && arr[leftEnd - leftSubLength] > arr[rightStart])
                    leftSubLength++;
                while (rightStart+rightSubLength < row
                        && arr[rightStart + rightSubLength] < arr[leftEnd])
                    rightSubLength++;
                for(int i = 0; i <= leftEnd; i++){
                    for (int j = 0; j <= row-1-rightStart; j++){
                        if(arr[leftEnd-i] <= arr[rightStart+j]){
                            if(leftRightSubLength == 0 || leftRightSubLength > i+j) {
                                leftRightSubLength = i + j;
                                break;
                            }else if(leftRightSubLength <= i+j)
                                break;
                        }//if(arr[leftEnd-i] <= arr[rightStart+j])
                    }//for
                }//for

                int centerSubStrLength = rightStart - leftEnd -1;

                int min = Math.min(centerSubStrLength + leftSubLength,
                        centerSubStrLength + rightSubLength);
                if(leftRightSubLength == 0)
                    subStrLength = min;
                else
                    subStrLength = Math.min(min,centerSubStrLength+leftRightSubLength);
            }//else
        }//else

        return subStrLength;
    }
}
