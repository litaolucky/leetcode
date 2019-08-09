package leetcode_7_25;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 *
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {


    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{','}');
        hashMap.put('(',')');
        hashMap.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (hashMap.containsKey(c)) {
                stack.push(c);
            }
            else if (stack.empty()||hashMap.get(stack.pop())!=c) return false;
        }
        if (stack.empty()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()"));
    }
}
