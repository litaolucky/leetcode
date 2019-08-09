package leetcode_7_30;

import java.util.Arrays;

/**
 *
 * 给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
 *
 * 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
 *
 * 示例:
 * 输入:
 * [1,2,3,4,5,6,7,8]
 * 输出: true
 * 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-with-same-average
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SplitArraySameAverage {

    /**
     * 想法一， 排序，然后从大数开始向另外两个里面‘扔’
     *
     *
     * @param A
     * @return
     */
    public boolean splitArraySameAverage(int[] A) {
        int B = 0;
        int BSum = 0;
        int C = 0;
        int CSum = 0;
        Arrays.sort(A);
        for (int i = A.length-1; i >=0 ;i--) {
            if (BSum==0) {
                B+=A[i];
                BSum++;
            } else if (CSum==0) {
                C+=A[i];
                CSum++;
            } else if (B/BSum > C/CSum) {
                C+=A[i];
                CSum++;
            } else {
                B+=A[i];
                BSum++;
            }
        }
        if (B/BSum==C/CSum) return true;
        else return false;
    }

    public static void main(String[] args) {
        new SplitArraySameAverage().splitArraySameAverage(new int[]{2,0,5,6,16,12,15,12,4});
    }
}
