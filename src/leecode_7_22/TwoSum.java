package leecode_7_22;

/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

/**
 *
 * 解题思路， 一遍哈希表，key为值， value为下标， 边算边存， 解决
 *
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])) {
                return new int[] {hashMap.get(target-nums[i]), i};
            }
            // wa1: hashMap.put(i, nums[i]) -> hashMap.put(nums[i], i);
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such answer!");
    }


    /**
     *
     *
     * 想法： 建立在双指针上的做法， 对双指针的移动++的形式改进， 利用二分以达到logN的时间复杂度
     *
     * （具体时间复杂度并不是LogN）
     *
     * PS：为了省事， 我们假设数组中一定有两个符合这样的数
     *
     * 具体做法： 利用二分法的思想， 我们需要对两边数字进行二分，
     * 那么有，
     * 1. 两个数字向中间二分
     * 2. 两个数字向两边分二分
     *
     * 所以需要将数组分为三段， 即需要四个下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumTest(int[] nums, int target) {
        int length = nums.length;
        //边界俩下标
        int min = 0, max = length-1;
        //我们寻找的数的下标
        int a = 0, b = length-1;

        while(a < b) {
            int sum = nums[a] + nums[b];
            if (sum == target) return new int[]{a, b};
            //总数小于target， 我们有两种跳法， 小数向后二分， 大数向后二分， 这里我们做下判断
            if (sum < target) {
                //大数向后跳
                if (nums[b] <= target/2) {
                    b = (b+max)/2;
                    min = a;
                }
                //小数向后跳
                else {
                    a = (a+b)/2;
                    max = b;
                }
            }
            //同理
            if (sum > target) {
                //小数向前跳
                if (nums[a] >= target/2) {
                    a = (a+min)/2;
                    max = b;
                }
                //大数向前跳
                else {
                    b = (a+b)/2;
                    min = a;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] sums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int target = 6;
        int[] result = new TwoSum().twoSumTest(sums, target);
        for (int i: result) {
            System.out.println(i);
        }

    }
}
