package leetcode_7_24;

/**
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LongestPalindrome {

    /**
     *
     * 我们这里主要用马拉车算法解决回文，
     *
     * 预先技巧， 利用插入字符的方式， 将字符串变为恒定的奇数， 插入格式这个样#a#b#, 2n+1
     *
     * 定义辅助数组p, 用来保存第i个字符的最长回文半径， 推算可知p[i]-1为以i为中心的最长回文长度
     *
     * 好了， 也就是说我们如果求得了数组p， 最长回文的信息就能推算出来了
     *
     * 我们的数组是从左向右依次算的， 在算右边的回文的时候， 左边的回文是已经确定了的， 我们再通过已经覆盖到这里的回文
     * 来对称， 从而可以确定当前的回文的至少回文， 这里有个疑问， 覆盖到此下标的回文可能很多， 怎么确定使用谁的回文呢， 这是其一
     *
     *
     *
     *
     *
     * @param s
     * @return
     */

    /**
     *
     * 尝试有马拉车算法做， 第一步， 先是往里面塞东西，
     *
     * 第二部， 解题
     *
     *
     * @param s
     * @return
     */
    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }
}
