package leetcode_7_28;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidParentheses {

    /**
     *
     * 这个题可以利用线性规划做， 加之有效的括号的方法， 我们来统一做一下。
     *
     *
     *
     */

    public int longestValidParentheses(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        Stack<Character> stack = new Stack<>();





        return 0;
    }
}
