//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        // 小于1的直接返回
        if (numRows <= 1) {
            return s;
        }
        // 字符数组
        char[] sChars = s.toCharArray();
        // 字符串长度、二维数组的大小x：横向 y：纵向
        int slen = s.length(), x = slen / (numRows - 1) + 1, y = numRows;
        char[][] chars = new char[x][y];
        int sCharsPoint = 0;
        // 放入二维数组 倾斜的列两头默认为 char 0 NUL
        for (int i = 0; i < x; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < y; j++) {
                    if (sCharsPoint >= slen) break;
                    chars[i][j] = sChars[sCharsPoint];
                    sCharsPoint++;
                }
            } else {
                for (int j = y - 2; j > 0; j--) {
                    if (sCharsPoint >= slen) break;
                    chars[i][j] = sChars[sCharsPoint];
                    sCharsPoint++;
                }
            }
        }
        // 横向读取
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (chars[j][i] != 0) {
                    sb.append(chars[j][i]);
                }
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
