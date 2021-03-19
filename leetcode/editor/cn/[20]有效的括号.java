//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2252 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean isValid1(String s) {
//        while (true) {
//            int lenBefore = s.length();
//            s = s.replaceAll("(\\(\\))|(\\[\\])|(\\{\\})", "");
//            int lenPre = s.length();
//            if (lenBefore == lenPre) {
//                break;
//            }
//        }
//        if (s.length() > 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> stock = new LinkedList<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stock.push(c);
            } else {
                Character peek = stock.peek();
                if (peek == null && (c == ')' || c == ']' || c == '}')) {
                    return false;
                }
                if ((peek == '(' && c == ')') || (peek == '[' && c == ']') || (peek == '{' && c == '}')) {
                    stock.pop();
                } else {
                    stock.push(c);
                }
            }
        }
        if (stock.isEmpty()) {
            return true;
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
