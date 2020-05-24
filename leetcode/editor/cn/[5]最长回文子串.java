//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        // 边界 长度为1时 和 2 时，为1时 判断两侧， 为2时判断本身及两侧
        int p1 = 1, p2 = 2;
        String longestStr = "";
        char[] chars = s.toCharArray();
        if (s.length() > 0) {
            longestStr = String.valueOf(chars[0]);
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            // border边界 距离数组两边
            int border = Math.min(len - i - 1, i);
            // 中心为1
            for (int j = 1; j <= border; j++) {
                if (chars[i-j] == chars[i+j]) {
                    if (j*2+1 > longestStr.length()) {
                        longestStr = s.substring(i - j, i + j + 1);
                    }
                } else {
                    break;
                }

            }
            // 中心为2
            if ((i-1)>= 0 && chars[i] == chars[i-1]) {
                if (longestStr.length() <= 1) {
                    longestStr = s.substring(i-1,i+1);
                }
                border = Math.min(len - i - 1, i - 1);
                for (int j = 1; j <= border; j++) {
                    if (chars[i-j-1] == chars[i+j]) {
                        if (j*2+2 > longestStr.length()) {
                            longestStr = s.substring(i - j - 1, i + j + 1);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return longestStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
