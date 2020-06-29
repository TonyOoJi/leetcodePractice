//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 纵深 暴力
        StringBuilder sb = new StringBuilder();
        int prePoint = 0;
        char currChar = ' ';
        if (strs.length == 0) {
            return "";
        }
        while (true) {
            for (int i = 0, len = strs.length; i < len; i++) {
                if (prePoint > strs[i].length() - 1) {
                    return sb.toString();
                }
                currChar = strs[0].charAt(prePoint);
                if (strs[i].charAt(prePoint) != currChar) {
                    return sb.toString();
                }
            }
            sb.append(currChar);
            prePoint++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
