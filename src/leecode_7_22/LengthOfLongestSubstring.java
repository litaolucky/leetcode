package leecode_7_22;

/**
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

import java.util.HashMap;

/**
 * 思路:
 *
 * 也是利用HashMap存值， 建立索引， 索引建立的目的是为了让窗口滑动更快。
 *
 * 具体做法， 遍历， 遇到相同字符， i直接跳到i的下一个， 其中不停计算最大length
 *
 */

/**
 *
 * 总结， 说说细节
 *
 * 首先呢， 关于hashMap映射的使用， 这里使用的映射不是单纯的下标， 而是当前下标+1， 也就是他的下一个，
 * 目的呢， 也是跟滑动窗口有关， 看wa1那里， 我们要考虑一种情况 abba 这种， 中间重复的例子， 当我碰到第二个a的时候， 就不能单纯的直接
 * 让i从第一个a+1开始， 忽略了之前的bb， 这时候去要判断max， 以去除这样的情况， 这是正确的映射可以帮你少做一次判断，也就是说你应该很清楚
 * 你的映射的那个值代表了什么， 这里我们的映射从起初的单纯的存储当前字符位置， 触发这种情况时 i应该在哪。
 *
 */

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abba");

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>(n);
        for (int i = 0, j = 0; j < n; j++) {
            char curChar = s.charAt(j);
            if (hashMap.containsKey(curChar)) {
                // wa1: i = hashMap.get(curChar);
                i = Math.max(i, hashMap.get(curChar));
            }
            ans = Math.max(ans, j-i+1);
            // wa2: 这里是映射关系
            hashMap.put(curChar, j+1);
        }
        return ans;
    }
}