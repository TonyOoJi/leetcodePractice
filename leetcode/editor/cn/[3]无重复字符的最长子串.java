//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0, end = 0, len = s.length(), max = 1, maxT = 1;
        if (len == 0) {
            return 0;
        }
        while (end < len - 1) {
            String window = s.substring(begin, end + 1);
            int contain = window.indexOf(s.charAt(end + 1));
            if (contain < 0) {
                end ++;
                maxT ++;
            } else {
                begin =begin + contain + 1;
                end ++;
                maxT = end - begin + 1;
            }
            if (maxT > max) {
                max = maxT;
            }

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
