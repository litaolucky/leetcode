package leetcode_7_31;

import java.util.Arrays;

/**
 * 给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
 *
 * 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
 *
 * 示例:
 * 输入:
 * [1,2,3,4,5,6,7,8]
 * 输出: true
 * 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 * 注意:
 *
 * A 数组的长度范围为 [1, 30].
 * A[i] 的数据范围为 [0, 10000].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-with-same-average
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitArraySameAverage {

    /**
     *
     * 看一个大佬的解析答案， 非常棒， 将这样的一个题转化成了搜索条件， 很棒的解题思路
     *  https://leetcode-cn.com/problems/split-array-with-same-average/solution/leetcode-shu-zu-de-jun-zhi-fen-ge-by-he-style
     *
     * @param A
     * @return
     *
     * 其中条件sum*i%n来自
     *
     * sum/n = sumi/i
     *
     * 那么sum*i/n = sumi
     *
     * 那么sum*i/n 必然整数
     *
     * 已知sum*i为整数， 那么sum*i%n一定整除
     *
     * 即剪枝条件为sum*i%n==0
     *
     */

    public boolean splitArraySameAverage(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int a: A) sum+=a;
        Arrays.sort(A);
        for (int i = 1; i <= n/2; i++) {
            if (sum*i%n==0 && dfs(A, 0, i, sum*i/n)) return true;
        }
        return false;
    }

    /**
     *
     * @param A 数组
     * @param begin 起始搜索位置
     * @param n 搜几个
     * @param target 加和目标
     * @return
     */
    private boolean dfs(int[] A, int begin, int n, int target) {
        //搜索完毕
        if (n==0) return target == 0;
        //数组已排序， 不可能搜到
        if (target < n* A[begin]) return false;
        for (int i = begin; i <= A.length - n; ++i) {
            // 略去重复的情况，缩短运行时间
            // 当时对这个地方有些疑惑， 想这样不会少情况嘛， 应该注意到i > begin 这个点， 然后就是重复的情况
            // 我们除去了i > begin这个点之后， 若满足A[i]==A[i-1]这样的情况的话， 那么就是重复的。即其余数字都是相同结果，
            // 这道题可以做个笔记出来
            if (i > begin && A[i] == A[i - 1]){
                continue;
            }
            if (dfs(A, i + 1, n - 1, target - A[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new SplitArraySameAverage().splitArraySameAverage(new int[]{60,30,30,30,30,30,30,30,30,30,30,30,30,30});
    }
}
