package leetcode_8_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || "".equals(digits)) return list;
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        dfs(0, digits, hashMap, list, new StringBuffer());
        return list;
    }

    /**
     * @param currentDeap  当前层级
     * @param digits       数字序列
     * @param hashMap      对应映射
     * @param list         结果存放
     * @param stringBuffer 当前字符串拼接
     */
    void dfs(int currentDeap, String digits, HashMap<Character, String> hashMap, List<String> list, StringBuffer stringBuffer) {
        if (currentDeap == digits.length()) {
            list.add(stringBuffer.toString());
            return;
        }
        for (Character character : hashMap.get(digits.charAt(currentDeap)).toCharArray()) {
            stringBuffer.append(character);
            dfs(currentDeap + 1, digits, hashMap, list, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
