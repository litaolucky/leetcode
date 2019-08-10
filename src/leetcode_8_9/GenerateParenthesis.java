package leetcode_8_9;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, n, 0, 0, "", result);
        return result;
    }

    private void dfs(int currentDeep, int max, int open, int close, String string, List<String> result) {
        if (currentDeep==max*2) {
            result.add(string);
            return;
        }
        if (open < max) dfs(currentDeep+1, max, open+1, close, string+'(',result);
        if (open > close) dfs(currentDeep+1, max, open, close+1, string+')', result);
    }
}
